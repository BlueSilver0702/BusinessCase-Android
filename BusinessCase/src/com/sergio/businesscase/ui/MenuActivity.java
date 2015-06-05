package com.sergio.businesscase.ui;


import java.io.ObjectOutputStream.PutField;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
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
import com.sergio.businesscase.utils.PreferenceUtils;


public class MenuActivity extends Activity implements OnClickListener, OnItemClickListener{
ExpandableListView listView;

Button save,newFile,word,excel,help,openFile;
Intent intent;
PreferenceUtils pref;
ArrayList<String> filename,openfile;
ArrayList<Integer> fileimage;
DBAdapter dba;
Dialog dialog;
FrameLayout menus;
FragmentTransaction transaction;
Typeface fonts ;
TextView title;
public static Context menucontext;
int selectfile = -1;

ParentMenuFragment parentMenu = new ParentMenuFragment();

//String stropen;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		menucontext = this;
		init();
		//setActionBar();
	}

//	private void setActionBar() {
//		ActionBar actionBar= (ActionBar)findViewById(R.id.actionbar_Login);
//		
//		Intent showdialog=new Intent(this, ShowDialogActiviy.class);
//		Action esquemaAction=new IntentAction(this,showdialog,R.drawable.ic_action_new);
//		actionBar.addAction(esquemaAction);
//		
//		Intent intent= new Intent(this, SaveActivity.class);
//		Action save = new IntentAction(this,intent , R.drawable.ic_action_save);
//		actionBar.addAction(save);
//		
//		
//		Intent openfile= new Intent(this,OpenFile.class);
//		Action newFolder= new IntentAction(this, openfile, R.drawable.action_folder_icon);
//		actionBar.addAction(newFolder);
//		
//		Intent intentword=new Intent(this, WordFile.class);
//		Action mswordAction= new IntentAction(this, intentword, R.drawable.action_msword_icon);
//		actionBar.addAction(mswordAction);
//		
//		Intent intentexcel=new Intent(this,BusinCaseExcelFileActivity.class);
//		Action msexcelAction= new IntentAction(this, intentexcel, R.drawable.action_microsoftexcel_icon);
//		actionBar.addAction(msexcelAction);
//		
//		Intent intentHelp=new Intent(this, HelpActivity.class);
//		Action helpAction=new IntentAction(this, intentHelp, R.drawable.help);
//		actionBar.addAction(helpAction);
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
		setContentView(R.layout.menu_new_activity);
		
//		menus = (FrameLayout)findViewById(R.id.menu_frame);
		
		transaction = getFragmentManager().beginTransaction();
		transaction.replace(R.id.menu_frame, parentMenu);
//		transaction.addToBackStack("a");
		transaction.commit();
		fonts= Typeface.createFromAsset(this.getAssets(), "fonts/Calibri-bold.ttf");
		
		title = (TextView)findViewById(R.id.content_title);
		title.setTypeface(fonts);
		
		Button back = (Button)findViewById(R.id.back);
		back.setOnClickListener(this);
		Button home = (Button)findViewById(R.id.home);
		home.setOnClickListener(this);
//		listView=(ExpandableListView) findViewById(R.id.menuExp_listView);
		newFile=(Button)findViewById(R.id.new_test);
		save=(Button)findViewById(R.id.save_test);
		word=(Button)findViewById(R.id.word_test);
		excel=(Button)findViewById(R.id.excel_test);
		help=(Button)findViewById(R.id.help_test);
		openFile=(Button)findViewById(R.id.open_test);
//		
//		listView.setGroupIndicator(null);
//		listView.setClickable(true);
//		listView.setAdapter(new MenuAdapter(this));
//		
		newFile.setOnClickListener(this);
		save.setOnClickListener(this);
		word.setOnClickListener(this);
		excel.setOnClickListener(this);
		openFile.setOnClickListener(this);
		help.setOnClickListener(this);
	}

