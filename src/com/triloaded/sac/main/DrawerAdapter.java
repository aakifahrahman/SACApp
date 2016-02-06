
package com.triloaded.sac.main;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.triloaded.sac.R;

import java.util.List;

public class DrawerAdapter extends ArrayAdapter<DrawerItem>
{

    private Context context;
    private List<DrawerItem> draweritems;
    private Typeface font;
	
    public DrawerAdapter(Context context, int resource,List<DrawerItem> items) {
		super(context, resource, items);
		this.context = context;
		this.draweritems = items;
		font = Typeface.createFromAsset(context.getAssets(), "fonts/chubgothic.ttf");
		
	}

    public int getCount(){
        return draweritems.size();
    }

    public DrawerItem getItem(int i){
        return draweritems.get(i);
    }

    public long getItemId(int i){
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup) {
        if (view == null)
        {
            view = ((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.drawerlistitem, null);
        }
        ImageView imageview = (ImageView)view.findViewById(R.id.iv1);
        TextView textview = (TextView)view.findViewById(R.id.tv1);
        imageview.setImageResource((draweritems.get(i)).getIcon());
        textview.setText((draweritems.get(i)).getTitle());
        textview.setTypeface(font);
        return view;
        
    }
}
