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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.apptentive.android.sdk.Apptentive;
import com.flurry.android.FlurryAgent;
import com.sergio.businesscase.R;
import com.sergio.businesscase.db.DBAdapter;
import com.sergio.businesscase.helper.Attributes;
import com.sergio.businesscase.utils.CommonUtils;
import com.sergio.businesscase.utils.PreferenceUtils;

public class IngresosTabActivity extends Activity implements OnClickListener{

	private static final String TAG = "IngresosTabActivity";
	public static Context context;
//	ImageView addRow,deleteRow;
	Button btnGuarder, addRow,deleteRow;
	String strVariable,strValue;
	int count=0,i,j;
	ImageView imgHelp,help;
	EditText etvariable1,etvalue1,etvariable2,etvalue2,etvariable3,etvalue3,etvariable4,etvalue4,etvariable5,etvalue5,
	etvariable6,etvalue6,etvariable7,etvalue7,etvariable8,etvalue8;

	TextView txvariable1,txvalue1,txvariable2,txvalue2,txvariable3,txvalue3,txvariable4,txvalue4,txvariable5,txvalue5,txvariable6,txvalue6,txvariable7,
	txvalue7,txvariable8,txvalue8;
	
	PreferenceUtils pref;
	TextView invesrionTitle;
//	RelativeLayout relLayInver;
	String displayEdittext[];
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ingresos_tab_activity);
		context = this;
		
		Intent intent=getIntent();
		i=intent.getIntExtra(Attributes.TABVALUE, 0);
		j=intent.getIntExtra(Attributes.LABEL2, 0);
		Log.d(TAG, "inversion value  in ingressos value"+i);
				
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
		Typeface fonts = Typeface.createFromAsset(getAssets(), "fonts/Calibri.ttf");
		Typeface bols_fonts = Typeface.createFromAsset(getAssets(), "fonts/Calibri-bold.ttf");
