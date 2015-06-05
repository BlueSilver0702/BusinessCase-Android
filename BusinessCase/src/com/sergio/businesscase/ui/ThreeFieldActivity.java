package com.sergio.businesscase.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
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

public class ThreeFieldActivity extends Activity implements OnClickListener{
	int i,resultados,help=6;
	EditText etConDepF1,etConDepF2,etConDepF3,etConDepF4,etConDepResLarga1,etConDepResLarga2,etConDepResLarga3,etConDepResLarga4;
	TextView tvDesc,tvDescCorta1,tvDescLarga1,tvDescCorta2,tvDescLarga2,tvDescCorta3,tvDescLarga3,tvDescCorta4,tvDescLarga4,tvDesc1,tvDesc2,tvDesc3,tvDesc4;
	ImageView imgviewHelp,actionHelp,helpBtn;
	Button guarder,add,delete;
	Intent intent;
	int count=0;
	PreferenceUtils pref;
	String[] strRow;
	public static Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.three_field_activity);
		context = this;
		Intent intent=getIntent();
		i=intent.getIntExtra(Attributes.LABEL3, 0);
		resultados=intent.getIntExtra(Attributes.RESULTADOS, 0);
		Log.d("TAG", "Resultados=="+resultados);
		Log.d("TAG", "i== "+i);
		
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
		pref=new PreferenceUtils(this);
		Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Calibri.ttf");
		Typeface bold_font = Typeface.createFromAsset(getAssets(), "fonts/Calibri-bold.ttf");

		guarder=(Button)findViewById(R.id.btn_treefieldGuard);
		guarder.setTypeface(font);
		actionHelp = (ImageView)findViewById(R.id.ihelp);
		helpBtn= (ImageView)findViewById(R.id.imageView1);
//		helpBtn.setVisibility(View.GONE);
		
		etConDepF1=(EditText)findViewById(R.id.et_condep_feild1);
		etConDepF1.setTypeface(font);
		etConDepF2=(EditText)findViewById(R.id.et_condep_feild2);
		etConDepF2.setTypeface(font);
		etConDepF3=(EditText)findViewById(R.id.et_condep_feild3);
		etConDepF3.setTypeface(font);
		etConDepF4=(EditText)findViewById(R.id.et_condep_feild4);
		etConDepF4.setTypeface(font);
		
		etConDepResLarga1=(EditText)findViewById(R.id.et_condep_feild_desc_larga1);
		etConDepResLarga1.setTypeface(font);
		etConDepResLarga2=(EditText)findViewById(R.id.et_condep_feild_desc_larga2);
		etConDepResLarga2.setTypeface(font);
		etConDepResLarga3=(EditText)findViewById(R.id.et_condep_feild_desc_larga3);
		etConDepResLarga3.setTypeface(font);
		etConDepResLarga4=(EditText)findViewById(R.id.et_condep_feild_desc_larga4);
		etConDepResLarga4.setTypeface(font);
		
		tvDesc=(TextView)findViewById(R.id.tv_desc);
		tvDesc.setTypeface(bold_font);
		
		tvDesc1=(TextView)findViewById(R.id.tv_desc1);
		tvDesc1.setTypeface(font);
		tvDesc2=(TextView)findViewById(R.id.tv_desc2);
		tvDesc2.setTypeface(font);
		tvDesc3=(TextView)findViewById(R.id.tv_desc3);
		tvDesc3.setTypeface(font);
		tvDesc4=(TextView)findViewById(R.id.tv_desc4);
		tvDesc4.setTypeface(font);


		tvDescCorta1=(TextView)findViewById(R.id.tv_desc_short1);
		tvDescCorta1.setTypeface(font);
		tvDescCorta2=(TextView)findViewById(R.id.tv_desc_short2);
		tvDescCorta2.setTypeface(font);
		tvDescCorta3=(TextView)findViewById(R.id.tv_desc_corta3);
		tvDescCorta3.setTypeface(font);
		tvDescCorta4=(TextView)findViewById(R.id.tv_desc_corta4);
		tvDescCorta4.setTypeface(font);
		
		tvDescLarga1=(TextView)findViewById(R.id.tv_desc_long1);
		tvDescLarga1.setTypeface(font);
		tvDescLarga2=(TextView)findViewById(R.id.tv_desc_larga2);
		tvDescLarga2.setTypeface(font);
		tvDescLarga3=(TextView)findViewById(R.id.tv_desc_larga3);
		tvDescLarga3.setTypeface(font);
		tvDescLarga4=(TextView)findViewById(R.id.tv_desc_larga4);
		tvDescLarga4.setTypeface(font);

		CommonUtils.setTextWatcher(etConDepF1);
		CommonUtils.setTextWatcher(etConDepF2);
		CommonUtils.setTextWatcher(etConDepF3);
		CommonUtils.setTextWatcher(etConDepF4);
		CommonUtils.setTextWatcher(etConDepResLarga1);
		CommonUtils.setTextWatcher(etConDepResLarga2);
		CommonUtils.setTextWatcher(etConDepResLarga3);
		CommonUtils.setTextWatcher(etConDepResLarga4);

		imgviewHelp = (ImageView)findViewById(R.id.imgview_help);
		add=(Button)findViewById(R.id.btn_addtv);
		delete=(Button)findViewById(R.id.btn_deletetv);
		
		findViewById(R.id.backbtn7).setOnClickListener(this);
		findViewById(R.id.homebtn7).setOnClickListener(this);
