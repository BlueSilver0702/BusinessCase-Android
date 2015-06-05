package com.sergio.businesscase.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sergio.businesscase.R;


public class CommonUtils {
	public static void showAlertDialog(String title,String message,final Context context,final Intent intent){
		final Dialog custDialog = new Dialog(context);
		custDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		custDialog.setContentView(R.layout.cust_dialog);
		TextView dialog_title = (TextView)custDialog.findViewById(R.id.dialog_title);
		if(title == "title"){
			dialog_title.setText("¿Qué escribir?");
		}
		
		TextView textmsg =(TextView)custDialog.findViewById(R.id.tv_helpmsg);
		Button btnOk =(Button)custDialog.findViewById(R.id.btnok);
		textmsg.setText(message);
		btnOk.setText("  Ok  ");
		btnOk.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				if(intent!= null)
					context.startActivity(intent);
				custDialog.dismiss();
			}
		});
		custDialog.show();
		
	}
	
	public static void setTextWatcher(final EditText textWatch){
		textWatch.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				String textLength =s.toString();
				String noOfWords[] = s.toString().split(" ");
			
				if (textLength.length()>70 || noOfWords.length>12) {
					setScroller(textWatch);
					
				}
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,int after) {
						
			}
			
			@Override
			public void afterTextChanged(Editable s) {
							
			}
		});
	}
	public static void setScroller(EditText editText)	{
		editText.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_UP:
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                    }
				
			
				return false;
			}
		});
	}
	
	public static void showAlertTable(Context context,String variable1,String value1,String variable2,String value2){
		Dialog tableDialoge = new Dialog(context);
		tableDialoge.requestWindowFeature(Window.FEATURE_NO_TITLE);
		tableDialoge.setContentView(R.layout.modelo_financero_table);
		TextView varText = (TextView)tableDialoge.findViewById(R.id.variabletext);
		varText.setText(variable1);
		TextView valueText = (TextView)tableDialoge.findViewById(R.id.valuetext);
		valueText.setText(value1);
		TextView varText2 = (TextView)tableDialoge.findViewById(R.id.variabletext2);
		varText2.setText(variable2);
		TextView valueText2 = (TextView)tableDialoge.findViewById(R.id.valuetext2);
		valueText2.setText(value2);
		tableDialoge.show();
	}
	
//	public static void showAlertDialog(String title,String message,final Context context,final Intent intent){
//		AlertDialog.Builder adb=new AlertDialog.Builder(context);
//		adb.setTitle(title);
//		adb.setMessage(message);
//		
//		adb.setPositiveButton("Ok",new DialogInterface.OnClickListener() {
//			
//			@Override
//			public void onClick(DialogInterface dialog, int which) {
//				if(intent!= null)
//				context.startActivity(intent);
//				
//			}
//		} );
//		adb.show();
//	}
	

}