//		relLayInver = (RelativeLayout)findViewById(R.id.only_for_inversion);
		help = (ImageView)findViewById(R.id.ivhelp);
		invesrionTitle = (TextView)findViewById(R.id.tv_inversion_title);
		invesrionTitle.setTypeface(bols_fonts);
		if(j==0){
			if(i==0){
				invesrionTitle.setText("Variables de Ingresos");
			}else if(i==3){
				invesrionTitle.setText("Variables de Ahorros");
			}
			
			
			if(i==1){
				invesrionTitle.setText("Variables de Gastos");
			}else if(i==4){
				invesrionTitle.setText("Variables de Costos");
			}
		}
		if(j==2){
			i=j;
			help.setVisibility(View.VISIBLE);
			invesrionTitle.setText("Variables de Inversión");
			help.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intentHelp=new Intent(IngresosTabActivity.this, TitleDescription.class);
					intentHelp.putExtra(Attributes.TITLETEXT, 4);
					intentHelp.putExtra(Attributes.LABEL2, i);
					intentHelp.putExtra("home_flag", 52);
					startActivity(intentHelp);
					
				}
			});
			
		}
		
		
				
		imgHelp=(ImageView)findViewById(R.id.imgbtn_ing_help);
		addRow=(Button)findViewById(R.id.btn_add_row);
		deleteRow=(Button)findViewById(R.id.btn_delete_row);
		btnGuarder=(Button)findViewById(R.id.btn_guard);
		btnGuarder.setTypeface(fonts);
		
		findViewById(R.id.backbtn51).setOnClickListener(this);
		findViewById(R.id.homebtn51).setOnClickListener(this);
		
		txvariable1 = (TextView)findViewById(R.id.tx_variable1);
		txvariable1.setTypeface(fonts);
		
		txvalue1 = (TextView)findViewById(R.id.tx_valor1);
		txvalue1.setTypeface(fonts);
		
		txvariable2 = (TextView)findViewById(R.id.tx_variable2);
		txvariable2.setTypeface(fonts);
		
		txvalue2 = (TextView)findViewById(R.id.tx_valor2);
		txvalue2.setTypeface(fonts);
		
		txvariable3 = (TextView)findViewById(R.id.tx_variable3);
		txvariable3.setTypeface(fonts);
		
		txvalue3 = (TextView)findViewById(R.id.tx_valor3);
		txvalue3.setTypeface(fonts);
		
		txvariable4 = (TextView)findViewById(R.id.tx_variable4);
		txvariable4.setTypeface(fonts);
		
		txvalue4 = (TextView)findViewById(R.id.tx_valor4);
		txvalue4.setTypeface(fonts);
		
		txvariable5 = (TextView)findViewById(R.id.tx_variable5);
		txvariable5.setTypeface(fonts);
		
		txvalue5 = (TextView)findViewById(R.id.tx_valor5);
		txvalue5.setTypeface(fonts);
		
		txvariable6 = (TextView)findViewById(R.id.tx_variable6);
		txvariable6.setTypeface(fonts);
		
		txvalue6 = (TextView)findViewById(R.id.tx_valor6);
		txvalue6.setTypeface(fonts);
		
		txvariable7 = (TextView)findViewById(R.id.tx_variable7);
		txvariable7.setTypeface(fonts);
		
		txvalue7 = (TextView)findViewById(R.id.tx_valor7);
		txvalue7.setTypeface(fonts);
		
		txvariable8 = (TextView)findViewById(R.id.tx_variable8);
		txvariable8.setTypeface(fonts);
		
		txvalue8 = (TextView)findViewById(R.id.tx_valor8);
		txvalue8.setTypeface(fonts);
		
		
		
		etvariable1 =(EditText)findViewById(R.id.et_variable1);
		etvariable1.setTypeface(fonts);
		
		etvalue1 =(EditText)findViewById(R.id.et_valor1);
		etvalue1.setTypeface(fonts);
		
		etvariable2 =(EditText)findViewById(R.id.et_variable2);
		etvariable2.setTypeface(fonts);
	
		etvalue2 =(EditText)findViewById(R.id.et_valor2);
		etvalue2.setTypeface(fonts);
		
		etvariable3 =(EditText)findViewById(R.id.et_variable3);
		etvariable3.setTypeface(fonts);
		
		etvalue3 =(EditText)findViewById(R.id.et_valor3);
		etvalue3.setTypeface(fonts);
		
		etvariable4 =(EditText)findViewById(R.id.et_variable4);
		etvariable4.setTypeface(fonts);
		
		etvalue4 =(EditText)findViewById(R.id.et_valor4);
		etvalue4.setTypeface(fonts);
		
		etvariable5 =(EditText)findViewById(R.id.et_variable5);
		etvariable5.setTypeface(fonts);
		
		etvalue5 =(EditText)findViewById(R.id.et_valor5);
		etvalue5.setTypeface(fonts);
		
		etvariable6 =(EditText)findViewById(R.id.et_variable6);
		etvariable6.setTypeface(fonts);
		
		etvalue6 =(EditText)findViewById(R.id.et_valor6);
		etvalue6.setTypeface(fonts);
		
		etvariable7 =(EditText)findViewById(R.id.et_variable7);
		etvariable7.setTypeface(fonts);
		
		etvalue7 =(EditText)findViewById(R.id.et_valor7);
		etvalue7.setTypeface(fonts);
		
		etvariable8 =(EditText)findViewById(R.id.et_variable8);
		etvariable8.setTypeface(fonts);
	
		etvalue8 =(EditText)findViewById(R.id.et_valor8);
		etvalue8.setTypeface(fonts);
		addRow.setOnClickListener(this);
		deleteRow.setOnClickListener(this);
		btnGuarder.setOnClickListener(this);
		imgHelp.setOnClickListener(this);
		if(i== 0){
			if(pref.getVariable() != null){
			displayEdittext = pref.getVariable().split("~");
			getDisplayValues(i);
			}
		}
		if(i== 1){
			if(pref.getEgrossVariable() != null){
			displayEdittext = pref.getEgrossVariable().split("~");
			getDisplayValues(i);
			}
		}
		if(i== 2){
			if(pref.getInversionVariable() != null){
			displayEdittext = pref.getInversionVariable().split("~");
			getDisplayValues(i);
			}
		}
		if(i== 3){
			if(pref.getAhorrosVariable() != null){
			displayEdittext = pref.getAhorrosVariable().split("~");
			getDisplayValues(i);
			}
		}if(i== 4){
			if(pref.getCostosVariable() != null){
			displayEdittext = pref.getCostosVariable().split("~");
			getDisplayValues(i);
			}
		}
		
	}

	private void getDisplayValues(int x) {
		for (int j = 0; j < displayEdittext.length; j++) {
			if(j==0){
				txvariable1.setVisibility(View.VISIBLE);
				txvalue1.setVisibility(View.VISIBLE);
				etvariable1.setVisibility(View.VISIBLE);
				etvalue1.setVisibility(View.VISIBLE);
				count=1;
			}
			if(j==1){
				txvariable2.setVisibility(View.VISIBLE);
				txvalue2.setVisibility(View.VISIBLE);
				etvariable2.setVisibility(View.VISIBLE);
				etvalue2.setVisibility(View.VISIBLE);
				count=2;
			}
			if(j==2){
				txvariable3.setVisibility(View.VISIBLE);
				txvalue3.setVisibility(View.VISIBLE);
				etvariable3.setVisibility(View.VISIBLE);
				etvalue3.setVisibility(View.VISIBLE);
				count=3;
			}
			if(j==3){
				txvariable4.setVisibility(View.VISIBLE);
				txvalue4.setVisibility(View.VISIBLE);
				etvariable4.setVisibility(View.VISIBLE);
				etvalue4.setVisibility(View.VISIBLE);
				count=4;
			}
			if(j==4){
				txvariable5.setVisibility(View.VISIBLE);
				txvalue5.setVisibility(View.VISIBLE);
				etvariable5.setVisibility(View.VISIBLE);
				etvalue5.setVisibility(View.VISIBLE);
				count=5;
			}
			if(j==5){
				txvariable6.setVisibility(View.VISIBLE);
				txvalue6.setVisibility(View.VISIBLE);
				etvariable6.setVisibility(View.VISIBLE);
				etvalue6.setVisibility(View.VISIBLE);
				count=6;
			}
			if(j==6){
				txvariable7.setVisibility(View.VISIBLE);
				txvalue7.setVisibility(View.VISIBLE);
				etvariable7.setVisibility(View.VISIBLE);
				etvalue7.setVisibility(View.VISIBLE);
				count=7;
			}
			if(j==7){
				txvariable8.setVisibility(View.VISIBLE);
				txvalue8.setVisibility(View.VISIBLE);
				etvariable8.setVisibility(View.VISIBLE);
				etvalue8.setVisibility(View.VISIBLE);
				count=8;
			}
			setValue(i);
		}
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_add_row:
			
			if(count==7){
				txvariable8.setVisibility(View.VISIBLE);
				txvalue8.setVisibility(View.VISIBLE);
				etvariable8.setVisibility(View.VISIBLE);
				etvalue8.setVisibility(View.VISIBLE);
				etvariable8.requestFocus();
				count=8;
			}
			if(count==6){
				txvariable7.setVisibility(View.VISIBLE);
				txvalue7.setVisibility(View.VISIBLE);
				etvariable7.setVisibility(View.VISIBLE);
				etvalue7.setVisibility(View.VISIBLE);
				etvariable7.requestFocus();
				count=7;
			}
			
			if(count==5){
				txvariable6.setVisibility(View.VISIBLE);
				txvalue6.setVisibility(View.VISIBLE);
				etvariable6.setVisibility(View.VISIBLE);
				etvalue6.setVisibility(View.VISIBLE);
				etvariable6.requestFocus();
				count=6;
			}
			
			if(count==4){
				txvariable5.setVisibility(View.VISIBLE);
				txvalue5.setVisibility(View.VISIBLE);
				etvariable5.setVisibility(View.VISIBLE);
				etvalue5.setVisibility(View.VISIBLE);
				etvariable5.requestFocus();
				count=5;
			}
			if(count==3){
				txvariable4.setVisibility(View.VISIBLE);
				txvalue4.setVisibility(View.VISIBLE);
				etvariable4.setVisibility(View.VISIBLE);
				etvalue4.setVisibility(View.VISIBLE);
				etvariable4.requestFocus();
				count=4;
			}
			if(count==2){
				txvariable3.setVisibility(View.VISIBLE);
				txvalue3.setVisibility(View.VISIBLE);
				etvariable3.setVisibility(View.VISIBLE);
				etvalue3.setVisibility(View.VISIBLE);
				etvariable3.requestFocus();
				count=3;
			}
			if(count==1){
				txvariable2.setVisibility(View.VISIBLE);
				txvalue2.setVisibility(View.VISIBLE);
				etvariable2.setVisibility(View.VISIBLE);
				etvalue2.setVisibility(View.VISIBLE);
				etvariable2.requestFocus();
				count=2;
			}
			if(count==0){
				txvariable1.setVisibility(View.VISIBLE);
				txvalue1.setVisibility(View.VISIBLE);
				etvariable1.setVisibility(View.VISIBLE);
				
				etvalue1.setVisibility(View.VISIBLE);
				count=1;
			}
			
			setValue(i);
		
			//addItems(list);
			
			break;

		case R.id.btn_delete_row:
			
			if(count==1){
				txvariable1.setVisibility(View.GONE);
				txvalue1.setVisibility(View.GONE);
				etvariable1.setVisibility(View.GONE);
				
				etvalue1.setVisibility(View.GONE);
				count=0;
			}
			
			if(count==2){
				txvariable2.setVisibility(View.GONE);
				txvalue2.setVisibility(View.GONE);
				etvariable2.setVisibility(View.GONE);
			
				etvalue2.setVisibility(View.GONE);
				count=1;
			}
			
			if(count==3){
				txvariable3.setVisibility(View.GONE);
				txvalue3.setVisibility(View.GONE);
				etvariable3.setVisibility(View.GONE);
				
				etvalue3.setVisibility(View.GONE);
				count=2;
			}
			
			if(count==4){
				txvariable4.setVisibility(View.GONE);
				txvalue4.setVisibility(View.GONE);
				etvariable4.setVisibility(View.GONE);
				
				etvalue4.setVisibility(View.GONE);
				count=3;
			}
			
			if(count==5){
				txvariable5.setVisibility(View.GONE);
				txvalue5.setVisibility(View.GONE);
				etvariable5.setVisibility(View.GONE);
				
				etvalue5.setVisibility(View.GONE);
				count=4;
			}
			
			if(count==6){
				txvariable6.setVisibility(View.GONE);
				txvalue6.setVisibility(View.GONE);
				etvariable6.setVisibility(View.GONE);
				
				etvalue6.setVisibility(View.GONE);
				count=5;
			}
			
			if(count==7){
				txvariable7.setVisibility(View.GONE);
				txvalue7.setVisibility(View.GONE);
				etvariable7.setVisibility(View.GONE);
			
				etvalue7.setVisibility(View.GONE);
				count=6;
			}
			
			if(count==8){
				txvariable8.setVisibility(View.GONE);
				txvalue8.setVisibility(View.GONE);
				etvariable8.setVisibility(View.GONE);
				
				etvalue8.setVisibility(View.GONE);
				count=7;
			}
			
			break;
		case R.id.imgbtn_ing_help:
		
			if(i==0 )
				CommonUtils.showAlertTable(this,"Espacios disponibles","16","Precio de venta por hr.","USD$17.5");
//			CommonUtils.showAlertDialog("", Attributes.HelpMessage.MODELOFINANCIERO[0], this, null);
			if(i==3){
				CommonUtils.showAlertTable(this,"Gastos de \noficina \nmensuales","USD$1,450","Sueldos \nmensuales","USD$750");
			}
			if(i==1)
				CommonUtils.showAlertTable(this,"Sueldo por hora / empleado","$4.00","Nœmero de empleados","2");
//				CommonUtils.showAlertDialog("", Attributes.HelpMessage.MODELOFINANCIERO[1], this, null);
			if(i==4){
				CommonUtils.showAlertTable(this,"Lineas\n telefónicas ","10","Costo mensual \nde renta por \nlínea","USD$68");
			}
			if(i==2)
				CommonUtils.showAlertTable(this,"Mts. por remodelar","280","Costo por m2","$750");
//				CommonUtils.showAlertDialog("", Attributes.HelpMessage.MODELFININVERSION, this, null);
			break;
		case R.id.btn_guard:
			
			DBAdapter dba = new DBAdapter(this);
//			String saveFile="";
			dba.open();
//			Cursor cursor =dba.getFileName();
//			if(cursor!= null){
//				cursor.moveToLast();
//			}
//			if(cursor.moveToLast()){
//				saveFile = cursor.getString(cursor.getColumnIndex(Attributes.Database.NOMBREDEARCHIVO));
//				Log.d(TAG, "database  last record is"+ saveFile);
//			}
//			if(saveFile.equals(pref.getHeading())){
				Log.d(TAG, "database  eqal");
				dba.updateRow(pref.getHeading(), pref.getTilte(), pref.getTema(), pref.getObjective(), pref.getDescriptionShort1(), pref.getDescriptionLarge1(), pref.getDescriptionShortAhorros1(), pref.getDescriptionLargeAhorros1(), pref.getDescriptionShortEgresos1(), pref.getDescriptionLargeEgresos1(), pref.getDescriptionShortCostos(), pref.getDescriptionLargeCostos(), pref.getDescriptionShortInversion(), pref.getDescriptionLargeInversion(), pref.getDescriptionShortBeneficios(), pref.getDescriptionLargeBeneficios(), pref.getDescriptionShortImpactos(), pref.getDescriptionLargeImpactos(), pref.getDescriptionShortRiesgos(), pref.getDescriptionLargeRiesgos(), pref.getIntroduction(), 
					pref.getAlcancesYLimit(),pref.getAlcancesYLimitCapacidad(), pref.getAlcancesYLimitHorarios(), pref.getAlcancesYLimitsCobertura(), pref.getAlcancesYLimitsComercial(), pref.getAlcancesYLimitsPersonal(), pref.getAlcancesYLimitsDemanda(), pref.getAlcancesYLimitsDuracion(), pref.getAlcancesYLimitsSegmen(), pref.getAlcancesYLimitsTechnologia(), pref.getAlcancesYLimitsOtro1(), pref.getAlcancesYLimitsOtro2(), pref.getAlcancesYLimitsOtro3(), 
					pref.getDependencia1(), pref.getDependencia2(), pref.getDependencia3(), pref.getDependencia4(), pref.getResultados1(), pref.getResultados2(), pref.getResultados3(), pref.getResultados4(), pref.getSupuestos1(), pref.getSupuestos2(), pref.getSupuestos3(), pref.getConclusion(), pref.getRecommendies(),pref.getSummary(),pref.getContingenciaDeslarga(),pref.getDependenciaDesLarga(),pref.getResultadosDesLarga(),pref.getSupuestosDescLarga(),pref.getCheckedElement());
				
//			}
			dba.close();				
			getValue(i);
			break;
			
		case R.id.backbtn51:
			finish();
			overridePendingTransition( R.drawable.pull_in_left ,  R.drawable.push_out_right );
			break;
		case R.id.homebtn51:
			final Dialog home_back_dlg = new Dialog(this);
			home_back_dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
			home_back_dlg.setContentView(R.layout.home_dialog);
			
			home_back_dlg.findViewById(R.id.home_btn_back).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					finish();
					if(j==2){
						
						((Activity) MenuActivity.menucontext).finish();
					}else{
						((Activity) ModeloFinancieroActivity.context).finish();
						((Activity) MenuActivity.menucontext).finish();
					}
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
//					if(j==2){
//						
//						((Activity) MenuActivity.menucontext).finish();
//					}else{
//						((Activity) ModeloFinancieroActivity.context).finish();
//						((Activity) MenuActivity.menucontext).finish();
//					}
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
		}
		
	}

	@Override
	protected void onPause() {
		getValue(i);
		super.onPause();
	}
	private void getValue(int x) {
		strVariable=etvariable1.getText().toString()+"~";
		strVariable=strVariable+etvariable2.getText().toString()+"~";
		strVariable=strVariable+etvariable3.getText().toString()+"~";
		strVariable=strVariable+etvariable4.getText().toString()+"~";
		strVariable=strVariable+etvariable5.getText().toString()+"~";
		strVariable=strVariable+etvariable6.getText().toString()+"~";
		strVariable=strVariable+etvariable7.getText().toString()+"~";
		strVariable=strVariable+etvariable8.getText().toString();
		Log.d(TAG, "str variable is "+strVariable);
		//spinner1.setSelection(position)
		strValue=etvalue1.getText().toString()+"~";
		strValue=strValue+etvalue2.getText().toString()+"~";
		strValue=strValue+etvalue3.getText().toString()+"~";
		strValue=strValue+etvalue4.getText().toString()+"~";
		strValue=strValue+etvalue5.getText().toString()+"~";
		strValue=strValue+etvalue6.getText().toString()+"~";
		strValue=strValue+etvalue7.getText().toString()+"~";
		strValue=strValue+etvalue8.getText().toString();
		Log.d(TAG, "str value is"+strValue);
		
		
		switch (x) {
		case 0:
				pref.setVariable(strVariable);
				pref.setValor(strValue);
			break;

		case 1:
			pref.setEgrossVariable(strVariable);
			pref.setEgrossValor(strValue);
		break;
		case 2:
			pref.setInversionVariable(strVariable);
			pref.setInversionValor(strValue);
			break;
		case 3:
			pref.setAhorrosVariable(strVariable);
			pref.setAhorrosValor(strValue);
		break;
		case 4:
			pref.setCostosVariable(strVariable);
			pref.setCostosValor(strValue);
		break;
		}
	
}

	private void setValue(int no) {
		String variabe,value;
		switch (no) {
		case 0:
			if(pref.getVariable()!= null){
				try{
				variabe = pref.getVariable().split("~")[0];
				etvariable1.setText(variabe);
				variabe = pref.getVariable().split("~")[1];
				etvariable2.setText(variabe);
				variabe = pref.getVariable().split("~")[2];
				etvariable3.setText(variabe);
				variabe = pref.getVariable().split("~")[3];
				etvariable4.setText(variabe);
				variabe = pref.getVariable().split("~")[4];
				etvariable5.setText(variabe);
				variabe = pref.getVariable().split("~")[5];
				etvariable6.setText(variabe);
				variabe = pref.getVariable().split("~")[6];
				etvariable7.setText(variabe);
				variabe = pref.getVariable().split("~")[7];
				etvariable8.setText(variabe);
				}catch(ArrayIndexOutOfBoundsException e){
					
				}
			}
			if(pref.getValor()!= null){
				try{
					value = pref.getValor().split("~")[0];
					etvalue1.setText(value);
					value = pref.getValor().split("~")[1];
					etvalue2.setText(value);
					value = pref.getValor().split("~")[2];
					etvalue3.setText(value);
					value = pref.getValor().split("~")[3];
					etvalue4.setText(value);
					value = pref.getValor().split("~")[4];
					etvalue5.setText(value);
					value = pref.getValor().split("~")[5];
					etvalue6.setText(value);
					value = pref.getValor().split("~")[6];
					etvalue7.setText(value);
					value = pref.getValor().split("~")[7];
					etvalue8.setText(value);
					
					
				}catch(ArrayIndexOutOfBoundsException e){
					
				}
			}
			break;

		case 1:
			if(pref.getEgrossVariable()!= null){
				try{
				variabe = pref.getEgrossVariable().split("~")[0];
				etvariable1.setText(variabe);
				variabe = pref.getEgrossVariable().split("~")[1];
				etvariable2.setText(variabe);
				variabe = pref.getEgrossVariable().split("~")[2];
				etvariable3.setText(variabe);
				variabe = pref.getEgrossVariable().split("~")[3];
				etvariable4.setText(variabe);
				variabe = pref.getEgrossVariable().split("~")[4];
				etvariable5.setText(variabe);
				variabe = pref.getEgrossVariable().split("~")[5];
				etvariable6.setText(variabe);
				variabe = pref.getEgrossVariable().split("~")[6];
				etvariable7.setText(variabe);
				variabe = pref.getEgrossVariable().split("~")[7];
				etvariable8.setText(variabe);
				}catch(ArrayIndexOutOfBoundsException e){
					
				}
			}
			if(pref.getEgrossValor()!= null){
				try{
					value = pref.getEgrossValor().split("~")[0];
					etvalue1.setText(value);
					value = pref.getEgrossValor().split("~")[1];
					etvalue2.setText(value);
					value = pref.getEgrossValor().split("~")[2];
					etvalue3.setText(value);
					value = pref.getEgrossValor().split("~")[3];
					etvalue4.setText(value);
					value = pref.getEgrossValor().split("~")[4];
					etvalue5.setText(value);
					value = pref.getEgrossValor().split("~")[5];
					etvalue6.setText(value);
					value = pref.getEgrossValor().split("~")[6];
					etvalue7.setText(value);
					value = pref.getEgrossValor().split("~")[7];
					etvalue8.setText(value);
					
				}catch(ArrayIndexOutOfBoundsException e){
					
				}
			}
			
			break;
		case 2:
			if(pref.getInversionVariable()!= null){
				try{
				variabe = pref.getInversionVariable().split("~")[0];
				etvariable1.setText(variabe);
				variabe = pref.getInversionVariable().split("~")[1];
				etvariable2.setText(variabe);
				variabe = pref.getInversionVariable().split("~")[2];
				etvariable3.setText(variabe);
				variabe = pref.getInversionVariable().split("~")[3];
				etvariable4.setText(variabe);
				variabe = pref.getInversionVariable().split("~")[4];
				etvariable5.setText(variabe);
				variabe = pref.getInversionVariable().split("~")[5];
				etvariable6.setText(variabe);
				variabe = pref.getInversionVariable().split("~")[6];
				etvariable7.setText(variabe);
				variabe = pref.getInversionVariable().split("~")[7];
				etvariable8.setText(variabe);
				}catch(ArrayIndexOutOfBoundsException e){
					
				}
			}
			if(pref.getInversionValor()!= null){
				try{
					value = pref.getInversionValor().split("~")[0];
					etvalue1.setText(value);
					value = pref.getInversionValor().split("~")[1];
					etvalue2.setText(value);
					value = pref.getInversionValor().split("~")[2];
					etvalue3.setText(value);
					value = pref.getInversionValor().split("~")[3];
					etvalue4.setText(value);
					value = pref.getInversionValor().split("~")[4];
					etvalue5.setText(value);
					value = pref.getInversionValor().split("~")[5];
					etvalue6.setText(value);
					value = pref.getInversionValor().split("~")[6];
					etvalue7.setText(value);
					value = pref.getInversionValor().split("~")[7];
					etvalue8.setText(value);
					
					
				}catch(ArrayIndexOutOfBoundsException e){
					
				}
			}
	
			break;
		case 3:
			if(pref.getAhorrosVariable()!= null){
				try{
					variabe = pref.getAhorrosVariable().split("~")[0];
					etvariable1.setText(variabe);
					variabe = pref.getAhorrosVariable().split("~")[1];
					etvariable2.setText(variabe);
					variabe = pref.getAhorrosVariable().split("~")[2];
					etvariable3.setText(variabe);
					variabe = pref.getAhorrosVariable().split("~")[3];
					etvariable4.setText(variabe);
					variabe = pref.getAhorrosVariable().split("~")[4];
					etvariable5.setText(variabe);
					variabe = pref.getAhorrosVariable().split("~")[5];
					etvariable6.setText(variabe);
					variabe = pref.getAhorrosVariable().split("~")[6];
					etvariable7.setText(variabe);
					variabe = pref.getAhorrosVariable().split("~")[7];
					etvariable8.setText(variabe);
				}catch(ArrayIndexOutOfBoundsException e){
					
				}
			}
			if(pref.getAhorrosValor()!= null){
				try{
					value = pref.getAhorrosValor().split("~")[0];
					etvalue1.setText(value);
					value = pref.getAhorrosValor().split("~")[1];
					etvalue2.setText(value);
					value = pref.getAhorrosValor().split("~")[2];
					etvalue3.setText(value);
					value = pref.getAhorrosValor().split("~")[3];
					etvalue4.setText(value);
					value = pref.getAhorrosValor().split("~")[4];
					etvalue5.setText(value);
					value = pref.getAhorrosValor().split("~")[5];
					etvalue6.setText(value);
					value = pref.getAhorrosValor().split("~")[6];
					etvalue7.setText(value);
					value = pref.getAhorrosValor().split("~")[7];
					etvalue8.setText(value);					
				}catch(ArrayIndexOutOfBoundsException e){
					
				}
			}
	
			break;
		case 4:
			if(pref.getCostosVariable()!= null){
				try{
				variabe = pref.getCostosVariable().split("~")[0];
				etvariable1.setText(variabe);
				variabe = pref.getCostosVariable().split("~")[1];
				etvariable2.setText(variabe);
				variabe = pref.getCostosVariable().split("~")[2];
				etvariable3.setText(variabe);
				variabe = pref.getCostosVariable().split("~")[3];
				etvariable4.setText(variabe);
				variabe = pref.getCostosVariable().split("~")[4];
				etvariable5.setText(variabe);
				variabe = pref.getCostosVariable().split("~")[5];
				etvariable6.setText(variabe);
				variabe = pref.getCostosVariable().split("~")[6];
				etvariable7.setText(variabe);
				variabe = pref.getCostosVariable().split("~")[7];
				etvariable8.setText(variabe);
				}catch(ArrayIndexOutOfBoundsException e){
					
				}
			}
			if(pref.getCostosValor()!= null){
				try{
					value = pref.getCostosValor().split("~")[0];
					etvalue1.setText(value);
					value = pref.getCostosValor().split("~")[1];
					etvalue2.setText(value);
					value = pref.getCostosValor().split("~")[2];
					etvalue3.setText(value);
					value = pref.getCostosValor().split("~")[3];
					etvalue4.setText(value);
					value = pref.getCostosValor().split("~")[4];
					etvalue5.setText(value);
					value = pref.getCostosValor().split("~")[5];
					etvalue6.setText(value);
					value = pref.getCostosValor().split("~")[6];
					etvalue7.setText(value);
					value = pref.getCostosValor().split("~")[7];
					etvalue8.setText(value);
					
				}catch(ArrayIndexOutOfBoundsException e){
					
				}
			}
	
			break;
		
		}
		
	}
}