@Override
public void onClick(View v) {
	
	switch (v.getId()) {
	case R.id.new_test:
		newFile();
		break;

	case R.id.open_test:
		open();
//		intent= new Intent(this, OpenFile.class);
//		startActivity(intent);
		break;
		
	case R.id.save_test:
		saveData();
		break;
		
	case R.id.word_test:
		final Dialog dlg = new Dialog(MenuActivity.this);
		dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dlg.setContentView(R.layout.doc_save_confirm);
		
		dlg.findViewById(R.id.confirm_save).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View vi) {
				// TODO Auto-generated method stub
				dlg.dismiss();
				
				final Dialog dlg2 = new Dialog(MenuActivity.this);
				dlg2.requestWindowFeature(Window.FEATURE_NO_TITLE);
				dlg2.setContentView(R.layout.save_confirm);
				
				dlg2.findViewById(R.id.internal).setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						dlg2.dismiss();
						intent= new Intent(MenuActivity.this, WordFile.class);
						startActivity(intent);
					}
				});
				
				dlg2.findViewById(R.id.external).setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						dlg2.dismiss();
						
						Boolean isSDPresent = android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
						
						if(isSDPresent){
							intent= new Intent(MenuActivity.this, WordFile.class);
							startActivity(intent);
						}else{
							Toast.makeText(MenuActivity.this, "There is No SDCard!", Toast.LENGTH_LONG).show();
						}
					}
				});
				
				dlg2.findViewById(R.id.googledir).setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						dlg2.dismiss();
					}
				});
				
				dlg2.show();
				
			}
		});
		
		dlg.findViewById(R.id.confirm_send).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				intent = new Intent(MenuActivity.this,  WordFile.class);
				intent.putExtra("SendMail", 5);
				startActivity(intent);
				dlg.dismiss();
			}
		});
		dlg.show();
		break;
		
	case R.id.excel_test:
		final Dialog dlg3 = new Dialog(MenuActivity.this);
		dlg3.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dlg3.setContentView(R.layout.doc_save_confirm);
		
		dlg3.findViewById(R.id.confirm_save).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View vi) {
				// TODO Auto-generated method stub
				dlg3.dismiss();
				
				final Dialog dlg4 = new Dialog(MenuActivity.this);
				dlg4.requestWindowFeature(Window.FEATURE_NO_TITLE);
				dlg4.setContentView(R.layout.save_confirm);
				
				dlg4.findViewById(R.id.internal).setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						dlg4.dismiss();
						intent= new Intent(MenuActivity.this, BusinCaseExcelFileActivity.class);
						startActivity(intent);
					}
				});
				
				dlg4.findViewById(R.id.external).setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						dlg4.dismiss();
						
						Boolean isSDPresent = android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
						
						if(isSDPresent){
							intent= new Intent(MenuActivity.this, BusinCaseExcelFileActivity.class);
							startActivity(intent);
						}else{
							Toast.makeText(MenuActivity.this, "There is No SDCard!", Toast.LENGTH_LONG).show();
						}
					}
				});
				
				dlg4.findViewById(R.id.googledir).setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						dlg4.dismiss();
					}
				});
				
				dlg4.show();
				
			}
		});
		dlg3.findViewById(R.id.confirm_send).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dlg3.dismiss();
				intent = new Intent(MenuActivity.this,  BusinCaseExcelFileActivity.class);
				intent.putExtra("SendMail", 5);
				startActivity(intent);
				dlg3.dismiss();
			}
		});
		dlg3.show();
		
		break;
		
	case R.id.help_test:
		if(ParentMenuFragment.position == 9){
			intent= new Intent(MenuActivity.this, TitleDescription.class);
			intent.putExtra(Attributes.TITLETEXT, 9);
			this.startActivity(intent);
		}else{
			intent= new Intent(this, HelpActivity.class);
			startActivity(intent);
		}
		break;
		
	case R.id.back:
