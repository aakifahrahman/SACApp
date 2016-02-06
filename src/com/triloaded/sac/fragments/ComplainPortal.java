package com.triloaded.sac.fragments;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.triloaded.sac.R;
import com.triloaded.sac.customviews.SpinnerAdapter;
import com.triloaded.sac.db.ScriptRunner;
import com.triloaded.sac.db.ScriptRunner.ScriptFinishListener;
import com.triloaded.sac.gcm.GcmUtils;

import android.support.v4.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ComplainPortal extends Fragment {
	
	private ProgressDialog dialog;
	EditText name_c, rollno_c, complaint_c, phone_c;
	String name="", rollno="", complaint="", phone="",ctype="";
	Spinner spinner;
	List<String> list= new ArrayList<String>();
	
	public ComplainPortal() {
		
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		Button send = (Button) getActivity().findViewById(R.id.sendregister);
	
		 Typeface oxyfont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Oxygen-Regular.ttf");
			
			
			name_c = (EditText) getActivity().findViewById(R.id.name);
			rollno_c = (EditText) getActivity().findViewById(R.id.rollno);
			complaint_c = (EditText) getActivity().findViewById(R.id.complaint);
			phone_c = (EditText) getActivity().findViewById(R.id.phonenumber);
			
			 list.add("Select an issue type");
		     list.add("General");
		     list.add("Hostel");
		     list.add("Mess");
		     list.add("Academic");
		     list.add("Sports");
			

		       
		    SpinnerAdapter adapter = new SpinnerAdapter(getActivity(), R.layout.list_item,list);
				
			
			spinner = (Spinner) getActivity().findViewById(R.id.spinctype);
			spinner.setAdapter(adapter);
			
			
			name_c.setTypeface(oxyfont);
			rollno_c.setTypeface(oxyfont);
			complaint_c.setTypeface(oxyfont);
			phone_c.setTypeface(oxyfont);
				
			
			dialog = new ProgressDialog(getActivity());
	        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
	        dialog.setIndeterminate(true);
	        dialog.setCancelable(false);
	    	dialog.setMessage("Sending..");
	    	
	    	send.setOnClickListener(new OnClickListener(){
	        	@Override
	            public void onClick(View v) {
	        		
	        		boolean ok = true;
	        		rollno = rollno_c.getText().toString();
	    			name = name_c.getText().toString();	
	    			complaint = complaint_c.getText().toString();
	    			phone = phone_c.getText().toString();
	    			ctype=spinner.getSelectedItem().toString();
	    			
	    			if(spinner.getSelectedItemPosition() == 0){
	    				Toast.makeText(getActivity(), "Please Select an issue type.!", Toast.LENGTH_SHORT).show();
	        			ok = false;
	    			}
	    			
	    			else if (rollno.length() == 0 && name.length()==0){
	        			Toast.makeText(getActivity(), "You have to provide either name or rollno !", Toast.LENGTH_SHORT).show();
	        			ok = false;
	        		}
	        		else if(complaint.length() == 0){
	    				Toast.makeText(getActivity(), "Complaint Field cannot be left blank !", Toast.LENGTH_SHORT).show();
	    				ok = false;
	        		}
	    			else if(rollno.length() != 0 && !(rollno.charAt(0)=='M'|| rollno.charAt(0)=='m' || rollno.charAt(0)=='B' || rollno.charAt(0)=='b'|| rollno.charAt(0)=='P'|| rollno.charAt(0)=='p')){
	    				ok = false;
	    				Toast.makeText(getActivity(), "Invalid RollNo !", Toast.LENGTH_SHORT).show();
	    			}
	    			else if(rollno.length() != 9){
	    				ok = false;
	    				Toast.makeText(getActivity(), "Invalid RollNo !", Toast.LENGTH_SHORT).show();
	    			}
	    			
	    				
	    			if(ok == true ){
	    				dialog.show();
	    				
	    				ScriptRunner run = new ScriptRunner(new ScriptFinishListener() {
							
							@Override
							public void finish(String result, int resultCode) {
								dialog.hide();
								if(resultCode == ScriptRunner.SUCCESS){
									Toast.makeText(getActivity(), "Success!", 1500).show();
								}else{
									Toast.makeText(getActivity(), "Check your connection!", 1500).show();
								}
							}
						});
	    				
						try {
							String enRoll = URLEncoder.encode(rollno,"UTF-8");
							String enName = URLEncoder.encode(name,"UTF-8");
		    				String enPhone = URLEncoder.encode(phone,"UTF-8");
		    				String enComplaint = URLEncoder.encode(complaint,"UTF-8");
		    				String enCtype = URLEncoder.encode(ctype,"UTF-8");
		    				String enSenderid = URLEncoder.encode(GcmUtils.getRegistrationId(getActivity()),"UTF-8");
		    				String postReceiverUrl = "http://athena.nitc.ac.in/sac/recieve.php?" +
		    						"rollno="+enRoll+"&name="+enName+"&phone="+enPhone+"" +
		    								"&complaint="+enComplaint+"&type="+enCtype+"&senderid="+enSenderid;
		    				
		    				
		    				
		    				run.execute(postReceiverUrl);
		    				
						} catch (Exception e) {
							dialog.hide();
							Toast.makeText(getActivity(), "Some error occured. Cant send",1000).show();
							
						}
	    				
	    			}
	    			
	        	}
	        });
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.complaint, container, false);
	}
	
	/*class Task extends AsyncTask<Void, Void, Void> {

		protected Void doInBackground(Void... arg0) {		
			
			 String postReceiverUrl = "http://athena.nitc.ac.in/sac/recieve.php";
			  
			 HttpClient httpClient = new DefaultHttpClient();
			  
			 HttpPost httpPost = new HttpPost(postReceiverUrl);
			  
			 List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
			 nameValuePairs.add(new BasicNameValuePair("rollno", rollno));
			 nameValuePairs.add(new BasicNameValuePair("name", name));
			 nameValuePairs.add(new BasicNameValuePair("phone", phone));
			 nameValuePairs.add(new BasicNameValuePair("complaint", complaint));
			 nameValuePairs.add(new BasicNameValuePair("type",ctype));
			 nameValuePairs.add(new BasicNameValuePair("senderid",GcmUtils.getRegistrationId(getActivity())));
			 try {
				httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			 } 
			 catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
			  
			 HttpResponse response = null;
			 try {
				response = httpClient.execute(httpPost);
		   	 } 
			 catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 } 
			 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
			 HttpEntity resEntity = response.getEntity();
			  
			 if (resEntity != null) {
			      
			     String responseStr = null;
			   	 try {
					responseStr = EntityUtils.toString(resEntity).trim();
				 } 
			   	 catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				 } 
			   	 catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    Log.v("aaki", "Response: " +  responseStr);
			      
			 }
			
			 return null; 

		}

		protected void onPostExecute(Void result) {

		    // TODO: do something with the feed
			Toast.makeText(getActivity(), "Sent successfully !", Toast.LENGTH_SHORT).show();
		}
		}
	*/
}
