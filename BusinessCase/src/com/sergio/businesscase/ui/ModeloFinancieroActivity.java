package com.sergio.businesscase.ui;

import java.util.ArrayList;

import com.apptentive.android.sdk.Apptentive;
import com.flurry.android.FlurryAgent;
import com.sergio.businesscase.R;
import com.sergio.businesscase.helper.Attributes;
import com.sergio.businesscase.helper.PropositoListAdapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TabActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class ModeloFinancieroActivity extends Activity implements OnItemClickListener, OnClickListener{
	TextView title;
	int i;
	ImageView help;
	ListView list5;
	public static Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modelo_financiero_activity);
		Intent intent=getIntent();
		i=intent.getIntExtra(Attributes.LABEL2, 0);
		context = this;
		init();
//		setActionBar();
	}

//	private void setActionBar() {
//		
//		ActionBar actionBar= (ActionBar)findViewById(R.id.actionbar_modelo);
//
//		Intent intentHelp=new Intent(this, TitleDescription.class);
//		intentHelp.putExtra(Attributes.TITLETEXT, 4);
//		intentHelp.putExtra(Attributes.LABEL2, i);
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
	
	private void init(){
		Typeface fonts = Typeface.createFromAsset(getAssets(), "fonts/Calibri-bold.ttf");
		title=(TextView)findViewById(R.id.tv_modelo_title);
		title.setTypeface(fonts);
		help = (ImageView)findViewById(R.id.imgview_help);
		help.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intentHelp=new Intent(ModeloFinancieroActivity.this, TitleDescription.class);
				intentHelp.putExtra(Attributes.TITLETEXT, 4);
				intentHelp.putExtra(Attributes.LABEL2, i);
				intentHelp.putExtra("home_flag", 51);
				startActivity(intentHelp);
			}
		});
		
		findViewById(R.id.backbtn5).setOnClickListener(this);
		findViewById(R.id.homebtn5).setOnClickListener(this);
		
		list5 = (ListView)findViewById(R.id.model_financios);
		list5.setOnItemClickListener(this);
		
		ArrayList<String> titlenames = new ArrayList<String>();
		if(i==0){
			title.setText("Variables de\n  Beneficios");
			titlenames.add("Ingresos");
			titlenames.add("Ahorros");
		}
		if(i==1){
			title.setText("       Variables de\n Impactos Negativos");
			titlenames.add("Gastos");
			titlenames.add("Costos");
		}
		PropositoListAdapter adapter = new PropositoListAdapter(this,titlenames);
		list5.setAdapter(adapter);
		
	}
	
	
