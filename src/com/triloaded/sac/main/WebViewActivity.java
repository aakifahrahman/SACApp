package com.triloaded.sac.main;


import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import com.triloaded.sac.R;

public class WebViewActivity extends Activity {
	
	public static final int MANIFESTO_PAGE1 = 1;
	public static final int MANIFESTO_PAGE2 = 2;
	public static final int MANIFESTO_PAGE3 = 3;
	public static final int MANIFESTO_PAGE4 = 4;
	public static final int PW_PAGE1 = 5;
	public static final int PW_PAGE2 = 6;
	public static final int PW_PAGE3 = 7;
	public static final int PW_PAGE4 = 8;
	
	public static final String KEY = "key";
	
	private WebView browser;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webviewlayout);
		browser = (WebView) findViewById(R.id.browser);
		
		Bundle bundle = getIntent().getExtras();
		int page = bundle.getInt(KEY);
		
		switch (page) {
		case MANIFESTO_PAGE1:browser.loadUrl("file:///android_asset/manifest1.html");break;
		case MANIFESTO_PAGE2:browser.loadUrl("file:///android_asset/manifest2.html");break;
		case MANIFESTO_PAGE3:browser.loadUrl("file:///android_asset/manifest3.html");break;
		case MANIFESTO_PAGE4:browser.loadUrl("file:///android_asset/manifest4.html");break;
		case PW_PAGE1:browser.loadUrl("file:///android_asset/pw1.html");break;
		case PW_PAGE2:browser.loadUrl("file:///android_asset/pw2.html");break;
		case PW_PAGE3:browser.loadUrl("file:///android_asset/pw3.html");break;
		case PW_PAGE4:browser.loadUrl("file:///android_asset/pw4.html");break;
		
		default:break;
		}
		
		
	}

}