//		finish();
		if(ParentMenuFragment.position==-1){
			finish();	
		}else{
			getFragmentManager().popBackStack("b", FragmentManager.POP_BACK_STACK_INCLUSIVE);
			title.setText("Contendio");
			ParentMenuFragment.position=-1;
		}
		break;
		
	case R.id.home:
		
		final Dialog home_back_dlg = new Dialog(this);
		home_back_dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
		home_back_dlg.setContentView(R.layout.home_dialog);
		
		home_back_dlg.findViewById(R.id.home_btn_back).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		home_back_dlg.findViewById(R.id.home_back_cancel).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				home_back_dlg.dismiss();
			}
		});
		
		home_back_dlg.show();
//		AlertDialog.Builder alert = new AlertDialog.Builder(this);
//		
//		alert.setTitle("¿Estás seguro que deseas cerrar tu Business Case?");
//		
//		alert.setNeutralButton("Si", new DialogInterface.OnClickListener() {
//			
//			@Override
//			public void onClick(DialogInterface dialog, int which) {
//				finish();
//			}
//		});
//		alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
//			
//			@Override
//			public void onClick(DialogInterface dialog, int which) {
//				
//			}
//		});
//		alert.show();
	}
	
	
}

private void open() {
	dba=new DBAdapter(this);
	filename= new ArrayList<String>();
	openfile = new ArrayList<String>();
	pref=new PreferenceUtils(this);
	
	dialog= new Dialog(this, R.style.cust_dialog);
	dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
	//dialog.setCancelable(false);
	dialog.setContentView(R.layout.open_file_gridview);
	
	dialog.findViewById(R.id.daopenfile).setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			if(selectfile != -1){
				dba.open();
				dialog.dismiss();
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
				selectfile = -1;
				dba.close();
			}else{
				Toast.makeText(MenuActivity.this, "No Selected file", Toast.LENGTH_LONG).show();
			}
		}
	});
	
	dialog.findViewById(R.id.dadelfile).setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			dba.open();
			if(selectfile != -1){
				
				final Dialog dlg = new Dialog(MenuActivity.this);
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
				Toast.makeText(MenuActivity.this, "No Selected file", Toast.LENGTH_LONG).show();
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
		Toast.makeText(this, "No record exist", Toast.LENGTH_LONG).show();
		
	}
		
}

