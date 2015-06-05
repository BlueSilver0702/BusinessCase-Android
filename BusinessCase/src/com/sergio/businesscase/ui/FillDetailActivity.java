package com.sergio.businesscase.ui;

import android.R.bool;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.apptentive.android.sdk.Apptentive;
import com.apptentive.android.sdk.ApptentiveActivity;
import com.apptentive.android.sdk.util.Constants;
import com.flurry.android.FlurryAgent;
import com.sergio.businesscase.R;
import com.sergio.businesscase.db.DBAdapter;
import com.sergio.businesscase.helper.Attributes;
import com.sergio.businesscase.utils.CommonUtils;
import com.sergio.businesscase.utils.PreferenceUtils;

public class FillDetailActivity extends ApptentiveActivity implements OnClickListener{
	private static final String TAG = "FillDetailActivity";
	Intent intent;
	int i,btnId=-1,riesgos,count=0;
	int help=1;
	int value;
	ImageView helpBtn,imgHelp,imgbtn_help;
	Button guarder;
	Button add,delete;
//	ImageButton imgHelp;
	EditText descCort1,descLarga1,descCort2,descLarga2,descCort3,descLarga3,descCort4,descLarga4;
	TextView tvdescCort1,tvdescLarga1, tvdescCort2,tvdescLarga2, tvdescCort3,tvdescLarga3, tvdescCort4,tvdescLarga4;
	String strDescCorta,strDescLarga;
	PreferenceUtils pref;
	String strRow[];
	public static Context contex;
	TextView title;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fill_details);
		contex = this;
		intent=getIntent();
		i=intent.getIntExtra(Attributes.POSITION, 0);
		Log.d(TAG, "i=="+i);
		btnId=intent.getIntExtra("id", 0);
		riesgos=intent.getIntExtra(Attributes.RIESGOS, 0);
		pref = new PreferenceUtils(this);
		
		init();
//		setActioBar();
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
	
//	@Override
//	public void onWindowFocusChanged(boolean hasFocus) {
//	    super.onWindowFocusChanged(hasFocus);
//	    if (hasFocus) {
//	        // Engage a code point called "init".
//g
//	    	boolean shown = Apptentive.engage(this, "init");
//	        String s = "dfdf";
//	    }
//	}