//		add.setBackgroundDrawable(Attributes.getShape(Attributes.COLORS[5], Attributes.COLORS[5]));
//		delete.setBackgroundDrawable(Attributes.getShape(Attributes.COLORS[9], Attributes.COLORS[9]));
		
		helpBtn.setOnClickListener(this);
		add.setOnClickListener(this);
		delete.setOnClickListener(this);
		guarder.setOnClickListener(this);
		actionHelp.setOnClickListener(this);
		imgviewHelp.setOnClickListener(this);
		
				
		if(i==0 && resultados==0){
			tvDesc.setText("Contingencias");
			
			tvDesc1.setText("Contingencias1");
			tvDesc2.setText("Contingencias2");
			tvDesc3.setText("Contingencias3");
			tvDesc4.setText("Contingencias4");
			
			if(pref.getDescriptionShortRiesgos()!=null){
				try{
					for(int i=0 ;i<4;i++){
						String str=pref.getDescriptionShortRiesgos().split("~")[i];
						if(i==0){
							etConDepF1.setText(str);
						}
						if(i==1){
							etConDepF2.setText(str);
						}
						if(i==2){
							etConDepF3.setText(str);
						}
						if(i==3){
							etConDepF4.setText(str);
						}
					}
					
					
				}catch (ArrayIndexOutOfBoundsException e) {
					
				}
			}
			String strConDesLarga="";
			if(pref.getContingenciaDeslarga()!= null){
				try{
					strConDesLarga =pref.getContingenciaDeslarga().split("~")[0];
					etConDepResLarga1.setText(strConDesLarga);
					strConDesLarga =pref.getContingenciaDeslarga().split("~")[1];
					etConDepResLarga2.setText(strConDesLarga);
					strConDesLarga =pref.getContingenciaDeslarga().split("~")[2];
					etConDepResLarga3.setText(strConDesLarga);
					strConDesLarga =pref.getContingenciaDeslarga().split("~")[3];
					etConDepResLarga4.setText(strConDesLarga);	
				}catch(ArrayIndexOutOfBoundsException aiob){
					
				}
			}
			getVisibleRow("Contingencias");
			
		}else if(i==1 && resultados==0){
			tvDesc.setText("Dependencias");
			tvDesc1.setText("Dependencias1");
			tvDesc2.setText("Dependencias2");
			tvDesc3.setText("Dependencias3");
			tvDesc4.setText("Dependencias4");
			
			etConDepF1.setText(pref.getDependencia1());
			etConDepF2.setText(pref.getDependencia2());
			etConDepF3.setText(pref.getDependencia3());
			etConDepF4.setText(pref.getDependencia4());
			String strDeplarga = "";
			if(pref.getDependenciaDesLarga()!= null){
				try{
					
					String ss = pref.getDependenciaDesLarga();
					strDeplarga =pref.getDependenciaDesLarga().split("~")[0];
					etConDepResLarga1.setText(strDeplarga);
					strDeplarga =pref.getDependenciaDesLarga().split("~")[1];
					etConDepResLarga2.setText(strDeplarga);
					strDeplarga =pref.getDependenciaDesLarga().split("~")[2];
					etConDepResLarga3.setText(strDeplarga);
					strDeplarga =pref.getDependenciaDesLarga().split("~")[3];
					etConDepResLarga4.setText(strDeplarga);	
				}catch(ArrayIndexOutOfBoundsException aiob){
					
				}
			}
				
			getVisibleRow("Dependencias");
		}else{
			help=7;
			tvDesc.setText("     Resultados\n No Financieros");
			tvDesc1.setText("Resultados1");
			tvDesc2.setText("Resultados2");
			tvDesc3.setText("Resultados3");
			tvDesc4.setText("Resultados4");	
			
			 if(pref.getDescriptionShortBeneficios()!=null){
				 String strShort="";
				try{
					strShort= pref.getDescriptionShortBeneficios().split("~")[0];
					etConDepF1.setText(strShort);
					strShort= pref.getDescriptionShortBeneficios().split("~")[1];
					etConDepF2.setText(strShort);
					strShort= pref.getDescriptionShortBeneficios().split("~")[2];
					etConDepF3.setText(strShort);
					strShort= pref.getDescriptionShortBeneficios().split("~")[3];
					etConDepF4.setText(strShort);
				
				}catch(ArrayIndexOutOfBoundsException e){
					
				}
			 }
			 if(pref.getResultadosDesLarga()!=null){
				 String strShort="";
				try{
					String ss= pref.getResultadosDesLarga();
					strShort= pref.getResultadosDesLarga().split("~")[0];
					etConDepResLarga1.setText(strShort);
					strShort= pref.getResultadosDesLarga().split("~")[1];
					etConDepResLarga2.setText(strShort);
					strShort= pref.getResultadosDesLarga().split("~")[2];
					etConDepResLarga3.setText(strShort);
					strShort= pref.getResultadosDesLarga().split("~")[3];
					etConDepResLarga4.setText(strShort);
				
				}catch(ArrayIndexOutOfBoundsException e){
					
				}
			 }
			 getVisibleRow("Resultados");
			 
		}

	}

	private void getVisibleRow(String string) {
		if(string.equals("Contingencias")){
			if(pref.getContingenciaDeslarga()!=null || pref.getDescriptionShortRiesgos()!= null){
				if(pref.getContingenciaDeslarga()!=null)
					strRow= pref.getContingenciaDeslarga().split("~");
				if(strRow==null||strRow.length==0)
					strRow = pref.getDescriptionShortRiesgos().split("~");
				displayVisibleRow();
			}
			
		}else if(string.equals("Dependencias")){
			if(pref.getDependenciaDesLarga()!=null ){
					strRow= pref.getDependenciaDesLarga().split("~");
				displayVisibleRow();
			}
			
		}else if(string.equals("Resultados")){
			if(pref.getResultadosDesLarga()!=null || pref.getDescriptionShortBeneficios()!= null){
				if(pref.getResultadosDesLarga()!=null)
					strRow= pref.getResultadosDesLarga().split("~");
				if(strRow==null||strRow.length==0)
					strRow = pref.getDescriptionShortBeneficios().split("~");
				displayVisibleRow();
			}
			
		}
		
	}


	private void displayVisibleRow() {
		for(int j=0;j<strRow.length;j++){
			if(j==0){
//				helpBtn.setVisibility(View.VISIBLE);
				tvDesc1.setVisibility(View.VISIBLE);
				tvDescCorta1.setVisibility(View.VISIBLE);
				tvDescLarga1.setVisibility(View.VISIBLE);
				etConDepF1.setVisibility(View.VISIBLE);
				etConDepResLarga1.setVisibility(View.VISIBLE);
				count=1;
			}
			if(j==1){
				tvDesc2.setVisibility(View.VISIBLE);
				tvDescCorta2.setVisibility(View.VISIBLE);
				tvDescLarga2.setVisibility(View.VISIBLE);
				etConDepF2.setVisibility(View.VISIBLE);
				etConDepResLarga2.setVisibility(View.VISIBLE);
				count=2;
			}
			if(j==2){
				tvDesc3.setVisibility(View.VISIBLE);
				tvDescCorta3.setVisibility(View.VISIBLE);
				tvDescLarga3.setVisibility(View.VISIBLE);
				etConDepF3.setVisibility(View.VISIBLE);
				etConDepResLarga3.setVisibility(View.VISIBLE);
			
				count=3;
			}
			if(j==3){
				tvDesc4.setVisibility(View.VISIBLE);
				tvDescCorta4.setVisibility(View.VISIBLE);
				tvDescLarga4.setVisibility(View.VISIBLE);
				etConDepF4.setVisibility(View.VISIBLE);
				etConDepResLarga4.setVisibility(View.VISIBLE);
				count=4;
			}
		}
		
	}


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.imgview_help:
			if(i==0 && resultados==0){
				CommonUtils.showAlertDialog("", Attributes.HelpMessage.CONTANGCIA_HELP, this, null);
			}else if(i==1 && resultados==0){
				CommonUtils.showAlertDialog("", Attributes.HelpMessage.DEPENDENCIA_HELP, this, null);
			}else
				CommonUtils.showAlertDialog("", Attributes.HelpMessage.RESLTADOS_HELP, this, null);
			break;
			
		case R.id.btn_addtv:
			
			if(count==0){
//				helpBtn.setVisibility(View.VISIBLE);
				tvDesc1.setVisibility(View.VISIBLE);
				tvDescCorta1.setVisibility(View.VISIBLE);
				tvDescLarga1.setVisibility(View.VISIBLE);
				etConDepF1.setVisibility(View.VISIBLE);
				etConDepResLarga1.setVisibility(View.VISIBLE);
				etConDepF1.requestFocus();
				count=1;
			}else if(count==1){
				tvDesc2.setVisibility(View.VISIBLE);
				tvDescCorta2.setVisibility(View.VISIBLE);
				tvDescLarga2.setVisibility(View.VISIBLE);
				etConDepF2.setVisibility(View.VISIBLE);
				etConDepResLarga2.setVisibility(View.VISIBLE);
				etConDepF2.requestFocus();
				count=2;
			}else if(count==2){
				tvDesc3.setVisibility(View.VISIBLE);
				tvDescCorta3.setVisibility(View.VISIBLE);
				tvDescLarga3.setVisibility(View.VISIBLE);
				etConDepF3.setVisibility(View.VISIBLE);
				etConDepResLarga3.setVisibility(View.VISIBLE);
				etConDepF3.requestFocus();
			
				count=3;
			}else if(count==3){
				tvDesc4.setVisibility(View.VISIBLE);
				tvDescCorta4.setVisibility(View.VISIBLE);
				tvDescLarga4.setVisibility(View.VISIBLE);
				etConDepF4.setVisibility(View.VISIBLE);
				etConDepResLarga4.setVisibility(View.VISIBLE);
				etConDepF4.requestFocus();
				count=4;
			}