private void newFile() {
	pref= new PreferenceUtils(this);
//	dba = new DBAdapter(this);
	final Dialog dialog= new Dialog(this,R.style.cust_dialog);
	dialog.setContentView(R.layout.bcase_name);
	dialog.setCancelable(true);
	dialog.setTitle("Ingresa el nombre del archivo (B-Case)");
	final EditText notheArche=(EditText)dialog.findViewById(R.id.et_nothrarch);
	pref=new PreferenceUtils(this);
	Button ok=(Button)dialog.findViewById(R.id.btn_ok);
	dialog.show();
	
	ok.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			if(notheArche.getText().toString().trim().length()>=1){
				pref.clearSharedPref();
				dialog.dismiss();
				String str=notheArche.getText().toString();
				pref.setHeading(str);			
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
@SuppressWarnings("deprecation")
@SuppressLint("SimpleDateFormat")
private void saveData() {
	final PreferenceUtils pref= new PreferenceUtils(this);
	final DBAdapter dba= new DBAdapter(this);
	dba.open();
	
	final Dialog dialog = new Dialog(this);
	dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
	dialog.setContentView(R.layout.saveas_dlg);
	
	Button saveas = (Button)dialog.findViewById(R.id.saveas);
	Button cancel = (Button)dialog.findViewById(R.id.cancel_saveas);
	
	saveas.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			dialog.dismiss();
			
			final Dialog saveDlg = new Dialog(MenuActivity.this);
			saveDlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
			saveDlg.setContentView(R.layout.saveas_name);
			
			final EditText fileName = (EditText)saveDlg.findViewById(R.id.newfilename_dlg);
			Button yes = (Button)saveDlg.findViewById(R.id.saveasdlg_ok);
			
			yes.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Log.d("TAG", "Get file name"+fileName.getText().toString());
					pref.setHeading(fileName.getText().toString());
					dba.insert(pref.getHeading(), pref.getTilte(), pref.getTema(), pref.getObjective(), pref.getDescriptionShort1(), pref.getDescriptionLarge1(), pref.getDescriptionShortAhorros1(), pref.getDescriptionLargeAhorros1(), pref.getDescriptionShortEgresos1(), pref.getDescriptionLargeEgresos1(), pref.getDescriptionShortCostos(), pref.getDescriptionLargeCostos(), pref.getDescriptionShortInversion(), pref.getDescriptionLargeInversion(), pref.getDescriptionShortBeneficios(), pref.getDescriptionLargeBeneficios(), pref.getDescriptionShortImpactos(), pref.getDescriptionLargeImpactos(), pref.getDescriptionShortRiesgos(), pref.getDescriptionLargeRiesgos(), pref.getIntroduction(), 
							pref.getAlcancesYLimit(),pref.getAlcancesYLimitCapacidad(), pref.getAlcancesYLimitHorarios(), pref.getAlcancesYLimitsCobertura(), pref.getAlcancesYLimitsComercial(), pref.getAlcancesYLimitsPersonal(), pref.getAlcancesYLimitsDemanda(), pref.getAlcancesYLimitsDuracion(), pref.getAlcancesYLimitsSegmen(), pref.getAlcancesYLimitsTechnologia(), pref.getAlcancesYLimitsOtro1(), pref.getAlcancesYLimitsOtro2(), pref.getAlcancesYLimitsOtro3(), 
							pref.getDependencia1(), pref.getDependencia2(), pref.getDependencia3(), pref.getDependencia4(), pref.getResultados1(), pref.getResultados2(), pref.getResultados3(), pref.getResultados4(), pref.getSupuestos1(), pref.getSupuestos2(), pref.getSupuestos3(), pref.getConclusion(), pref.getRecommendies(),pref.getSummary(),pref.getContingenciaDeslarga(),pref.getDependenciaDesLarga(),pref.getResultadosDesLarga(),pref.getSupuestosDescLarga(),pref.getCheckedElement());
					Toast.makeText(MenuActivity.this, "record is saved sucessfully", Toast.LENGTH_LONG).show();
					
					saveDlg.dismiss();
				}
			});
			
			saveDlg.show();
//			final EditText fileName = new EditText(MenuActivity.this);
//			AlertDialog.Builder adb = new AlertDialog.Builder(MenuActivity.this);
//			adb.setTitle("New File name");
//			adb.setView(fileName);
//			adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//				
//				@Override
//				public void onClick(DialogInterface dialog, int which) {
//					Log.d("TAG", "Get file name"+fileName.getText().toString());
//					pref.setHeading(fileName.getText().toString());
//					dba.insert(pref.getHeading(), pref.getTilte(), pref.getTema(), pref.getObjective(), pref.getDescriptionShort1(), pref.getDescriptionLarge1(), pref.getDescriptionShortAhorros1(), pref.getDescriptionLargeAhorros1(), pref.getDescriptionShortEgresos1(), pref.getDescriptionLargeEgresos1(), pref.getDescriptionShortCostos(), pref.getDescriptionLargeCostos(), pref.getDescriptionShortInversion(), pref.getDescriptionLargeInversion(), pref.getDescriptionShortBeneficios(), pref.getDescriptionLargeBeneficios(), pref.getDescriptionShortImpactos(), pref.getDescriptionLargeImpactos(), pref.getDescriptionShortRiesgos(), pref.getDescriptionLargeRiesgos(), pref.getIntroduction(), 
//							pref.getAlcancesYLimit(),pref.getAlcancesYLimitCapacidad(), pref.getAlcancesYLimitHorarios(), pref.getAlcancesYLimitsCobertura(), pref.getAlcancesYLimitsComercial(), pref.getAlcancesYLimitsPersonal(), pref.getAlcancesYLimitsDemanda(), pref.getAlcancesYLimitsDuracion(), pref.getAlcancesYLimitsSegmen(), pref.getAlcancesYLimitsTechnologia(), pref.getAlcancesYLimitsOtro1(), pref.getAlcancesYLimitsOtro2(), pref.getAlcancesYLimitsOtro3(), 
//							pref.getDependencia1(), pref.getDependencia2(), pref.getDependencia3(), pref.getDependencia4(), pref.getResultados1(), pref.getResultados2(), pref.getResultados3(), pref.getResultados4(), pref.getSupuestos1(), pref.getSupuestos2(), pref.getSupuestos3(), pref.getConclusion(), pref.getRecommendies(),pref.getSummary(),pref.getContingenciaDeslarga(),pref.getDependenciaDesLarga(),pref.getResultadosDesLarga(),pref.getSupuestosDescLarga(),pref.getCheckedElement());
//					Toast.makeText(MenuActivity.this, "record is saved sucessfully", Toast.LENGTH_LONG).show();
//	
//					dba.close();					
//				}
//			});
//			adb.show();
		}
	});
	
	cancel.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			dialog.dismiss();
		}
	});
	
	dialog.show();
	
