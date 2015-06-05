package com.sergio.businesscase.ui;

import com.apptentive.android.sdk.Apptentive;
import com.flurry.android.FlurryAgent;
import com.sergio.businesscase.R;
import com.sergio.businesscase.helper.Attributes;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class ReviewActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.review_view);
		Typeface bold_font = Typeface.createFromAsset(getAssets(), "fonts/Calibri-bold.ttf");
		TextView title = (TextView)findViewById(R.id.review_title);
		title.setTypeface(bold_font);
		
		findViewById(R.id.review_back).setOnClickListener(this);
		findViewById(R.id.review_home).setOnClickListener(this);
		
		findViewById(R.id.report_bug).setOnClickListener(this);
		findViewById(R.id.idea_btn).setOnClickListener(this);
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
	
//	@Override
//	public void onWindowFocusChanged(boolean hasFocus) {
//	    super.onWindowFocusChanged(hasFocus);
//	    if (hasFocus) {
//	        // Engage a code point called "init".
//	        boolean shown = Apptentive.engage(this, "main_activity_focused");
//	    }
//	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
			case R.id.review_back:
				finish();
				break;
			case R.id.review_home:
				
				final Dialog home_back_dlg = new Dialog(this);
				home_back_dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
				home_back_dlg.setContentView(R.layout.home_dialog);
				
				home_back_dlg.findViewById(R.id.home_btn_back).setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						finish();
						((Activity)FAQActivity.contex).finish();
					}
				});
				home_back_dlg.findViewById(R.id.home_back_cancel).setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						home_back_dlg.dismiss();
					}
				});
				
				home_back_dlg.show();
				
//				AlertDialog.Builder alert = new AlertDialog.Builder(this);
//				
//				alert.setTitle("¿Estás seguro que deseas cerrar tu Business Case?");
//				
//				alert.setNeutralButton("Si", new DialogInterface.OnClickListener() {
//					
//					@Override
//					public void onClick(DialogInterface dialog, int which) {
//						finish();
//						((Activity)FAQActivity.contex).finish();
//					}
//				});
//				alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
//					
//					@Override
//					public void onClick(DialogInterface dialog, int which) {
//						
//					}
//				});
//				alert.show();
				
				
				break;
				
			case R.id.report_bug:
//				Apptentive.showMessageCenter(ReviewActivity.this);
				
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://BCase.com/"));
				startActivity(intent);
				break;
				
			case R.id.idea_btn:
				Intent email_intent = new Intent(Intent.ACTION_SEND);
				
				String subject = "Ideas y Mejoras BcaseApp";
				
				email_intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"example@BusinessCase.com"});
				email_intent.putExtra(Intent.EXTRA_SUBJECT, subject);
				email_intent.setType("message/rfc822");
				startActivity(Intent.createChooser(email_intent, "Choose an Email Client"));				
				break;
		
		}
	}

}
