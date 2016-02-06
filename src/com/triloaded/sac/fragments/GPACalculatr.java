package com.triloaded.sac.fragments;

import java.util.List;
import java.util.Vector;

import com.triloaded.sac.R;
import com.triloaded.sac.customviews.Gpa;
import com.triloaded.sac.customviews.GpaAdapter;
import com.triloaded.sac.customviews.GpaEntry;
import com.triloaded.sac.customviews.ResultsDialog;
import com.triloaded.sac.customviews.SemInfo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class GPACalculatr extends Fragment {
	
	private ListView lv;
	private GpaAdapter adapter;
	List<SemInfo> info;
	int semno;
	boolean isInterMeadiate = false;
	
		private String message, sem="nothing";
		private Button calc;
	
	public GPACalculatr() {
		
	}
	public GPACalculatr(List<SemInfo> info,int sem) {
		this.info = info;
		this.semno = sem;
		isInterMeadiate = true;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);		
		
		
		List<Gpa> list = new Vector<Gpa>();
		for(int i=0;i<10;i++){
			list.add(new Gpa(0, 0, true));
		}
		adapter = new GpaAdapter(getActivity(), R.layout.gpa_item,list );
		lv = (ListView) getActivity().findViewById(R.id.gpalistview);
		lv.setAdapter(adapter);
		
		calc = (Button) getActivity().findViewById(R.id.calc_btn);
		
		calc.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if(adapter.checkValid()){
					
					float point,totalcredits = adapter.getTotalcredits();
					if(totalcredits!=0){
						point = adapter.getGpaVal();
					}else{
					    point = 0;
					}
					if(!isInterMeadiate)
					{
						ResultsDialog dialog = new ResultsDialog(getActivity(), String.format("%.2f", point));
					    dialog.show();
					}
					else{
	               /* Bundle args = new Bundle();
	                args.putString("message", Float.toString(point));
	                args.putString("sem", sem);
	                args.putString("semcredits",Float.toString(totalcredits));
	                //Toast.makeText(getActivity(), "Sending "+sem, Toast.LENGTH_SHORT).show();
	                */
					info.get(semno).setPoints(point);
					info.get(semno).setCredits(totalcredits);
					info.get(semno).setValid(true);	
	                CGPA fragment = new CGPA(info);
	               // fragment.setArguments(args);
	                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
	                ft.replace(R.id.frame_container, fragment);
	                ft.addToBackStack(null);
	                ft.commit();
					}
				}
				
				/*if(checkAll()){
					
					//Log.i("debug", ""+entry1.getValue());
					
					int sum  = entry1.getValue()+entry2.getValue()
						+entry3.getValue()+entry4.getValue()
						+entry5.getValue()+entry6.getValue()
						+entry7.getValue()+entry8.getValue()
						+entry9.getValue()+entry10.getValue();
					
					float totalcredits =
							+entry1.getCredit()+entry2.getCredit()
							+entry3.getCredit()+entry4.getCredit()
							+entry5.getCredit()+entry6.getCredit()
							+entry7.getCredit()+entry8.getCredit()
							+entry9.getCredit()+entry10.getCredit();
					
					float point = (float) (Math.floor(sum/totalcredits * 100)/100);
					
					
					if(sem.equals("nothing"))
					{
						ResultsDialog dialog = new ResultsDialog(getActivity(), String.format("%.2f", point));
					    dialog.show();
					}
					else{
	                Bundle args = new Bundle();
	                args.putString("message", Float.toString(point));
	                args.putString("sem", sem);
	                args.putString("semcredits",Float.toString(totalcredits));
	                //Toast.makeText(getActivity(), "Sending "+sem, Toast.LENGTH_SHORT).show();
	                
	                CGPA fragment = new CGPA();
	                fragment.setArguments(args);
	                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
	                ft.replace(R.id.frame_container, fragment);
	                ft.addToBackStack(null);
	                ft.commit();
					}
				}
				*/
			}

		});
		
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		 View rootView  = inflater.inflate(R.layout.gpa, container, false);
		/* try{
			 sem=getArguments().getString("sem");
			 //Toast.makeText(getActivity(), "Recieved "+sem, Toast.LENGTH_LONG).show();
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }*/
    	 return rootView;
	}
	


			
}
