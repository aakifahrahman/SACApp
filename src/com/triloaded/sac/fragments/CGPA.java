package com.triloaded.sac.fragments;

import java.util.List;
import java.util.Vector;

import com.triloaded.sac.R;
import com.triloaded.sac.customviews.CgpaDialog;
import com.triloaded.sac.customviews.CgpaDialog.CgpaChoiceListener;
import com.triloaded.sac.customviews.ResultsDialog;
import com.triloaded.sac.customviews.SemInfo;

import android.support.v4.app.Fragment;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class CGPA extends Fragment {
    
	private TextView cgpaa1,cgpa2,cgpa3,cgpa4,cgpa5,cgpa6,cgpa7,cgpa8, sem1, sem2, sem3, sem4, sem5, sem6, sem7, sem8;
	String message,sem,semester,semcredits;
	private Button calcButton;
	private float sem1_credits,sem2_credits,sem3_credits,sem4_credits,sem5_credits,sem6_credits,sem7_credits,sem8_credits,
					sem1_point,sem2_point,sem3_point,sem4_point,sem5_point,sem6_point,sem7_point,sem8_point;
	private int noOfCredits;
	private float cgpaNum=0,cgpa=0;
	private Button b1,b2,b3,b4,b5,b6,b7,b8;
	private List<SemInfo> seminfo;
	
	public CGPA(List<SemInfo> info) {
		this.seminfo = info;
		for(int i=0;i<8;i++){
			//Log.i("tag", ""+seminfo.toString());
		}
	}
	public CGPA() {
		seminfo = new Vector<SemInfo>();
		for(int i=0;i<8;i++){
			seminfo.add(new SemInfo(0,0,false));
		}
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.cgpa, container, false);
        cgpaa1 = (TextView) rootView.findViewById(R.id.cgpa1);
        cgpa2 = (TextView) rootView.findViewById(R.id.cgpa2);
        cgpa3 = (TextView) rootView.findViewById(R.id.cgpa3);
        cgpa4 = (TextView) rootView.findViewById(R.id.cgpa4);
        cgpa5 = (TextView) rootView.findViewById(R.id.cgpa5);
        cgpa6 = (TextView) rootView.findViewById(R.id.cgpa6);
        cgpa7 = (TextView) rootView.findViewById(R.id.cgpa7);
        cgpa8 = (TextView) rootView.findViewById(R.id.cgpa8);
        
        for(int i=0;i<8;i++){
        	SemInfo obj = seminfo.get(i);
        	//String gpaval = String.valueOf(obj.getPoints());
        	String gpa = String.format("%.2f", obj.getPoints());
        	if(obj.isValid()){
        		switch(i){
        		case 0: cgpaa1.setText(""+gpa); break;
				case 1: cgpa2.setText(""+gpa); break;
				case 2: cgpa3.setText(""+gpa); break;
				case 3: cgpa4.setText(""+gpa); break;
				case 4: cgpa5.setText(""+gpa); break;
				case 5: cgpa6.setText(""+gpa); break;
				case 6: cgpa7.setText(""+gpa); break;
				case 7: cgpa8.setText(""+gpa); break; 
        		}
        	}
        }
        
  
        sem1 = (TextView) rootView.findViewById(R.id.text1);
        sem2 = (TextView) rootView.findViewById(R.id.text2);
        sem3 = (TextView) rootView.findViewById(R.id.text3);
        sem4 = (TextView) rootView.findViewById(R.id.text4);
        sem5 = (TextView) rootView.findViewById(R.id.text5);
        sem6 = (TextView) rootView.findViewById(R.id.text6);
        sem7 = (TextView) rootView.findViewById(R.id.text7);
        sem8 = (TextView) rootView.findViewById(R.id.text8);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Oxygen-Regular.ttf");
        sem1.setTypeface(font);
        sem2.setTypeface(font);
        sem3.setTypeface(font);
        sem4.setTypeface(font);
        sem5.setTypeface(font);
        sem6.setTypeface(font);
        sem7.setTypeface(font);
        sem8.setTypeface(font);
        
       
        
        OnClickListener clickListener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int sem=0;
				switch(v.getId()){
				case R.id.button1: sem =0; break;
				case R.id.button2: sem =1; break;
				case R.id.button3: sem =2; break;
				case R.id.button4: sem =3; break;
				case R.id.button5: sem =4; break;
				case R.id.button6: sem =5; break;
				case R.id.button7: sem =6; break;
				case R.id.button8: sem =7; break;
				}
				
				CgpaDialog dialog = new CgpaDialog(getActivity(), sem, new CgpaChoiceListener() {
					
					@Override
					public void choiceGoto(int sem) {
						 
	 	                 GPACalculatr nextFrag= new GPACalculatr(seminfo,sem);
	 	                 //nextFrag.setArguments(args);
	 	                 getFragmentManager().beginTransaction()
	            	     .replace(R.id.frame_container, nextFrag)
	            	     .addToBackStack(null)
	            	     .commit();
					}
					
					@Override
					public void choiceCalc(int sem, float gpaval, int credits) {
						seminfo.get(sem).setCredits(credits);
						seminfo.get(sem).setPoints(gpaval);
						seminfo.get(sem).setValid(true);
						//refresh
						String gpa = String.format("%.2f", gpaval);
						switch(sem){
						case 0: cgpaa1.setText(""+gpa); break;
						case 1: cgpa2.setText(""+gpa); break;
						case 2: cgpa3.setText(""+gpa); break;
						case 3: cgpa4.setText(""+gpa); break;
						case 4: cgpa5.setText(""+gpa); break;
						case 5: cgpa6.setText(""+gpa); break;
						case 6: cgpa7.setText(""+gpa); break;
						case 7: cgpa8 .setText(""+gpa); break;
						}
					}
				});
				dialog.show();
				
			}
		};
        
		b1= (Button) rootView.findViewById(R.id.button1);
		b2= (Button) rootView.findViewById(R.id.button2);
		b3= (Button) rootView.findViewById(R.id.button3);
		b4= (Button) rootView.findViewById(R.id.button4);
		b5= (Button) rootView.findViewById(R.id.button5);
		b6= (Button) rootView.findViewById(R.id.button6);
		b7= (Button) rootView.findViewById(R.id.button7);
		b8= (Button) rootView.findViewById(R.id.button8);
		
		b1.setOnClickListener(clickListener);
		b2.setOnClickListener(clickListener);
		b3.setOnClickListener(clickListener);
		b4.setOnClickListener(clickListener);
		b5.setOnClickListener(clickListener);
		b6.setOnClickListener(clickListener);
		b7.setOnClickListener(clickListener);
		b8.setOnClickListener(clickListener);
		
		
        calcButton = (Button) rootView.findViewById(R.id.cgpacalc);
        calcButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				float cgpa,totalSum=0,totalCredits=0;
				for(int i=0;i<8;i++){
					totalSum += seminfo.get(i).getPoints() * seminfo.get(i).getCredits();
					totalCredits += seminfo.get(i).getCredits();
				}
				if(totalCredits !=0){
				  cgpa = totalSum/totalCredits;
				}else{
					cgpa = 0;
				}
				ResultsDialog dialog = new ResultsDialog(getActivity(), String.format("%.2f", cgpa));
	        	dialog.show();
	        
			
			}
		});
        
        return rootView;
        
      /*  try{
        if(sem1_credits == 100){
        	calcButton.setEnabled(false);
        }
        else
        	calcButton.setEnabled(true);
        
        calcButton.setOnClickListener(new OnClickListener(){
        	@Override
            public void onClick(View v) {
        		/*preferenceSettings = getActivity().getPreferences(0);
           	    if(preferenceSettings.getFloat("sem1_credits",100) !=100)
           	    	preferenceEditor.clear().commit();
           	    checkbox1.setChecked(false);
           	    checkbox2.setChecked(false);
           	    checkbox3.setChecked(false);
           	    checkbox4.setChecked(false);
           	    checkbox5.setChecked(false);
           	    checkbox6.setChecked(false);
           	    checkbox7.setChecked(false);
           	    checkbox8.setChecked(false);
           	    cgpaa1.setText("");
           	    cgpa2.setText("");
           	    cgpa3.setText("");
           	    cgpa4.setText("");
           	    cgpa5.setText("");
           	    cgpa6.setText("");
           	    cgpa7.setText("");
           	    cgpa8.setText("");
           	    
        	}
        });
        }
        catch(Exception e){
        	e.printStackTrace();
        }
        
        
      /*  try{
        	 message=getArguments().getString("message");
        	 sem=getArguments().getString("sem");
        	 semcredits=getArguments().getString("semcredits");
        	 float point = Float.parseFloat(message.trim());
        	 int semester = Integer.parseInt(sem.trim());
        	 float semCredits = Float.parseFloat(semcredits);
             //Toast.makeText(getActivity(), "Recieved semester "+sem+" with pooint "+message+" and credits "+semcredits, Toast.LENGTH_SHORT).show();
        	 
        	 preferenceSettings = this.getActivity().getPreferences(0);
        	 preferenceEditor = preferenceSettings.edit();
        	 
        	 if(semester == 1){
        		 preferenceEditor.putFloat("sem1_point", point);
        		 preferenceEditor.putFloat("sem1_credits", semCredits);
        		 preferenceEditor.commit();
        	 }
        	 else if(semester == 2){
        		 preferenceEditor.putFloat("sem2_point", point);
        		 preferenceEditor.putFloat("sem2_credits", semCredits);
        		 preferenceEditor.commit();
        	 }
        	 else if(semester == 3){
        		 preferenceEditor.putFloat("sem3_point", point);
        		 preferenceEditor.putFloat("sem3_credits", semCredits);
        		 preferenceEditor.commit();
        	 }
        	 else if(semester == 4){
        		 preferenceEditor.putFloat("sem4_point", point);
        		 preferenceEditor.putFloat("sem4_credits", semCredits);
        		 preferenceEditor.commit();
        	 }
        	 else if(semester == 5){
        		 preferenceEditor.putFloat("sem5_point", point);
        		 preferenceEditor.putFloat("sem5_credits", semCredits);
        		 preferenceEditor.commit();
        	 }
        	 else if(semester == 6){
        		 preferenceEditor.putFloat("sem6_point", point);
        		 preferenceEditor.putFloat("sem6_credits", semCredits);
        		 preferenceEditor.commit();
        	 }
        	 else if(semester == 7){
        		 preferenceEditor.putFloat("sem7_point", point);
        		 preferenceEditor.putFloat("sem7_credits", semCredits);
        		 preferenceEditor.commit();
        	 }
        	 else if(semester == 8){
        		 preferenceEditor.putFloat("sem8_point", point);
        		 preferenceEditor.putFloat("sem8_credits", semCredits);
        		 preferenceEditor.commit();
        	 }
        	
        }
        catch (Exception e){
        	e.printStackTrace();
        }
    
        try{     
        	sem1_credits = preferenceSettings.getFloat("sem1_credits",100);
        	sem2_credits = preferenceSettings.getFloat("sem2_credits",100);
        	sem3_credits = preferenceSettings.getFloat("sem3_credits",100);
        	sem4_credits = preferenceSettings.getFloat("sem4_credits",100);
        	sem5_credits = preferenceSettings.getFloat("sem5_credits",100);
        	sem6_credits = preferenceSettings.getFloat("sem6_credits",100);
        	sem7_credits = preferenceSettings.getFloat("sem7_credits",100);
        	sem8_credits = preferenceSettings.getFloat("sem8_credits",100);
        	
        	sem1_point = preferenceSettings.getFloat("sem1_point",100);
        	sem2_point = preferenceSettings.getFloat("sem2_point",100);
        	sem3_point = preferenceSettings.getFloat("sem3_point",100);
        	sem4_point = preferenceSettings.getFloat("sem4_point",100);
        	sem5_point = preferenceSettings.getFloat("sem5_point",100);
        	sem6_point = preferenceSettings.getFloat("sem6_point",100);
        	sem7_point = preferenceSettings.getFloat("sem7_point",100);
        	sem8_point = preferenceSettings.getFloat("sem8_point",100);
        	
        	noOfCredits=0;
        	if(sem1_credits != 100){
        		noOfCredits+=sem1_credits;
        		cgpaNum=cgpaNum+(sem1_credits*sem1_point);
        		cgpaa1.setText(Float.toString(sem1_point));
        		checkbox1.setChecked(true);
        	}
        	if(sem2_credits != 100){
        		noOfCredits+=sem2_credits;
        		cgpaNum=cgpaNum+(sem2_credits*sem2_point);
        		cgpa2.setText(Float.toString(sem2_point));
        		checkbox2.setChecked(true);
        	}
        	if(sem3_credits != 100){
        		noOfCredits+=sem3_credits;
        		cgpaNum=cgpaNum+(sem3_credits*sem3_point);
        		cgpa3.setText(Float.toString(sem3_point));
        		checkbox3.setChecked(true);
        	}
        	if(sem4_credits != 100){
        		noOfCredits+=sem4_credits;
        		cgpaNum=cgpaNum+(sem4_credits*sem4_point);
        		cgpa4.setText(Float.toString(sem4_point));
        		checkbox4.setChecked(true);
        	}
        	if(sem5_credits != 100){
        		noOfCredits+=sem5_credits;
        		cgpaNum=cgpaNum+(sem5_credits*sem5_point);
        		cgpa5.setText(Float.toString(sem5_point));
        		checkbox5.setChecked(true);
        	}
        	if(sem6_credits != 100){
        		noOfCredits+=sem6_credits;
        		cgpaNum=cgpaNum+(sem6_credits*sem6_point);
        		cgpa6.setText(Float.toString(sem6_point));
        		checkbox6.setChecked(true);
        	}
        	if(sem7_credits != 100){
        		noOfCredits+=sem7_credits;
        		cgpaNum=cgpaNum+(sem7_credits*sem7_point);
        		cgpa7.setText(Float.toString(sem7_point));
        		checkbox7.setChecked(true);
        	}
        	if(sem8_credits != 100){
        		noOfCredits+=sem8_credits;
        		cgpaNum=cgpaNum+(sem8_credits*sem8_point);
        		cgpa8.setText(Float.toString(sem8_point));
        		checkbox8.setChecked(true);
        	}
        	cgpa = cgpaNum/noOfCredits;
        	if(cgpa != 0){
        		ResultsDialog dialog = new ResultsDialog(getActivity(), String.format("%.2f", cgpa));
        		dialog.show();
        		Log.i("aaki", "dialog");
        	}
        }
        catch(Exception e){
        	e.printStackTrace();
        }
        
        try{
        Log.i("sem1_credits", Float.toString(preferenceSettings.getFloat("sem1_credits",100)));
        Log.i("sem2_credits", Float.toString(preferenceSettings.getFloat("sem2_credits",100)));
        Log.i("sem3_credits", Float.toString(preferenceSettings.getFloat("sem3_credits",100)));
        Log.i("sem4_credits", Float.toString(preferenceSettings.getFloat("sem4_credits",100)));
        Log.i("sem5_credits", Float.toString(preferenceSettings.getFloat("sem5_credits",100)));
        Log.i("sem6_credits", Float.toString(preferenceSettings.getFloat("sem6_credits",100)));
        Log.i("sem7_credits", Float.toString(preferenceSettings.getFloat("sem7_credits",100)));
        Log.i("sem8_credits", Float.toString(preferenceSettings.getFloat("sem8_credits",100)));
        }
        catch(Exception e){
        	e.printStackTrace();
        }
        
        
        */
        
        
    
        
  /*
        checkbox1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

            	 if(checkbox1.isChecked()){
            		 Bundle args = new Bundle();
 	                 args.putString("sem", Integer.toString(1));
 	                 
 	                 GPACalculatr nextFrag= new GPACalculatr();
 	                 nextFrag.setArguments(args);
 	                 getFragmentManager().beginTransaction()
            	     .replace(R.id.frame_container, nextFrag)
            	     .addToBackStack(null)
            	     .commit();
            	 }
            }
        });
       
        
        checkbox2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

            	 if(checkbox2.isChecked()){
            		 Bundle args = new Bundle();
 	                 args.putString("sem", Integer.toString(2));
 	                  
 	                 GPACalculatr nextFrag= new GPACalculatr();
 	                 nextFrag.setArguments(args);
 	                 getFragmentManager().beginTransaction()
            	     .replace(R.id.frame_container, nextFrag)
            	     .addToBackStack(null)
            	     .commit();
            	 }
            }
        });

       
        checkbox3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

            	 if(checkbox3.isChecked()){
            		 Bundle args = new Bundle();
 	                 args.putString("sem", Integer.toString(3));
 	                
 	                 GPACalculatr nextFrag= new GPACalculatr();
 	                 nextFrag.setArguments(args);
 	                 getFragmentManager().beginTransaction()
            	     .replace(R.id.frame_container, nextFrag)
            	     .addToBackStack(null)
            	     .commit();
            	 }
            }
        });
        
        
        checkbox4.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

            	 if(checkbox4.isChecked()){
            		 Bundle args = new Bundle();
 	                 args.putString("sem", Integer.toString(4));
            		 
 	                 GPACalculatr nextFrag= new GPACalculatr();
 	                 nextFrag.setArguments(args);
 	                 getFragmentManager().beginTransaction()
            	     .replace(R.id.frame_container, nextFrag)
            	     .addToBackStack(null)
            	     .commit();
            	 }
            }
        });
        
        
        checkbox5.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

            	 if(checkbox5.isChecked()){
            		 Bundle args = new Bundle();
 	                 args.putString("sem", Integer.toString(5));
            		 
 	                 GPACalculatr nextFrag= new GPACalculatr();
 	                 nextFrag.setArguments(args);
 	                 getFragmentManager().beginTransaction()
            	     .replace(R.id.frame_container, nextFrag)
            	     .addToBackStack(null)
            	     .commit();
            	 }
            }
        });
        
        
        checkbox6.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

            	 if(checkbox6.isChecked()){
            		 Bundle args = new Bundle();
 	                 args.putString("sem", Integer.toString(6));
            		
 	                 GPACalculatr nextFrag= new GPACalculatr();
 	                 nextFrag.setArguments(args);
 	                 getFragmentManager().beginTransaction()
            	     .replace(R.id.frame_container, nextFrag)
            	     .addToBackStack(null)
            	     .commit();
            	 }
            }
        });
        
        
        checkbox7.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

            	 if(checkbox7.isChecked()){
            		 Bundle args = new Bundle();
 	                 args.putString("sem", Integer.toString(7));
 	                 
 	                 GPACalculatr nextFrag= new GPACalculatr();
 	                 nextFrag.setArguments(args);
 	                 getFragmentManager().beginTransaction()
            	     .replace(R.id.frame_container, nextFrag)
            	     .addToBackStack(null)
            	     .commit();
            	 }
            }
        });
        
        
        checkbox8.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

            	 if(checkbox8.isChecked()){
            		 Bundle args = new Bundle();
 	                 args.putString("sem", Integer.toString(8));
 	                 
 	                 GPACalculatr nextFrag= new GPACalculatr();
 	                 nextFrag.setArguments(args);
 	                 getFragmentManager().beginTransaction()
            	     .replace(R.id.frame_container, nextFrag)
            	     .addToBackStack(null)
            	     .commit();
            	 }
            }
        });
        */
       // return rootView;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

}
