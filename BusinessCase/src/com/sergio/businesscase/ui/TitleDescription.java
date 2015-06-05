package com.sergio.businesscase.ui;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.apptentive.android.sdk.Apptentive;
import com.flurry.android.FlurryAgent;
import com.sergio.businesscase.R;
import com.sergio.businesscase.helper.Attributes;

public class TitleDescription extends Activity implements OnClickListener{
	private int home_flag = -1;
	private String title_txt = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.title_desc);
		TextView text=(TextView)findViewById(R.id.tv_titldesc);
		text.setPadding(7, 0, 5, 5);
		Typeface font_Bold = Typeface.createFromAsset(getAssets(), "fonts/Calibri-bold.ttf");
		TextView title = (TextView)findViewById(R.id.helpnave_title);
		title.setTypeface(font_Bold);
		
		findViewById(R.id.backhelp11).setOnClickListener(this);
		findViewById(R.id.homehelp11).setOnClickListener(this);
//		text.setTextColor(Color.BLACK);
//		text.setBackgroundColor(Color.WHITE);
		text.setTextSize(16);
		text.setMovementMethod(new ScrollingMovementMethod());
		Intent intent=getIntent();
//		String str=intent.getStringExtra(Attributes.TITLETEXT);
		
		int position=intent.getIntExtra(Attributes.TITLETEXT, 0);
		int childPosition=intent.getIntExtra(Attributes.LABEL2, 0);
		home_flag = intent.getIntExtra("home_flag", 0);
		title_txt = intent.getStringExtra("title");
		
		if(position ==999 || position == 99 || position == 998){
			if(position == 999){
				text.setText(Attributes.Description.FILLDETAILHELP[0]);
			}else if (position == 99){
				text.setText(Attributes.Description.FILLDETAILHELP[1]);
			}else{
				text.setText(Attributes.Description.FILLDETAILHELP[2]);
			}
		}else{		
			ArrayList<String> childtitles = (ArrayList<String>) Attributes.getHelpChildListForTitle().get(position);
			if(position!=0 && position!=1 && position!=4 && position!=6){
				title.setText(Attributes.getParentList().get(position));
				text.setText(Attributes.Description.TITILMESSAGE[position]);
				
			}else if(position==0){
				title.setText(childtitles.get(childPosition));
				text.setText(Attributes.Description.SUBLISTMESSAGE[childPosition]);
			}else if(position==1){
				title.setText(childtitles.get(childPosition));
				childPosition=childPosition+3;
				text.setText(Attributes.Description.SUBLISTMESSAGE[childPosition]);
			} else if(position==4){
				title.setText(childtitles.get(childPosition));
				childPosition=childPosition+7;
				text.setText(Attributes.Description.SUBLISTMESSAGE[childPosition]);
			}else{
				title.setText(childtitles.get(childPosition));
				childPosition=childPosition+10;
				text.setText(Attributes.Description.SUBLISTMESSAGE[childPosition]);
			}
		}
		
		if(title_txt != null){
			title.setText(title_txt);
		}
//		setContentView(text);
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

	@Override
	public void onClick(View vi) {
		switch(vi.getId()){
		case R.id.backhelp11:
			finish();
			break;
		case R.id.homehelp11:
			
			final Dialog home_back_dlg = new Dialog(this);
			home_back_dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
			home_back_dlg.setContentView(R.layout.home_dialog);
			
			home_back_dlg.findViewById(R.id.home_btn_back).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					finish();
					if(home_flag == 1){
						((Activity)EsquemaGeneralActivity.context).finish();
					} else if(home_flag == 21){
						((Activity)SecondStageActivity.context2).finish();
					} else if(home_flag == 22){
						((Activity)FillDetailActivity.contex).finish();
					} else if(home_flag == 23){
						((Activity)SecondStageActivity.context2).finish();
						((Activity)FillDetailActivity.contex).finish();
					} else if(home_flag == 3){
						((Activity)IntroductionActivity.context).finish();
					} else if(home_flag == 4){
						((Activity)FillDetailActivity.contex).finish();
					}  else if(home_flag == 51){
						((Activity)ModeloFinancieroActivity.context).finish();
					} else if(home_flag == 52){
						((Activity)IngresosTabActivity.context).finish();
					} else if(home_flag == 6){
						((Activity)AlcancesYLimites.context).finish();
					} else if(home_flag == 61){
						((Activity)AlcancesCheckedElements.context).finish();
						((Activity)AlcancesYLimites.context).finish();
					} else if(home_flag == 7){
						((Activity)ThreeFieldActivity.context).finish();
					}  else if(home_flag == 9){
						((Activity)SupuestosActivity.context).finish();
					} else if(home_flag == 10){
						((Activity)FuentesTabActivity.context).finish();
					} else if(home_flag == 11){
						((Activity)ConculsionActivity.context).finish();
					} else if(home_flag == 12){
						((Activity)SuamrioEjecutivoActivity.context).finish();
					}
					else{
						((Activity)HelpActivity.context).finish();
					}
					((Activity) MenuActivity.menucontext).finish();
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
//					if(home_flag == 1){
//						((Activity)EsquemaGeneralActivity.context).finish();
//					} else if(home_flag == 21){
//						((Activity)SecondStageActivity.context2).finish();
//					} else if(home_flag == 22){
//						((Activity)FillDetailActivity.contex).finish();
//					} else if(home_flag == 23){
//						((Activity)SecondStageActivity.context2).finish();
//						((Activity)FillDetailActivity.contex).finish();
//					} else if(home_flag == 3){
//						((Activity)IntroductionActivity.context).finish();
//					} else if(home_flag == 4){
//						((Activity)FillDetailActivity.contex).finish();
//					}  else if(home_flag == 51){
//						((Activity)ModeloFinancieroActivity.context).finish();
//					} else if(home_flag == 52){
//						((Activity)IngresosTabActivity.context).finish();
//					} else if(home_flag == 6){
//						((Activity)AlcancesYLimites.context).finish();
//					} else if(home_flag == 61){
//						((Activity)AlcancesCheckedElements.context).finish();
//						((Activity)AlcancesYLimites.context).finish();
//					} else if(home_flag == 7){
//						((Activity)ThreeFieldActivity.context).finish();
//					}  else if(home_flag == 9){
//						((Activity)SupuestosActivity.context).finish();
//					} else if(home_flag == 10){
//						((Activity)FuentesTabActivity.context).finish();
//					} else if(home_flag == 11){
//						((Activity)ConculsionActivity.context).finish();
//					} else if(home_flag == 12){
//						((Activity)SuamrioEjecutivoActivity.context).finish();
//					}
//					else{
//						((Activity)HelpActivity.context).finish();
//					}
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
			
			
			break;
		}
		
	}

}
