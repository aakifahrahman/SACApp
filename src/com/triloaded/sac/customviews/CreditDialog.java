package com.triloaded.sac.customviews;

import com.triloaded.sac.R;

import android.app.Dialog;
import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class CreditDialog extends Dialog implements android.view.View.OnClickListener{
	
	private Button b1,b2,b3,b4,b5;
	private CreditChooseListener listener;
	
	public CreditDialog(Context context, CreditChooseListener listener) {
		super(context);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
		getWindow().setLayout(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		
		this.listener = listener;
		
		setContentView(R.layout.creditdialog);
		b1 = (Button) findViewById(R.id.button1);
		b2 = (Button) findViewById(R.id.button2);
		b3 = (Button) findViewById(R.id.button3);
		b4 = (Button) findViewById(R.id.button4);
		b5 = (Button) findViewById(R.id.button5);
		
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		b5.setOnClickListener(this);
		
		
		
		
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.button1: listener.choose(1);dismiss();break;
		case R.id.button2: listener.choose(2);dismiss();break;
		case R.id.button3: listener.choose(3);dismiss();break;
		case R.id.button4: listener.choose(4);dismiss();break;
		case R.id.button5: listener.choose(5);dismiss();break;
		}
	}
	
	
	public interface CreditChooseListener{
	  
		public void choose(int credit);
	
	}

}
