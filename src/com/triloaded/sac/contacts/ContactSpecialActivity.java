package com.triloaded.sac.contacts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.ListView;

import com.triloaded.sac.R;
import com.triloaded.sac.contacts.ContactsActivity.ContactListener;

public class ContactSpecialActivity extends Activity {
	ExpandableListAdapter listAdapter;
	ExpandableListView expListView;
	List<String> listDataHeader;
    String itemclicked,header;
	HashMap<String, List<Contact>> listDataChild;  
	int position;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact_specialactivity_layout);
		
		ExpandableListView lv = (ExpandableListView) findViewById(R.id.expandview);
		
		preparedlist();
		
		ExpandableListAdapter adapter = new ExpandableListAdapter(this, listDataHeader, listDataChild, new ContactSpecialListener() {
			@Override
			public void mail(String mail) {
				Intent in = new Intent(Intent.ACTION_SENDTO,
						Uri.fromParts("mailto", mail, null));
				startActivity(Intent.createChooser(in, "Send Email"));
				
			}
			
			@Override
			public void call(String phone) {
				Intent callIntent = new Intent(
						Intent.ACTION_DIAL);
				callIntent.setData(Uri.parse("tel:" + phone));
				startActivity(callIntent);
			}
		});
		
		lv.setAdapter(adapter);
		
	}
	
	
	public interface ContactSpecialListener {
		void call(String phone);
		void mail(String mail);
	}
	private void preparedlist()
	{
		listDataHeader = new ArrayList<String>();
		listDataChild = new HashMap<String, List<Contact>>();

		
		DatabaseAdapter myDbHelper;
        myDbHelper = new DatabaseAdapter(this);
        try {
        	myDbHelper.createdatabase();
	    } 
        catch (IOException ioe) {
        	throw new Error("Unable to create database");
	    }

	    try {
	    	myDbHelper.open();
	    }
	    catch(SQLException ex){
	    	throw ex;
	    }
		
	
		listDataHeader.add("ALL");
		listDataHeader.add("FIFTH YEAR");
		listDataHeader.add("FOURTH YEAR");
		listDataHeader.add("THIRD YEAR");
		listDataHeader.add("SECOND YEAR");
		listDataHeader.add("FIRST YEAR");
		
	  	List<Contact> Executive = new ArrayList<Contact>();
	  	List<Contact> Branch_Reps = new ArrayList<Contact>();
	  	List<Contact> Hostel_Reps = new ArrayList<Contact>();
	  	List<Contact> Sports_Captains = new ArrayList<Contact>();
		List<Contact> Mess_Reps = new ArrayList<Contact>();
		List<Contact> Club_Secs = new ArrayList<Contact>();
	  	
		  
	  	try{
	  		Executive = myDbHelper.getAllBranchContacts("ALL");
	  		Branch_Reps = myDbHelper.getAllBranchContacts("FIFTH");
	  		Hostel_Reps = myDbHelper.getAllBranchContacts("FOURTH");
	  		Sports_Captains = myDbHelper.getAllBranchContacts("THIRD");
	  		Mess_Reps = myDbHelper.getAllBranchContacts("SECOND");
	  		Club_Secs = myDbHelper.getAllBranchContacts("FIRST");
		  	
	  	}
	  	catch(Exception e){
	  		e.printStackTrace();
	  	}
	  	
		listDataChild.put(listDataHeader.get(0), Executive); 
		listDataChild.put(listDataHeader.get(1), Branch_Reps);
		listDataChild.put(listDataHeader.get(2), Hostel_Reps);
		listDataChild.put(listDataHeader.get(3), Sports_Captains);
		listDataChild.put(listDataHeader.get(4), Mess_Reps);
		listDataChild.put(listDataHeader.get(5), Club_Secs);
	}
	
}
