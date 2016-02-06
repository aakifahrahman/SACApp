package com.triloaded.sac.fragments;

import java.util.ArrayList;

import com.triloaded.sac.R;
import com.triloaded.sac.calendar.db.CustomListAdapter;
import com.triloaded.sac.calendar.db.CalendarItem;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class Calendar extends Fragment{
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.calendar, container, false);
		ArrayList image_details = getListData();
		final ListView lv1 = (ListView) rootView.findViewById(R.id.custom_list);
		lv1.setAdapter(new CustomListAdapter(getActivity(), image_details));

		return rootView;
	}

	private ArrayList getListData() {
		ArrayList results = new ArrayList();
		CalendarItem newsData = new CalendarItem();
		newsData.setdate("January 2 2015");
		newsData.setevent("Registration 1");
		results.add(newsData);

		newsData = new CalendarItem();
		newsData.setdate("January 4 2015");
		newsData.setevent("Milad-un-Nabi");
		results.add(newsData);

		newsData = new CalendarItem();
		newsData.setdate("January 5 2015");
		newsData.setevent("Registration 2");
		results.add(newsData);

		newsData = new CalendarItem();
		newsData.setdate("January 6 2015");
		newsData.setevent("Registration 3");
		results.add(newsData);

		newsData = new CalendarItem();
		newsData.setdate("January 12 2015");
		newsData.setevent("Late Registration");
		results.add(newsData);

		newsData = new CalendarItem();
		newsData.setdate("January 13 2015");
		newsData.setevent("Add/Drop Courses");
		results.add(newsData);

		newsData = new CalendarItem();
		newsData.setdate("January 20 2015");
		newsData.setevent("BoAC");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("January 26 2015");
		newsData.setevent("Republic Day");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("February 9 2015");
		newsData.setevent("BoAC");
		results.add(newsData);

		newsData = new CalendarItem();
		newsData.setdate("February 10 2015");
		newsData.setevent("Test 1");
		results.add(newsData);

		newsData = new CalendarItem();
		newsData.setdate("February 11 2015");
		newsData.setevent("Test 1");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("February 12 2015");
		newsData.setevent("Test 1");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("February 13 2015");
		newsData.setevent("Test 1");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("February 16 2015");
		newsData.setevent("Test 1");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("February 17 2015");
		newsData.setevent("Maha Shivarathri");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("February 25 2015");
		newsData.setevent("Senate");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("March 6 2015");
		newsData.setevent("Holi");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("March 14 2015");
		newsData.setevent("Sports Day");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("March 26 2015");
		newsData.setevent("Ragam");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("March 27 2015");
		newsData.setevent("Ragam");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("March 28 2015");
		newsData.setevent("Ragam");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("March 29 2015");
		newsData.setevent("Ragam");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("April 1 2015");
		newsData.setevent("BoAC");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("April 2 2015");
		newsData.setevent("Mahavir Jayanti");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("April 3 2015");
		newsData.setevent("Good Friday");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("April 6 2015");
		newsData.setevent("Test 2");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("April 7 2015");
		newsData.setevent("Test 2");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("April 8 2015");
		newsData.setevent("Test 2");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("April 9 2015");
		newsData.setevent("Test 2");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("April 10 2015");
		newsData.setevent("Test 2");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("April 13 2015");
		newsData.setevent("Teacher Evaluation 1");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("April 14 2015");
		newsData.setevent("Teacher Evaluation 2");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("April 15 2015");
		newsData.setevent("Vishu");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("April 16 2015");
		newsData.setevent("Teacher Evaluation 3");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("April 17 2015");
		newsData.setevent("Teacher Evaluation 4");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("April 20 2015");
		newsData.setevent("Teacher Evaluation 5");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("April 21 2015");
		newsData.setevent("Senate");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("April 23 2015");
		newsData.setevent("Pre-Registration 1");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("April 24 2015");
		newsData.setevent("Pre-Registration 2");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("April 27 2015");
		newsData.setevent("Pre-Registration 3 / Attendance Report");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("April 28 2015");
		newsData.setevent("Pre-Registration 14 / Application for Condonation");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("April 29 2015");
		newsData.setevent("Pre-Registration 5");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("April 30 2015");
		newsData.setevent("Condonation list");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("May 4 2015");
		newsData.setevent("Budha Purnima");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("May 5 2015");
		newsData.setevent("End Exam 1");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("May 6 2015");
		newsData.setevent("End Exam 2");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("May 7 2015");
		newsData.setevent("End Exam 3");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("May 8 2015");
		newsData.setevent("End Exam 4");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("May 11 2015");
		newsData.setevent("End Exam 5");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("May 12 2015");
		newsData.setevent("End Exam 6");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("May 13 2015");
		newsData.setevent("End Exam 7");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("May 14 2015");
		newsData.setevent("End Exam 8");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("May 15 2015");
		newsData.setevent("End Exam 9");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("May 16 2015");
		newsData.setevent("Semester Vacation starts");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("May 26 2015");
		newsData.setevent("End Result Declaration");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("June 1 2015");
		newsData.setevent("Make Up Exam 1");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("June 2 2015");
		newsData.setevent("Make Up Exam 2");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("June 3 2015");
		newsData.setevent("Make Up Exam 3");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("June 4 2015");
		newsData.setevent("Make Up Exam 4");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("June 5 2015");
		newsData.setevent("Make Up Exam 5");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("June 10 2015");
		newsData.setevent("Submission of Result to Academic Section");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("June 15 2015");
		newsData.setevent("Web Announcement for Supplementary Exam");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("June 26 2015");
		newsData.setevent("Last date for submission of online application");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("July 3 2015");
		newsData.setevent("Last date of submission of hard copy");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("July 6 2015");
		newsData.setevent("Issue of Hall Ticket");
		results.add(newsData);
		

		newsData = new CalendarItem();
		newsData.setdate("July 8 2015");
		newsData.setevent("First year Supplementary Exam 1");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("July 9 2015");
		newsData.setevent("First year Supplementary Exam 2");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("July 10 2015");
		newsData.setevent("First year Supplementary Exam 3");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("July 13 2015");
		newsData.setevent("First year Supplementary Exam 4");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("July 14 2015");
		newsData.setevent("First year Supplementary Exam 5");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("July 15 2015");
		newsData.setevent("First year Supplementary Exam 6");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("July 16 2015");
		newsData.setevent("First year Supplementary Exam 7");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("July 17 2015");
		newsData.setevent("First year Supplementary Exam 8");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("July 18 2015");
		newsData.setevent("Eid-ul-Fitr");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("July 24 2015");
		newsData.setevent("First year Supplementary Exam Results / Semester Vacation Ends");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("July 27 2015");
		newsData.setevent("Monsoon Registration 1");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("July 28 2015");
		newsData.setevent("Monsoon Registration 2");
		results.add(newsData);
		
		newsData = new CalendarItem();
		newsData.setdate("July 29 2015");
		newsData.setevent("Monsoon Semester Class Starts");
		results.add(newsData);
		
		return results;
	}
	
}
