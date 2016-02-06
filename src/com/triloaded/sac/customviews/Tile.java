package com.triloaded.sac.customviews;

import java.util.List;
import java.util.Vector;

import com.triloaded.sac.R;


import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.MeasureSpec;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

public class Tile extends LinearLayout {
	
	private boolean open = false;
	private Context context;
	private int position;
	
	private TextView heading;
	private TextView body;
	
	private String headingText;
	private String bodytext;
	
	private int height;
	private int expandedHeight;
	//private int heightExtension = 400;
	
	
	private ResizeAnimation openAnim;
	private ResizeAnimation closeAnim;
	private OnExpandListener expandListener;
	private Typeface font;
	
	public Tile(final Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		font = Typeface.createFromAsset(context.getAssets(), "fonts/Oxygen-Regular.ttf");
		
		setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(open){
					startAnimation(closeAnim);
					open = false;
				}else{
					expandListener.onExpand(position);
					startAnimation(openAnim);
					open = true;
				}
			}
		});
	}
	
	
	public Tile(Context context){
		super(context);
	}
	
	
	
	public void setHeading(String s){
		this.headingText = s;
		heading.setText(headingText);
		heading.setTypeface(font);
		//heading.invalidate();
	}
	public void setContent(String s){
		this.bodytext = s;
		body.setText(bodytext);
		body.setTypeface(font);
		Log.i("anas", "Specs h:"+height+" exp: "+expandedHeight+" h "+this.getHeight());
		
	}
	
	
	public boolean isOpen(){
		return open;
	}
	public void close(){
		if(open){
			startAnimation(closeAnim);
			open = false;
		}
	}
	
	public void open(){
		if(!open){
			startAnimation(openAnim);
			open = true;
		}
	}
	public void setOnExpandListener(OnExpandListener listener){
		this.expandListener = listener;
	}
	
	
	
	public void setPosition(int p){
		this.position  = p;
	}
	
	public int getPosition(){
		return position;
	}
	
	@Override
	protected void onFinishInflate() {
	
		super.onFinishInflate();
		heading = (TextView) findViewById(R.id.headText);
		body = (TextView) findViewById(R.id.feedContent);
		ScrollView view = (ScrollView) findViewById(R.id.scrollpad);
		view.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				v.getParent().requestDisallowInterceptTouchEvent(true);
				Log.i("tag", ""+v.getParent().toString());
				return false;
			}
		});
		
		//Log.i("anas", "Finish h:"+height+" exp: "+expandedHeight+" h "+this.getHeight());
		
	}
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		
		if(height == 0){
			height = MeasureSpec.getSize(heightMeasureSpec);
			int width = MeasureSpec.getSize(widthMeasureSpec);
			Log.i("tag", "w:"+width+" h: "+height);
			if(height>100){
				expandedHeight = height+400;
			}else if(height>75){
				expandedHeight = height+300;
				
			}else if(height>50){
				expandedHeight = height+200;
			}else{
				expandedHeight = height+100;
			}
			Log.i("anas", "Specs h:"+height+" exp: "+expandedHeight+" h "+this.getHeight());
			
			super.onMeasure(widthMeasureSpec, heightMeasureSpec);
			
			openAnim = new ResizeAnimation(Tile.this,height, expandedHeight);
			openAnim.setDuration(500);
			closeAnim = new ResizeAnimation(Tile.this,expandedHeight, height);
			closeAnim.setDuration(500);
		}else{
			super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		}
	}
	
	
	/* Interface for handling open and close */
	public interface OnExpandListener{ 
		public void onExpand(int position);
	}
	
	public interface OnOptionClickListener{
		public void onOptionClick(String place);
	}
	
}
