package com.triloaded.sac.customviews;

import com.triloaded.sac.R;
import com.triloaded.sac.customviews.GpaView.GpaStateChangeListener;
import com.triloaded.sac.customviews.Tile;
import com.triloaded.sac.customviews.Tile.OnExpandListener;


import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GpaAdapter extends ArrayAdapter<Gpa> {
	
	private Context context;
	private List<Gpa> gpalist;
	private Typeface font;

	public GpaAdapter(Context context, int resource,List<Gpa> items) {
			super(context, resource, items);
			this.context = context;
			this.gpalist = items;
			//font = Typeface.createFromAsset(context.getAssets(), "fonts/Oxygen-Regular.ttf");
			
		}

	    public int getCount(){
	        return gpalist.size();
	    }

	    public Gpa getItem(int i){
	        return gpalist.get(i);
	    }
	    
	    public boolean checkValid(){
	    	for(int i=0;i<gpalist.size();i++){
	    		if(!gpalist.get(i).isValid()){
	    			Toast.makeText(context,"Check "+(i+1) , 2000).show();
	    			return false;
	    		}
	    	}
	    	return true;
	    }
	    
	    public float getGpaVal(){
	    	int totalcredits=0;
	    	float total = 0;
	    	for(int i=0;i<gpalist.size();i++){
	    		totalcredits+=gpalist.get(i).getCredit();
	    		total += gpalist.get(i).getCredit() * gpalist.get(i).getGradepoint();
	    	}
	    	return total/totalcredits;
	    }
	    
	    public int getTotalcredits(){
	    	int totalcredits=0;
	    	
	    	for(int i=0;i<gpalist.size();i++){
	    		totalcredits+=gpalist.get(i).getCredit();
	    	}
	    	return totalcredits;
	    }

	    public long getItemId(int i){
	        return (long)i;
	    }

	    public View getView(final int i, View view, ViewGroup viewgroup) {
	        if (view == null)
	        {
	            view = ((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.gpa_item, null);
	        }
	        
	        GpaView gpa = (GpaView) view.findViewById(R.id.gpaview);
	        Button cB = (Button) gpa.findViewById(R.id.credit_btn);
	        Button gB = (Button) gpa.findViewById(R.id.grade_btn);
	        TextView tv = (TextView) gpa.findViewById(R.id.count);
	        tv.setText(""+(i+1));
	        if(gpalist.get(i).getCredit()==0){
	        	cB.setText("Credit");
	        }else{
	        	cB.setText(""+gpalist.get(i).getCredit());
	        }
	        if(gpalist.get(i).getGradepoint()==0){
	        	gB.setText("Grade");
	        }else{
	        	//Toast.makeText(context, "from function",1000).show();
	        	gB.setText(""+getGradeLetter(gpalist.get(i).getGradepoint()));
	        }
	        gpa.setStatelistener(new GpaStateChangeListener() {
				
				@Override
				public void gradeChange(int grade) {
					Gpa gpa = gpalist.get(i);
					gpa.setGradepoint(grade);
					if(gpa.getCredit()==0){
						gpa.setValid(false);
						//Toast.makeText(context, "made valid", 1000).show();
					}else{
						gpa.setValid(true);
					}
				}
				
				@Override
				public void creditChange(int credit) {
					Gpa gpa = gpalist.get(i);
					gpa.setCredit(credit);
					if(gpa.getGradepoint()==0){
						gpa.setValid(false);
						
					}else{
						gpa.setValid(true);
					}
					
				}
			});
	
	
	        return view;
	        
	    }

		private String getGradeLetter(int credit) {
			String s;
			switch(credit){
			case 10: s="S";break;
			case 9: s="A";break;
			case 8: s="B";break;
			case 7: s="C";break;
			case 6: s="D";break;
			case 5:s="E";break;
			case 4:s="R";break;
			case 3:s="F";break;
			default:s="Grade";break;
			}
			return s;
		}
	    
  
}
