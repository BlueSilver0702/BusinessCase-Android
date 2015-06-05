package com.sergio.businesscase.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import android.R.integer;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources.Theme;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
//import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.apptentive.android.sdk.Apptentive;
import com.flurry.android.FlurryAgent;
import com.sergio.businesscase.R;
import com.sergio.businesscase.db.DBAdapter;
import com.sergio.businesscase.helper.Attributes;
import com.sergio.businesscase.helper.DialogeListAdapter;
import com.sergio.businesscase.helper.GridListAdapter;
import com.sergio.businesscase.utils.CommonUtils;
import com.sergio.businesscase.utils.PreferenceUtils;


public class BusinessCaseActivity extends Activity implements OnClickListener, OnItemClickListener{
	Intent intent;
	PreferenceUtils pref;
//	ImageView open,newFile,help;
	Button open, newfile, training, about,fAQ; 
	ArrayList<String> filename,openfile;
	ArrayList<Integer> fileimage;
	DBAdapter dba;
	Dialog dialog;
	public static Context startcontext;
	
	private int selectfile = -1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.startup_new);
		startcontext = this;
		init();
//		stopApp();
	}

	private void wellComeText() {
		CommonUtils.showAlertDialog("", Attributes.WELLCOME, this, null);		
	}
	
	private void stopApp(){
		Calendar c = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = formatter.format(c.getTime());
		
		String [] newdate = formattedDate.split("/");
		
		int day = Integer.parseInt(newdate[0]);
		int month = Integer.parseInt(newdate[1]);
		int year = Integer.parseInt(newdate[2]);
			
		if(year != 2015){
			finish();
		}else if(month != 2){
			finish();
		}else if(!(day>4 && day<10)){
			finish();
		}		
	}

	private void init() {
//		open = (ImageView)findViewById(R.id.imgview_open);
//		help = (ImageView)findViewById(R.id.imgview_helpsection);
//		newFile = (ImageView)findViewById(R.id.imgview_newFile);
		
		open = (Button)findViewById(R.id.openfile);
		newfile = (Button)findViewById(R.id.newfile);
		about = (Button)findViewById(R.id.about);
		training = (Button)findViewById(R.id.training);
		fAQ = (Button)findViewById(R.id.faq);
		
		
		dba=new DBAdapter(this);
//		open.setOnClickListener(this);
//		help.setOnClickListener(this);
//		newFile.setOnClickListener(this);

		open.setOnClickListener(this);
		newfile.setOnClickListener(this);
		about.setOnClickListener(this);
		training.setOnClickListener(this);
		fAQ.setOnClickListener(this);
		
	}
	private void newFile() {
		pref= new PreferenceUtils(this);
//		dba = new DBAdapter(this);
		 Typeface fonts= Typeface.createFromAsset(getAssets(), "fonts/Calibri.ttf");
		final Dialog dialog= new Dialog(this,R.style.cust_dialog);
		dialog.setContentView(R.layout.bcase_name);
//		dialog.setCancelable(false);
		
		
		dialog.setTitle("Ingresa el nombre del archivo (B-Case)");
		final EditText notheArche=(EditText)dialog.findViewById(R.id.et_nothrarch);
		notheArche.setTypeface(fonts);
		pref=new PreferenceUtils(this);
		Button ok=(Button)dialog.findViewById(R.id.btn_ok);
		ok.setTypeface(fonts);
		dialog.show();
		
		ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if(notheArche.getText().toString().trim().length()>=1){
					
					pref.clearSharedPref();
				dialog.dismiss();
				intent= new Intent(BusinessCaseActivity.this, MenuActivity.class);
				startActivity(intent);
				String str=notheArche.getText().toString();
				pref.setHeading(str);
				dba.open();
				dba.insert(pref.getHeading(), pref.getTilte(), pref.getTema(), pref.getObjective(), pref.getDescriptionShort1(), pref.getDescriptionLarge1(), pref.getDescriptionShortAhorros1(), pref.getDescriptionLargeAhorros1(), pref.getDescriptionShortEgresos1(), pref.getDescriptionLargeEgresos1(), pref.getDescriptionShortCostos(), pref.getDescriptionLargeCostos(), pref.getDescriptionShortInversion(), pref.getDescriptionLargeInversion(), pref.getDescriptionShortBeneficios(), pref.getDescriptionLargeBeneficios(), pref.getDescriptionShortImpactos(), pref.getDescriptionLargeImpactos(), pref.getDescriptionShortRiesgos(), pref.getDescriptionLargeRiesgos(), pref.getIntroduction(), 
						pref.getAlcancesYLimit(),pref.getAlcancesYLimitCapacidad(), pref.getAlcancesYLimitHorarios(), pref.getAlcancesYLimitsCobertura(), pref.getAlcancesYLimitsComercial(), pref.getAlcancesYLimitsPersonal(), pref.getAlcancesYLimitsDemanda(), pref.getAlcancesYLimitsDuracion(), pref.getAlcancesYLimitsSegmen(), pref.getAlcancesYLimitsTechnologia(), pref.getAlcancesYLimitsOtro1(), pref.getAlcancesYLimitsOtro2(), pref.getAlcancesYLimitsOtro3(), 
						pref.getDependencia1(), pref.getDependencia2(), pref.getDependencia3(), pref.getDependencia4(), pref.getResultados1(), pref.getResultados2(), pref.getResultados3(), pref.getResultados4(), pref.getSupuestos1(), pref.getSupuestos2(), pref.getSupuestos3(), pref.getConclusion(), pref.getRecommendies(),pref.getSummary(),pref.getContingenciaDeslarga(),pref.getDependenciaDesLarga(),pref.getResultadosDesLarga(),pref.getSupuestosDescLarga(),pref.getCheckedElement());
				dba.close();

				
			}else {
				notheArche.setError("Enter the file name");
				notheArche.addTextChangedListener(new TextWatcher() {
					
					@Override
					public void onTextChanged(CharSequence s, int start, int before, int count) {
						
						
					}
					
					@Override
					public void beforeTextChanged(CharSequence s, int start, int count,
							int after) {
						
						
					}
					
					@Override
					public void afterTextChanged(Editable s) {
						
						notheArche.setError(null);
					}
				});
				
			}	
			}
		});
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
	
	
//
//	@Override
//	public void onClick(View v) {
//		switch (v.getId()) {
//		case R.id.imgview_open:
//			open();
//			break;
//
//		case R.id.imgview_helpsection:
//			wellComeText();
//			break;
//			
//		case R.id.imgview_newFile:
//			newFile();
//			
//			break;
//		}
//		
//	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.openfile:
			open();
			break;

		case R.id.about:
			wellComeText();
			break;
			
		case R.id.newfile:
			newFile();
			break;
		case R.id.training:
			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.turnkeyhydraulics.co.za/hydraulic-services/"));
			startActivity(browserIntent);
			break;
		case R.id.faq:
			Intent faq_Intent = new Intent(BusinessCaseActivity.this, FAQActivity.class);
			startActivity(faq_Intent);
			break;
		}
		
	}

	private void open() {
		
		filename= new ArrayList<String>();
		openfile = new ArrayList<String>();
		pref=new PreferenceUtils(this);
		
		dialog= new Dialog(this, R.style.cust_dialog);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		//dialog.setCancelable(false);
		//dialog.setTitle("Abrir archivo");
		dialog.setContentView(R.layout.open_file_gridview);
		
//		TextView title = (TextView)findViewById(R.id.opentadatitle);
		Button open = (Button)dialog.findViewById(R.id.daopenfile);
		Button delete = (Button)dialog.findViewById(R.id.dadelfile);
		
		open.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View vi) {
				if(selectfile != -1){
					dba.open();
					dialog.dismiss();
	//				adb.dismiss();
					String str=filename.get(selectfile);
					ArrayList<String> filedata= new ArrayList<String>();
					Log.d("TAG", "file name is "+str);
					
					filedata=dba.getOpenFile(str);
					Log.d("TAG","filedata size"+filedata.size());
					pref.setHeading(filedata.get(0));
					pref.setTitle(filedata.get(1));
					pref.setTema(filedata.get(2));
					pref.setObjective(filedata.get(3));
					pref.setDescriptionShort1(filedata.get(4));
					pref.setDescriptionLarge1(filedata.get(5));
					pref.setDescriptionShortAhorros1(filedata.get(6));
					pref.setDescriptionLargeAhorros1(filedata.get(7));
					pref.setDescriptionShortEgresos1(filedata.get(8));
					pref.setDescriptionLargeEgresos1(filedata.get(9));
					pref.setDescriptionShortCostos(filedata.get(10));
					pref.setDescriptionLargeCostos(filedata.get(11));
					pref.setDescriptionShortInversion(filedata.get(12));
					pref.setDescriptionLargeInversion(filedata.get(13));
					pref.setDescriptionShortBeneficios(filedata.get(14));
					pref.setDescriptionLargeBeneficios(filedata.get(15));
					pref.setDescriptionShortImpactos(filedata.get(16));
					pref.setDescriptionLargeImpactos(filedata.get(17));
					pref.setDescriptionShortRiesgos(filedata.get(18));
					pref.setDescriptionLargeRiesgos(filedata.get(19));
					pref.setIntroduction(filedata.get(20));
					pref.setAlcancesYLimits(filedata.get(21));
					pref.setAlcancesYLimitsCapcidad(filedata.get(22));
					pref.setAlcancesYLimitsHorarios(filedata.get(23));
					pref.setAlcancesYLimitsCobertura(filedata.get(24));
					pref.setAlcancesYLimitsComercial(filedata.get(25));
					pref.setAlcancesYLimitsPersonal(filedata.get(26));
					pref.setAlcancesYLimitsDemanda(filedata.get(27));
					pref.setAlcancesYLimitsDuracion(filedata.get(28));
					pref.setAlcancesYLimitsSegmen(filedata.get(29));
					pref.setAlcancesYLimitsTechnologia(filedata.get(30));
					pref.setAlcancesYLimitsOtro1(filedata.get(31));
					pref.setAlcancesYLimitsOtro2(filedata.get(32));
					pref.setAlcancesYLimitsOtro3(filedata.get(33));
					pref.setDependencia1(filedata.get(34));
					pref.setDependencia2(filedata.get(35));
					pref.setDependencia3(filedata.get(36));
					pref.setDependencia4(filedata.get(37));
					pref.setResultados1(filedata.get(38));
					pref.setResultados2(filedata.get(39));
					pref.setResultados3(filedata.get(40));
					pref.setResultados4(filedata.get(41));
					pref.setConclusion(filedata.get(45));
					pref.setRecommendies(filedata.get(46));
					pref.setContingenciaDesLarga(filedata.get(48));
					pref.setDependenciaDesLarga(filedata.get(49));
					pref.setResultadosDescLarga(filedata.get(50));
					pref.setSupuestosDescLarga(filedata.get(51));
					pref.setCheckedElement(filedata.get(52));
					Log.d("TAG", "file data is "+filedata);
					
					dba.close();
					Intent intent=new Intent(BusinessCaseActivity.this, MenuActivity.class);
					startActivity(intent);
					selectfile = -1;
				}else{
					Toast.makeText(BusinessCaseActivity.this, "No Selected file", Toast.LENGTH_LONG).show();
				}
			}
		});
		
		delete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View vi) {
				dba.open();
				if(selectfile != -1){
					
					final Dialog dlg = new Dialog(BusinessCaseActivity.this);
					dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
					
					dlg.setContentView(R.layout.delet_confirm);
					
					dlg.findViewById(R.id.confirm_y).setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View v) {
							dialog.dismiss();
							dlg.dismiss();
							dba.deleteRecord(filename.get(selectfile));
							dba.close();
							selectfile = -1;
						}
					});
					
					dlg.findViewById(R.id.confilrm_n).setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							dialog.dismiss();
							dlg.dismiss();
							dba.close();
							selectfile = -1;
						}
					});
					
					dlg.show();
					
				}else{
					Toast.makeText(BusinessCaseActivity.this, "No Selected file", Toast.LENGTH_LONG).show();
				}
			}
		});
		
		GridView gridview=(GridView)dialog.findViewById(R.id.gridView1);
		dba.open();
		Cursor cursor=dba.getFileName();
		if(cursor!=null){
			cursor.moveToFirst();
		}
		if(cursor.moveToFirst()){
			do{
				filename.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.NOMBREDEARCHIVO)));
				Log.d("TAG", "file name list is"+filename.size());
			}while(cursor.moveToNext());
		}
		cursor.close();
		dba.close();
		
		
		GridListAdapter adapter= new GridListAdapter(this, 0, filename);
		gridview.setAdapter(adapter);
		if(filename.size()>0){
			dialog.show();
			gridview.setOnItemClickListener(this);
		}else{
			//finish();
			final Dialog dlg = new Dialog(BusinessCaseActivity.this);
			dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
			
			dlg.setContentView(R.layout.empty_dialog);
			dlg.show();
			
			Thread deply = new Thread(){
				@Override
				public void run(){
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						
					}finally{
						dlg.dismiss();
					}
				}
			};
			deply.start();
//			Toast.makeText(this, "No record exist", Toast.LENGTH_LONG).show();
		}
		

		
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View view, final int position, long arg3) {
		
		selectfile = position;
		
	}
	
}
