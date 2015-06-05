package com.sergio.businesscase.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.apptentive.android.sdk.Apptentive;
import com.flurry.android.FlurryAgent;
import com.sergio.businesscase.R;
import com.sergio.businesscase.db.DBAdapter;
import com.sergio.businesscase.helper.Attributes;
import com.sergio.businesscase.utils.CommonUtils;
import com.sergio.businesscase.utils.PreferenceUtils;

public class SupuestosActivity extends Activity implements OnClickListener{
	public static Context context;
	
	 ImageView help;
	 Button guarder, add,less;
	int count=0;
	TextView susDesc;
	ImageView susRowHelp, guide;
	
	 TextView tvSup1,tvSup2,tvSup3,tvSup4,tvSupShort1,tvSupShort2,tvSupShort3,tvSupShort4,tvSupLong1,tvSupLong2,tvSupLong3,tvSupLong4;
	 EditText etSup1,etSup2,etSup3,etSup4,etSupLong1,etSupLong2,etSupLong3,etSupLong4;
	 PreferenceUtils pref;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.supuestos_activity);
		context = this;
		init();
//		setActionBar();
	}

//	private void setActionBar() {
//		ActionBar actionBar= (ActionBar)findViewById(R.id.actionbar_susp);
//		
////		Intent esquemaGene=new Intent(this, EsquemaGeneralActivity.class);
////		Action esquemaAction=new IntentAction(this,esquemaGene,R.drawable.ic_action_new);
////		actionBar.addAction(esquemaAction);
////		
////		Action newFolder= new IntentAction(this, null, R.drawable.action_folder_icon);
////		actionBar.addAction(newFolder);
////		
////		Intent intentword=new Intent(this, WordFile.class);
////		Action mswordAction= new IntentAction(this, intentword, R.drawable.action_msword_icon);
////		actionBar.addAction(mswordAction);
////		
////		Intent intentexcel=new Intent(this,BusinCaseExcelFileActivity.class);
////		Action msexcelAction= new IntentAction(this, intentexcel, R.drawable.action_microsoftexcel_icon);
////		actionBar.addAction(msexcelAction);
//		
//		Intent intentHelp=new Intent(this, TitleDescription.class);
//		intentHelp.putExtra(Attributes.TITLETEXT, 8);
//		Action helpAction=new IntentAction(this, intentHelp, R.drawable.help_white);
//		actionBar.addAction(helpAction);
//	
//		
//	}
	
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

	private void init() {
		pref=new PreferenceUtils(this);
		
		Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Calibri.ttf");
		Typeface bold_font = Typeface.createFromAsset(getAssets(), "fonts/Calibri-bold.ttf");
		help = (ImageView)findViewById(R.id.imgbtn_help);
		guide = (ImageView)findViewById(R.id.supuestos_guard);
		guarder = (Button)findViewById(R.id.btn_guarder);
		add=(Button)findViewById(R.id.addButton);
		less=(Button)findViewById(R.id.subButton);
		
		findViewById(R.id.backbtn9).setOnClickListener(this);
		findViewById(R.id.homebtn9).setOnClickListener(this);
		
		guarder.setTypeface(font);
		tvSup1 =(TextView)findViewById(R.id.tv_sup1);
		tvSup1.setText("Supuestos1");
		tvSup1.setTypeface(font);
		
		tvSupShort1 =(TextView)findViewById(R.id.tv_desc_short1);
		tvSupShort1.setTypeface(font);
		tvSupShort2 =(TextView)findViewById(R.id.tv_desc_short2);
		tvSupShort2.setTypeface(font);
		tvSupShort3 =(TextView)findViewById(R.id.tv_desc_short3);
		tvSupShort3.setTypeface(font);
		tvSupShort4 =(TextView)findViewById(R.id.tv_desc_short4);
		tvSupShort4.setTypeface(font);
		
		tvSupLong1 =(TextView)findViewById(R.id.tv_desc_larga1);
		tvSupLong1.setTypeface(font);
		tvSupLong2 =(TextView)findViewById(R.id.tv_desc_larga2);
		tvSupLong2.setTypeface(font);
		tvSupLong3 =(TextView)findViewById(R.id.tv_desc_larga3);
		tvSupLong3.setTypeface(font);
		tvSupLong4 =(TextView)findViewById(R.id.tv_desc_larga4);
		tvSupLong4.setTypeface(font);
		
		etSup1 =(EditText)findViewById(R.id.et_sup1);
		etSup1.setTypeface(font);
		
		etSupLong1 =(EditText)findViewById(R.id.et_sup_larga1);
		etSupLong1.setTypeface(font);
		etSupLong2 =(EditText)findViewById(R.id.et_sup_larga2);
		etSupLong2.setTypeface(font);		
		etSupLong3 =(EditText)findViewById(R.id.et_sup_larga3);
		etSupLong3.setTypeface(font);		
		etSupLong4 =(EditText)findViewById(R.id.et_sup_larga4);
		etSupLong4.setTypeface(font);
		
		
		tvSup2 =(TextView)findViewById(R.id.tv_sup2);
		tvSup2.setText("Supuestos2");
		tvSup2.setTypeface(font);
		
		etSup2 =(EditText)findViewById(R.id.et_sup2);
		etSup2.setTypeface(font);
		
		tvSup3 =(TextView)findViewById(R.id.tv_sup3);
		tvSup3.setText("Supuestos3");
		tvSup3.setTypeface(font);
		
		etSup3 =(EditText)findViewById(R.id.et_sup3);
		etSup3.setTypeface(font);
		
		tvSup4 =(TextView)findViewById(R.id.tv_sup4);
		tvSup4.setText("Supuestos4");
		tvSup4.setTypeface(font);
		
		etSup4= (EditText)findViewById(R.id.et_sup4);
		etSup4.setTypeface(font);
		CommonUtils.setTextWatcher(etSup1);
		CommonUtils.setTextWatcher(etSup2);
		CommonUtils.setTextWatcher(etSup3);
		CommonUtils.setTextWatcher(etSup4);
		CommonUtils.setTextWatcher(etSupLong1);
		CommonUtils.setTextWatcher(etSupLong2);
		CommonUtils.setTextWatcher(etSupLong3);
		CommonUtils.setTextWatcher(etSupLong4);
		
//		add.setBackgroundDrawable(Attributes.getShape(Attributes.COLORS[5], Attributes.COLORS[5] ));
//		less.setBackgroundDrawable(Attributes.getShape(Attributes.COLORS[9], Attributes.COLORS[9] ));
		
		susRowHelp=(ImageView)findViewById(R.id.imgview_sus_help);
		susRowHelp.setOnClickListener(this);
		
		susDesc=(TextView)findViewById(R.id.tv_suspectos_desc);
		susDesc.setTypeface(bold_font);
		susDesc.setText("Supuestos");
		
		
//		adapter= new DynamicListAdapter(this, 0, item);
//		setListAdapter(adapter);
		add.setOnClickListener(this);
		less.setOnClickListener(this);
		guarder.setOnClickListener(this);
		help.setOnClickListener(this);
		guide.setOnClickListener(this);
		if(pref.getSupuestos1()!= null){
			tvSup1.setVisibility(View.VISIBLE);
			etSup1.setVisibility(View.VISIBLE);
			tvSupShort1.setVisibility(View.VISIBLE);
			tvSupLong1.setVisibility(View.VISIBLE);
			etSupLong1.setVisibility(View.VISIBLE);
			etSup1.setText(pref.getSupuestos1());
			try{
				etSupLong1.setText(pref.getSupuestosDescLarga().split("~")[0]);
			}catch(Exception e){
				e.printStackTrace();
			}
			count=1;
			
		}
		if(pref.getSupuestos2()!= null ){
			tvSup2.setVisibility(View.VISIBLE);
			etSup2.setVisibility(View.VISIBLE);
			tvSupShort2.setVisibility(View.VISIBLE);
			tvSupLong2.setVisibility(View.VISIBLE);
			etSupLong2.setVisibility(View.VISIBLE);
			etSup2.setText(pref.getSupuestos2());
			try{
				etSupLong2.setText(pref.getSupuestosDescLarga().split("~")[1]);
			}catch(Exception e){
				e.printStackTrace();
			}
			count=2;
			
		}
		if(pref.getSupuestos3()!= null ){
			tvSup3.setVisibility(View.VISIBLE);
			etSup3.setVisibility(View.VISIBLE);
			tvSupShort3.setVisibility(View.VISIBLE);
			tvSupLong3.setVisibility(View.VISIBLE);
			etSupLong3.setVisibility(View.VISIBLE);
			etSup3.setText(pref.getSupuestos3());
			try{
				etSupLong3.setText(pref.getSupuestosDescLarga().split("~")[2]);
			}catch(Exception e){
				e.printStackTrace();
			}
			count=3;
			
		}	
		if(pref.getSupuestos4()!= null ){
			tvSup4.setVisibility(View.VISIBLE);
			etSup4.setVisibility(View.VISIBLE);
			tvSupShort4.setVisibility(View.VISIBLE);
			tvSupLong4.setVisibility(View.VISIBLE);
			etSupLong4.setVisibility(View.VISIBLE);
			etSup4.setText(pref.getSupuestos4());
			try{
				etSupLong4.setText(pref.getSupuestosDescLarga().split("~")[3]);
			}catch(Exception e){
				e.printStackTrace();
			}
			count=4;
			
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.addButton:
			if(count == 3){
				tvSup4.setVisibility(View.VISIBLE);
				etSup4.setVisibility(View.VISIBLE);
				tvSupShort4.setVisibility(View.VISIBLE);
				tvSupLong4.setVisibility(View.VISIBLE);
				etSupLong4.setVisibility(View.VISIBLE);
				etSup4.setText(pref.getSupuestos4());
				etSup4.requestFocus();
				count=4;
			}
			if(count==2){
				tvSup3.setVisibility(View.VISIBLE);
				etSup3.setVisibility(View.VISIBLE);
				tvSupShort3.setVisibility(View.VISIBLE);
				tvSupLong3.setVisibility(View.VISIBLE);
				etSupLong3.setVisibility(View.VISIBLE);
				etSup3.setText(pref.getSupuestos3());
				etSup3.requestFocus();
				count=3;
			}
			if(count==1){
				tvSup2.setVisibility(View.VISIBLE);
				etSup2.setVisibility(View.VISIBLE);
				tvSupShort2.setVisibility(View.VISIBLE);
				tvSupLong2.setVisibility(View.VISIBLE);
				etSupLong2.setVisibility(View.VISIBLE);
				etSup2.setText(pref.getSupuestos2());
				etSup2.requestFocus();
				count=2;
			}
			if(count==0){
				tvSup1.setVisibility(View.VISIBLE);
				etSup1.setVisibility(View.VISIBLE);
				tvSupShort1.setVisibility(View.VISIBLE);
				tvSupLong1.setVisibility(View.VISIBLE);
				etSupLong1.setVisibility(View.VISIBLE);
				etSup1.setText(pref.getSupuestos1());
				count=1;
			}
						
			break;

		case R.id.subButton:
			if(count==1){
				tvSup1.setVisibility(View.GONE);
				etSup1.setVisibility(View.GONE);
				tvSupShort1.setVisibility(View.GONE);
				tvSupLong1.setVisibility(View.GONE);
				etSupLong1.setVisibility(View.GONE);
				count=0;
			}
			if(count==2){
				tvSup2.setVisibility(View.GONE);
				etSup2.setVisibility(View.GONE);
				tvSupShort2.setVisibility(View.GONE);
				tvSupLong2.setVisibility(View.GONE);
				etSupLong2.setVisibility(View.GONE);
				count=1;
			}
			if(count==3){
				tvSup3.setVisibility(View.GONE);
				etSup3.setVisibility(View.GONE);
				tvSupShort3.setVisibility(View.GONE);
				tvSupLong3.setVisibility(View.GONE);
				etSupLong3.setVisibility(View.GONE);
				count=2;
			}
			if(count==4){
				tvSup4.setVisibility(View.GONE);
				etSup4.setVisibility(View.GONE);
				tvSupShort4.setVisibility(View.GONE);
				tvSupLong4.setVisibility(View.GONE);
				etSupLong4.setVisibility(View.GONE);
				count=3;
			}
			break;
			
		case R.id.imgview_sus_help:
			CommonUtils.showAlertDialog("", Attributes.HelpMessage.SUPESTOSHELPMESSAGE, this, null);
			break;
		case R.id.btn_guarder:
			
				pref.setSupuestos1(etSup1.getText().toString());
				pref.setSupuestos2(etSup2.getText().toString());
				pref.setSupuestos3(etSup3.getText().toString());
				pref.setSupuestos4(etSup4.getText().toString());
				String strDepLarga=etSupLong1.getText().toString()+"~";
				strDepLarga= strDepLarga+etSupLong2.getText().toString()+"~";
				strDepLarga= strDepLarga+etSupLong3.getText().toString()+"~";
				strDepLarga= strDepLarga+etSupLong4.getText().toString();
				pref.setSupuestosDescLarga(strDepLarga);
				DBAdapter dba = new DBAdapter(this);
//				pref = new PreferenceUtils(this);
//				String saveFile="";
				dba.open();
//				Cursor cursor =dba.getFileName();
//				if(cursor!= null){
//					cursor.moveToLast();
//				}
//				if(cursor.moveToLast()){
//					saveFile = cursor.getString(cursor.getColumnIndex(Attributes.Database.NOMBREDEARCHIVO));
////					Log.d(TAG, "database  last record is"+ saveFile);
//				}
//				if(saveFile.equals(pref.getHeading())){
					
					dba.updateRow(pref.getHeading(), pref.getTilte(), pref.getTema(), pref.getObjective(), pref.getDescriptionShort1(), pref.getDescriptionLarge1(), pref.getDescriptionShortAhorros1(), pref.getDescriptionLargeAhorros1(), pref.getDescriptionShortEgresos1(), pref.getDescriptionLargeEgresos1(), pref.getDescriptionShortCostos(), pref.getDescriptionLargeCostos(), pref.getDescriptionShortInversion(), pref.getDescriptionLargeInversion(), pref.getDescriptionShortBeneficios(), pref.getDescriptionLargeBeneficios(), pref.getDescriptionShortImpactos(), pref.getDescriptionLargeImpactos(), pref.getDescriptionShortRiesgos(), pref.getDescriptionLargeRiesgos(), pref.getIntroduction(), 
						pref.getAlcancesYLimit(),pref.getAlcancesYLimitCapacidad(), pref.getAlcancesYLimitHorarios(), pref.getAlcancesYLimitsCobertura(), pref.getAlcancesYLimitsComercial(), pref.getAlcancesYLimitsPersonal(), pref.getAlcancesYLimitsDemanda(), pref.getAlcancesYLimitsDuracion(), pref.getAlcancesYLimitsSegmen(), pref.getAlcancesYLimitsTechnologia(), pref.getAlcancesYLimitsOtro1(), pref.getAlcancesYLimitsOtro2(), pref.getAlcancesYLimitsOtro3(), 
						pref.getDependencia1(), pref.getDependencia2(), pref.getDependencia3(), pref.getDependencia4(), pref.getResultados1(), pref.getResultados2(), pref.getResultados3(), pref.getResultados4(), pref.getSupuestos1(), pref.getSupuestos2(), pref.getSupuestos3(), pref.getConclusion(), pref.getRecommendies(),pref.getSummary(),pref.getContingenciaDeslarga(),pref.getDependenciaDesLarga(),pref.getResultadosDesLarga(),pref.getSupuestosDescLarga(),pref.getCheckedElement());
					
//				}
				dba.close();
					
			break;
		case R.id.imgbtn_help:
			Intent intentHelp=new Intent(this, TitleDescription.class);
			intentHelp.putExtra(Attributes.TITLETEXT, 8);
			intentHelp.putExtra("home_flag", 9);
			
			startActivity(intentHelp);
			break;
		case R.id.supuestos_guard:
			CommonUtils.showAlertDialog("title", "Descripción: \n\t Corta En 2 o 3 palabras describe el supuesto sobre el cual se fundamenta la propuesta. Esta descripción se utilizará en el documento (Business Case).\n\nDescripción Larga: \n\tDescribe con mayor detalle pero en forma concreta, la descripción corta del “supuesto” antes definida, de tal forma que la persona que lea esta descripción (larga) pueda entender su impacto sin necesidad de que estés presente para explicarla. Esta descripción se utilizará en el documento (Business Case).", this, null);
			break;
			
		case R.id.backbtn9:
			finish();
			overridePendingTransition( R.drawable.pull_in_left ,  R.drawable.push_out_right );
			break;
		case R.id.homebtn9:
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
			
			
			
		}
		
		
	}
	@Override
	protected void onPause() {
		pref.setSupuestos1(etSup1.getText().toString());
		pref.setSupuestos2(etSup2.getText().toString());
		pref.setSupuestos3(etSup3.getText().toString());
		pref.setSupuestos4(etSup4.getText().toString());
		
		String strDepLarga=etSupLong1.getText().toString()+"~";
		strDepLarga= strDepLarga+etSupLong2.getText().toString()+"~";
		strDepLarga= strDepLarga+etSupLong3.getText().toString()+"~";
		strDepLarga= strDepLarga+etSupLong4.getText().toString();
		pref.setSupuestosDescLarga(strDepLarga);
		super.onPause();
	}

}
