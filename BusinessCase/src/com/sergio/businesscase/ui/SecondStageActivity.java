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
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SecondStageActivity extends Activity implements OnClickListener, OnItemClickListener{
	
	private static final String TAG = "SecongStageActivity";
	Button btnLabel1,btnLabel2;
	int i,id;
	Button help, back;
	Intent intent;
	TextView text;
	ListView list2;
	
	ArrayList<String> lists = new ArrayList<String>();
	
	public static Context context2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.second_stage_activity);
		context2 = this;
		Intent intent=getIntent();
		i=intent.getIntExtra(Attributes.LABEL2,0);
		Log.d(TAG, "Child list position= "+i);
	
//		setActionBar();
		init();
	}

//	private void setActionBar() {
//		
//		ActionBar actionBar= (ActionBar)findViewById(R.id.actionbar_secondstage);
//		
//		Intent intentHelp=new Intent(this, TitleDescription.class);
//		intentHelp.putExtra(Attributes.TITLETEXT, 1);
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

	//@SuppressWarnings("deprecation")
	private void init() {
		text = (TextView)findViewById(R.id.title21);
		help = (Button)findViewById(R.id.help_btn2);
		Button back = (Button)findViewById(R.id.back_btn2);
		back.setOnClickListener(this);
		Button home = (Button)findViewById(R.id.home_btn2);
		home.setOnClickListener(this);
		
		Typeface fonts = Typeface.createFromAsset(getAssets(), "fonts/Calibri-bold.ttf");
		text.setTypeface(fonts);
		
		list2 = (ListView)findViewById(R.id.list21);
		list2.setOnItemClickListener(this);
	
		help.setOnClickListener(this);
		
		switch (i) {
		case 0:
			
			text.setText(" Beneficios\nFinancieros");
			lists.clear();
			lists.add("Ingresos");
			lists.add("Ahorros");
			PropositoListAdapter adapter1 = new PropositoListAdapter(this, lists);
			
			list2.setAdapter(adapter1);
			
			break;
		case 1:
			text.setText("Impactos Negativos");
			lists.clear();
			lists.add("Gastos");
			lists.add("Costos");
			PropositoListAdapter adapter2 = new PropositoListAdapter(this, lists);
			
			list2.setAdapter(adapter2);
			
			break;
			
		case 2:
			finish();
			intent=new Intent(this, FillDetailActivity.class);
			intent.putExtra(Attributes.POSITION, i);
			startActivity(intent);
			break;
			
			
		case 3:
			text.setText("Otros Aspectos \n No financieros");
			lists.clear();
			lists.add("Beneficios");
			lists.add("Impactos Negativos");
			PropositoListAdapter adapter4 = new PropositoListAdapter(this, lists);
			
			list2.setAdapter(adapter4);
			break;
			
			

		}
		
	}
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.help_btn2:
			Intent intentHelp=new Intent(this, TitleDescription.class);
			intentHelp.putExtra(Attributes.TITLETEXT, 1);
			intentHelp.putExtra(Attributes.LABEL2, i);
			intentHelp.putExtra("home_flag", 21);
			startActivity(intentHelp);
			break;
		case R.id.back_btn2:
			finish();
			overridePendingTransition( R.drawable.pull_in_left ,  R.drawable.push_out_right );
			break;
		case R.id.home_btn2:
			
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
			
			
		}
		
		
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		switch(position){
			case 0:
				id = 0;
				intent=new Intent(this, FillDetailActivity.class);
				intent.putExtra(Attributes.POSITION, i);
				intent.putExtra("id", id);
				Log.d(TAG, "Id=== "+id);
				startActivity(intent);
				overridePendingTransition( R.drawable.pull_in_right ,  R.drawable.push_out_left );
				break;
	
			case 1:
				id = 1;
				intent=new Intent(this, FillDetailActivity.class);
				intent.putExtra(Attributes.POSITION, i);
				intent.putExtra("id", id);
				Log.d(TAG, "Id=== "+id);
				startActivity(intent);
				overridePendingTransition( R.drawable.pull_in_right ,  R.drawable.push_out_left );
				break;
		}
	}
}
