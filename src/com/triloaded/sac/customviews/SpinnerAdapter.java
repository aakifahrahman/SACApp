package com.triloaded.sac.customviews;

import java.util.List;

import com.triloaded.sac.R;




import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;


public class SpinnerAdapter extends ArrayAdapter<String> {
	
	
	
	private Context context;
	private List<String> data;
	LayoutInflater inflator;

	
	public SpinnerAdapter(Context context, int resource,List<String> eventsData) {
		super(context, resource, eventsData);
		this.context = context;
		this.data = eventsData;
		
		inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		
		
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if(convertView == null){
			 v = inflator.inflate(R.layout.list_item, null);
		}
		
		TextView tv = (TextView) v.findViewById(R.id.tvListItem);
		tv.setText(getItem(position).toString());
		
		
		return v;
	}
	
	 @Override
	 public View getDropDownView(int position, View convertView, ViewGroup parent)
	 {   
		 View v = convertView;
			if(convertView == null){
				 v = inflator.inflate(R.layout.spinner_drop_item, null);
			}
			
			TextView tv = (TextView) v.findViewById(R.id.tvListItem);
			tv.setText(getItem(position).toString());
			
			
			return v;
	 }
	 
	 
	

}