//	private void setActioBar() {
//		
//		ActionBar actionBar= (ActionBar)findViewById(R.id.actionbar_filldetail);
//	
//		Intent intentHelp=new Intent(this, TitleDescription.class);
//		intentHelp.putExtra(Attributes.LABEL2, i);
//		intentHelp.putExtra(Attributes.TITLETEXT, help);
//		Action helpAction=new IntentAction(this, intentHelp, R.drawable.help_white);
//		actionBar.addAction(helpAction);
//	
//	}

	private void init() {

		Typeface fonts = Typeface.createFromAsset(getAssets(), "fonts/Calibri.ttf");
		Typeface font_Bold = Typeface.createFromAsset(getAssets(), "fonts/Calibri-bold.ttf");
		title =(TextView)findViewById(R.id.lv_title);
		title.setTypeface(font_Bold);
		helpBtn= (ImageView)findViewById(R.id.imageView1);
		helpBtn.setVisibility(View.GONE);
		
		imgbtn_help = (ImageView)findViewById(R.id.imgbtn_help);
		
		findViewById(R.id.backbtn21).setOnClickListener(this);
		findViewById(R.id.homebtn21).setOnClickListener(this);
		
		tvdescCort1 = (TextView)findViewById(R.id.tv_descCorta1);
		tvdescCort1.setTypeface(fonts);
		descCort1 = (EditText)findViewById(R.id.descCort1);
		descCort1.setTypeface(fonts);
		
		tvdescLarga1 = (TextView)findViewById(R.id.tv_descLarga1);
		tvdescLarga1.setTypeface(fonts);
		descLarga1 = (EditText)findViewById(R.id.descLarga1);
		descLarga1.setTypeface(fonts);
		
		tvdescCort2 = (TextView)findViewById(R.id.tv_descCorta2);
		tvdescCort2.setTypeface(fonts);
		descCort2 = (EditText)findViewById(R.id.descCort2);
		descCort2.setTypeface(fonts);
		
		tvdescLarga2 = (TextView)findViewById(R.id.tv_descLarga2);
		tvdescLarga2.setTypeface(fonts);
		descLarga2 = (EditText)findViewById(R.id.descLarga2);
		descLarga2.setTypeface(fonts);
		
		tvdescCort3 = (TextView)findViewById(R.id.tv_descCorta3);
		tvdescCort3.setTypeface(fonts);
		descCort3 = (EditText)findViewById(R.id.descCort3);
		descCort3.setTypeface(fonts);
		
		tvdescLarga3 = (TextView)findViewById(R.id.tv_descLarga3);
		tvdescLarga2.setTypeface(fonts);
		descLarga3 = (EditText)findViewById(R.id.descLarga3);
		descLarga3.setTypeface(fonts);
		
		tvdescCort4 = (TextView)findViewById(R.id.tv_descCorta4);
		tvdescCort4.setTypeface(fonts);
		
		descCort4 = (EditText)findViewById(R.id.descCort4);
		descCort4.setTypeface(fonts);
		
		tvdescLarga4 = (TextView)findViewById(R.id.tv_descLarga4);
		tvdescLarga4.setTypeface(fonts);
		descLarga4 = (EditText)findViewById(R.id.descLarga4);
		descLarga4.setTypeface(fonts);
		
		guarder=(Button)findViewById(R.id.button_guarder);
		guarder.setTypeface(fonts);
		
		CommonUtils.setTextWatcher(descCort1);
		CommonUtils.setTextWatcher(descCort2);
		CommonUtils.setTextWatcher(descCort3);
		CommonUtils.setTextWatcher(descCort4);
		CommonUtils.setTextWatcher(descLarga1);
		CommonUtils.setTextWatcher(descLarga2);
		CommonUtils.setTextWatcher(descLarga3);
		CommonUtils.setTextWatcher(descLarga4);

	
		imgHelp=(ImageView)findViewById(R.id.imgbtn_filldetail);
		add=(Button)findViewById(R.id.btn_add);
	
		delete=(Button)findViewById(R.id.btn_delete);
	
		helpBtn.setOnClickListener(this);
		add.setOnClickListener(this);
		delete.setOnClickListener(this);
		guarder.setOnClickListener(this);
		imgHelp.setOnClickListener(this);
		imgbtn_help.setOnClickListener(this);
		if(riesgos==3){
			help=3;
			title.setText("Riesgos");
			value=7;
			getRowVisible(value);
		} else{
			if(i==2){
				title.setText("Inversión");
				value=4;
				getRowVisible(value);
				
			}else{
				
			switch (btnId) {
			
			case 0:
				if(i==0){
					title.setText("Beneficios Financieros \n           / Ingresos");
					imgHelp.setVisibility(View.VISIBLE);
					value=0;
					getRowVisible(value);
				
					
				}	
				else if(i==1){
					imgHelp.setVisibility(View.VISIBLE);
					title.setText("Impactos Negativos\n          / Gastos");
					value=2;
					getRowVisible(value);
					
				}	
				else if(i==3){
					title.setText("   Otros Aspectos No   \nFinancieros / Beneficios");
					value=5;
					getRowVisible(value);
				}
							
				break;
	
			case 1:
				if(i==0){
					title.setText("Beneficios Financieros \n           / Ahorros");
					value=1;
					help= 999;
					getRowVisible(value);
					
				}else if(i==1){
					help= 99;
					title.setText("Impactos Negativos\n          / Costos");
					value=3;
					getRowVisible(value);
					
				}else if(i==3){
					help= 998;
					title.setText("    Otros Aspectos /   \n Impactos Negativos");
					value=6;
					getRowVisible(value);
				}
				break;
				
			}
		}
	}
}
//	private void setTextWatcher(final EditText textWatch){
//		textWatch.addTextChangedListener(new TextWatcher() {
//			
//			@Override
//			public void onTextChanged(CharSequence s, int start, int before, int count) {
//				String textLength =s.toString();
//				String noOfWords[] = s.toString().split(" ");
//			
//				if (textLength.length()>70 || noOfWords.length>12) {
//					setScroller(textWatch);
//					
//				}
//				
//			}
//			
//			@Override
//			public void beforeTextChanged(CharSequence s, int start, int count,int after) {
//						
//			}
//			
//			@Override
//			public void afterTextChanged(Editable s) {
//							
//			}
//		});
//	}
//	private void setScroller(EditText editText)
//	{
//editText.setOnTouchListener(new OnTouchListener() {
//			
//			@Override
//			public boolean onTouch(View v, MotionEvent event) {
//				
//                    v.getParent().requestDisallowInterceptTouchEvent(true);
//                    switch (event.getAction() & MotionEvent.ACTION_MASK) {
//                    case MotionEvent.ACTION_UP:
//                        v.getParent().requestDisallowInterceptTouchEvent(false);
//                        break;
//                    }
//				
//			
//				return false;
//			}
//		});
//	}

	
	private void getRowVisible(int value2) {
		switch (value2) {
		case 0:
			
			if(pref.getDescriptionLarge1()!=null || pref.getDescriptionShort1()!= null){
				if(pref.getDescriptionLarge1()!=null)
					strRow= pref.getDescriptionLarge1().split("~");
				if(strRow==null||strRow.length==0)
					strRow = pref.getDescriptionShort1().split("~");
				displayVisibleRow();
			}
			break;

		case 1:
			if(pref.getDescriptionLargeAhorros1()!=null || pref.getDescriptionShortAhorros1()!= null){
				if(pref.getDescriptionLargeAhorros1()!=null)
					strRow= pref.getDescriptionLargeAhorros1().split("~");
				if(strRow==null||strRow.length==0)
					strRow = pref.getDescriptionShortAhorros1().split("~");
				displayVisibleRow();
			}
			break;
		case 2:
			if(pref.getDescriptionLargeEgresos1()!=null || pref.getDescriptionShortEgresos1()!= null){
				if(pref.getDescriptionLargeEgresos1()!=null)
					strRow= pref.getDescriptionLargeEgresos1().split("~");
				if(strRow==null||strRow.length==0)
					strRow = pref.getDescriptionShortEgresos1().split("~");
				displayVisibleRow();
			}
			break;
		case 3:
			if(pref.getDescriptionLargeCostos()!=null || pref.getDescriptionShortCostos()!= null){
				if(pref.getDescriptionLargeCostos()!=null)
					strRow= pref.getDescriptionLargeCostos().split("~");
				if(strRow==null||strRow.length==0)
					strRow =  pref.getDescriptionShortCostos().split("~");
				displayVisibleRow();
			}
			break;
		case 4:
			if(pref.getDescriptionLargeInversion()!=null || pref.getDescriptionShortInversion()!= null){
				if(pref.getDescriptionLargeInversion()!= null)
					strRow= pref.getDescriptionLargeInversion().split("~");
				if(strRow==null||strRow.length==0)
					strRow = pref.getDescriptionShortInversion().split("~");
				displayVisibleRow();
			}
			break;
		case 5:
			if(pref.getDescriptionLargeBeneficios()!=null || pref.getDescriptionShortBeneficios()!= null){
				if(pref.getDescriptionLargeBeneficios()!= null)
					strRow= pref.getDescriptionLargeBeneficios().split("~");
				if(strRow==null||strRow.length==0)
					strRow =pref.getDescriptionShortBeneficios().split("~");
				displayVisibleRow();
			}
			break;
		case 6:
			if(pref.getDescriptionLargeImpactos()!=null || pref.getDescriptionShortImpactos()!= null){
				if(pref.getDescriptionLargeImpactos()!=null)
					strRow= pref.getDescriptionLargeImpactos().split("~");
				if(strRow==null||strRow.length==0)
					strRow= pref.getDescriptionShortImpactos().split("~");
				displayVisibleRow();
			}
			break;
		case 7:
			if(pref.getDescriptionLargeRiesgos()!=null || pref.getDescriptionShortRiesgos()!= null){
				if(pref.getDescriptionLargeRiesgos()!=null)
					strRow= pref.getDescriptionLargeRiesgos().split("~");
				if(strRow==null||strRow.length==0)
					strRow = pref.getDescriptionShortRiesgos().split("~");
				displayVisibleRow();
			}
			break;
			
		}
		
		
	}

	private void displayVisibleRow() {
		for(int j=0;j<strRow.length;j++){
			
			if(j==0){
				helpBtn.setVisibility(View.VISIBLE);
				tvdescCort1.setVisibility(View.VISIBLE);
				tvdescLarga1.setVisibility(View.VISIBLE);
				descCort1.setVisibility(View.VISIBLE);
				descLarga1.setVisibility(View.VISIBLE);
//				setPrefValue(value);
				count=1;
			}
			if(j==1){
				tvdescCort2.setVisibility(View.VISIBLE);
				tvdescLarga2.setVisibility(View.VISIBLE);
				descCort2.setVisibility(View.VISIBLE);
				descLarga2.setVisibility(View.VISIBLE);
//				setPrefValue(value);
				count=2;
			}
			if(j==2){
				tvdescCort3.setVisibility(View.VISIBLE);
				tvdescLarga3.setVisibility(View.VISIBLE);
				descCort3.setVisibility(View.VISIBLE);
				descLarga3.setVisibility(View.VISIBLE);
//				setPrefValue(value);
				count=3;
			}
			if(j==3){
				tvdescCort4.setVisibility(View.VISIBLE);
				tvdescLarga4.setVisibility(View.VISIBLE);
				descCort4.setVisibility(View.VISIBLE);
				descLarga4.setVisibility(View.VISIBLE);
				count=4;
			}
			
			setPrefValue(value);
			
		}
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_add:
			
			if(count==3){
				tvdescCort4.setVisibility(View.VISIBLE);
				tvdescLarga4.setVisibility(View.VISIBLE);
				descCort4.setVisibility(View.VISIBLE);
				descLarga4.setVisibility(View.VISIBLE);
				count=4;
				descCort4.requestFocus();
				setPrefValue(value);
			}
			if(count==2){
				tvdescCort3.setVisibility(View.VISIBLE);
				tvdescLarga3.setVisibility(View.VISIBLE);
				descCort3.setVisibility(View.VISIBLE);
				descLarga3.setVisibility(View.VISIBLE);
				descCort3.requestFocus();
				count=3;
				setPrefValue(value);
			}
			if(count==1){
				tvdescCort2.setVisibility(View.VISIBLE);
				tvdescLarga2.setVisibility(View.VISIBLE);
				descCort2.setVisibility(View.VISIBLE);
				descLarga2.setVisibility(View.VISIBLE);
				descCort2.requestFocus();
				count=2;
				setPrefValue(value);
			}
			if(count==0){
				helpBtn.setVisibility(View.VISIBLE);
				tvdescCort1.setVisibility(View.VISIBLE);
				tvdescLarga1.setVisibility(View.VISIBLE);
				descCort1.setVisibility(View.VISIBLE);
				descLarga1.setVisibility(View.VISIBLE);
				count=1;
				setPrefValue(value);
			}
		
				
			break;

		case R.id.btn_delete:
			if(count==1){
				helpBtn.setVisibility(View.INVISIBLE);
				tvdescCort1.setVisibility(View.GONE);
				tvdescLarga1.setVisibility(View.GONE);
				descCort1.setVisibility(View.GONE);
				descLarga1.setVisibility(View.GONE);
				count=0;
			}
			if(count==2){
				tvdescCort2.setVisibility(View.GONE);
				tvdescLarga2.setVisibility(View.GONE);
				descCort2.setVisibility(View.GONE);
				descLarga2.setVisibility(View.GONE);
				count=1;
			}
			if(count==3){
				tvdescCort3.setVisibility(View.GONE);
				tvdescLarga3.setVisibility(View.GONE);
				descCort3.setVisibility(View.GONE);
				descLarga3.setVisibility(View.GONE);
				count=2;
			}
			if(count==4){
				tvdescCort4.setVisibility(View.GONE);
				tvdescLarga4.setVisibility(View.GONE);
				descCort4.setVisibility(View.GONE);
				descLarga4.setVisibility(View.GONE);
				count=3;
			}
			 
			
			
			break;
			
		case R.id.button_guarder:
			
			saveInPrefrerenceva(value);
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
//				Log.d(TAG, "database eqal");
				dba.updateRow(pref.getHeading(), pref.getTilte(), pref.getTema(), pref.getObjective(), pref.getDescriptionShort1(), pref.getDescriptionLarge1(), pref.getDescriptionShortAhorros1(), pref.getDescriptionLargeAhorros1(), pref.getDescriptionShortEgresos1(), pref.getDescriptionLargeEgresos1(), pref.getDescriptionShortCostos(), pref.getDescriptionLargeCostos(), pref.getDescriptionShortInversion(), pref.getDescriptionLargeInversion(), pref.getDescriptionShortBeneficios(), pref.getDescriptionLargeBeneficios(), pref.getDescriptionShortImpactos(), pref.getDescriptionLargeImpactos(), pref.getDescriptionShortRiesgos(), pref.getDescriptionLargeRiesgos(), pref.getIntroduction(), 
					pref.getAlcancesYLimit(),pref.getAlcancesYLimitCapacidad(), pref.getAlcancesYLimitHorarios(), pref.getAlcancesYLimitsCobertura(), pref.getAlcancesYLimitsComercial(), pref.getAlcancesYLimitsPersonal(), pref.getAlcancesYLimitsDemanda(), pref.getAlcancesYLimitsDuracion(), pref.getAlcancesYLimitsSegmen(), pref.getAlcancesYLimitsTechnologia(), pref.getAlcancesYLimitsOtro1(), pref.getAlcancesYLimitsOtro2(), pref.getAlcancesYLimitsOtro3(), 
					pref.getDependencia1(), pref.getDependencia2(), pref.getDependencia3(), pref.getDependencia4(), pref.getResultados1(), pref.getResultados2(), pref.getResultados3(), pref.getResultados4(), pref.getSupuestos1(), pref.getSupuestos2(), pref.getSupuestos3(), pref.getConclusion(), pref.getRecommendies(),pref.getSummary(),pref.getContingenciaDeslarga(),pref.getDependenciaDesLarga(),pref.getResultadosDesLarga(),pref.getSupuestosDescLarga(),pref.getCheckedElement());
				dba.close();
//			}

			
			break;
			case R.id.imageView1:
				switch (value) {
				case 0:
					CommonUtils.showAlertDialog("title",Attributes.HelpMessage.RROPOSITOHELPMESSAGE1[value], this, null);
					break;
				case 1:
					CommonUtils.showAlertDialog("title",Attributes.HelpMessage.RROPOSITOHELPMESSAGE1[value], this, null);
					break;
				case 2:
					CommonUtils.showAlertDialog("title",Attributes.HelpMessage.RROPOSITOHELPMESSAGE1[value], this, null);
					break;
				case 3:
					CommonUtils.showAlertDialog("title",Attributes.HelpMessage.RROPOSITOHELPMESSAGE1[value], this, null);
					break;
				case 4:
					CommonUtils.showAlertDialog("title",Attributes.HelpMessage.RROPOSITOHELPMESSAGE1[value], this, null);
					break;
				case 5:
					CommonUtils.showAlertDialog("title",Attributes.HelpMessage.RROPOSITOHELPMESSAGE1[value], this, null);
					break;
				case 6:
					CommonUtils.showAlertDialog("title",Attributes.HelpMessage.RROPOSITOHELPMESSAGE1[value], this, null);
					break;

				case 7:
					CommonUtils.showAlertDialog("title",Attributes.HelpMessage.RROPOSITOHELPMESSAGE1[value], this, null);
					break;
				
				}
				break;
		case R.id.imgbtn_filldetail:
			switch (value) {
			case 0:
				CommonUtils.showAlertDialog("",Attributes.HelpMessage.RROPOSITOHELPMESSAGE[value], this, null);
				break;
			case 1:
				CommonUtils.showAlertDialog("",Attributes.HelpMessage.RROPOSITOHELPMESSAGE[value], this, null);
				break;
			case 2:
				CommonUtils.showAlertDialog("",Attributes.HelpMessage.RROPOSITOHELPMESSAGE[value], this, null);
				break;
			case 3:
				CommonUtils.showAlertDialog("",Attributes.HelpMessage.RROPOSITOHELPMESSAGE[value], this, null);
				break;
			case 4:
				CommonUtils.showAlertDialog("",Attributes.HelpMessage.RROPOSITOHELPMESSAGE[value], this, null);
				break;
			case 5:
				CommonUtils.showAlertDialog("",Attributes.HelpMessage.RROPOSITOHELPMESSAGE[value], this, null);
				break;
			case 6:
				CommonUtils.showAlertDialog("",Attributes.HelpMessage.RROPOSITOHELPMESSAGE[value], this, null);
				break;

			case 7:
				CommonUtils.showAlertDialog("",Attributes.HelpMessage.RROPOSITOHELPMESSAGE[value], this, null);
				break;
			
			}
			break;
//			if(value ==4){
//				CommonUtils.showAlertDialog("", "Se refiere al dinero empleado para adquirir el equipo necsario para operar adecuadamente, el cual asciende a $X mil d—lares", this, null);
//			}else if(value ==7)
//			{
//				CommonUtils.showAlertDialog("", "Que la demanda sobrepase la capacidad instalada en lo que refiere a los espacios f’sicos (horas de oficina) y de servicios complementarios y por ende se genere una insatisfacci—n por parte de los clientes.", this, null);
//			}else if(value ==6){
//				CommonUtils.showAlertDialog("", "Descripci—n corta: \n\tÒTiempoÓ\n\nDescripci—n Larga: \n\tÒSe refiere al tiempo requerido para arrancar el negocio, el cual implica para los accionistas distraer parte de su tiempo que normalmente es destinado a su actividad econ—mica principal para dedic‡rselo a iniciar y encaminar el negocio propuestoÓ.", this, null);
//			}
//			switch (btnId) {
//			case R.id.button1:
//				if(value == 0){
//					CommonUtils.showAlertDialog("", "Descripci—n corta:\n\t Generaci—n de una fuente de ingresos permanente \n\nDescripci—n Larga:\n\t El modelo de negocio propuesto se estima genere un ingreso durante sus primeros 3 a–os de operaciones de aproximadamente de USD$690,000.", this, null);					
//				}else if(value ==2)
//				CommonUtils.showAlertDialog("", "Un egreso es un gasto corriente que se realiza mes a mes, independientemente de que se venda o se produzca el producto y/o servicio", this, null);
//				else if(value == 5){
//					CommonUtils.showAlertDialog("", "Descripci—n corta: \n\tÒTranquilidadÓ\n\nDescripci—n Larga: \n\tÒEsta propuesta generar‡ una fuente de ingresos permanente que ofrecer‡ tranquilidad financiera a los sociosÓ", this, null);
//				}
//				break;
//
//			case R.id.button2:
//				if(value == 1){
//					CommonUtils.showAlertDialog("", "Esta propuesta contempla generar un ahorro de $X d—lares mensuales por concepto de energ’a que hoy en d’a se gasta y que a partir de la propuesta se dejar‡ de gastar.", this, null);
//				}else if(value == 3)
//				CommonUtils.showAlertDialog("", "Un costo es un gasto necesario para produir el producto y/o servicio", this, null);
//				break;
//			
//			}
//			break;
		case R.id.imgbtn_help:
			Intent intentHelp=new Intent(this, TitleDescription.class);
			if (help == 999 || help == 99 || help == 998) {
				intentHelp.putExtra(Attributes.TITLETEXT, help);
			}else{
				intentHelp.putExtra(Attributes.LABEL2, i);
				intentHelp.putExtra(Attributes.TITLETEXT, help);
			}
			
			intentHelp.putExtra("title", title.getText().toString());
			
			if(riesgos != 0){
				intentHelp.putExtra("home_flag", 4);
			}else{
				if(i==2)
					intentHelp.putExtra("home_flag", 22);
				else
					intentHelp.putExtra("home_flag", 23);			
			}
			startActivity(intentHelp);
			break;
		case R.id.backbtn21:
			if(riesgos == 3){
				show_reviewDialog();
			} else{
				finish();
//				overridePendingTransition( R.drawable.pull_in_left ,  R.drawable.push_out_right );
			}
			break;
		case R.id.homebtn21:
			final Dialog home_back_dlg = new Dialog(this);
			home_back_dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
			home_back_dlg.setContentView(R.layout.home_dialog);
			
			home_back_dlg.findViewById(R.id.home_btn_back).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					finish();
					((Activity)SecondStageActivity.context2).finish();
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
//					if(riesgos == 0){
//						finish();
//						((Activity)SecondStageActivity.context2).finish();
//						((Activity)MenuActivity.menucontext).finish();
//					} else{
//						finish();
//						((Activity)MenuActivity.menucontext).finish();
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
			
		}
		
	}
	
	
