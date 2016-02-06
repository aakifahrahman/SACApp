package com.triloaded.sac.main;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.triloaded.sac.R;

public class SplashScreen extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.splash);
		
		RelativeLayout page = (RelativeLayout) findViewById(R.id.page);
		page.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(SplashScreen.this, MainActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		Toast.makeText(this, "Touch to enter", 5000).show();;
	}

}
