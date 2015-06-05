package com.sergio.businesscase.ui;

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
import android.widget.TextView;

import com.apptentive.android.sdk.Apptentive;
import com.flurry.android.FlurryAgent;
import com.sergio.businesscase.R;
import com.sergio.businesscase.db.DBAdapter;
import com.sergio.businesscase.helper.Attributes;
import com.sergio.businesscase.utils.CommonUtils;
import com.sergio.businesscase.utils.PreferenceUtils;

public class EsquemaGeneralActivity extends Activity implements OnClickListener{
	
	private static final String TAG = "Esquema general";
	EditText etObjective;
	TextView textDescription;
	PreferenceUtils pref;
	Intent intent;
	int i;
	Button guarder, back;
	Button help,imgbtn_help;
	DBAdapter dba;
	public static Context context;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.esquma_general_activity_new);
		context = this;
		intent=getIntent();
		i=intent.getIntExtra(Attributes.LABEL2,0);
		Log.d(TAG, "i is"+i);
		
		
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
//		ActionBar actionBar= (ActionBar)findViewById(R.id.actionbar_esquema);
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
//		intentHelp.putExtra(Attributes.TITLETEXT, 0);
//		intentHelp.putExtra(Attributes.LABEL2, i);
//		Action helpAction=new IntentAction(this, intentHelp, R.drawable.help_white);
//		actionBar.addAction(helpAction);
//	
//	}

	
	
	private void init() {
		Typeface fonts = Typeface.createFromAsset(getAssets(), "fonts/Calibri.ttf");
		Typeface bold_fonts = Typeface.createFromAsset(getAssets(), "fonts/Calibri-bold.ttf");
		
		pref=new PreferenceUtils(this);
		textDescription=(TextView)findViewById(R.id.title11);
		textDescription.setTextSize(18);
		textDescription.setTypeface(bold_fonts);
		
		help =(Button)findViewById(R.id.viewhelp11);
		help.setOnClickListener(this);
		imgbtn_help = (Button)findViewById(R.id.help11);
		imgbtn_help.setOnClickListener(this);
		
		guarder =(Button)findViewById(R.id.btn_save11);
		guarder.setTypeface(fonts);
		guarder.setOnClickListener(this);
		
		back = (Button)findViewById(R.id.back_btn11);
		back.setOnClickListener(this);
		
		Button home = (Button)findViewById(R.id.home11);
		home.setOnClickListener(this);
		
		etObjective=(EditText)findViewById(R.id.etaim11);
		etObjective.setTypeface(fonts);
		
		if(i==0){
			textDescription.setText(R.string.title);
			etObjective.setText(pref.getTilte());
		}
		else if(i==1){
			textDescription.setText(R.string.theme);
			etObjective.setText(pref.getTema());
			
		}else{
			textDescription.setText(R.string.aim);
			etObjective.setText(pref.getObjective());
			
		}
		//enabling the edit text scrolling
		
//		etObjective.setMovementMethod(new ScrollingMovementMethod());
		
		
	}
	
	
	
	@Override
	protected void onPause() {
	if(i==0){
		pref.setTitle(etObjective.getText().toString());
	}else if(i==1){
		pref.setTema(etObjective.getText().toString());
	}else
		pref.setObjective(etObjective.getText().toString());
		
		super.onPause();
	}

	@Override
	public void onClick(View v) {
		dba = new DBAdapter(this);
//		String saveFile="";
		switch (v.getId()) {
			case R.id.btn_save11:
				if(i==0){
					pref.setTitle(etObjective.getText().toString());
								
				}else if(i==1){
					pref.setTema(etObjective.getText().toString());
					
				}else{
					pref.setObjective(etObjective.getText().toString());
					
				}
				dba.open();
	//			Cursor cursor =dba.getFileName();
	//			
	//			if(cursor!= null){
	//				cursor.moveToLast();
	//			}
	//			if(cursor.moveToLast()){
	//				saveFile = cursor.getString(cursor.getColumnIndex(Attributes.Database.NOMBREDEARCHIVO));
	//				Log.d(TAG, "database  last record is"+ saveFile);
	//			}
	//			if(saveFile.equals(pref.getHeading())){
					Log.d(TAG, "files are eqal");
					dba.updateRow(pref.getHeading(), pref.getTilte(), pref.getTema(), pref.getObjective(), pref.getDescriptionShort1(), pref.getDescriptionLarge1(), pref.getDescriptionShortAhorros1(), pref.getDescriptionLargeAhorros1(), pref.getDescriptionShortEgresos1(), pref.getDescriptionLargeEgresos1(), pref.getDescriptionShortCostos(), pref.getDescriptionLargeCostos(), pref.getDescriptionShortInversion(), pref.getDescriptionLargeInversion(), pref.getDescriptionShortBeneficios(), pref.getDescriptionLargeBeneficios(), pref.getDescriptionShortImpactos(), pref.getDescriptionLargeImpactos(), pref.getDescriptionShortRiesgos(), pref.getDescriptionLargeRiesgos(), pref.getIntroduction(), 
						pref.getAlcancesYLimit(),pref.getAlcancesYLimitCapacidad(), pref.getAlcancesYLimitHorarios(), pref.getAlcancesYLimitsCobertura(), pref.getAlcancesYLimitsComercial(), pref.getAlcancesYLimitsPersonal(), pref.getAlcancesYLimitsDemanda(), pref.getAlcancesYLimitsDuracion(), pref.getAlcancesYLimitsSegmen(), pref.getAlcancesYLimitsTechnologia(), pref.getAlcancesYLimitsOtro1(), pref.getAlcancesYLimitsOtro2(), pref.getAlcancesYLimitsOtro3(), 
						pref.getDependencia1(), pref.getDependencia2(), pref.getDependencia3(), pref.getDependencia4(), pref.getResultados1(), pref.getResultados2(), pref.getResultados3(), pref.getResultados4(), pref.getSupuestos1(), pref.getSupuestos2(), pref.getSupuestos3(), pref.getConclusion(), pref.getRecommendies(),pref.getSummary(),pref.getContingenciaDeslarga(),pref.getDependenciaDesLarga(),pref.getResultadosDesLarga(),pref.getSupuestosDescLarga(),pref.getCheckedElement());
					
	//			}
				dba.close();
	//			dba.insert(pref.getHeading(), pref.getTilte(), pref.getTema(), pref.getObjective(), pref.getDescriptionShort1(), pref.getDescriptionLarge1(), pref.getDescriptionShortAhorros1(), pref.getDescriptionLargeAhorros1(), pref.getDescriptionShortEgresos1(), pref.getDescriptionLargeEgresos1(), pref.getDescriptionShortCostos(), pref.getDescriptionLargeCostos(), pref.getDescriptionShortInversion(), pref.getDescriptionLargeInversion(), pref.getDescriptionShortBeneficios(), pref.getDescriptionLargeBeneficios(), pref.getDescriptionShortImpactos(), pref.getDescriptionLargeImpactos(), pref.getDescriptionShortRiesgos(), pref.getDescriptionLargeRiesgos(), pref.getIntroduction(), 
	//					pref.getAlcancesYLimit(),pref.getAlcancesYLimitCapacidad(), pref.getAlcancesYLimitHorarios(), pref.getAlcancesYLimitsCobertura(), pref.getAlcancesYLimitsComercial(), pref.getAlcancesYLimitsPersonal(), pref.getAlcancesYLimitsDemanda(), pref.getAlcancesYLimitsDuracion(), pref.getAlcancesYLimitsSegmen(), pref.getAlcancesYLimitsTechnologia(), pref.getAlcancesYLimitsOtro1(), pref.getAlcancesYLimitsOtro2(), pref.getAlcancesYLimitsOtro3(), 
	//					pref.getDependencia1(), pref.getDependencia2(), pref.getDependencia3(), pref.getDependencia4(), pref.getResultados1(), pref.getResultados2(), pref.getResultados3(), pref.getResultados4(), pref.getSupuestos1(), pref.getSupuestos2(), pref.getSupuestos3(), pref.getConclusion(), pref.getRecommendies());
			
	
				break;
	
			case R.id.viewhelp11:
				if(i==0){
					CommonUtils.showAlertDialog("", "Adecuación de un piso para renta de oficinas virtuales en Madrid", this, null);
				}else if(i==1){
					CommonUtils.showAlertDialog("", "Hoy en día se cuenta con un piso vacío de aproximadamente 280 m2 dentro de un edificio ubicado en Madrid, mismo que se encuentra completamente desocupado y por lo tanto desaprovechado.  En España el 98% de las empresas son PYMEs, dentro de este grupo las microempresas representan un 97% del total de empresas del sector servicios, en donde existe un número creciente de profesionales independientes quienes se encuentran iniciando su negocio o que residen en una ciudad distinta en la que se desarrolla su actividad profesional y por lo tanto no cuentan con el presupuesto para instalar una oficina normal o no desean incrementar considerablemente su nivel de gastos fijos. La oficina virtual es un espacio físico acondicionado con escritorios, mobiliario y herramientas tecnológicas (computadora, teléfono, celular, software, etc.) que permiten a la persona realizar sus labores temporalmente como si estuviera en su propia oficina, cuenta con servicios secretariales, domicilio fiscal, cafetería, entre otros."+
						      "Dado lo anteriormente expuesto, se considera conveniente evaluar mediante un Business Case los beneficios, costos y riesgos de adecuar el espacio físico disponible como un conjunto de oficinas que puedan ser empleadas temporalmente por los profesionales independientes", this, null);
				}else
				{
					CommonUtils.showAlertDialog("", "Medir los beneficios, impactos negativos y riesgos probables de comercializar en Madrid espacios temporales para ser utilizados como oficina", this, null);
				}
				break;
			case R.id.help11:
				Intent intentHelp=new Intent(this, TitleDescription.class);
				intentHelp.putExtra(Attributes.TITLETEXT, 0);
				intentHelp.putExtra(Attributes.LABEL2, i);
				intentHelp.putExtra("home_flag", 1);
				startActivity(intentHelp);
				break;
			
			case R.id.back_btn11:
				finish();
				overridePendingTransition( R.drawable.pull_in_left ,  R.drawable.push_out_right );
				break;
				
			case R.id.home11:
				
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
				
//				AlertDialog.Builder alert = new AlertDialog.Builder(this);
//				
//				alert.setTitle("¿Estás seguro que deseas cerrar tu Business Case?");
//				
//				alert.setNeutralButton("Si", new DialogInterface.OnClickListener() {
//					
//					@Override
//					public void onClick(DialogInterface dialog, int which) {
//						finish();
//						((Activity)MenuActivity.menucontext).finish();
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
		}
		
		
		
		
	}
	
}