private void show_reviewDialog(){
	
//	finish();
	boolean i = Apptentive.engage(this, "Suverys");
	
	if(!i){
		finish();
	}
	
//	final Dialog dlg = new Dialog(this);
//	dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
//	dlg.setContentView(R.layout.appentive_review);
//	
//	final RadioGroup quiz1 = (RadioGroup)dlg.findViewById(R.id.quiz1);
//	final RadioGroup quiz2 = (RadioGroup)dlg.findViewById(R.id.quiz2);
//	final RadioGroup quiz3 = (RadioGroup)dlg.findViewById(R.id.quiz3);
//	final RadioGroup quiz4 = (RadioGroup)dlg.findViewById(R.id.quiz4);
//	
//	dlg.findViewById(R.id.review_cancel).setOnClickListener(new OnClickListener() {
//		
//		@Override
//		public void onClick(View v) {
//			finish();
//			overridePendingTransition( R.drawable.pull_in_left ,  R.drawable.push_out_right );	
//		}
//	});
//	
//	dlg.findViewById(R.id.review_submit).setOnClickListener(new OnClickListener() {
//		
//		@Override
//		public void onClick(View v) {
//			
//			int selectedID_quiz1 = quiz1.getCheckedRadioButtonId();
//			int selectedID_quiz2 = quiz2.getCheckedRadioButtonId();
//			int selectedID_quiz3 = quiz3.getCheckedRadioButtonId();
//			int selectedID_quiz4 = quiz4.getCheckedRadioButtonId();
//			
//			if(selectedID_quiz1 == R.id.quiz1_ok){
//				Apptentive.engage(FillDetailActivity.this, "Do you find this App useful?");
//			}
//			
//			if(selectedID_quiz2 == R.id.quiz2_ok){
//				Apptentive.engage(FillDetailActivity.this, "Did you find this App easy to use?");
//			}
//			
//			if(selectedID_quiz3 == R.id.quiz3_ok){
//				Apptentive.engage(FillDetailActivity.this, "Did you enjoy it?");
//			}
//			if(selectedID_quiz4 == R.id.quiz4_ok){
//				Apptentive.engage(FillDetailActivity.this, "Do you think this app solves any problem in your daily life?");
//			}
//			
//			finish();
//			overridePendingTransition( R.drawable.pull_in_left ,  R.drawable.push_out_right );	
//		}
//	});
//	
//	dlg.show();
}