//	AlertDialog.Builder alert = new AlertDialog.Builder(this);
//	TextView txt = new TextView(this);
//	txt.setTextColor(Color.WHITE);
//	txt.setTextSize(18);
//	txt.setText("¿Deseas guardar este archivo con nombre distinto? ");
//	txt.setBackgroundColor(Color.rgb(0, 21, 50));
//	alert.setView(txt);
////	alert.setPositiveButton("Guardar como", new DialogInterface.OnClickListener() {
////		
////		@Override
////		public void onClick(DialogInterface dialog, int which) {
////			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
////			String timeStamp = dateFormat.format(new Date());
////			pref.setHeading(pref.getHeading()+timeStamp);
////			dba.insert(pref.getHeading(), pref.getTilte(), pref.getTema(), pref.getObjective(), pref.getDescriptionShort1(), pref.getDescriptionLarge1(), pref.getDescriptionShortAhorros1(), pref.getDescriptionLargeAhorros1(), pref.getDescriptionShortEgresos1(), pref.getDescriptionLargeEgresos1(), pref.getDescriptionShortCostos(), pref.getDescriptionLargeCostos(), pref.getDescriptionShortInversion(), pref.getDescriptionLargeInversion(), pref.getDescriptionShortBeneficios(), pref.getDescriptionLargeBeneficios(), pref.getDescriptionShortImpactos(), pref.getDescriptionLargeImpactos(), pref.getDescriptionShortRiesgos(), pref.getDescriptionLargeRiesgos(), pref.getIntroduction(), 
////					pref.getAlcancesYLimit(),pref.getAlcancesYLimitCapacidad(), pref.getAlcancesYLimitHorarios(), pref.getAlcancesYLimitsCobertura(), pref.getAlcancesYLimitsComercial(), pref.getAlcancesYLimitsPersonal(), pref.getAlcancesYLimitsDemanda(), pref.getAlcancesYLimitsDuracion(), pref.getAlcancesYLimitsSegmen(), pref.getAlcancesYLimitsTechnologia(), pref.getAlcancesYLimitsOtro1(), pref.getAlcancesYLimitsOtro2(), pref.getAlcancesYLimitsOtro3(), 
////					pref.getDependencia1(), pref.getDependencia2(), pref.getDependencia3(),pref.getDependencia4(), pref.getResultados1(), pref.getResultados2(), pref.getResultados3(), pref.getResultados4(), pref.getSupuestos1(), pref.getSupuestos2(), pref.getSupuestos3(), pref.getConclusion(), pref.getRecommendies(),pref.getSummary(),pref.getContingenciaDeslarga(),pref.getDependenciaDesLarga(),pref.getResultadosDesLarga(),pref.getSupuestosDescLarga(),pref.getCheckedElement());
////			Log.d("tag", "date and time is "+pref.getHeading());
////			Toast.makeText(MenuActivity.this, "record is already exist\n New file name is="+pref.getHeading(), Toast.LENGTH_LONG).show();
////			dba.close();
////
////		}
////	});
//	alert.setNeutralButton("Guardar como", new DialogInterface.OnClickListener() {
//		
//		@Override
//		public void onClick(DialogInterface dialog, int which) {
//			final EditText fileName = new EditText(MenuActivity.this);
//			AlertDialog.Builder adb = new AlertDialog.Builder(MenuActivity.this);
//			adb.setTitle("New File name");
//			adb.setView(fileName);
//			adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//				
//				@Override
//				public void onClick(DialogInterface dialog, int which) {
//					Log.d("TAG", "Get file name"+fileName.getText().toString());
//					pref.setHeading(fileName.getText().toString());
//					dba.insert(pref.getHeading(), pref.getTilte(), pref.getTema(), pref.getObjective(), pref.getDescriptionShort1(), pref.getDescriptionLarge1(), pref.getDescriptionShortAhorros1(), pref.getDescriptionLargeAhorros1(), pref.getDescriptionShortEgresos1(), pref.getDescriptionLargeEgresos1(), pref.getDescriptionShortCostos(), pref.getDescriptionLargeCostos(), pref.getDescriptionShortInversion(), pref.getDescriptionLargeInversion(), pref.getDescriptionShortBeneficios(), pref.getDescriptionLargeBeneficios(), pref.getDescriptionShortImpactos(), pref.getDescriptionLargeImpactos(), pref.getDescriptionShortRiesgos(), pref.getDescriptionLargeRiesgos(), pref.getIntroduction(), 
//							pref.getAlcancesYLimit(),pref.getAlcancesYLimitCapacidad(), pref.getAlcancesYLimitHorarios(), pref.getAlcancesYLimitsCobertura(), pref.getAlcancesYLimitsComercial(), pref.getAlcancesYLimitsPersonal(), pref.getAlcancesYLimitsDemanda(), pref.getAlcancesYLimitsDuracion(), pref.getAlcancesYLimitsSegmen(), pref.getAlcancesYLimitsTechnologia(), pref.getAlcancesYLimitsOtro1(), pref.getAlcancesYLimitsOtro2(), pref.getAlcancesYLimitsOtro3(), 
//							pref.getDependencia1(), pref.getDependencia2(), pref.getDependencia3(), pref.getDependencia4(), pref.getResultados1(), pref.getResultados2(), pref.getResultados3(), pref.getResultados4(), pref.getSupuestos1(), pref.getSupuestos2(), pref.getSupuestos3(), pref.getConclusion(), pref.getRecommendies(),pref.getSummary(),pref.getContingenciaDeslarga(),pref.getDependenciaDesLarga(),pref.getResultadosDesLarga(),pref.getSupuestosDescLarga(),pref.getCheckedElement());
//					Toast.makeText(MenuActivity.this, "record is saved sucessfully", Toast.LENGTH_LONG).show();
//	
//					dba.close();					
//				}
//			});
//			adb.show();
//			
////			Log.d("tag", "does not match ");
////			dba.insert(pref.getHeading(), pref.getTilte(), pref.getTema(), pref.getObjective(), pref.getDescriptionShort1(), pref.getDescriptionLarge1(), pref.getDescriptionShortAhorros1(), pref.getDescriptionLargeAhorros1(), pref.getDescriptionShortEgresos1(), pref.getDescriptionLargeEgresos1(), pref.getDescriptionShortCostos(), pref.getDescriptionLargeCostos(), pref.getDescriptionShortInversion(), pref.getDescriptionLargeInversion(), pref.getDescriptionShortBeneficios(), pref.getDescriptionLargeBeneficios(), pref.getDescriptionShortImpactos(), pref.getDescriptionLargeImpactos(), pref.getDescriptionShortRiesgos(), pref.getDescriptionLargeRiesgos(), pref.getIntroduction(), 
////					pref.getAlcancesYLimit(),pref.getAlcancesYLimitCapacidad(), pref.getAlcancesYLimitHorarios(), pref.getAlcancesYLimitsCobertura(), pref.getAlcancesYLimitsComercial(), pref.getAlcancesYLimitsPersonal(), pref.getAlcancesYLimitsDemanda(), pref.getAlcancesYLimitsDuracion(), pref.getAlcancesYLimitsSegmen(), pref.getAlcancesYLimitsTechnologia(), pref.getAlcancesYLimitsOtro1(), pref.getAlcancesYLimitsOtro2(), pref.getAlcancesYLimitsOtro3(), 
////					pref.getDependen	cia1(), pref.getDependencia2(), pref.getDependencia3(), pref.getDependencia4(), pref.getResultados1(), pref.getResultados2(), pref.getResultados3(), pref.getResultados4(), pref.getSupuestos1(), pref.getSupuestos2(), pref.getSupuestos3(), pref.getConclusion(), pref.getRecommendies());
////			Toast.makeText(MenuActivity.this, "record is saved sucessfully", Toast.LENGTH_LONG).show();
//
////			dba.close();
//
//			
//		}
//	});
//	alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
//		
//		@Override
//		public void onClick(DialogInterface dialog, int which) {
//			dba.close();
//			
//			
//		}
//	});
//	
//	AlertDialog a= alert.create();
//	a.show();
//	// set Custom button in alert dialog 
//	Button positive = a.getButton(DialogInterface.BUTTON_POSITIVE);
//	int sdk = android.os.Build.VERSION.SDK_INT;
//	if(positive!= null){
//		if(sdk< android.os.Build.VERSION_CODES.JELLY_BEAN){
//			positive.setBackgroundDrawable(getResources().getDrawable(R.drawable.greenbutton));
//		}else {
//			positive.setBackground(getResources().getDrawable(R.drawable.greenbutton));
//		}
//			
//	}
//	
//	Button newFile = a.getButton(DialogInterface.BUTTON_NEUTRAL);
//	if(newFile != null){
//		if(sdk< android.os.Build.VERSION_CODES.JELLY_BEAN){
//			newFile.setBackgroundDrawable(getResources().getDrawable(R.drawable.greenbutton));
//		}else {
//			newFile.setBackground(getResources().getDrawable(R.drawable.greenbutton));
//		}
//	}
//	
//	Button cancel = a.getButton(DialogInterface.BUTTON_NEGATIVE);
//	if(cancel != null){
//		if(sdk< android.os.Build.VERSION_CODES.JELLY_BEAN){
//			cancel.setBackgroundDrawable(getResources().getDrawable(R.drawable.greenbutton));
//		}else{
//			cancel.setBackground(getResources().getDrawable(R.drawable.greenbutton));
//		}
//	}
	
 }

