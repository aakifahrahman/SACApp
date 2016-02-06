package com.triloaded.sac.calendar.db;

import java.util.ArrayList;

import com.triloaded.sac.R;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class CustomListAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<CalendarItem> listData;

	private LayoutInflater layoutInflater;

	public CustomListAdapter(Context context, ArrayList<CalendarItem> listData) {
		this.context = context;
		this.listData = listData;
		layoutInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return listData.size();
	}

	@Override
	public Object getItem(int position) {
		return listData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = layoutInflater.inflate(R.layout.calendar_list_item, null);
			holder = new ViewHolder();
			
			Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/Oxygen-Regular.ttf");
			
			holder.dateView = (TextView) convertView.findViewById(R.id.date);
			holder.eventView = (TextView) convertView.findViewById(R.id.event);
			
			holder.dateView.setTypeface(font);
			holder.eventView.setTypeface(font);
			
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.dateView.setText(listData.get(position).getdate());
		holder.eventView.setText(listData.get(position).getevent());

		return convertView;
	}

	static class ViewHolder {
		TextView dateView;
		TextView eventView;
	}

}
