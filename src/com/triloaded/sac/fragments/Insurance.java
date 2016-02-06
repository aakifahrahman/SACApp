package com.triloaded.sac.fragments;



import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.triloaded.sac.R;
public class Insurance extends Fragment{

	private TextView body, heading;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Oxygen-Regular.ttf");
		
		/*body = (TextView) getActivity().findViewById(R.id.txttext);
		heading = (TextView) getActivity().findViewById(R.id.txtheading);
		
        body.setText("Vidal Healthcare Private Limited is a health management & services company." +
        		" Headquartered in Bangalore they have a pan India presence - their provider network covers 125 cites," +
        		" and has over 1000 Diagnostic centers, 600 Doctors and Specialists," +
        		" 150 Counselors, Nutritionists and Trainers." +"They are the bridge between the providers of health care" +
        		" delivery and those who pay for it - they leverage their partnerships and aggregate" +
        		" the expertise of some of the best brand in the business to bring us holistic Wellness programs." +
        		"Vidal Health is the official Medical Insurance provider for NIT Calicut students. You can download their Android" +
        		"App - Vidal Health Vire -  at ");   
        
        body.setTypeface(font);
        heading.setTypeface(font);
        */
		

	    WebView browser = (WebView) getActivity().findViewById(R.id.webview);
	    browser.loadUrl("file:///android_asset/insure.html");
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.insurance, container, false);
	}
	
}
