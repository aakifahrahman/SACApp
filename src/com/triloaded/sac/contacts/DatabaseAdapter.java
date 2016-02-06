package com.triloaded.sac.contacts;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseAdapter extends SQLiteOpenHelper {

    private Context mycontext;

    private String DB_PATH = "data/data/com.triloaded.sac/databases/";
    private static String DB_NAME = "database.db";
    public SQLiteDatabase myDataBase;

    public DatabaseAdapter(Context context) {
        super(context, DB_NAME, null, 1);
        this.mycontext = context;
        boolean dbexist = checkdatabase();
        if (dbexist) {
        } else {
            System.out.println("Database doesn't exist");
            try {
                createdatabase();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public void createdatabase() throws IOException {
        boolean dbexist = checkdatabase();
        if (dbexist) {
        } else {
            this.getReadableDatabase();
            try {
                copydatabase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    private boolean checkdatabase() {
        boolean checkdb = false;
        try {
            String myPath = DB_PATH + DB_NAME;
            File dbfile = new File(myPath);
            checkdb = dbfile.exists();
        } catch (SQLiteException e) {
            System.out.println("Database doesn't exist");
        }

        return checkdb;
    }

    private void copydatabase() throws IOException {

    	InputStream mInput = mycontext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream mOutput = new FileOutputStream(outFileName);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer))>0)
        {
            mOutput.write(mBuffer, 0, mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();

    }

    public void open() {
        // Open the database
        String mypath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(mypath, null,
                SQLiteDatabase.OPEN_READWRITE);
        Log.i("aaki", "contacts db opened successfully");
    }

    public synchronized void close() {
        myDataBase.close();
        super.close();
    }

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	
	 public List<Contact> getAllBranchContacts(String var) {
	    	
	    	List<Contact> contactList = new ArrayList<Contact>();
	    
	    	// Select All Query
	    	String selectQuery = "select * from branch_reps WHERE year = '"+var+"';";
	 
	    	SQLiteDatabase db = this.getWritableDatabase();
	    	Cursor cursor = db.rawQuery(selectQuery, null);
	 
	    	if (cursor.moveToFirst()) {
	    		do {
	    			Contact contact = new Contact();
	    			contact.setId(Integer.parseInt(cursor.getString(0)));
	    			contact.setName(cursor.getString(1));
	    			contact.setPost(cursor.getString(2)+" - "+cursor.getString(3)+" branch - "+cursor.getString(4)+" year");
	    			contact.setPhone(cursor.getString(5));
	    			contact.setEmail(cursor.getString(6));
	    			
	    			contactList.add(contact);
	    		} 
	    		while (cursor.moveToNext());
	    	}
	 
	    	return contactList;
	    }
	
    
    public List<Contact> getAllExecContacts() {
    	
    	List<Contact> contactList = new ArrayList<Contact>();
    
    	// Select All Query
    	String selectQuery = "SELECT  * FROM executive_council";
 
    	SQLiteDatabase db = this.getWritableDatabase();
    	Cursor cursor = db.rawQuery(selectQuery, null);
 
    	if (cursor.moveToFirst()) {
    		do {
    			Contact contact = new Contact();
    			contact.setId(Integer.parseInt(cursor.getString(0)));
    			contact.setName(cursor.getString(1));
    			contact.setPost(cursor.getString(2));
    			contact.setPhone(cursor.getString(3));
    			contact.setEmail(cursor.getString(4));
    			
    			contactList.add(contact);
    		} 
    		while (cursor.moveToNext());
    	}
 
    	return contactList;
    }
    
    public List<Contact> getAllBranchRepsContacts() {
    	
    	List<Contact> contactList = new ArrayList<Contact>();
    
    	String selectQuery = "SELECT  * FROM branch_reps";
 
    	SQLiteDatabase db = this.getWritableDatabase();
    	Cursor cursor = db.rawQuery(selectQuery, null);
 
    	if (cursor.moveToFirst()) {
    		do {
    			Contact contact = new Contact();
    			contact.setId(Integer.parseInt(cursor.getString(0)));
    			contact.setName(cursor.getString(1));
    			contact.setPost(cursor.getString(2)+" - "+cursor.getString(3)+" branch - "+cursor.getString(4)+" year");
    			contact.setPhone(cursor.getString(5));
    			contact.setEmail(cursor.getString(6));
    			
    			contactList.add(contact);
    		} 
    		while (cursor.moveToNext());
    	}
 
    	return contactList;
    }

    public List<Contact> getAllHostelRepsContacts() {
    	
    	List<Contact> contactList = new ArrayList<Contact>();
    
    	String selectQuery = "SELECT  * FROM hostel_reps";
 
    	SQLiteDatabase db = this.getWritableDatabase();
    	Cursor cursor = db.rawQuery(selectQuery, null);
 
    	if (cursor.moveToFirst()) {
    		do {
    			Contact contact = new Contact();
    			contact.setId(Integer.parseInt(cursor.getString(0)));
    			contact.setName(cursor.getString(1));
    			contact.setPost(cursor.getString(2)+" hostel");
    			contact.setPhone(cursor.getString(3));
    			contact.setEmail(cursor.getString(4));
    			
    			contactList.add(contact);
    		} 
    		while (cursor.moveToNext());
    	}
 
    	return contactList;
    }    

    public List<Contact> getAllSports_CaptainsContacts() {
    	
    	List<Contact> contactList = new ArrayList<Contact>();
    
    	String selectQuery = "SELECT  * FROM sports_captains";
 
    	SQLiteDatabase db = this.getWritableDatabase();
    	Cursor cursor = db.rawQuery(selectQuery, null);
 
    	if (cursor.moveToFirst()) {
    		do {
    			Contact contact = new Contact();
    			contact.setId(Integer.parseInt(cursor.getString(0)));
    			contact.setName(cursor.getString(1));
    			contact.setPost(cursor.getString(2));
    			contact.setPhone(cursor.getString(3));
    			contact.setEmail(cursor.getString(4));
    			
    			contactList.add(contact);
    		} 
    		while (cursor.moveToNext());
    	}
 
    	return contactList;
    }
    
    public List<Contact> getAllMess_RepsContacts() {
    	
    	List<Contact> contactList = new ArrayList<Contact>();
    
    	String selectQuery = "SELECT  * FROM mess_reps";
 
    	SQLiteDatabase db = this.getWritableDatabase();
    	Cursor cursor = db.rawQuery(selectQuery, null);
 
    	if (cursor.moveToFirst()) {
    		do {
    			Contact contact = new Contact();
    			contact.setId(Integer.parseInt(cursor.getString(0)));
    			contact.setName(cursor.getString(1));
    			contact.setPost(cursor.getString(2)+" mess");
    			contact.setPhone(cursor.getString(3));
    			contact.setEmail(cursor.getString(4));
    			
    			contactList.add(contact);
    		} 
    		while (cursor.moveToNext());
    	}
 
    	return contactList;
    }
    
    public List<Contact> getAllClub_SecsContacts() {
    	
    	List<Contact> contactList = new ArrayList<Contact>();
    
    	String selectQuery = "SELECT  * FROM club_secretaries";
 
    	SQLiteDatabase db = this.getWritableDatabase();
    	Cursor cursor = db.rawQuery(selectQuery, null);
 
    	if (cursor.moveToFirst()) {
    		do {
    			Contact contact = new Contact();
    			contact.setId(Integer.parseInt(cursor.getString(0)));
    			contact.setName(cursor.getString(1));
    			contact.setPost(cursor.getString(2));
    			contact.setPhone(cursor.getString(3));
    			contact.setEmail(cursor.getString(4));
    			
    			contactList.add(contact);
    		} 
    		while (cursor.moveToNext());
    	}
 
    	return contactList;
    }
    
    public List<Contact> getAllClass_RepsContacts() {
    	
    	List<Contact> contactList = new ArrayList<Contact>();
    
    	String selectQuery = "SELECT  * FROM class_reps";
 
    	SQLiteDatabase db = this.getWritableDatabase();
    	Cursor cursor = db.rawQuery(selectQuery, null);
 
    	if (cursor.moveToFirst()) {
    		do {
    			Contact contact = new Contact();
    			contact.setId(Integer.parseInt(cursor.getString(0)));
    			contact.setName(cursor.getString(1));
    			contact.setPost(cursor.getString(2)+" "+cursor.getString(3)+" "+cursor.getString(4)+" batch "+cursor.getString(5)+ " year");
    			contact.setPhone(cursor.getString(6));
    			contact.setEmail(cursor.getString(7));
    			
    			contactList.add(contact);
    		} 
    		while (cursor.moveToNext());
    	}
 
    	return contactList;
    }
    
}