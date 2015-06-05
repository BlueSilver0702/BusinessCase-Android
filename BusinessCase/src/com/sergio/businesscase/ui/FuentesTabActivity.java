package com.sergio.businesscase.ui;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.apptentive.android.sdk.Apptentive;
import com.flurry.android.FlurryAgent;
import com.sergio.businesscase.R;
import com.sergio.businesscase.db.DBAdapter;
import com.sergio.businesscase.helper.Attributes;
import com.sergio.businesscase.utils.CommonUtils;
import com.sergio.businesscase.utils.PreferenceUtils;

public class FuentesTabActivity extends Activity implements OnClickListener{
	private static final String TAG = "FuentesTabActivity";
	public static Context context;
	
	ArrayList<String> tabItems;
	ListView list;
	TextView title;
	ImageView imHelp,actionhelp;
	EditText etField1,etField2,etField3,etField4;
	Button guarder;
	int i;
	PreferenceUtils pref;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fuentes_tab_activity);
		context = this;
		Intent intent=getIntent();
		i=intent.getIntExtra(Attributes.LABEL3, 0);
		
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
//		 ActionBar actionBar= (ActionBar)findViewById(R.id.actionbar_fuentes);
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
//		intentHelp.putExtra(Attributes.TITLETEXT, 9);
//		Action helpAction=new IntentAction(this, intentHelp, R.drawable.help_white);
//		actionBar.addAction(helpAction);
//	
//		
//	}

	private void init() {
	
		pref=new PreferenceUtils(this);
		Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Calibri.ttf");
		Typeface font_bold = Typeface.createFromAsset(getAssets(), "fonts/Calibri-bold.ttf");
		guarder = (Button)findViewById(R.id.btn_fuente);
		imHelp=(ImageView)findViewById(R.id.imgBtn_funtes);
		actionhelp=(ImageView)findViewById(R.id.action_help);
		guarder.setTypeface(font);
		
		actionhelp.setOnClickListener(this);
		guarder.setOnClickListener(this);
		imHelp.setOnClickListener(this);
		findViewById(R.id.backbtn10).setOnClickListener(this);
		findViewById(R.id.homebtn10).setOnClickListener(this);
		
		etField1=(EditText)findViewById(R.id.etSortDesc1);
		etField1.setTypeface(font);
		etField2=(EditText)findViewById(R.id.etSortDesc2);
		etField2.setTypeface(font);
		etField3=(EditText)findViewById(R.id.etSortDesc3);
		etField3.setTypeface(font);
		etField4=(EditText)findViewById(R.id.etSortDesc4);
		etField4.setTypeface(font);
		title=(TextView)findViewById(R.id.tv_fuentes);
		title.setTypeface(font_bold);
		
		if(i==0){
			title.setText("Fuente de Datos /\n        Ingresos");
			 if(pref.getDescriptionShort1()!=null || pref.getFuntesIngresos()!=null){
				 String strShort="";
				 if(pref.getFuntesIngresos()!=null){
					 			
					try{
						strShort=pref.getFuntesIngresos().split("~")[0];
						etField1.setText(strShort);
						String str2=pref.getFuntesIngresos().split("~")[1];
						etField2.setText(str2);
						String str3=pref.getFuntesIngresos().split("~")[2];
						etField3.setText(str3);
						String str4=pref.getFuntesIngresos().split("~")[3];
						etField4.setText(str4);
					}catch (Exception e) {
						
					}
				 }else{
					 try{
							Log.d(TAG, "pref is "+pref.getDescriptionShort1().split("~"));
							strShort=pref.getDescriptionShort1().split("~")[0];
							etField1.setText(strShort);
							String str2=pref.getDescriptionShort1().split("~")[1];
							etField2.setText(str2);
							String str3=pref.getDescriptionShort1().split("~")[2];
							etField3.setText(str3);
							String str4=pref.getDescriptionShort1().split("~")[3];
							etField4.setText(str4);
						}catch (Exception e) {
							
						}
				 }
			 }
			
		}
		if(i==1){
			title.setText("Fuente de Datos /\n        Ahorros");
			 if(pref.getDescriptionShortAhorros1()!=null){
				 String strShort="";
				try{
					Log.d(TAG, "pref is "+pref.getDescriptionShortAhorros1().split("~"));
					strShort=pref.getDescriptionShortAhorros1().split("~")[0];
					etField1.setText(strShort);
					String str2=pref.getDescriptionShortAhorros1().split("~")[1];
					etField2.setText(str2);
					String str3=pref.getDescriptionShortAhorros1().split("~")[2];
					etField3.setText(str3);
					String str4=pref.getDescriptionShortAhorros1().split("~")[3];
					etField4.setText(str4);				
				}catch (Exception e) {
					
				}
			 }
			
		}
		if(i==2){
			title.setText("Fuente de Datos /\n          Gastos");
			 if(pref.getDescriptionShortEgresos1()!=null){
				 String strShort="";
				try{
					Log.d(TAG, "pref is "+pref.getDescriptionShortEgresos1().split("~"));
					strShort=pref.getDescriptionShortEgresos1().split("~")[0];
					etField1.setText(strShort);
					String str2=pref.getDescriptionShortEgresos1().split("~")[1];
					etField2.setText(str2);
					String str3=pref.getDescriptionShortEgresos1().split("~")[2];
					etField3.setText(str3);
					String str4=pref.getDescriptionShortEgresos1().split("~")[3];
					etField4.setText(str4);
				
				}catch (Exception e) {
					
				}
			 }
			
		}
		if(i==3){
			title.setText("Fuente de Datos /\n         Costos");
			 if(pref.getDescriptionShortCostos()!=null){
				 String strShort="";
				try{
					Log.d(TAG, "pref is "+pref.getDescriptionShortCostos().split("~"));
					strShort=pref.getDescriptionShortCostos().split("~")[0];
					etField1.setText(strShort);
					String str2=pref.getDescriptionShortCostos().split("~")[1];
					etField2.setText(str2);
					String str3=pref.getDescriptionShortCostos().split("~")[2];
					etField3.setText(str3);
					String str4=pref.getDescriptionShortCostos().split("~")[3];
					etField4.setText(str4);
				
				}catch (Exception e) {
					
				}
			 }
			
		}
		if(i==4){
			title.setText("Fuente de Datos /\n        Inversión");
			 if(pref.getDescriptionShortInversion()!=null){
				 String strShort="";
				try{
					Log.d(TAG, "pref is "+pref.getDescriptionShortInversion().split("~"));
					strShort=pref.getDescriptionShortInversion().split("~")[0];
					etField1.setText(strShort);
					String str2=pref.getDescriptionShortInversion().split("~")[1];
					etField2.setText(str2);
					String str3=pref.getDescriptionShortInversion().split("~")[2];
					etField3.setText(str3);
					String str4=pref.getDescriptionShortInversion().split("~")[3];
					etField4.setText(str4);
				
				}catch (Exception e) {
					
				}
			 }
		}

		
		
	}

	@Override
	public void onClick(View v) {
		String str="";
		switch (v.getId()) {
		case R.id.imgBtn_funtes:
			switch (i) {
			case 0:
				CommonUtils.showAlertDialog("", Attributes.HelpMessage.FUENTESTABHELP[i], this, null);
				break;

			case 1:
				CommonUtils.showAlertDialog("", Attributes.HelpMessage.FUENTESTABHELP[i], this, null);
				break;
			case 2:
				CommonUtils.showAlertDialog("", Attributes.HelpMessage.FUENTESTABHELP[i], this, null);
				break;
			case 3:
				CommonUtils.showAlertDialog("", Attributes.HelpMessage.FUENTESTABHELP[i], this, null);
				break;
			case 4:	
				CommonUtils.showAlertDialog("", Attributes.HelpMessage.FUENTESTABHELP[i], this, null);
				break;
			}
			
			break;

		case R.id.btn_fuente:
			
		switch (i) {
		case 0:		
//			String strShort1 = "",strShort2="",strShort3="",strShort4="";
//			 if(pref.getDescriptionShort1()!=null){
//		 			
//					try{
//						Log.d(TAG, "pref is "+pref.getDescriptionShort1().split("~"));
//						strShort1=pref.getDescriptionShort1().split("~")[0];
//						
//						strShort2=pref.getDescriptionShort1().split("~")[1];
//						
//						strShort3=pref.getDescriptionShort1().split("~")[2];
//						
//						strShort4=pref.getDescriptionShort1().split("~")[3];
//						
//					}catch (Exception e) {
//						
//					}
//			
//				str=etField1.getText().toString()+strShort1+"~";
//				str=str+etField2.getText().toString()+strShort2+"~";
//				str=str+etField3.getText().toString()+strShort3+"~";
//				str=str+etField4.getText().toString()+strShort4;
//				pref.setFuntesIngresos(str);
//			 }
//			 else{
				 str=etField1.getText().toString()+"~";
					str=str+etField2.getText().toString()+"~";
					str=str+etField3.getText().toString()+"~";
					str=str+etField4.getText().toString();
					pref.setFuntesIngresos(str);
//			 }
			Log.d(TAG, "str is "+str);
						
			break;

		case 1:
			
			str=etField1.getText().toString()+"~";
			str=str+etField2.getText().toString()+"~";
			str=str+etField3.getText().toString()+"~";
			str=str+etField4.getText().toString();
			pref.setDescriptionShortAhorros1(str);
			
			break;

		case 2:
			str=etField1.getText().toString()+"~";
			str=str+etField2.getText().toString()+"~";
			str=str+etField3.getText().toString()+"~";
			str=str+etField4.getText().toString();
			pref.setDescriptionShortEgresos1(str);
			
			break;

		case 3:
			str=etField1.getText().toString()+"~";
			str=str+etField2.getText().toString()+"~";
			str=str+etField3.getText().toString()+"~";
			str=str+etField4.getText().toString();
			pref.setDescriptionShortCostos(str);
			
			break;

		case 4:
			str=etField1.getText().toString()+"~";
			str=str+etField2.getText().toString()+"~";
			str=str+etField3.getText().toString()+"~";
			str=str+etField4.getText().toString();
			pref.setDescriptionShortInversion(str);
			
			break;
				
		}
		DBAdapter dba = new DBAdapter(this);
//		pref = new PreferenceUtils(this);
//		String saveFile="";
		dba.open();
//		Cursor cursor =dba.getFileName();
//		if(cursor!= null){
//			cursor.moveToLast();
//		}
//		if(cursor.moveToLast()){
//			saveFile = cursor.getString(cursor.getColumnIndex(Attributes.Database.NOMBREDEARCHIVO));
////			Log.d(TAG, "database  last record is"+ saveFile);
//		}
//		if(saveFile.equals(pref.getHeading())){
//			
			dba.updateRow(pref.getHeading(), pref.getTilte(), pref.getTema(), pref.getObjective(), pref.getDescriptionShort1(), pref.getDescriptionLarge1(), pref.getDescriptionShortAhorros1(), pref.getDescriptionLargeAhorros1(), pref.getDescriptionShortEgresos1(), pref.getDescriptionLargeEgresos1(), pref.getDescriptionShortCostos(), pref.getDescriptionLargeCostos(), pref.getDescriptionShortInversion(), pref.getDescriptionLargeInversion(), pref.getDescriptionShortBeneficios(), pref.getDescriptionLargeBeneficios(), pref.getDescriptionShortImpactos(), pref.getDescriptionLargeImpactos(), pref.getDescriptionShortRiesgos(), pref.getDescriptionLargeRiesgos(), pref.getIntroduction(), 
				pref.getAlcancesYLimit(),pref.getAlcancesYLimitCapacidad(), pref.getAlcancesYLimitHorarios(), pref.getAlcancesYLimitsCobertura(), pref.getAlcancesYLimitsComercial(), pref.getAlcancesYLimitsPersonal(), pref.getAlcancesYLimitsDemanda(), pref.getAlcancesYLimitsDuracion(), pref.getAlcancesYLimitsSegmen(), pref.getAlcancesYLimitsTechnologia(), pref.getAlcancesYLimitsOtro1(), pref.getAlcancesYLimitsOtro2(), pref.getAlcancesYLimitsOtro3(), 
				pref.getDependencia1(), pref.getDependencia2(), pref.getDependencia3(), pref.getDependencia4(), pref.getResultados1(), pref.getResultados2(), pref.getResultados3(), pref.getResultados4(), pref.getSupuestos1(), pref.getSupuestos2(), pref.getSupuestos3(), pref.getConclusion(), pref.getRecommendies(),pref.getSummary(),pref.getContingenciaDeslarga(),pref.getDependenciaDesLarga(),pref.getResultadosDesLarga(),pref.getSupuestosDescLarga(),pref.getCheckedElement());
			
//		}
		dba.close();
		break;
		
		case R.id.action_help:
			Intent intentHelp=new Intent(this, TitleDescription.class);
			intentHelp.putExtra(Attributes.TITLETEXT, 9);
			
			intentHelp.putExtra("home_flag", 10);
			startActivity(intentHelp);
			break;
			
		case R.id.backbtn10:
			finish();
			overridePendingTransition( R.drawable.pull_in_left ,  R.drawable.push_out_right );
			break;
		case R.id.homebtn10:
			
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
//			
			
			
	}
	
	}
	

}
