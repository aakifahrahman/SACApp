package com.triloaded.sac.customviews;

import java.security.PublicKey;

import com.triloaded.sac.R;

import android.app.Dialog;
import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CgpaDialog extends Dialog{
	
	
	
	CgpaChoiceListener listener;
	int semval;
	EditText gpa,credit;
	Button calcBtn,gotoBtn;
    Context context;
		
	public CgpaDialog(Context contxt,int sem, CgpaChoiceListener listen) {
		super(contxt);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.WHITE));
		getWindow().setLayout(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		this.context = contxt;
		this.listener = listen;
		this.semval = sem;
		setContentView(R.layout.cgpachoice);
		gpa = (EditText) findViewById(R.id.gpaet);
		credit = (EditText) findViewById(R.id.creditset);
		calcBtn = (Button) findViewById(R.id.choosebtn);
		gotoBtn = (Button) findViewById(R.id.gotocalc);
		
		calcBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int credits=-1;
				float gpaval=-1;
				try{
					credits = Integer.parseInt(credit.getText().toString());
					gpaval = Float.parseFloat(gpa.getText().toString());
				}catch(Exception e){
					Toast.makeText(context, "Enter valid values.", 1000).show();
				}
				if(credits>0&&gpaval>0){
				listener.choiceCalc(semval, gpaval, credits);
				dismiss();
				}
			}
		});
		
		gotoBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				listener.choiceGoto(semval);
				dismiss();
			}
		});
		
		
		
	}
	
	
	
	public interface CgpaChoiceListener {
		
		public void choiceGoto(int sem);
		public void choiceCalc(int sem, float gpa, int credits);
	}

}
