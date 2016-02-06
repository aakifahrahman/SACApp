package com.triloaded.sac.customviews;

import android.app.ActionBar.LayoutParams;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

import com.triloaded.sac.R;

public class GradeDialog extends Dialog implements OnClickListener{
	
	private Button b1,b2,b3,b4,b5,b6,b7,b8;
	private GradeChooseListener listener;
	
	public GradeDialog(Context context, GradeChooseListener listener) {
		super(context);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
		getWindow().setLayout(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		
		this.listener = listener;
		setContentView(R.layout.gradedialog);
		
		b1 = (Button) findViewById(R.id.button1);
		b2 = (Button) findViewById(R.id.button2);
		b3 = (Button) findViewById(R.id.button3);
		b4 = (Button) findViewById(R.id.button4);
		b5 = (Button) findViewById(R.id.button5);
		b6 = (Button) findViewById(R.id.button6);
		b7 = (Button) findViewById(R.id.button7);
		b8 = (Button) findViewById(R.id.button8);
		
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		b5.setOnClickListener(this);
		b6.setOnClickListener(this);
		b7.setOnClickListener(this);
		b8.setOnClickListener(this);
		
		
		
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.button1: listener.choose(10,"S");dismiss();break;
		case R.id.button2: listener.choose(9,"A");dismiss();break;
		case R.id.button3: listener.choose(8,"B");dismiss();break;
		case R.id.button4: listener.choose(7,"C");dismiss();break;
		case R.id.button5: listener.choose(6,"D");dismiss();break;
		case R.id.button6: listener.choose(5,"E");dismiss();break;
		case R.id.button7: listener.choose(4,"R");dismiss();break;
		case R.id.button8: listener.choose(3,"F");dismiss();break;
		}
	}
	
	
	public interface GradeChooseListener{
	  
		public void choose(int grade, String s);
	
	}


}
