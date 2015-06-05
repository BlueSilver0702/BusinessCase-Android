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

public class IntroductionActivity extends Activity  implements OnClickListener{
	TextView introDesc;
	EditText introMatter;
	PreferenceUtils pref;
	ImageView help,helpdialoge;
	Button guarder;
	public static Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.introduction_activity);
		context = this;
		init();
//		setActionBar();
	}

//	private void setActionBar() {
//		
//		ActionBar actionBar= (ActionBar)findViewById(R.id.actionbar_intro);
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
//		intentHelp.putExtra(Attributes.TITLETEXT, 2);
//		Action helpAction=new IntentAction(this, intentHelp, R.drawable.help_white);
//		actionBar.addAction(helpAction);
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
		introDesc=(TextView)findViewById(R.id.tvintro_desc);
		help = (ImageView)findViewById(R.id.help3);
		helpdialoge = (ImageView)findViewById(R.id.viewhelp3);
		Typeface fonts = Typeface.createFromAsset(getAssets(), "fonts/Calibri.ttf");
		Typeface bold_fonts = Typeface.createFromAsset(getAssets(), "fonts/Calibri-bold.ttf");
		introDesc.setTypeface(bold_fonts);
		
		introDesc.setText("Introducción");
		guarder =(Button)findViewById(R.id.btn_save_intro);
		guarder.setTypeface(fonts);
		
		findViewById(R.id.backbtn3).setOnClickListener(this);
		findViewById(R.id.homebtn3).setOnClickListener(this);
		//introDesc.setText(Attributes.Description.INTRODUCIONDESC);
		introMatter=(EditText)findViewById(R.id.etintro_matter);
		//introMatter.setText(pref.getIntroduction());
		introMatter.setText(pref.getIntroduction());
		introMatter.setTypeface(fonts);
		
		helpdialoge.setOnClickListener(this);
		help.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intentHelp=new Intent(IntroductionActivity.this, TitleDescription.class);
				intentHelp.putExtra(Attributes.TITLETEXT, 2);
				intentHelp.putExtra("home_flag", 3);
				startActivity(intentHelp);
			}
		});
		guarder.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String matter=introMatter.getText().toString();
				pref.setIntroduction(matter);
//				pref.setTema(matter);

				DBAdapter dba = new DBAdapter(IntroductionActivity.this);
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
				
			}
		});
		
	}
	@Override
	protected void onPause() {

		String matter=introMatter.getText().toString();
		pref.setIntroduction(matter);
//		pref.setTema(matter);

		super.onPause();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.viewhelp3:
			CommonUtils.showAlertDialog("", Attributes.HelpMessage.INTRODCTION_HELP, this, null);
			
			break;
		case R.id.backbtn3:
			finish();
			overridePendingTransition( R.drawable.pull_in_left ,  R.drawable.push_out_right );
			break;
		case R.id.homebtn3:
			
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
			
			
		
		default:
			break;
		}
		
	}
	

	

}