//			if(i==0 && resultados==0 || i==1 && resultados==0){
//				
//			}else
//				helpBtn.setVisibility(View.INVISIBLE);
			break;

		case R.id.btn_deletetv:
			if(count==4){
				tvDesc4.setVisibility(View.GONE);
				tvDescCorta4.setVisibility(View.GONE);
				tvDescLarga4.setVisibility(View.GONE);
				etConDepF4.setVisibility(View.GONE);
				etConDepResLarga4.setVisibility(View.GONE);
				count=3;
				
			}else
			if(count==3){
				tvDesc3.setVisibility(View.GONE);
				tvDescCorta3.setVisibility(View.GONE);
				tvDescLarga3.setVisibility(View.GONE);
				etConDepF3.setVisibility(View.GONE);
				etConDepResLarga3.setVisibility(View.GONE);
				count=2;
			}else if(count==2){
				tvDesc2.setVisibility(View.GONE);
				tvDescCorta2.setVisibility(View.GONE);
				tvDescLarga2.setVisibility(View.GONE);
				etConDepF2.setVisibility(View.GONE);
				etConDepResLarga2.setVisibility(View.GONE);
				count=1;
			}else if(count==1){
//				helpBtn.setVisibility(View.INVISIBLE);
				tvDesc1.setVisibility(View.GONE);
				tvDescCorta1.setVisibility(View.GONE);
				tvDescLarga1.setVisibility(View.GONE);
				etConDepF1.setVisibility(View.GONE);
				etConDepResLarga1.setVisibility(View.GONE);
				count=0;
			}
			
			
			break;
			
		case R.id.btn_treefieldGuard:
			if(i==0 && resultados==0){
				String strCon1=etConDepF1.getText().toString()+"~";
				pref.setDescriptionShortRiesgos(strCon1);
				String strCon2=etConDepF2.getText().toString()+"~";
				pref.setDescriptionShortRiesgos(strCon1+strCon2);
				String strCon3=etConDepF3.getText().toString()+"~";
				pref.setDescriptionShortRiesgos(strCon1+strCon2+strCon3);
				String strCon4=etConDepF4.getText().toString();
				pref.setDescriptionShortRiesgos(strCon1+strCon2+strCon3+strCon4);
			
				String strConLarga=etConDepResLarga1.getText().toString()+"~";
				strConLarga= strConLarga+etConDepResLarga2.getText().toString()+"~";
				strConLarga= strConLarga+etConDepResLarga3.getText().toString()+"~";
				strConLarga= strConLarga+etConDepResLarga4.getText().toString();
				pref.setContingenciaDesLarga(strConLarga);
				
			}else
			if(i==1 && resultados==0){
				String strDep1=etConDepF1.getText().toString();
				pref.setDependencia1(strDep1);
				String strDep2=etConDepF2.getText().toString();
				pref.setDependencia2(strDep2);
				String strDep3=etConDepF3.getText().toString();
				pref.setDependencia3(strDep3);
				String strCon4=etConDepF4.getText().toString();
				pref.setDependencia4(strCon4);
				
				
				String strDepLarga=etConDepResLarga1.getText().toString()+"~";
				strDepLarga= strDepLarga+etConDepResLarga2.getText().toString()+"~";
				strDepLarga= strDepLarga+etConDepResLarga3.getText().toString()+"~";
				strDepLarga= strDepLarga+etConDepResLarga4.getText().toString();
				pref.setDependenciaDesLarga(strDepLarga);
				
			}else{
				String strRes1=etConDepF1.getText().toString()+"~";
				String strRes2=etConDepF2.getText().toString()+"~";
				String strRes3=etConDepF3.getText().toString()+"~";
				String strRes4=etConDepF4.getText().toString();
				pref.setDescriptionShortBeneficios(strRes1+strRes2+strRes3+strRes4);
				
				String strResLarga=etConDepResLarga1.getText().toString()+"~";
				strResLarga= strResLarga+etConDepResLarga2.getText().toString()+"~";
				strResLarga= strResLarga+etConDepResLarga3.getText().toString()+"~";
				strResLarga= strResLarga+etConDepResLarga4.getText().toString();
				pref.setResultadosDescLarga(strResLarga);
			}
			DBAdapter dba = new DBAdapter(this);
