package com.triloaded.sac.fragments;

import com.triloaded.sac.R;
import com.triloaded.sac.db.FeedAdapter;
import com.triloaded.sac.db.FeedDb;
import com.triloaded.sac.db.ScriptRunner;
import com.triloaded.sac.db.ScriptRunner.ScriptFinishListener;
import com.triloaded.sac.gcm.Notification;
import com.triloaded.sac.main.MainActivity;

import java.util.List;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class NewsFeed extends Fragment{

	
	private FeedDb db;
	private Context context;
	private List<Notification> feedList;
	private ListView lv;
	private FeedAdapter adapter;
	private ScriptRunner checkrun;
	private ScriptRunner run;
	public NewsFeed() {
		
	}
	
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		context = getActivity().getApplicationContext();
		db = new FeedDb(context);
		feedList = db.getFeeds();
		
		adapter = new FeedAdapter(context, R.layout.feedlist_item, feedList);
		
		lv= (ListView) getActivity().findViewById(R.id.feedlist);
	    lv.setAdapter(adapter);
				
				
		final String maxid = db.getMaxLocalId();
		
		checkrun = new ScriptRunner(new ScriptFinishListener() {
			
			@Override
			public void finish(String result, int resultCode) {
				
				if(resultCode == ScriptRunner.SUCCESS){
					try {
						JSONObject jsonObj = new JSONObject(result);
						String maxCount = jsonObj.getString("maxcount");
						
						Log.i("debug", "net - max:"+maxCount + "local max:"+maxid);
						if(!maxCount.equals(maxid)){
							Update(maxid);
						}
						
						
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				
			}
		});
		
		checkrun.execute(MainActivity.SERVER+"gcm/getMaxFeedId.php");
		
		
		
	}
	
	public void Update(String maxid){
		run = new ScriptRunner(new ScriptFinishListener() {
			
			@Override
			public void finish(String result, int resultCode) {
				
				if(resultCode == ScriptRunner.SUCCESS){
					List<Notification> feeds = new Vector<Notification>();
					
					try {
						JSONArray jArray = new JSONArray(result);
						for(int i=0;i<jArray.length();i++){
							Notification feed = new Notification(jArray.getJSONObject(i));
							feeds.add(feed);
						}
						
						db.addFeeds(feeds);
						
					} catch (JSONException e) {
						Log.i("error", "json"+e.toString());
					}
					
				}
				
			}
		});
		run.execute(MainActivity.SERVER+"gcm/getFeeds.php?maxid="+maxid);
	}
	
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.newsfeed, container, false);
	}
	
	@Override
	public void onDestroy() {
		Log.i("debug", "OnDestroy Called");
		if(run!=null)
		run.cancel(true);
		if(checkrun!=null)
		checkrun.cancel(true);
		super.onDestroy();
	}

	
}