//	private void init() {
//		//applying custom fonts 
//		Typeface fonts = Typeface.createFromAsset(getAssets(), "fonts/Calibri.ttf");
//		title=(TextView)findViewById(R.id.tv_modelo_title);
//		title.setTypeface(fonts);
//		
//		help = (ImageView)findViewById(R.id.imgview_help);
//		
//		//create tab host that will contain tab
//		tabHost=(TabHost)findViewById(android.R.id.tabhost);
//		
//		tab1=tabHost.newTabSpec("Tab1");
//		tab2=tabHost.newTabSpec("Tab2");
//		
//		if(i==0){
//			title.setText("Variables de Beneficios");
//			
//		Intent intentIngross= new Intent(this, IngresosTabActivity.class);
//		intentIngross.putExtra(Attributes.TABVALUE, i);
//		//set the tab name
//		tab1.setIndicator("Ingresos");
//		
//		tab1.setContent(intentIngross);
//	
//		tab2.setIndicator("Ahorros");
//		tab2.setContent(intentIngross);
//		
//		
//		
//		}
//		
//		if(i==1){
//			title.setText("Variables de Impactos Negativos");
//			Intent intentIngross= new Intent(this, IngresosTabActivity.class);
//			intentIngross.putExtra(Attributes.TABVALUE, i);		
//			tab1.setIndicator("Egresos Normales");
//			tab1.setContent(intentIngross);
//			
//			tab2.setIndicator("Costos Normales");
//			tab2.setContent(intentIngross);
//			
//			
//		}
//		// add the tab host to display
//		
//				tabHost.addTab(tab1);
//				tabHost.addTab(tab2);
//				
//				//give custom tab widget size
//				tabHost.getTabWidget().getChildAt(0).getLayoutParams().height=55;
//				tabHost.getTabWidget().getChildAt(1).getLayoutParams().height=55;
//
//				// tab background color 
//				tabHost.getTabWidget().getChildAt(1).setBackgroundColor(Color.rgb(0, 21, 50));
//				TextView size = (TextView)tabHost.getTabWidget().getChildAt(0).findViewById(android.R.id.title);
//				size.setTextSize(18);
//				TextView size1 = (TextView)tabHost.getTabWidget().getChildAt(1).findViewById(android.R.id.title);
//				size1.setTextColor(Color.WHITE);
//				size1.setTextSize(18);
//		
//				help.setOnClickListener(new OnClickListener() {
//					
//					@Override
//					public void onClick(View arg0) {
//						Intent intentHelp=new Intent(ModeloFinancieroActivity.this, TitleDescription.class);
//						intentHelp.putExtra(Attributes.TITLETEXT, 4);
//						intentHelp.putExtra(Attributes.LABEL2, i);
//						startActivity(intentHelp);
//						
//					}
//				});
//		
//	}
	

	
//	public void onResume() {
//
//		 super.onResume();
//		     tabHost.getTabWidget().getChildAt(0).setOnClickListener(new OnClickListener() {
//
//		                   public void onClick(View v) {
//
//		                Log.d("tag", "tab is clicked");
//		                tabHost.setCurrentTab(0);
//		    //based on your count value..you can do anything...like going back to homepage...
//		    //    similar thing exist on iphone (double tab a tab..it takes back to homepage)
//		   }
//		 });
//		     tabHost.getTabWidget().getChildAt(1).setOnClickListener(new OnClickListener() {
//
//                 public void onClick(View v) {
//                	 Intent intentIngross= new Intent(ModeloFinancieroActivity.this, IngresosTabActivity.class);
//                	 if(i==0){
//         			intentIngross.putExtra(Attributes.TABVALUE, 3);
//        			tab2.setContent(intentIngross);
//                	 }else{
//                		 intentIngross.putExtra(Attributes.TABVALUE, 4);
//             			tab2.setContent(intentIngross);
//                	 }
//              
//              tabHost.setCurrentTab(1);
//  //based on your count value..you can do anything...like going back to homepage...
//  //    similar thing exist on  (double tab a tab..it takes back to homepage)
// }
//});
//
//
//	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		// TODO Auto-generated method stub
		if(i==0){
			if(position == 0){
				Intent intentIngross= new Intent(this, IngresosTabActivity.class);
				intentIngross.putExtra(Attributes.TABVALUE, i);
				startActivity(intentIngross);
				overridePendingTransition( R.drawable.pull_in_right ,  R.drawable.push_out_left );
			}else if(position == 1){
				Intent intentIngross= new Intent(this, IngresosTabActivity.class);
				intentIngross.putExtra(Attributes.TABVALUE, 3);
				startActivity(intentIngross);
				overridePendingTransition( R.drawable.pull_in_right ,  R.drawable.push_out_left );
			}
		}
		if(i==1){
			if(position == 0){
				Intent intentIngross= new Intent(this, IngresosTabActivity.class);
				intentIngross.putExtra(Attributes.TABVALUE, i);
				startActivity(intentIngross);
				overridePendingTransition( R.drawable.pull_in_right ,  R.drawable.push_out_left );
			}else if(position == 1){
				Intent intentIngross= new Intent(this, IngresosTabActivity.class);
				intentIngross.putExtra(Attributes.TABVALUE, 4);
				startActivity(intentIngross);
				overridePendingTransition( R.drawable.pull_in_right ,  R.drawable.push_out_left );
			}
		}
		
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.backbtn5:
			finish();
			overridePendingTransition( R.drawable.pull_in_left ,  R.drawable.push_out_right );
			break;
		case R.id.homebtn5:
			
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
//					((Activity) MenuActivity.menucontext).finish();
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

//	@Override
//	public void onClick(View v) {
//	//	TabListAdapter adapter=new TabListAdapter(getApplicationContext(), 0, null, 0);
//	//	adapter.getTextOnList();
//		Log.d("TAG", "adapter is called");
//		
//	} 
}
