package com.triloaded.sac.contacts;

import java.util.ArrayList;
import java.util.List;

import com.triloaded.sac.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ContactsActivity extends Activity {
	
	public static final int CONT_EXECUTIVE_COUNCIL = 0;
	public static final int CONT_BRANCH_REPS = 1;
	public static final int CONT_HOSTEL_REPS = 2;
	public static final int CONT_SPORTS_CAPTAINS =3 ;
	public static final int CONT_MESS_REPS = 4;
	public static final int CONT_CLUB_SECRETARIES = 5;
	//public static final int CLASS_REPS = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact_activity_layout);
		
		List<Contact> list = new ArrayList<Contact>();
	  	
		int type = getIntent().getExtras().getInt("type");
		String text = getIntent().getExtras().getString("title");
		
		getActionBar().setTitle(text);
		
		DatabaseAdapter myDbHelper = new DatabaseAdapter(this);
		
		switch(type){
		
		case CONT_BRANCH_REPS:
			list=myDbHelper.getAllBranchRepsContacts();
			break;
		case CONT_CLUB_SECRETARIES:
			list=myDbHelper.getAllClub_SecsContacts();
			break;
		case CONT_EXECUTIVE_COUNCIL:
			list=myDbHelper.getAllExecContacts();
			break;
		case CONT_HOSTEL_REPS:
			list=myDbHelper.getAllHostelRepsContacts();
			break;
		case CONT_SPORTS_CAPTAINS:
			list=myDbHelper.getAllSports_CaptainsContacts();
			break;
		case CONT_MESS_REPS:
			list=myDbHelper.getAllMess_RepsContacts();
			break;
		}
		
		ContactAdapter adapter = new ContactAdapter(this, R.layout.contacts_child_item, list,  new ContactListener() {
			
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
		ListView lv = (ListView) findViewById(R.id.contact_list);
		lv.setAdapter(adapter);
		
		
	}
	
	
	public interface ContactListener {
		void call(String phone);
		void mail(String mail);
	}
	
	
	
	
}
