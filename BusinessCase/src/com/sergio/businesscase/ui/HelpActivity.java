package com.sergio.businesscase.ui;

import java.util.ArrayList;

import com.apptentive.android.sdk.Apptentive;
import com.flurry.android.FlurryAgent;
import com.sergio.businesscase.R;
import com.sergio.businesscase.helper.Attributes;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

public class HelpActivity extends Activity implements OnClickListener{
	ArrayList<String> parentList;
	ArrayList<Object> childList;
	FragmentTransaction transaction;
	ParentHelpFragment parenthelpMenu = new ParentHelpFragment();
	Button back, home;
	public static Context context;
	
	protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			context = this;
			init();
	}

	private void init() {
		Typeface fonts= Typeface.createFromAsset(getAssets(), "fonts/Calibri.ttf");
		Typeface fonts_bold= Typeface.createFromAsset(getAssets(), "fonts/Calibri-bold.ttf");
		setContentView(R.layout.help_activity);
		
		TextView helptitle = (TextView)findViewById(R.id.help_main_title);
		helptitle.setTypeface(fonts_bold);
		
		back = (Button)findViewById(R.id.helpback_btn);
		back.setOnClickListener(this);
		home = (Button)findViewById(R.id.helphome_btn);
		home.setOnClickListener(this);
		
		transaction = getFragmentManager().beginTransaction();
		transaction.replace(R.id.helplists, parenthelpMenu);
//		transaction.addToBackStack("a");
		transaction.commit();
		
//		TextView helpTitle = (TextView)findViewById(R.id.textView1);
//		helpTitle.setTypeface(fonts);
//		listView=(ExpandableListView) findViewById(R.id.expandableListView1);
//		listView.setGroupIndicator(null);
//		listView.setClickable(true);
//		listView.setAdapter(new HelpListAdapter(this));
		
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
	public void onClick(View vi) {
		switch(vi.getId()){
		case R.id.helpback_btn:
			if(ParentHelpFragment.position == -1){
				finish();
			}else{
				ParentHelpFragment.position = -1;
				getFragmentManager().popBackStack("b", FragmentManager.POP_BACK_STACK_INCLUSIVE);
			}
			
			break;
			
		case R.id.helphome_btn:
			
			final Dialog home_back_dlg = new Dialog(this);
			home_back_dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
			home_back_dlg.setContentView(R.layout.home_dialog);
			
			home_back_dlg.findViewById(R.id.home_btn_back).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					finish();
					((Activity)MenuActivity.menucontext).finish();
				}
			});
			home_back_dlg.findViewById(R.id.home_back_cancel).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					home_back_dlg.dismiss();
				}
			});
			
			home_back_dlg.show();
			
//			AlertDialog.Builder alert = new AlertDialog.Builder(this);
//			
//			alert.setTitle("¿Estás seguro que deseas cerrar tu Business Case?");
//			
//			alert.setNeutralButton("Si", new DialogInterface.OnClickListener() {
//				
//				@Override
//				public void onClick(DialogInterface dialog, int which) {
//					finish();
//					((Activity) MenuActivity.menucontext).finish();
//				}
//			});
//			alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
//				
//				@Override
//				public void onClick(DialogInterface dialog, int which) {
//					
//				}
//			});
//			alert.show();
			
//			((Activity) BusinessCaseActivity.startcontext).finish();
//			Intent intent= new 	Intent(HelpActivity.this, BusinessCaseActivity.class);
//			startActivity(intent);
			break;
		}
	}
	
}