@Override
public void onItemClick(AdapterView<?> arg0, View arg1, final int position, long arg3) {
	selectfile = position;
	//	dialog.dismiss();
//	String []dilogeArr = {"Open","Delete"};
//	final AlertDialog adb = new AlertDialog.Builder(MenuActivity.this).create();
//	LayoutInflater inflater = getLayoutInflater();
//	View convertView = (View)inflater.inflate(R.layout.inner_dialoge, null);
//	adb.setView(convertView);
//	ListView listInnerDialoge = (ListView)convertView.findViewById(R.id.lv_innerdilog);
//	listInnerDialoge.setAdapter(new DialogeListAdapter(this, 0, dilogeArr));
//	adb.show();
//	listInnerDialoge.setOnItemClickListener(new OnItemClickListener() {
//
//		@Override
//		public void onItemClick(AdapterView<?> arg0, View arg1, int pos,long arg3) {
//			dba.open();
//			if(pos==0){
//				dialog.dismiss();
//				adb.dismiss();
//				String str=filename.get(position);
//				ArrayList<String> filedata= new ArrayList<String>();
//				Log.d("TAG", "file name is "+str);
//				
//				filedata=dba.getOpenFile(str);
//				Log.d("TAG","filedata size"+filedata.size());
//				pref.setHeading(filedata.get(0));
//				pref.setTitle(filedata.get(1));
//				pref.setTema(filedata.get(2));
//				pref.setObjective(filedata.get(3));
//				pref.setDescriptionShort1(filedata.get(4));
//				pref.setDescriptionLarge1(filedata.get(5));
//				pref.setDescriptionShortAhorros1(filedata.get(6));
//				pref.setDescriptionLargeAhorros1(filedata.get(7));
//				pref.setDescriptionShortEgresos1(filedata.get(8));
//				pref.setDescriptionLargeEgresos1(filedata.get(9));
//				pref.setDescriptionShortCostos(filedata.get(10));
//				pref.setDescriptionLargeCostos(filedata.get(11));
//				pref.setDescriptionShortInversion(filedata.get(12));
//				pref.setDescriptionLargeInversion(filedata.get(13));
//				pref.setDescriptionShortBeneficios(filedata.get(14));
//				pref.setDescriptionLargeBeneficios(filedata.get(15));
//				pref.setDescriptionShortImpactos(filedata.get(16));
//				pref.setDescriptionLargeImpactos(filedata.get(17));
//				pref.setDescriptionShortRiesgos(filedata.get(18));
//				pref.setDescriptionLargeRiesgos(filedata.get(19));
//				pref.setIntroduction(filedata.get(20));
//				pref.setAlcancesYLimits(filedata.get(21));
//				pref.setAlcancesYLimitsCapcidad(filedata.get(22));
//				pref.setAlcancesYLimitsHorarios(filedata.get(23));
//				pref.setAlcancesYLimitsCobertura(filedata.get(24));
//				pref.setAlcancesYLimitsComercial(filedata.get(25));
//				pref.setAlcancesYLimitsPersonal(filedata.get(26));
//				pref.setAlcancesYLimitsDemanda(filedata.get(27));
//				pref.setAlcancesYLimitsDuracion(filedata.get(28));
//				pref.setAlcancesYLimitsSegmen(filedata.get(29));
//				pref.setAlcancesYLimitsTechnologia(filedata.get(30));
//				pref.setAlcancesYLimitsOtro1(filedata.get(31));
//				pref.setAlcancesYLimitsOtro2(filedata.get(32));
//				pref.setAlcancesYLimitsOtro3(filedata.get(33));
//				pref.setDependencia1(filedata.get(34));
//				pref.setDependencia2(filedata.get(35));
//				pref.setDependencia3(filedata.get(36));
//				pref.setDependencia4(filedata.get(37));
//				pref.setResultados1(filedata.get(38));
//				pref.setResultados2(filedata.get(39));
//				pref.setResultados3(filedata.get(40));
//				pref.setResultados4(filedata.get(41));
//				pref.setConclusion(filedata.get(45));
//				pref.setRecommendies(filedata.get(46));
//				pref.setContingenciaDesLarga(filedata.get(48));
//				pref.setDependenciaDesLarga(filedata.get(49));
//				pref.setResultadosDescLarga(filedata.get(50));
//				pref.setSupuestosDescLarga(filedata.get(51));
//				pref.setCheckedElement(filedata.get(52));
//				Log.d("TAG", "file data is "+filedata);
//				
//				dba.close();
//
//			}else{
//				dialog.dismiss();
//				adb.dismiss();
//				dba.deleteRecord(filename.get(position));
//				dba.close();
//			}
//			
//		}
//	});
	
}
	
}
