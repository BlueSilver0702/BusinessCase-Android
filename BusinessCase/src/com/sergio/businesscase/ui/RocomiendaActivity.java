package com.sergio.businesscase.ui;

import com.apptentive.android.sdk.Apptentive;
import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.FacebookError;
import com.flurry.android.FlurryAgent;
import com.sergio.businesscase.R;
import com.sergio.businesscase.helper.Attributes;
import com.sergio.businesscase.utils.PreferenceUtils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class RocomiendaActivity extends Activity implements OnClickListener{

	private final static String Facebook_AppID = "177870095671066";
	private Facebook facebook;
	private PreferenceUtils pref;
	
	private static final int TWITTER_LOGIN_REQUEST_CODE = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rocomienda_view);
		
		Typeface bold_font = Typeface.createFromAsset(getAssets(), "fonts/Calibri-bold.ttf");
		TextView title = (TextView)findViewById(R.id.rocomend_title);
		title.setTypeface(bold_font);
		
		findViewById(R.id.rocom_back).setOnClickListener(this);
		findViewById(R.id.rocom_home).setOnClickListener(this);
		
		findViewById(R.id.calificanos_btn).setOnClickListener(this);
		findViewById(R.id.facebook_btn).setOnClickListener(this);
		findViewById(R.id.tweet_btn).setOnClickListener(this);
		findViewById(R.id.linkedin_btn).setOnClickListener(this);
		findViewById(R.id.google_btn).setOnClickListener(this);
		init_Social();
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
	
	void init_Social(){
		pref = new PreferenceUtils(this);
		facebook = new Facebook(Facebook_AppID);
//		mAsyncRunner = new AsyncFacebookRunner(facebook);
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.rocom_back:
			finish();
			break;
		case R.id.rocom_home:
			
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
			break;
			
		case R.id.calificanos_btn:

			Intent calificanosIntent = new Intent(Intent.ACTION_VIEW);
			calificanosIntent.setData(Uri.parse("http://play.google.com/"));
			startActivity(calificanosIntent);
			break;
		case R.id.facebook_btn:
			loginToFacebook();
			break;
			
		case R.id.tweet_btn:
			String tweetUrl = "https://twitter.com/intent/tweet";
			Uri uri = Uri.parse(tweetUrl);
			startActivity(new Intent(Intent.ACTION_VIEW, uri));
			break;
		case R.id.linkedin_btn:
			Intent linkedIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.linkedin.com/"));
			startActivity(linkedIntent);
			break;
			
		case R.id.google_btn:
			Intent googleIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/"));
			startActivity(googleIntent);
			break;
		default:
			break;
		}
	}
	
	
	//--------------------Facebook----------------------------------------------//
	
	
	private void loginToFacebook(){
		
		String acces_token = pref.get_Facebook_Token();
		long expires = pref.getExpires();
		
		if(acces_token != null){
			postToWall();
		}
		
		if (expires != 0) {
			facebook.setAccessExpires(expires);
		}
		
		if (!facebook.isSessionValid()) {
			facebook.authorize(this,
					new String[] { "email", "publish_stream" },
					new DialogListener() {

						@Override
						public void onCancel() {
							// Function to handle cancel event
						}

						@Override
						public void onComplete(Bundle values) {
							// Function to handle complete event
							// Edit Preferences and update facebook acess_token
							pref.set_Facebook_Token(facebook.getAccessToken());
							pref.setExpires(facebook.getAccessExpires());
							postToWall();
						}

						@Override
						public void onError(DialogError error) {
							// Function to handle error

						}

						@Override
						public void onFacebookError(FacebookError fberror) {
							// Function to handle Facebook errors

						}

					});
		}
	}
	
	private void postToWall(){
//		facebook.request(parameters)
		
		facebook.dialog(this, "feed", new DialogListener() {

			@Override
			public void onFacebookError(FacebookError e) {
			}

			@Override
			public void onError(DialogError e) {
			}

			@Override
			public void onComplete(Bundle values) {
			
			}

			@Override
			public void onCancel() {
			}
		});
	}
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
	    facebook.authorizeCallback(requestCode, resultCode, data);
	    
	}
	//------------------------------------------------------------------------------------------//
	
	
	//-----------------------------------Twitter--------------------------------------//
	
}
