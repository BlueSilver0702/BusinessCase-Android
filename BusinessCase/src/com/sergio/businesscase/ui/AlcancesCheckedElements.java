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
import com.sergio.businesscase.helper.AlcancesListAdapter;
import com.sergio.businesscase.helper.Attributes;
import com.sergio.businesscase.utils.CommonUtils;
import com.sergio.businesscase.utils.PreferenceUtils;

public class AlcancesCheckedElements extends Activity implements OnClickListener{
	
	public static Context context;
	ArrayList<String> checkedStr = null;
	ArrayList<String> items;
	ListView list;
	Intent intent;
	AlcancesListAdapter adapter;
	Button guarder;
	TextView title,tvTempo,tvCapacidad,tvhorarios,tvCobertura,tvProductos,tvMoneda,tvDistributiohn,tvEditification,tvAlmacenamento,
			tvCapitalRequired,tvOtro1,tvOtro2,tvOtro3;;
	ImageView help;
	PreferenceUtils pref;
	EditText etTempo,etCapacidad,ethorarios,etCobertura,etProductos,etMoneda,etDistributiohn,etEditification,etAlmacenamento,
			etCapitalRequired,etOtro1,etOtro2,etOtro3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alcances_checked_elelments);
		context = this;
		
		intent=getIntent();
		
		init();
		
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
	
	private void init() {
		Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Calibri.ttf");
		Typeface bold_font = Typeface.createFromAsset(getAssets(), "fonts/Calibri-bold.ttf");
		pref = new PreferenceUtils(this);
		
		title =(TextView)findViewById(R.id.tvtitle);
		help = (ImageView)findViewById(R.id.imghelp_btn999);
		title.setTypeface(bold_font);
		title.setText("Alcances y Límites\n  / Descripciones");
		guarder=(Button)findViewById(R.id.btn_guard);
		guarder.setTypeface(font);
		guarder.setOnClickListener(this);
		
		findViewById(R.id.backbtn61).setOnClickListener(this);
		findViewById(R.id.homebtn61).setOnClickListener(this);
		
		checkedStr=new ArrayList<String>();
		
		checkedStr=intent.getStringArrayListExtra(Attributes.CHECKEDELEMENT);
		Log.d("TAG", "string array"+checkedStr.size()+"\ncheck array is"+checkedStr);
		
		etTempo =(EditText)findViewById(R.id.et_teimpo);
		etTempo.setTypeface(font);
		etCapacidad =(EditText)findViewById(R.id.et_capacidad);
		etCapacidad.setTypeface(font);
		ethorarios =(EditText)findViewById(R.id.et_horis_de_operation);
		ethorarios.setTypeface(font);
		etCobertura  =(EditText)findViewById(R.id.et_cobertura_geografica);
		etCobertura.setTypeface(font);
		etProductos =(EditText)findViewById(R.id.et_proucty_serviso);
		etProductos.setTypeface(font);
		etMoneda =(EditText)findViewById(R.id.et_moneda);
		etMoneda.setTypeface(font);
		etDistributiohn =(EditText)findViewById(R.id.et_distribucion);
		etDistributiohn.setTypeface(font);
		etEditification =(EditText)findViewById(R.id.et_edification);
		etEditification.setTypeface(font);
		etAlmacenamento =(EditText)findViewById(R.id.et_almaceniominto);
		etAlmacenamento.setTypeface(font);
		etCapitalRequired =(EditText)findViewById(R.id.et_capital_requiredo);
		etCapitalRequired.setTypeface(font);
		etOtro1 =(EditText)findViewById(R.id.et_ortos1);
		etOtro1.setTypeface(font);
		etOtro2 =(EditText)findViewById(R.id.et_ortos2);
		etOtro2.setTypeface(font);
		etOtro3 =(EditText)findViewById(R.id.et_ortos3);
		etOtro3.setTypeface(font);
		CommonUtils.setTextWatcher(etTempo);
		CommonUtils.setTextWatcher(etCapacidad);
		CommonUtils.setTextWatcher(ethorarios);
		CommonUtils.setTextWatcher(etCobertura);
		CommonUtils.setTextWatcher(etProductos);
		CommonUtils.setTextWatcher(etMoneda);
		CommonUtils.setTextWatcher(etDistributiohn);
		CommonUtils.setTextWatcher(etEditification);
		CommonUtils.setTextWatcher(etAlmacenamento);
		CommonUtils.setTextWatcher(etCapitalRequired);
		CommonUtils.setTextWatcher(etOtro1);
		CommonUtils.setTextWatcher(etOtro2);
		CommonUtils.setTextWatcher(etOtro3);
		
		tvTempo =(TextView)findViewById(R.id.tv_tiempo);
		tvTempo.setTypeface(font);
		tvCapacidad =(TextView)findViewById(R.id.tv_capacidad);
		tvCapacidad.setTypeface(font);
		tvhorarios =(TextView)findViewById(R.id.tv_horaris);
		tvhorarios.setTypeface(font);
		tvCobertura  =(TextView)findViewById(R.id.tv_cobertura);
		tvCobertura.setTypeface(font);
		tvProductos =(TextView)findViewById(R.id.tv_products);
		tvProductos.setTypeface(font);
		tvMoneda =(TextView)findViewById(R.id.tv_mondea);
		tvMoneda.setTypeface(font);
		tvDistributiohn =(TextView)findViewById(R.id.tv_distribucion);
		tvDistributiohn.setTypeface(font);
		tvEditification =(TextView)findViewById(R.id.tv_editification);
		tvEditification.setTypeface(font);
		tvAlmacenamento =(TextView)findViewById(R.id.tv_almace);
		tvAlmacenamento.setTypeface(font);
		tvCapitalRequired =(TextView)findViewById(R.id.tv_capital);
		tvCapitalRequired.setTypeface(font);
		tvOtro1 =(TextView)findViewById(R.id.tv_otro1);
		tvOtro1.setTypeface(font);
		tvOtro2 =(TextView)findViewById(R.id.tv_otro2);
		tvOtro2.setTypeface(font);
		tvOtro3 =(TextView)findViewById(R.id.tv_otro3);
		tvOtro3.setTypeface(font);
		setEdittextValue();
		
		help .setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intentHelp=new Intent(AlcancesCheckedElements.this, TitleDescription.class);
				intentHelp.putExtra(Attributes.TITLETEXT, 5);
				intentHelp.putExtra("home_flag", 61);
				startActivity(intentHelp);
				
			}
		});
		
	}

	@Override
	protected void onPause() {
		getEdittextValue();
//		adapter.getListText();
		super.onPause();
	
		
	}
	
	@Override
	public void onClick(View v) {
		
		switch(v.getId())
		{
			case R.id.btn_guard:
				getEdittextValue();	
//				adapter.getListText();
				DBAdapter dba = new DBAdapter(this);
				
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
//					
					dba.updateRow(pref.getHeading(), pref.getTilte(), pref.getTema(), pref.getObjective(), pref.getDescriptionShort1(), pref.getDescriptionLarge1(), pref.getDescriptionShortAhorros1(), pref.getDescriptionLargeAhorros1(), pref.getDescriptionShortEgresos1(), pref.getDescriptionLargeEgresos1(), pref.getDescriptionShortCostos(), pref.getDescriptionLargeCostos(), pref.getDescriptionShortInversion(), pref.getDescriptionLargeInversion(), pref.getDescriptionShortBeneficios(), pref.getDescriptionLargeBeneficios(), pref.getDescriptionShortImpactos(), pref.getDescriptionLargeImpactos(), pref.getDescriptionShortRiesgos(), pref.getDescriptionLargeRiesgos(), pref.getIntroduction(), 
						pref.getAlcancesYLimit(),pref.getAlcancesYLimitCapacidad(), pref.getAlcancesYLimitHorarios(), pref.getAlcancesYLimitsCobertura(), pref.getAlcancesYLimitsComercial(), pref.getAlcancesYLimitsPersonal(), pref.getAlcancesYLimitsDemanda(), pref.getAlcancesYLimitsDuracion(), pref.getAlcancesYLimitsSegmen(), pref.getAlcancesYLimitsTechnologia(), pref.getAlcancesYLimitsOtro1(), pref.getAlcancesYLimitsOtro2(), pref.getAlcancesYLimitsOtro3(), 
						pref.getDependencia1(), pref.getDependencia2(), pref.getDependencia3(), pref.getDependencia4(), pref.getResultados1(), pref.getResultados2(), pref.getResultados3(), pref.getResultados4(), pref.getSupuestos1(), pref.getSupuestos2(), pref.getSupuestos3(), pref.getConclusion(), pref.getRecommendies(),pref.getSummary(),pref.getContingenciaDeslarga(),pref.getDependenciaDesLarga(),pref.getResultadosDesLarga(),pref.getSupuestosDescLarga(),pref.getCheckedElement());
					
//				}
				dba.close();				
				break;			
			case R.id.backbtn61:
				finish();
				overridePendingTransition( R.drawable.pull_in_left ,  R.drawable.push_out_right );
				break;
			case R.id.homebtn61:
				final Dialog home_back_dlg = new Dialog(this);
				home_back_dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
				home_back_dlg.setContentView(R.layout.home_dialog);
				
				home_back_dlg.findViewById(R.id.home_btn_back).setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						finish();
						((Activity)AlcancesYLimites.context).finish();
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
//						((Activity)AlcancesYLimites.context).finish();
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
				
			
				break;
		}
		getEdittextValue();	
//		adapter.getListText();
		DBAdapter dba = new DBAdapter(this);
		
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
	
	}
	private void getEdittextValue() {
	
			for(int i=0;i<checkedStr.size();i++){
				
				String checkedrrayTitle = checkedStr.get(i);
				
			   if(checkedrrayTitle.equals(Attributes.CHKBOXTIEMPO)){
				  	pref.setAlcancesYLimits(etTempo.getText().toString());
				}
				if(checkedrrayTitle.equals(Attributes.CHKBOXCAPACIDAD)){
					pref.setAlcancesYLimitsCapcidad(etCapacidad.getText().toString());
				}
				if(checkedrrayTitle.equals(Attributes.CHKBOXHORARAIOS)){
					pref.setAlcancesYLimitsHorarios(ethorarios.getText().toString());
				}
				if(checkedrrayTitle.equals(Attributes.CHKBOXCOBERTURA)){
					pref.setAlcancesYLimitsCobertura(etCobertura.getText().toString());
				}
				if(checkedrrayTitle.equals(Attributes.CHKBOXCOMERCIAL)){
					pref.setAlcancesYLimitsComercial(etProductos.getText().toString());
				}
				if(checkedrrayTitle.equals(Attributes.CHKBOXPERSONAL)){
					pref.setAlcancesYLimitsPersonal(etMoneda.getText().toString());
				}
				if(checkedrrayTitle.equals(Attributes.CHKBOXDEMANDA)){
					pref.setAlcancesYLimitsDemanda(etDistributiohn.getText().toString());
				}
				if(checkedrrayTitle.equals(Attributes.CHKBOXDURACION)){
					pref.setAlcancesYLimitsDuracion(etEditification.getText().toString());
				}
				if(checkedrrayTitle.equals(Attributes.CHKBOXSEGMEN)){
					pref.setAlcancesYLimitsSegmen(etAlmacenamento.getText().toString());
				}
				if(checkedrrayTitle.equals(Attributes.CHKBOXTECHNOLOGIA)){
					pref.setAlcancesYLimitsTechnologia(etCapitalRequired.getText().toString());
				}
				if(checkedrrayTitle.equals(Attributes.CHKBOXOTRO1)){
					pref.setAlcancesYLimitsOtro1(etOtro1.getText().toString());
				}
				if(checkedrrayTitle.equals(Attributes.CHKBOXOTRO2)){
					pref.setAlcancesYLimitsOtro2(etOtro2.getText().toString());
				}
				if(checkedrrayTitle.equals(Attributes.CHKBOXOTRO3)){
					pref.setAlcancesYLimitsOtro3(etOtro3.getText().toString());
				}
			}		
	}

	private void setEdittextValue() {

		for(int i=0;i<checkedStr.size();i++){
			
			String checkedrrayTitle = checkedStr.get(i);
			
		   if(checkedrrayTitle.equals(Attributes.CHKBOXTIEMPO)){
			   tvTempo.setVisibility(View.VISIBLE);
			   etTempo.setVisibility(View.VISIBLE);
			   etTempo.setText(pref.getAlcancesYLimit());
			}
			if(checkedrrayTitle.equals(Attributes.CHKBOXCAPACIDAD)){
				tvCapacidad.setVisibility(View.VISIBLE);
				etCapacidad.setVisibility(View.VISIBLE);
				etCapacidad.setText(pref.getAlcancesYLimitCapacidad());
			}
			if(checkedrrayTitle.equals(Attributes.CHKBOXHORARAIOS)){
				tvhorarios.setVisibility(View.VISIBLE);
				ethorarios.setVisibility(View.VISIBLE);
				ethorarios.setText(pref.getAlcancesYLimitHorarios());
			}
			if(checkedrrayTitle.equals(Attributes.CHKBOXCOBERTURA)){
				tvCobertura.setVisibility(View.VISIBLE);
				etCobertura.setVisibility(View.VISIBLE);
				etCobertura.setText(pref.getAlcancesYLimitsCobertura());
			}
			if(checkedrrayTitle.equals(Attributes.CHKBOXCOMERCIAL)){
				tvProductos.setVisibility(View.VISIBLE);
				etProductos.setVisibility(View.VISIBLE);
				etProductos.setText(pref.getAlcancesYLimitsComercial());
			}
			if(checkedrrayTitle.equals(Attributes.CHKBOXPERSONAL)){
				tvMoneda.setVisibility(View.VISIBLE);
				etMoneda.setVisibility(View.VISIBLE);
				etMoneda.setText(pref.getAlcancesYLimitsPersonal());
			}
			if(checkedrrayTitle.equals(Attributes.CHKBOXDEMANDA)){
				tvDistributiohn.setVisibility(View.VISIBLE);
				etDistributiohn.setVisibility(View.VISIBLE);
				etDistributiohn.setText(pref.getAlcancesYLimitsDemanda());
			}
			if(checkedrrayTitle.equals(Attributes.CHKBOXDURACION)){
				tvEditification.setVisibility(View.VISIBLE);
				etEditification.setVisibility(View.VISIBLE);
				etEditification.setText(pref.getAlcancesYLimitsDuracion());
			}
			if(checkedrrayTitle.equals(Attributes.CHKBOXSEGMEN)){
				tvAlmacenamento.setVisibility(View.VISIBLE);
				etAlmacenamento.setVisibility(View.VISIBLE);
				etAlmacenamento.setText(pref.getAlcancesYLimitsSegmen());
			}
			if(checkedrrayTitle.equals(Attributes.CHKBOXTECHNOLOGIA)){
				tvCapitalRequired.setVisibility(View.VISIBLE);
				etCapitalRequired.setVisibility(View.VISIBLE);
				etCapitalRequired.setText(pref.getAlcancesYLimitsTechnologia());
			}
			if(checkedrrayTitle.equals(Attributes.CHKBOXOTRO1)){
				tvOtro1.setVisibility(View.VISIBLE);
				etOtro1.setVisibility(View.VISIBLE);
				etOtro1.setText(pref.getAlcancesYLimitsOtro1());
			}
			if(checkedrrayTitle.equals(Attributes.CHKBOXOTRO2)){
				tvOtro2.setVisibility(View.VISIBLE);
				etOtro2.setVisibility(View.VISIBLE);
				etOtro2.setText(pref.getAlcancesYLimitsOtro2());
			}
			if(checkedrrayTitle.equals(Attributes.CHKBOXOTRO3)){
				tvOtro3.setVisibility(View.VISIBLE);
				etOtro3.setVisibility(View.VISIBLE);
				etOtro3.setText(pref.getAlcancesYLimitsOtro3());
			}
	
		}
	
		
	}
}
