package com.triloaded.sac.fragments;

import com.triloaded.sac.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class WebViewFragment extends Fragment {
	
	public static final int MANIFESTO = 1;
	public static final int PAST_WORKS = 2;
	public static final int PROFILE = 3;
	
	public static final String KEY ="key";
	
	WebView browser;
	
	
	public WebViewFragment() {
		
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Bundle bundle = getArguments();
		int type = bundle.getInt(KEY);
		    
		browser = (WebView) getActivity().findViewById(R.id.browser);
		
		 switch(type){
		    case MANIFESTO: browser.loadUrl("file:///android_asset/manifesto.html");break;
		    case PAST_WORKS: browser.loadUrl("file:///android_asset/pastworks.html");break;
		    case PROFILE:browser.loadUrl("file:///android_asset/profile.html"); break;
		    	
		    }
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.webviewlayout, container, false);
	}
	
	

}
