package com.triloaded.sac.fragments;

import java.net.URLEncoder;

import android.support.v4.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.triloaded.sac.R;
import com.triloaded.sac.db.ScriptRunner;
import com.triloaded.sac.db.ScriptRunner.ScriptFinishListener;
import com.triloaded.sac.gcm.GcmUtils;
public class Suggestions extends Fragment{

	SuggFragClickListener listener;
	
	Button handle;
	private EditText emailSubject = null;
	private EditText emailBody = null;

	private ProgressDialog dialog;
	
	public Suggestions() {
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		TextView subject = (TextView) getActivity().findViewById(R.id.subject);
		TextView message = (TextView) getActivity().findViewById(R.id.message);
		
		Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Oxygen-Regular.ttf");
		subject.setTypeface(font);
		message.setTypeface(font);
		
		emailSubject = (EditText) getActivity().findViewById(R.id.subjecttext);
		emailBody = (EditText) getActivity().findViewById(R.id.messagetext);
		handle = (Button) getActivity().findViewById(R.id.send);
		
		dialog = new ProgressDialog(getActivity());
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);
    	dialog.setMessage("Sending..");
		
        handle.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
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
				String enSubj = URLEncoder.encode(emailSubject.getText().toString(),"UTF-8");
				String enBody = URLEncoder.encode(emailBody.getText().toString(),"UTF-8");
				String postReceiverUrl = "http://athena.nitc.ac.in/sac/suggest.php?" +
						"subject="+enSubj+"&suggestion="+enBody;
				run.execute(postReceiverUrl);
				
			} catch (Exception e) {
				dialog.hide();
				Toast.makeText(getActivity(), "Some error occured. Cant send.  ",1000).show();
				
			}
       	 }
     
        });
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.suggest, container, false);
	}
	
	public void setSuggFragClickListener(SuggFragClickListener listener){
		this.listener = listener;
	}
	
	public interface SuggFragClickListener{
		public void onClick(int n);
	}
}
