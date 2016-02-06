package com.triloaded.sac.fragments;

import com.triloaded.sac.R;

import android.support.v4.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Home extends Fragment {
	 
	
	HomeFragClickListener listener;
	
	Button handle;
	
	public Home() {
	
	}
	
	TextView main,nit;
	Typeface font;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Oxygen-Regular.ttf");
		
		main = (TextView) getActivity().findViewById(R.id.mainHeading);
		nit = (TextView) getActivity().findViewById(R.id.nitcalicut_tv);
		
		main.setTypeface(font);
		nit.setTypeface(font);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.home, container, false);
	}
	
	public void setHomeFragClickListener(HomeFragClickListener listener){
		this.listener = listener;
	}
	
	public interface HomeFragClickListener{
		public void onClick(int n);
	}
	
}
