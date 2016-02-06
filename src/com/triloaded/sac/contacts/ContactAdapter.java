package com.triloaded.sac.contacts;

import java.util.List;


import com.triloaded.sac.R;
import com.triloaded.sac.contacts.ContactsActivity.ContactListener;






import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.provider.ContactsContract.PhoneLookup;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ContactAdapter extends ArrayAdapter<Contact> {
	
	 private Context context;
	private List<Contact> items;
	private Typeface font;
	ContactListener listener;

	public ContactAdapter(Context context, int resource,List<Contact> items, ContactListener listener) {
			super(context, resource, items);
			this.context = context;
			this.items = items;
			this.listener = listener;
			//font = Typeface.createFromAsset(context.getAssets(), "fonts/code.otf");
			
		}

	    public int getCount(){
	        return items.size();
	    }

	    public Contact getItem(int i){
	        return items.get(i);
	    }

	    public long getItemId(int i){
	        return (long)i;
	    }

	    public View getView(int i, View convertView, ViewGroup viewgroup) {
	    	
	    	final Contact child = (Contact) getItem(i);

			if (convertView == null) {
				LayoutInflater infalInflater = (LayoutInflater) this.context
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = infalInflater.inflate(R.layout.contacts_child_item, null);
			}
			
			Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/Oxygen-Regular.ttf");
			
			TextView txtListChildName = (TextView) convertView.findViewById(R.id.name_c);
			txtListChildName.setText(child.getName());
			txtListChildName.setTypeface(font);
			
			TextView txtListChildPost = (TextView) convertView.findViewById(R.id.main_post);
			txtListChildPost.setText(child.getPost());
			txtListChildPost.setTypeface(font);
			
			TextView txtListChildPhone = (TextView) convertView.findViewById(R.id.phone_c);
			txtListChildPhone.setText(child.getPhone());
			txtListChildPhone.setTypeface(font);
			
			TextView txtListChildEmail = (TextView) convertView.findViewById(R.id.email_c);
			txtListChildEmail.setText(child.getEmail());
			txtListChildEmail.setTypeface(font);
	       
			RelativeLayout em = (RelativeLayout) convertView.findViewById(R.id.maillayout);
	        RelativeLayout ph = (RelativeLayout) convertView.findViewById(R.id.phonelayout);
	        ph.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					listener.call("+91"+child.getPhone());
					Log.i("tag", "hello");
				}
			});
	        em.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					listener.mail(child.getEmail());
					Log.i("tag", "hello");
				}
			});
	        
	        TextView fun = (TextView) convertView.findViewById(R.id.funtext);
	        fun.setText(""+child.getPost().charAt(0));
	        Log.i("tag",""+child.getPost().charAt(0));
	        fun.setTypeface(font);
			
			
	        return convertView;
	        
	    }
	}
