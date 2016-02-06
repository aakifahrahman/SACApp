package com.triloaded.sac.contacts;

import java.util.List;

import com.triloaded.sac.R;




import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ContactMenuAdapter extends ArrayAdapter<String> {
	
	 private Context context;
	private List<String> items;
	private Typeface font;

	public ContactMenuAdapter(Context context, int resource,List<String> items) {
			super(context, resource, items);
			this.context = context;
			this.items = items;
			//font = Typeface.createFromAsset(context.getAssets(), "fonts/code.otf");
			
		}

	    public int getCount(){
	        return items.size();
	    }

	    public String getItem(int i){
	        return items.get(i);
	    }

	    public long getItemId(int i){
	        return (long)i;
	    }

	    public View getView(int i, View convertView, ViewGroup viewgroup) {
	    	String headerTitle = (String) getItem(i);
			if (convertView == null) {
				LayoutInflater infalInflater = (LayoutInflater) this.context
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = infalInflater.inflate(R.layout.contacts_parent_item, null);
			}

			Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/Oxygen-Regular.ttf");
			TextView lblListHeader = (TextView) convertView.findViewById(R.id.lblListHeader);
			lblListHeader.setTypeface(font);
			lblListHeader.setText(headerTitle);
			return convertView;
	        
	    }
	}
