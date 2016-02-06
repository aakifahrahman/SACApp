package com.triloaded.sac.db;

import com.triloaded.sac.R;
import com.triloaded.sac.customviews.Tile;
import com.triloaded.sac.customviews.Tile.OnExpandListener;
import com.triloaded.sac.gcm.Notification;

import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FeedAdapter extends ArrayAdapter<Notification> {
	
	 private Context context;
	private List<Notification> feeds;
	private Typeface font;

	public FeedAdapter(Context context, int resource,List<Notification> items) {
			super(context, resource, items);
			this.context = context;
			this.feeds = items;
			font = Typeface.createFromAsset(context.getAssets(), "fonts/Oxygen-Regular.ttf");
			
		}

	    public int getCount(){
	        return feeds.size();
	    }

	    public Notification getItem(int i){
	        return feeds.get(i);
	    }

	    public long getItemId(int i){
	        return (long)i;
	    }

	    public View getView(int i, View view, ViewGroup viewgroup) {
	        if (view == null)
	        {
	            view = ((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.feedtile, null);
	        }
	        
	       /* RelativeLayout layout = (RelativeLayout) view;
	        TextView heading = (TextView)layout.findViewById(R.id.feedHeading);
	        heading.setText((feeds.get(i)).getHeading());
	        TextView content = (TextView)layout.findViewById(R.id.feedContent);
	        content.setText((feeds.get(i)).getContent());
	       
	        heading.setTypeface(font);
	        content.setTypeface(font);*/
	        
	        Tile tile = (Tile) view.findViewById(R.id.tile);
			tile.setPosition(i);
			tile.setOnExpandListener(new OnExpandListener() {
				
				@Override
				public void onExpand(int position) {
					Log.i("tag","expanding");
				}
			});
			/*tile.setOnExpandListener(new OnExpandListener() {
				
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
			});*/
			
			tile.setHeading(feeds.get(i).getHeading());
			tile.setContent(feeds.get(i).getContent());
		
	        return view;
	        
	    }
	}
