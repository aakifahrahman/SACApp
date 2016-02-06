package com.triloaded.sac.customviews;

import java.util.ArrayList;
import java.util.List;

import com.triloaded.sac.R;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class GpaEntry extends LinearLayout {
	
	private Spinner grade;
	private Spinner credit;
	private TextView tv;
	
	private static final String[] credits = {
		"Credit","1","2","3","4","5"
	};
	
	private static final String[] grades = {
		"Grade","S","A","B","C","D","E","R","F"
	};
	
	
	
	private Context context;
	private ArrayAdapter<String> creditadapter;
	private ArrayAdapter<String> gradeadapter;
	private SpinnerAdapter greadapter;
	private SpinnerAdapter creadapter;

	public GpaEntry(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		this.context = context;
		//View.inflate(context, R.layout.gpaentry,this);
		
		List<String> cre = new ArrayList<String>();
		cre.add("Credit");
		cre.add("1");
		cre.add("2");
		cre.add("3");
		cre.add("4");
		cre.add("5");
		
		List<String> gre = new ArrayList<String>();
		cre.add("Grade");
		cre.add("S");
		cre.add("A");
		cre.add("B");
		cre.add("C");
		cre.add("D");
		cre.add("E");
		cre.add("R");
		cre.add("F");
		  
	 creadapter = new SpinnerAdapter(context, R.layout.list_item,cre);
	    
	 greadapter = new SpinnerAdapter(context, R.layout.list_item,gre);
	    
		
	}
	
	@Override
	protected void onFinishInflate() {
		
		super.onFinishInflate();
		
		grade = (Spinner) findViewById(R.id.grade);
		credit = (Spinner) findViewById(R.id.credit);
		//TextView tv = (TextView) findViewById(R.id.textView2);
		tv.setText("9");
		

	    grade.setAdapter(greadapter);
	    credit.setAdapter(creditadapter);
	    
	   /* grade.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				Log.i("tag","selected");
				if(statelistener!=null){
					int gPos = grade.getSelectedItemPosition();
					int gr;
					switch (gPos) {
					case 0:gr=0;break;
					case 1:gr=10;break;
					case 2:gr=9;break;
					case 3:gr=8;break;
					case 4:gr=7;break;
					case 5:gr=6;break;
					case 6:gr=5;break;
					case 7:gr=4;break;
					default:gr=0;break;
					}
					statelistener.gradeChange(gr);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				Log.i("tag","nothing");
			}
		});
	    
	    credit.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				Log.i("tag","selected");
				if(statelistener!=null){
					int c = credit.getSelectedItemPosition();
					statelistener.creditChange(c);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				
			}
		});
	*/
         
	}
	
	public boolean checkOk(){
		if((grade.getSelectedItemPosition() == 0 
			&& credit.getSelectedItemPosition() !=0)
			||(grade.getSelectedItemPosition() != 0 
					&& credit.getSelectedItemPosition() ==0)
				){
			return false;
		}else{
			return true;
		}
	}
	
	public int getValue(){
		int gr;
		
		int gPos = grade.getSelectedItemPosition();
		int cPos = credit.getSelectedItemPosition();
		
		switch (gPos) {
		case 0:gr=0;break;
		case 1:gr=10;break;
		case 2:gr=9;break;
		case 3:gr=8;break;
		case 4:gr=7;break;
		case 5:gr=6;break;
		case 6:gr=5;break;
		case 7:gr=4;break;
		default:gr=0;break;
		}
		
		return gr * cPos;
	}
	
	public int getCredit(){
		return credit.getSelectedItemPosition();
	}
	
	

}
