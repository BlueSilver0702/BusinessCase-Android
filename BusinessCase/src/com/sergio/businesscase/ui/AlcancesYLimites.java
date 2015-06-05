package com.sergio.businesscase.ui;

import java.util.ArrayList;


import com.apptentive.android.sdk.Apptentive;
import com.flurry.android.FlurryAgent;
import com.sergio.businesscase.R;
import com.sergio.businesscase.helper.Attributes;
import com.sergio.businesscase.helper.ChkBoxListAdapter;
import com.sergio.businesscase.utils.CommonUtils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class AlcancesYLimites extends Activity implements OnClickListener{
	private static final String TAG = "AlcancesYLimites";
	
	Button btnNext;
	ImageView imgHelp,help;
	TextView alcancesTitle;
	ArrayList<String> chkboxList;
	ListView list;
	ChkBoxListAdapter adapter;
	int count=3;
	public static Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alcances_y_limites_activity);
		context = this;
		init();
//		setActionBar();
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
	
//	private void setActionBar() {
//		
//		ActionBar actionBar= (ActionBar)findViewById(R.id.actionbar_alcan);
//		
//		Intent intentHelp=new Intent(this, TitleDescription.class);
//		intentHelp.putExtra(Attributes.TITLETEXT, 5);
//		Action helpAction=new IntentAction(this, intentHelp, R.drawable.help_white);
//		actionBar.addAction(helpAction);
//	
//	}

	private void init() {
		chkboxList=new ArrayList<String>();
	
		Typeface fonts= Typeface.createFromAsset(getAssets(), "fonts/Calibri.ttf");
		Typeface bold_fonts= Typeface.createFromAsset(getAssets(), "fonts/Calibri-bold.ttf");
		imgHelp=(ImageView)findViewById(R.id.imgbtn_help);
		help = (ImageView)findViewById(R.id.iview_help);
		findViewById(R.id.backbtn6).setOnClickListener(this);
		findViewById(R.id.homebtn6).setOnClickListener(this);
		
		btnNext=(Button)findViewById(R.id.btn_next);
		btnNext.setTypeface(fonts);
		list=(ListView)findViewById(R.id.lv_alc_ylimit);
		
		alcancesTitle=(TextView)findViewById(R.id.title5);
		alcancesTitle.setTypeface(bold_fonts);
		alcancesTitle.setText("Alcances y Limites");
		
		chkboxList.add(Attributes.CHKBOXTIEMPO);
		chkboxList.add(Attributes.CHKBOXCAPACIDAD);
		chkboxList.add(Attributes.CHKBOXHORARAIOS);
		chkboxList.add(Attributes.CHKBOXCOBERTURA);
		chkboxList.add(Attributes.CHKBOXCOMERCIAL);
		chkboxList.add(Attributes.CHKBOXPERSONAL);
		chkboxList.add(Attributes.CHKBOXDEMANDA);
		chkboxList.add(Attributes.CHKBOXDURACION);
		chkboxList.add(Attributes.CHKBOXSEGMEN);
		chkboxList.add(Attributes.CHKBOXTECHNOLOGIA);
		chkboxList.add(Attributes.CHKBOXOTRO1);
		chkboxList.add(Attributes.CHKBOXOTRO2);
		chkboxList.add(Attributes.CHKBOXOTRO3);
		
		adapter= new ChkBoxListAdapter(this, 0, chkboxList);
		
		list.setAdapter(adapter);
			
		
		btnNext.setText("Descripciones");
		btnNext.setOnClickListener(this);
		imgHelp.setOnClickListener(this);
		help.setOnClickListener(this);
		
				
	}
	@Override
	public void onClick(View v) {
		
		
		switch (v.getId()) {
		case R.id.btn_next:
			
			Intent intent= new Intent(AlcancesYLimites.this, AlcancesCheckedElements.class);
			intent.putExtra(Attributes.CHECKEDELEMENT, adapter.getTextList());
			Log.d(TAG, "total str checked"+adapter.getTextList().size());
			
			if(adapter.getTextList().size()!=0){
			startActivity(intent);
			overridePendingTransition( R.drawable.pull_in_right ,  R.drawable.push_out_left );
//			finish();
			}else{
				Toast toast =Toast.makeText(this, "Por favor, selecciona al menos una casilla", Toast.LENGTH_LONG);
				View view = toast.getView();
				view.setBackgroundColor(Color.rgb(0, 21, 50));
				toast.show();
			}
		
			break;
			
		case R.id.imgbtn_help:
			CommonUtils.showAlertDialog("", Attributes.HelpMessage.ALCANCESELEMENTHELP, this, null);
			break;
		case R.id.iview_help:
			Intent intentHelp=new Intent(this, TitleDescription.class);
			intentHelp.putExtra(Attributes.TITLETEXT, 5);
			intentHelp.putExtra("home_flag", 6);
			startActivity(intentHelp);
			break;
			
		case R.id.homebtn6:
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
//					((Activity)MenuActivity.menucontext).finish();
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
				
			break;
		case R.id.backbtn6:
			finish();
			overridePendingTransition( R.drawable.pull_in_left ,  R.drawable.push_out_right );
			break;
		}
	
		
	}
	
	
	
	
	

}
