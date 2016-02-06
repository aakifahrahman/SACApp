package com.triloaded.sac.customviews;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import com.triloaded.sac.R;
import com.triloaded.sac.customviews.Tile.OnExpandListener;

import android.R.integer;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class TileList extends ListView{
	
	
	private Context context;
	//private CustomList listAdapter;
	
	public TileList(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
        
	}
	public TileList(Context context) {
		super(context);
	}

	
	/*
	
	private class CustomList extends ArrayAdapter<String>{
		List<String> strings;
		boolean[] states = new boolean[25];
		public CustomList(Context context,List<String> objects) {
			super(context,R.layout.feedtile,objects);
			strings = objects;
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View v = convertView;
			if(convertView == null){
				LayoutInflater inflator = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				 v = inflator.inflate(R.layout.feedtile, null);
				 states[position] = false;
			
			}else if(!states[position]){	
				LayoutInflater inflator = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				 v = inflator.inflate(R.layout.feedtile, null);
				 states[position] = false;
			}
			
			Tile tile = (Tile) v.findViewById(R.id.tile);
			tile.setPosition(position);
			tile.setOnExpandListener(new OnExpandListener() {
				
				@Override
				public void onExpand(int position) {
					for(int i=0;i<listAdapter.getCount();i++){
						if(position == i){
							states[position]=true;
						}else{
							states[i] =false;
						}
					}
					for(int i =0;i<getChildCount();i++){
							View v = getChildAt(i);
							Tile tile = (Tile) v.findViewById(R.id.tile);
							if(tile.isOpen() && tile.getPosition() != position){
								tile.close();
							}
						
					}
					
				}
			});
			
			tile.setHeading(strings.get(position));
			tile.setContent("");
			
			
			return v;
		}
		
	}
*/
}
