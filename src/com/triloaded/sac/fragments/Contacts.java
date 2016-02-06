package com.triloaded.sac.fragments;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.triloaded.sac.R;
import com.triloaded.sac.contacts.Contact;
import com.triloaded.sac.contacts.ContactMenuAdapter;
import com.triloaded.sac.contacts.ContactSpecialActivity;
import com.triloaded.sac.contacts.ContactsActivity;
import com.triloaded.sac.contacts.DatabaseAdapter;
import com.triloaded.sac.contacts.ExpandableListAdapter;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ExpandableListView;
import android.widget.ListView;

public class Contacts extends Fragment {

	ExpandableListAdapter listAdapter;
	ExpandableListView expListView;
	List<String> listDataHeader;
    String itemclicked,header;
	HashMap<String, List<Contact>> listDataChild;  
	int position;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		dbHelper();

		listDataHeader = new ArrayList<String>();
		listDataHeader.add("EXECUTIVE COUNCIL");
		listDataHeader.add("BRANCH REPS");
		listDataHeader.add("HOSTEL REPS");
		listDataHeader.add("SPORTS CAPTAINS");
		listDataHeader.add("MESS REPS");
		listDataHeader.add("CLUB SECRETARIES");
		
		ContactMenuAdapter adapter = new ContactMenuAdapter(getActivity(), R.layout.contacts_parent_item, listDataHeader);
		ListView lv = (ListView) getActivity().findViewById(R.id.contact_listview);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
					long id) {
				if(pos==1){
					Intent n = new Intent(getActivity(), ContactSpecialActivity.class);
					startActivity(n);
				}else{
				Intent n = new Intent(getActivity(), ContactsActivity.class);
				n.putExtra("type", pos);
				n.putExtra("title", listDataHeader.get(pos));
				startActivity(n);
				}
				
			}
			
		});
	
	}
	
	private void dbHelper() {
		DatabaseAdapter myDbHelper;
        myDbHelper = new DatabaseAdapter(getActivity());
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
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.contacts, container, false);
		
		/*// get the listview
				expListView = (ExpandableListView) rootView.findViewById(R.id.exp_listview1);
				// preparing list data
				preparedlist();
				listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listDataChild);
				// setting list adapter
				expListView.setAdapter(listAdapter);
				expListView.setDividerHeight(1);
			    expListView.setGroupIndicator(null);
			    expListView.setClickable(false);	*/

		return rootView;
	}
	
	private void preparedlist()
	{
		listDataHeader = new ArrayList<String>();
		listDataChild = new HashMap<String, List<Contact>>();

		
		DatabaseAdapter myDbHelper;
        myDbHelper = new DatabaseAdapter(getActivity());
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
		
	
		listDataHeader.add("EXECUTIVE COUNCIL");
		listDataHeader.add("BRANCH REPS");
		listDataHeader.add("HOSTEL REPS");
		listDataHeader.add("SPORTS CAPTAINS");
		listDataHeader.add("MESS REPS");
		listDataHeader.add("CLUB SECRETARIES");
		listDataHeader.add("CLASS REPS");
		
	  	List<Contact> Executive = new ArrayList<Contact>();
	  	
	  	try{
	  		Executive = myDbHelper.getAllExecContacts();
	  	}
	  	catch(Exception e){
	  		e.printStackTrace();
	  	}
	  	
	  	List<Contact> Branch_Reps = new ArrayList<Contact>();
	  	
	  	try{
	  		Branch_Reps = myDbHelper.getAllBranchRepsContacts();
	  	}
	  	catch(Exception e){
	  		e.printStackTrace();
	  	}
	  	
	  	List<Contact> Hostel_Reps = new ArrayList<Contact>();
	  	
	  	try{
	  		Hostel_Reps = myDbHelper.getAllHostelRepsContacts();
	  	}
	  	catch(Exception e){
	  		e.printStackTrace();
	  	}
	  	
	  	List<Contact> Sports_Captains = new ArrayList<Contact>();
	  	
	  	try{
	  		Sports_Captains = myDbHelper.getAllSports_CaptainsContacts();
	  	}
	  	catch(Exception e){
	  		e.printStackTrace();
	  	}
	  	
	  	List<Contact> Mess_Reps = new ArrayList<Contact>();
	  	
	  	try{
	  		Mess_Reps = myDbHelper.getAllMess_RepsContacts();
	  	}
	  	catch(Exception e){
	  		e.printStackTrace();
	  	}
	  	
	  	List<Contact> Club_Secs = new ArrayList<Contact>();
	  	
	  	try{
	  		Club_Secs = myDbHelper.getAllClub_SecsContacts();
	  	}
	  	catch(Exception e){
	  		e.printStackTrace();
	  	}
	  	
	  	List<Contact> Class_Reps = new ArrayList<Contact>();
	  	
	  	try{
	  		Class_Reps = myDbHelper.getAllClass_RepsContacts();
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
		listDataChild.put(listDataHeader.get(6), Class_Reps);
	}
	
}