@Override
protected void onPause() {

	saveInPrefrerenceva(value);
	super.onPause();
}

@Override
public void finish(){
	saveInPrefrerenceva(value);
	super.finish();
}

private void saveInPrefrerenceva(int value2) {
	strDescCorta=descCort1.getText().toString().trim()+"~";
	strDescCorta=strDescCorta+descCort2.getText().toString().trim()+"~";
	strDescCorta=strDescCorta+descCort3.getText().toString().trim()+"~";
	strDescCorta=strDescCorta+descCort4.getText().toString().trim();
	strDescLarga=descLarga1.getText().toString().trim()+"~";
	strDescLarga=strDescLarga+descLarga2.getText().toString().trim()+"~";
	strDescLarga=strDescLarga+descLarga3.getText().toString().trim()+"~";
	strDescLarga=strDescLarga+descLarga4.getText().toString().trim();
	if(value==0){
		
		pref.setDescriptionShort1(strDescCorta);
		pref.setDescriptionLarge1(strDescLarga);
		Log.d(TAG, "Desc corta "+strDescCorta+"\n desclarge"+strDescLarga);

	}
	if(value==1){
		
		pref.setDescriptionShortAhorros1(strDescCorta);
	
		pref.setDescriptionLargeAhorros1(strDescLarga);
		Log.d(TAG, "Desc corta "+strDescCorta+"\n desclarge"+strDescLarga);

	}
	if(value==2){
		
		pref.setDescriptionShortEgresos1(strDescCorta);
		pref.setDescriptionLargeEgresos1(strDescLarga);
		
	}
	if(value==3){
		
		pref.setDescriptionShortCostos(strDescCorta);
		pref.setDescriptionLargeCostos(strDescLarga);
	
	}
	if(value==4){
		
		pref.setDescriptionShortInversion(strDescCorta);
		pref.setDescriptionLargeInversion(strDescLarga);
	
	}
	if(value==5){
		
		pref.setDescriptionShortBeneficios(strDescCorta);
		pref.setDescriptionLargeBeneficios(strDescLarga);
	
	}
	if(value==6){
		
		pref.setDescriptionShortImpactos(strDescCorta);
		pref.setDescriptionLargeImpactos(strDescLarga);
	
	}
	if(value==7){
		
		pref.setDescriptionShortRiesgos(strDescCorta);
		pref.setDescriptionLargeRiesgos(strDescLarga);
	
	}
	
}

