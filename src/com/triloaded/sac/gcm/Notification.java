package com.triloaded.sac.gcm;

import org.json.JSONObject;

import android.util.Log;

public class Notification {
	
	static final String FEED_ID = "id";
	static final String FEED_HEADING = "heading";
	static final String FEED_CONTENT= "content";
	
	private int id;
	private String heading;
	private String content;
	
	
	
	
	public Notification(int id, String heading, String content) {
		this.setId(id);
		this.setHeading(heading);
		this.setContent(content);
		
	}
	
	public Notification(String jString) {
		
		try{

			JSONObject data = new JSONObject(jString);
			
			setId(data.getInt(FEED_ID));
			setHeading(data.getString(FEED_HEADING));
			setContent(data.getString(FEED_CONTENT));
			
			
		}catch(Exception e){
			Log.i("anas","Error creating Notification : "+e.toString());
		}
	}
	
	public Notification(JSONObject data) {
		
		try{
			
			setId(data.getInt(FEED_ID));
			setHeading(data.getString(FEED_HEADING));
			setContent(data.getString(FEED_CONTENT));
			
		}catch(Exception e){
			Log.i("anas","Error creating Notification : "+e.toString());
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
	
}