//			pref = new PreferenceUtils(this);
//			String saveFile="";
			dba.open();
//			Cursor cursor =dba.getFileName();
//			if(cursor!= null){
//				cursor.moveToLast();
//			}
//			if(cursor.moveToLast()){
//				saveFile = cursor.getString(cursor.getColumnIndex(Attributes.Database.NOMBREDEARCHIVO));
////				Log.d(TAG, "database  last record is"+ saveFile);
//			}
//			if(saveFile.equals(pref.getHeading())){
				
				dba.updateRow(pref.getHeading(), pref.getTilte(), pref.getTema(), pref.getObjective(), pref.getDescriptionShort1(), pref.getDescriptionLarge1(), pref.getDescriptionShortAhorros1(), pref.getDescriptionLargeAhorros1(), pref.getDescriptionShortEgresos1(), pref.getDescriptionLargeEgresos1(), pref.getDescriptionShortCostos(), pref.getDescriptionLargeCostos(), pref.getDescriptionShortInversion(), pref.getDescriptionLargeInversion(), pref.getDescriptionShortBeneficios(), pref.getDescriptionLargeBeneficios(), pref.getDescriptionShortImpactos(), pref.getDescriptionLargeImpactos(), pref.getDescriptionShortRiesgos(), pref.getDescriptionLargeRiesgos(), pref.getIntroduction(), 
					pref.getAlcancesYLimit(),pref.getAlcancesYLimitCapacidad(), pref.getAlcancesYLimitHorarios(), pref.getAlcancesYLimitsCobertura(), pref.getAlcancesYLimitsComercial(), pref.getAlcancesYLimitsPersonal(), pref.getAlcancesYLimitsDemanda(), pref.getAlcancesYLimitsDuracion(), pref.getAlcancesYLimitsSegmen(), pref.getAlcancesYLimitsTechnologia(), pref.getAlcancesYLimitsOtro1(), pref.getAlcancesYLimitsOtro2(), pref.getAlcancesYLimitsOtro3(), 
					pref.getDependencia1(), pref.getDependencia2(), pref.getDependencia3(), pref.getDependencia4(), pref.getResultados1(), pref.getResultados2(), pref.getResultados3(), pref.getResultados4(), pref.getSupuestos1(), pref.getSupuestos2(), pref.getSupuestos3(), pref.getConclusion(), pref.getRecommendies(),pref.getSummary(),pref.getContingenciaDeslarga(),pref.getDependenciaDesLarga(),pref.getResultadosDesLarga(),pref.getSupuestosDescLarga(),pref.getCheckedElement());
				
