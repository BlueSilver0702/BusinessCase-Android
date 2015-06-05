package com.sergio.businesscase.ui;

import com.apptentive.android.sdk.Apptentive;
import com.flurry.android.FlurryAgent;
import com.sergio.businesscase.R;
import com.sergio.businesscase.helper.Attributes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class FAQActivity extends Activity implements OnClickListener{
	public static Context contex;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.faq_view);
		contex = this;
		Typeface bold_font = Typeface.createFromAsset(getAssets(), "fonts/Calibri-bold.ttf");
		TextView title = (TextView)findViewById(R.id.faq_title);
		title.setTypeface(bold_font);	
		
		findViewById(R.id.faq_back).setOnClickListener(this);
		findViewById(R.id.coment_btn).setOnClickListener(this);
		findViewById(R.id.mygusta_btn).setOnClickListener(this);
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
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.faq_back:
			finish();
			boolean i = Apptentive.engage((Activity)BusinessCaseActivity.startcontext, "Rating Prompt");
			break;
		case R.id.coment_btn:
			startActivity(new Intent(FAQActivity.this, ReviewActivity.class));
			break;
		case R.id.mygusta_btn:
			startActivity(new Intent(FAQActivity.this, RocomiendaActivity.class));
			break;
		default:
			break;
		}
	}
}
