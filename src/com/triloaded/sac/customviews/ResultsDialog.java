package com.triloaded.sac.customviews;

import com.triloaded.sac.R;
import android.app.Dialog;
import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.widget.TextView;

public class ResultsDialog extends Dialog {
	
	TextView tv;
	
	public ResultsDialog(Context context, String gpa) {
		super(context);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
		getWindow().setLayout(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		
		setContentView(R.layout.resultdialog);
		
		tv = (TextView) findViewById(R.id.result);
		tv.setText(""+gpa);
		
		
		
	}
	

}