//			}
			dba.close();
			
			break;
		case R.id.ihelp:
			Intent intentHelp=new Intent(this, TitleDescription.class);
			intentHelp.putExtra(Attributes.TITLETEXT, help);
			intentHelp.putExtra(Attributes.LABEL2, i);
			intentHelp.putExtra("home_flag", 7);
			startActivity(intentHelp);
			break;
		case R.id.imageView1:
			if(i==0 && resultados==0){
				CommonUtils.showAlertDialog("title", Attributes.HelpMessage.CONDEPRESHELP[0], this, null);
			}else if(i==1 && resultados==0){
				CommonUtils.showAlertDialog("title", Attributes.HelpMessage.CONDEPRESHELP[1], this, null);
			}else{
				CommonUtils.showAlertDialog("title", Attributes.HelpMessage.CONDEPRESHELP[2], this, null);
			}
			
			break;
			
		case R.id.backbtn7:
			finish();
			overridePendingTransition( R.drawable.pull_in_left ,  R.drawable.push_out_right );
			break;
		case R.id.homebtn7:
			
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
//			
//			finish();
//			((Activity)MenuActivity.menucontext).finish();
		}
		
	}
	@Override
	protected void onPause() {
		if(i==0 && resultados==0){
			String strCon1=etConDepF1.getText().toString().trim()+"~";
			pref.setDescriptionShortRiesgos(strCon1);
			String strCon2=etConDepF2.getText().toString().trim()+"~";
			pref.setDescriptionShortRiesgos(strCon1+strCon2);
			String strCon3=etConDepF3.getText().toString().trim()+"~";
			pref.setDescriptionShortRiesgos(strCon1+strCon2+strCon3);
			String strCon4=etConDepF4.getText().toString().trim();
			pref.setDescriptionShortRiesgos(strCon1+strCon2+strCon3+strCon4);
			String strConLarga=etConDepResLarga1.getText().toString()+"~";
			strConLarga= strConLarga+etConDepResLarga2.getText().toString()+"~";
			strConLarga= strConLarga+etConDepResLarga3.getText().toString()+"~";
			strConLarga= strConLarga+etConDepResLarga4.getText().toString();
			pref.setContingenciaDesLarga(strConLarga);
				
		}else
		if(i==1 && resultados==0){
			String strDep1=etConDepF1.getText().toString();
			pref.setDependencia1(strDep1);
			String strDep2=etConDepF2.getText().toString();
			pref.setDependencia2(strDep2);
			String strDep3=etConDepF3.getText().toString();
			pref.setDependencia3(strDep3);
			String strCon4=etConDepF4.getText().toString();
			pref.setDependencia4(strCon4);
			String strDepLarga=etConDepResLarga1.getText().toString()+"~";
			strDepLarga= strDepLarga+etConDepResLarga2.getText().toString()+"~";
			strDepLarga= strDepLarga+etConDepResLarga3.getText().toString()+"~";
			strDepLarga= strDepLarga+etConDepResLarga4.getText().toString();
			pref.setDependenciaDesLarga(strDepLarga);
			
		}else{
			
			String strCon1=etConDepF1.getText().toString()+"~";
			String strCon2=etConDepF2.getText().toString()+"~";
			String strCon3=etConDepF3.getText().toString()+"~";
			String strCon4=etConDepF4.getText().toString();
			pref.setDescriptionShortBeneficios(strCon1+strCon2+strCon3+strCon4);
			String strResLarga=etConDepResLarga1.getText().toString()+"~";
			strResLarga= strResLarga+etConDepResLarga2.getText().toString()+"~";
			strResLarga= strResLarga+etConDepResLarga3.getText().toString()+"~";
			strResLarga= strResLarga+etConDepResLarga4.getText().toString();
			pref.setResultadosDescLarga(strResLarga);
				
		}
		
		super.onPause();
	}

	
}
