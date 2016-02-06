package com.triloaded.sac.customviews;



import com.triloaded.sac.R;
import com.triloaded.sac.customviews.CreditDialog.CreditChooseListener;
import com.triloaded.sac.customviews.GradeDialog.GradeChooseListener;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GpaView extends LinearLayout {

	private Context context;
	TextView tv;
	Button creditBtn,gradeBtn;
	private GpaStateChangeListener statelistener;
	
	public GpaView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
	}

	
	
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		
		creditBtn = (Button) findViewById(R.id.credit_btn);
		gradeBtn = (Button) findViewById(R.id.grade_btn);
		creditBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
					//statelistener.creditChange(credit)
					CreditDialog dialog = new CreditDialog(context, new CreditChooseListener() {
						
						@Override
						public void choose(int credit) {
							if(statelistener!=null){
								creditBtn.setText(""+credit);
								statelistener.creditChange(credit);
							}
						}
					});
					dialog.show();
				}
			
		});
		gradeBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				GradeDialog dialog = new GradeDialog(context, new GradeChooseListener() {
					
					@Override
					public void choose(int grade, String s) {
						if(statelistener!=null){
							gradeBtn.setText(s);
							statelistener.gradeChange(grade);
						}
						
					}
				});
				dialog.show();
				
			}
		});
		
	}
	
	
	public GpaStateChangeListener getStatelistener() {
		return statelistener;
	}

	public void setStatelistener(GpaStateChangeListener statelistener) {
		this.statelistener = statelistener;
	}

	public interface GpaStateChangeListener{
		public void gradeChange(int grade);
		public void creditChange(int credit);
	}
}
