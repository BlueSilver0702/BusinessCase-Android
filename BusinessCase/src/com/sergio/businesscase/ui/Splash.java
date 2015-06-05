package com.sergio.businesscase.ui;

import com.sergio.businesscase.R;
import com.sergio.businesscase.helper.Attributes;
import com.apptentive.android.sdk.Apptentive;
import com.flurry.android.FlurryAgent;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		Thread timer = new Thread(){
			public void run(){
				try {
					sleep(3000);
				} catch (InterruptedException e) {
					
				}finally{
					Intent intent= new 	Intent(Splash.this, BusinessCaseActivity.class);
					startActivity(intent);
				}
			}
		};
		timer.start();
	}
	
	 
	@Override
	protected void onStart()
	{
		super.onStart();
		Apptentive.onStart(this);
		FlurryAgent.onStartSession(this, Attributes.FLURRY_API_KEY);
	}
	 
	@Override
	protected void onStop()
	{
		super.onStop();
		Apptentive.onStop(this);
		FlurryAgent.onEndSession(this);
	}

}