private void setPrefValue(int v){
	if(v==0){
		
		 if(pref.getDescriptionShort1()!=null){
			 String strShort="";
			try{
			strShort= pref.getDescriptionShort1().split("~")[0];
			descCort1.setText(strShort);
			strShort= pref.getDescriptionShort1().split("~")[1];
			descCort2.setText(strShort);
			strShort= pref.getDescriptionShort1().split("~")[2];
			descCort3.setText(strShort);
			strShort= pref.getDescriptionShort1().split("~")[3];
			descCort4.setText(strShort);
			Log.d(TAG, "pref value"+descCort1+"\n"+descCort2+"\n"+descCort3+"\n"+descCort4);
			}catch(ArrayIndexOutOfBoundsException e){
				
			}
		 }
		 if(pref.getDescriptionLarge1()!=null){
			 String strLong="";
			 try{
			strLong= pref.getDescriptionLarge1().split("~")[0];
			descLarga1.setText(strLong);
			strLong= pref.getDescriptionLarge1().split("~")[1];
			descLarga2.setText(strLong);
			strLong= pref.getDescriptionLarge1().split("~")[2];
			descLarga3.setText(strLong);
			strLong= pref.getDescriptionLarge1().split("~")[3];
			descLarga4.setText(strLong);
		 }catch(ArrayIndexOutOfBoundsException e){
				
			}
			
		 }

	}
	if(v==1){
		
		 if(pref.getDescriptionShortAhorros1()!=null){
			 String strShort="";
			try{
			strShort= pref.getDescriptionShortAhorros1().split("~")[0];
			descCort1.setText(strShort);
			strShort= pref.getDescriptionShortAhorros1().split("~")[1];
			descCort2.setText(strShort);
			strShort= pref.getDescriptionShortAhorros1().split("~")[2];
			descCort3.setText(strShort);
			strShort= pref.getDescriptionShortAhorros1().split("~")[3];
			descCort4.setText(strShort);
			Log.d(TAG, "pref value"+descCort1+"\n"+descCort2+"\n"+descCort3+"\n"+descCort4);
			}catch(ArrayIndexOutOfBoundsException e){
				
			}
		 }
		 if(pref.getDescriptionLargeAhorros1()!=null){
			 String strLong="";
			 try{
			strLong= pref.getDescriptionLargeAhorros1().split("~")[0];
			descLarga1.setText(strLong);
			strLong= pref.getDescriptionLargeAhorros1().split("~")[1];
			descLarga2.setText(strLong);
			strLong= pref.getDescriptionLargeAhorros1().split("~")[2];
			descLarga3.setText(strLong);
			strLong= pref.getDescriptionLargeAhorros1().split("~")[3];
			descLarga4.setText(strLong);
		 }catch(ArrayIndexOutOfBoundsException e){
				
			}
			
		 }

	}
	if(v==2){
		
		 if(pref.getDescriptionShortEgresos1()!=null){
			 String strShort="";
			try{
			strShort= pref.getDescriptionShortEgresos1().split("~")[0];
			descCort1.setText(strShort);
			strShort= pref.getDescriptionShortEgresos1().split("~")[1];
			descCort2.setText(strShort);
			strShort= pref.getDescriptionShortEgresos1().split("~")[2];
			descCort3.setText(strShort);
			strShort= pref.getDescriptionShortEgresos1().split("~")[3];
			descCort4.setText(strShort);
			Log.d(TAG, "pref value"+descCort1+"\n"+descCort2+"\n"+descCort3+"\n"+descCort4);
			}catch(ArrayIndexOutOfBoundsException e){
				
			}
		 }
		 if(pref.getDescriptionLargeEgresos1()!=null){
			 String strLong="";
			 try{
			strLong= pref.getDescriptionLargeEgresos1().split("~")[0];
			descLarga1.setText(strLong);
			strLong= pref.getDescriptionLargeEgresos1().split("~")[1];
			descLarga2.setText(strLong);
			strLong= pref.getDescriptionLargeEgresos1().split("~")[2];
			descLarga3.setText(strLong);
			strLong= pref.getDescriptionLargeEgresos1().split("~")[3];
			descLarga4.setText(strLong);
		 }catch(ArrayIndexOutOfBoundsException e){
				
			}
			
		 }

	}
	if(v==3){
		
		 if(pref.getDescriptionShortCostos()!=null){
			 String strShort="";
			try{
			strShort= pref.getDescriptionShortCostos().split("~")[0];
			descCort1.setText(strShort);
			strShort= pref.getDescriptionShortCostos().split("~")[1];
			descCort2.setText(strShort);
			strShort= pref.getDescriptionShortCostos().split("~")[2];
			descCort3.setText(strShort);
			strShort= pref.getDescriptionShortCostos().split("~")[3];
			descCort4.setText(strShort);
			
			}catch(ArrayIndexOutOfBoundsException e){
				
			}
		 }
		 if(pref.getDescriptionLargeCostos()!=null){
			 String strLong="";
			 try{
			strLong= pref.getDescriptionLargeCostos().split("~")[0];
			descLarga1.setText(strLong);
			strLong= pref.getDescriptionLargeCostos().split("~")[1];
			descLarga2.setText(strLong);
			strLong= pref.getDescriptionLargeCostos().split("~")[2];
			descLarga3.setText(strLong);
			strLong= pref.getDescriptionLargeCostos().split("~")[3];
			descLarga4.setText(strLong);
		 }catch(ArrayIndexOutOfBoundsException e){
				
			}
			
		 }

	}
	if(v==4){
		
		 if(pref.getDescriptionShortInversion()!=null){
			 String strShort="";
			try{
			strShort= pref.getDescriptionShortInversion().split("~")[0];
			descCort1.setText(strShort);
			strShort= pref.getDescriptionShortInversion().split("~")[1];
			descCort2.setText(strShort);
			strShort= pref.getDescriptionShortInversion().split("~")[2];
			descCort3.setText(strShort);
			strShort= pref.getDescriptionShortInversion().split("~")[3];
			descCort4.setText(strShort);
			Log.d(TAG, "pref value"+descCort1+"\n"+descCort2+"\n"+descCort3+"\n"+descCort4);
			}catch(ArrayIndexOutOfBoundsException e){
				
			}
		 }
		 if(pref.getDescriptionLargeInversion()!=null){
			 String strLong="";
			 try{
			strLong= pref.getDescriptionLargeInversion().split("~")[0];
			descLarga1.setText(strLong);
			strLong= pref.getDescriptionLargeInversion().split("~")[1];
			descLarga2.setText(strLong);
			strLong= pref.getDescriptionLargeInversion().split("~")[2];
			descLarga3.setText(strLong);
			strLong= pref.getDescriptionLargeInversion().split("~")[3];
			descLarga4.setText(strLong);
		 }catch(ArrayIndexOutOfBoundsException e){
				
			}
			
		 }

	}
	if(v==5){
		
		 if(pref.getDescriptionShortBeneficios()!=null){
			 String strShort="";
			try{
			strShort= pref.getDescriptionShortBeneficios().split("~")[0];
			descCort1.setText(strShort);
			strShort= pref.getDescriptionShortBeneficios().split("~")[1];
			descCort2.setText(strShort);
			strShort= pref.getDescriptionShortBeneficios().split("~")[2];
			descCort3.setText(strShort);
			strShort= pref.getDescriptionShortBeneficios().split("~")[3];
			descCort4.setText(strShort);
			Log.d(TAG, "pref value"+descCort1+"\n"+descCort2+"\n"+descCort3+"\n"+descCort4);
			}catch(ArrayIndexOutOfBoundsException e){
				
			}
		 }
		 if(pref.getDescriptionLargeBeneficios()!=null){
			 String strLong="";
			 try{
			strLong= pref.getDescriptionLargeBeneficios().split("~")[0];
			descLarga1.setText(strLong);
			strLong= pref.getDescriptionLargeBeneficios().split("~")[1];
			descLarga2.setText(strLong);
			strLong= pref.getDescriptionLargeBeneficios().split("~")[2];
			descLarga3.setText(strLong);
			strLong= pref.getDescriptionLargeBeneficios().split("~")[3];
			descLarga4.setText(strLong);
		 }catch(ArrayIndexOutOfBoundsException e){
				
			}
			
		 }

	}
	if(v==6){
		
		 if(pref.getDescriptionShortImpactos()!=null){
			 String strShort="";
			try{
			strShort= pref.getDescriptionShortImpactos().split("~")[0];
			descCort1.setText(strShort);
			strShort= pref.getDescriptionShortImpactos().split("~")[1];
			descCort2.setText(strShort);
			strShort= pref.getDescriptionShortImpactos().split("~")[2];
			descCort3.setText(strShort);
			strShort= pref.getDescriptionShortImpactos().split("~")[3];
			descCort4.setText(strShort);
			Log.d(TAG, "pref value"+descCort1+"\n"+descCort2+"\n"+descCort3+"\n"+descCort4);
			}catch(ArrayIndexOutOfBoundsException e){
				
			}
		 }
		 if(pref.getDescriptionLargeImpactos()!=null){
			 String strLong="";
			 try{
			strLong= pref.getDescriptionLargeImpactos().split("~")[0];
			descLarga1.setText(strLong);
			strLong= pref.getDescriptionLargeImpactos().split("~")[1];
			descLarga2.setText(strLong);
			strLong= pref.getDescriptionLargeImpactos().split("~")[2];
			descLarga3.setText(strLong);
			strLong= pref.getDescriptionLargeImpactos().split("~")[3];
			descLarga4.setText(strLong);
		 }catch(ArrayIndexOutOfBoundsException e){
				
			}
			
		 }

	}
	if(v==7){
		
		 if(pref.getDescriptionShortRiesgos()!=null){
			 String strShort="";
			try{
			strShort= pref.getDescriptionShortRiesgos().split("~")[0];
			descCort1.setText(strShort);
			strShort= pref.getDescriptionShortRiesgos().split("~")[1];
			descCort2.setText(strShort);
			strShort= pref.getDescriptionShortRiesgos().split("~")[2];
			descCort3.setText(strShort);
			strShort= pref.getDescriptionShortRiesgos().split("~")[3];
			descCort4.setText(strShort);
			Log.d(TAG, "pref value"+descCort1+"\n"+descCort2+"\n"+descCort3+"\n"+descCort4);
			}catch(ArrayIndexOutOfBoundsException e){
				
			}
		 }
		 if(pref.getDescriptionLargeRiesgos()!=null){
			 String strLong="";
			 try{
			strLong= pref.getDescriptionLargeRiesgos().split("~")[0];
			descLarga1.setText(strLong);
			strLong= pref.getDescriptionLargeRiesgos().split("~")[1];
			descLarga2.setText(strLong);
			strLong= pref.getDescriptionLargeRiesgos().split("~")[2];
			descLarga3.setText(strLong);
			strLong= pref.getDescriptionLargeRiesgos().split("~")[3];
			descLarga4.setText(strLong);
		 }catch(ArrayIndexOutOfBoundsException e){
				
			}
			
		 }

	}
}
}

