package com.triloaded.sac.db;

import java.util.List;
import java.util.Vector;

import com.triloaded.sac.gcm.Notification;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class FeedDb extends SQLiteOpenHelper {

	public FeedDb(Context context) {
		super(context, "elect.db", null, 1);
		
	}

	public FeedDb(Context context, String name, CursorFactory factory,
			int version, DatabaseErrorHandler errorHandler) {
		super(context, name, factory, version, errorHandler);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
	}
	
	
	
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		
	}
	
	
	public List<Notification> getFeeds(){
		List<Notification> feeds = new Vector<Notification>();
		SQLiteDatabase db=this.getReadableDatabase();
		String query= "SELECT * from feeds ORDER BY id DESC;";
		Cursor cur=db.rawQuery(query, null);
		if(cur.moveToFirst()){
			do{
				Notification feed =new Notification(
						cur.getInt(cur.getColumnIndex("id")), 
						cur.getString(cur.getColumnIndex("heading")),
						cur.getString(cur.getColumnIndex("content")));
						
				feeds.add(feed);
				
			}while(cur.moveToNext());
		}
		cur.close();
		db.close();
		return feeds;
	}
	
	public void addFeed(Notification notification){
		SQLiteDatabase db=getWritableDatabase();
		ContentValues val=new ContentValues();
		val.put("id", notification.getId());
		val.put("heading", notification.getHeading());
		val.put("content", notification.getContent());
		try{
			db.insert("feeds", null, val);
		}
		catch(Exception e){
			Log.d("Error inserting", e.getMessage());
		}
	}
	
	
	public void addFeeds(List<Notification> feeds){
		SQLiteDatabase db=getWritableDatabase();
		
		for(int i=0;i<feeds.size();i++){
			try{
				Log.i("debug", "inset feed"+i);
				ContentValues val=new ContentValues();
				Notification feed = feeds.get(i);
				val.put("id", feed.getId());
				val.put("heading", feed.getHeading());
				val.put("content", feed.getContent());
				db.insert("feeds", null, val);
			}
			catch(Exception e){
				Log.d("Error inserting", e.getMessage());
			}
		}
		
	}
	
	public String getMaxLocalId() {
		SQLiteDatabase db=this.getReadableDatabase();
		String query= "SELECT max(`id`) FROM feeds;";
		Cursor cursor=db.rawQuery(query, null);
		cursor.moveToFirst();
		String update=cursor.getString(0);
		cursor.close();
//		db.close();
		if(update==null)
			update="0";
		return update;

	}
		
}
