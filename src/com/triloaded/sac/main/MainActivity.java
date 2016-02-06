package com.triloaded.sac.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Vector;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.triloaded.sac.R;
import com.triloaded.sac.fragments.CGPA;
import com.triloaded.sac.fragments.Calendar;
import com.triloaded.sac.fragments.ComplainPortal;
import com.triloaded.sac.fragments.Contacts;
import com.triloaded.sac.fragments.GPACalculatr;
import com.triloaded.sac.fragments.Home;
import com.triloaded.sac.fragments.Insurance;
import com.triloaded.sac.fragments.NewsFeed;
import com.triloaded.sac.fragments.Suggestions;
import com.triloaded.sac.fragments.WebViewFragment;
import com.triloaded.sac.fragments.Home.HomeFragClickListener;
import com.triloaded.sac.gcm.GcmUtils;
import com.triloaded.sac.gcm.RegisterApp;

import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {
	
	public static final String SERVER = "http://bulls-paperback.rhcloud.com/sacapp/";
	
	public static final int HOME_FRAG = 0;
	public static final int COMPLAINT = 1;
	public static final int NEWSFEED = 2;
	public static final int CONTACTS = 3;
	public static final int SGPA_CALC = 4;
	public static final int CGPA_CALC = 5;
	public static final int CALENDAR = 6;
	public static final int INSURANCE = 7;
	public static final int SUGGESTIONS = 8;
	
	
	public boolean isOnHome = true;
	
	private class SlideMenuClickListener  implements android.widget.AdapterView.OnItemClickListener{
		public SlideMenuClickListener() {
		}
		
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int i, long arg3) {
			displayView(i);
		}
	}

	private void displayView(int i) {
		Bundle args;
        Object obj = null;
        WebViewFragment webfrag = null;
        
        FragmentTransaction ftransn;
        
        if(i==HOME_FRAG){
        	isOnHome = true;
        }else{
        	isOnHome = false;
        }
        
        switch (i) {
        	case HOME_FRAG:
        		ftransn = getSupportFragmentManager().beginTransaction();
        		//ftransn.setCustomAnimations(R.anim.card_flip_right_in,R.anim.card_flip_right_out);
        		ftransn.replace(R.id.frame_container,(android.support.v4.app.Fragment) home).commit();
                break;
			case COMPLAINT:
				obj = new ComplainPortal();
				getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, ((android.support.v4.app.Fragment) (obj))).commit();
	            break;
			case NEWSFEED:
				obj = new NewsFeed();
				getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, ((android.support.v4.app.Fragment) (obj))).commit();
	            break;
			case CONTACTS:
				obj = new Contacts();
				getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, ((android.support.v4.app.Fragment) (obj))).commit();
	            break;
			case SGPA_CALC:
				obj = new GPACalculatr();
				getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, ((android.support.v4.app.Fragment) (obj))).commit();
	            break;
			case CGPA_CALC:
				obj = new CGPA();
				getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, ((android.support.v4.app.Fragment) (obj))).commit();
	            break;
			case SUGGESTIONS:
				obj = new Suggestions();
				getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, ((android.support.v4.app.Fragment) (obj))).commit();
	            break;
			case CALENDAR:
				obj = new Calendar();
				getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, ((android.support.v4.app.Fragment) (obj))).commit();
	            break;
			case INSURANCE:
				obj = new Insurance();
				getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, ((android.support.v4.app.Fragment) (obj))).commit();
	            break;
			default:
				Log.e("MainActivity", "Error in creating fragment");
				break;
		}
 
        setValues(i);
        
    }
	
	private void setValues(int i){
		if(i==HOME_FRAG){
			isOnHome = true;
		}else{
			isOnHome = false;
		}
		drawerList.setItemChecked(i, true);
        drawerList.setSelection(i);
        setTitle(drawerTitles[i]);
        drawerLayout.closeDrawer(drawerList);
	}

	private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
	private GoogleCloudMessaging gcm;
	
	private DrawerAdapter adapter;
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private CharSequence drawerTitle;
    private CharSequence title;
    
    private ActionBarDrawerToggle drawerToggle;
   
    private List<DrawerItem> items = new Vector<DrawerItem>();
    
    
    private int[] drawerIcons = new int[]{
    		R.drawable.drawer_home,R.drawable.drawer_complain,
    		R.drawable.drawer_feed,
    		R.drawable.drawer_contact,R.drawable.drawer_calc,
    		R.drawable.drawer_calc,R.drawable.drawer_calendar,
    		R.drawable.drawer_complain,
    		R.drawable.drawer_suggest
    };
    
    private String[] drawerTitles = new String[]{
    		"HOME","COMPLAINTS PORTAL","NEWSFEED","CONTACTS",
    		"SGPA CALCULATOR","CGPA CALCULATOR","ACADEMIC CALENDAR","INSURANCE","SUGGESTIONS"
    };
    
	private String dbpath;
	private Home home;
	
    public void onConfigurationChanged(Configuration configuration){
        super.onConfigurationChanged(configuration);
        drawerToggle.onConfigurationChanged(configuration);
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        overridePendingTransition(R.anim.fade, R.anim.hold);
        
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/chubgothic.ttf");
		
        
        int titleId = getResources().getIdentifier("action_bar_title", "id",
	            "android");
	    TextView tit = (TextView) findViewById(titleId);
	    tit.setTypeface(font);
	    tit.setTextColor(getResources().getColor(R.color.color_black));
        
      //GCM Registeration if not registered!!
      	    String regId = GcmUtils.getRegistrationId(this);
      	
      		if(regId.isEmpty()){
      			//need Registeration!!
      			if (checkPlayServices()) {
      				gcm = GoogleCloudMessaging.getInstance(getApplicationContext());
      				int appVersion = GcmUtils.getAppVersion(this);
      				new RegisterApp(getApplicationContext(), gcm, appVersion).execute();
      			}
      		}
      		
       ///reg end
      		
      		home = new Home();
    		home.setHomeFragClickListener(new HomeFragClickListener() {
				@Override
				public void onClick(int n) {
					Log.i("debug", "Called");
			
				}
			});
        
        CharSequence charsequence = getTitle();
        drawerTitle = charsequence;
        title = charsequence;
       
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        
        drawerList = (ListView)findViewById(R.id.list_slidermenu);
      
        items.add(new DrawerItem(drawerTitles[0], drawerIcons[0]));
        items.add(new DrawerItem(drawerTitles[1], drawerIcons[1]));
        items.add(new DrawerItem(drawerTitles[2], drawerIcons[2]));
        items.add(new DrawerItem(drawerTitles[3], drawerIcons[3]));
        items.add(new DrawerItem(drawerTitles[4], drawerIcons[4]));
        items.add(new DrawerItem(drawerTitles[5], drawerIcons[5]));
        items.add(new DrawerItem(drawerTitles[6], drawerIcons[6]));
        items.add(new DrawerItem(drawerTitles[7], drawerIcons[7]));
        items.add(new DrawerItem(drawerTitles[8], drawerIcons[8]));
        
        drawerList.setOnItemClickListener(new SlideMenuClickListener());
        adapter = new DrawerAdapter(getApplicationContext(),R.layout.drawerlistitem, items);
        drawerList.setAdapter(adapter);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.drawer_icon, R.string.drawer_open, R.string.drawer_close){

            public void onDrawerClosed(View view){
                getActionBar().setTitle(title);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View view){
                getActionBar().setTitle(drawerTitle);
                invalidateOptionsMenu();
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
        
        Bundle b = getIntent().getExtras();
        if(b!=null){
        	displayView(NEWSFEED);
        }else if (savedInstanceState == null){
            displayView(HOME_FRAG);
        }
            
        if(!checkDB()){
        	Log.i("debug", "copying db");
			copyDataBase();
		}
        
        //recieving data passed from sgpa to here
        Intent intent = getIntent();
        String message = intent.getStringExtra("point");
        //Toast.makeText(this, "Recieved "+message, Toast.LENGTH_SHORT).show();
        
        
        //send this data to cgpa
        Bundle bundle=new Bundle();
        bundle.putString("message", message);
        //set fragment class Arguments
        CGPA fragobj=new CGPA();
        fragobj.setArguments(bundle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem menuitem){
        if (drawerToggle.onOptionsItemSelected(menuitem)){
            return true;
        } else{
            return super.onOptionsItemSelected(menuitem);
        }
    }

    protected void onPostCreate(Bundle bundle){
        super.onPostCreate(bundle);
        drawerToggle.syncState();
    }

    public boolean onPrepareOptionsMenu(Menu menu){
        drawerLayout.isDrawerOpen(drawerList);
        return super.onPrepareOptionsMenu(menu);
    }

    public void setTitle(CharSequence charsequence){
        title = charsequence;
        getActionBar().setTitle(title);
    }
    
    
    private boolean checkDB(){
		File fil=this.getDatabasePath("elect.db");
		dbpath=fil.getPath();
		
		File db=new File(dbpath);
		
		if(!db.exists()){
			File db_dir=db.getParentFile();
			db_dir.mkdirs();
		}
		
		return db.exists();
	}
	
	private void copyDataBase(){ 
	     try{
	    	 
	    	InputStream myInput = this.getAssets().open("elect.db");
		    String outFileName = dbpath; 
		    OutputStream myOutput = new FileOutputStream(outFileName); 
		    byte[] buffer = new byte[1024];
		    int length;
	    	while ((length = myInput.read(buffer))>0){
	        myOutput.write(buffer, 0, length);
	    }

	    myOutput.flush();
	    myOutput.close();
	    myInput.close(); 
	    Log.i("debug","copied");
	    }
	    catch(Exception e){
	    	//db can't b copied - abort!
	    	Log.d("error", e.getMessage());
	    }
	    
	}

	
	private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, this,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Log.i("anas", "This device is not supported.");
                finish();
            }
            return false;
        }
        return true;
    }
	
	@Override
	public void onBackPressed() {
		if(!isOnHome){
			displayView(HOME_FRAG);
			return;
		}
		super.onBackPressed();
	}

}
