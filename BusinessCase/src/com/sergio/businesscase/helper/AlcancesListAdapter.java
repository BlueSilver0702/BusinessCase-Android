package com.sergio.businesscase.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.sergio.businesscase.R;
import com.sergio.businesscase.utils.PreferenceUtils;

public class AlcancesListAdapter extends ArrayAdapter<String>{
//	private static final String TAG = "Alcances List Adapter";
	Context context;
	ArrayList<String> list;
	
	HashMap<String, String> map;
	PreferenceUtils pref;
	int position;
	ViewHolder holder;
	String strlist;
	Typeface font;

	public AlcancesListAdapter(Context context, int textViewResourceId,
			List<String> objects) {
		super(context, textViewResourceId, objects);
		
		this.context=context;
		list=(ArrayList<String>)objects;
		map=new HashMap<String, String>();
		pref=new PreferenceUtils(context);
		font = Typeface.createFromAsset(context.getAssets(), "fonts/Calibri.ttf");
		
		
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		this.position=position;
		holder = new ViewHolder();
		
		if(convertView==null){
			LayoutInflater inflate=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView=inflate.inflate(R.layout.alcances_row, null);
			holder.title=(TextView)convertView.findViewById(R.id.tv_row_title);
			holder.title.setTypeface(font);
			holder.text=(EditText)convertView.findViewById(R.id.et_alca_listadpter);
			holder.text.setTypeface(font);
			
			convertView.setTag(holder);
					
		}else
		holder = (ViewHolder)convertView.getTag();
		
		holder.title.setText(list.get(position));
		
		if(list.get(position).equals(Attributes.CHKBOXTIEMPO)){
			if(pref.getAlcancesYLimit()!=null){
				holder.text.setText(pref.getAlcancesYLimit());
			}else
				holder.text.setText("");
		}
		if(list.get(position).equals(Attributes.CHKBOXCAPACIDAD)){
			if(pref.getAlcancesYLimitCapacidad()!=null){
				holder.text.setText(pref.getAlcancesYLimitCapacidad());
			}else
				holder.text.setText("");
		}
		
		if(list.get(position).equals(Attributes.CHKBOXHORARAIOS)){
			if(pref.getAlcancesYLimitHorarios()!=null){
				holder.text.setText(pref.getAlcancesYLimitHorarios());
			}else
				holder.text.setText("");
		}
		if(list.get(position).equals(Attributes.CHKBOXCOBERTURA)){
			if(pref.getAlcancesYLimitsCobertura()!=null){
				holder.text.setText(pref.getAlcancesYLimitsCobertura());
			}else
				holder.text.setText("");
		}
		if(list.get(position).equals(Attributes.CHKBOXCOMERCIAL)){
			if(pref.getAlcancesYLimitsComercial()!=null){
				holder.text.setText(pref.getAlcancesYLimitsComercial());
			}else
				holder.text.setText("");
		}
		
		if(list.get(position).equals(Attributes.CHKBOXPERSONAL)){
			if(pref.getAlcancesYLimitsPersonal()!=null){
				holder.text.setText(pref.getAlcancesYLimitsPersonal());
			}else
				holder.text.setText("");
		}
		
		if(list.get(position).equals(Attributes.CHKBOXDEMANDA)){
			if(pref.getAlcancesYLimitsDemanda()!=null){
				holder.text.setText(pref.getAlcancesYLimitsDemanda());
			}else
				holder.text.setText("");
		}
		if(list.get(position).equals(Attributes.CHKBOXDURACION)){
			if(pref.getAlcancesYLimitsDuracion()!=null){
				holder.text.setText(pref.getAlcancesYLimitsDuracion());
			}else
				holder.text.setText("");
		}
		
		if(list.get(position).equals(Attributes.CHKBOXSEGMEN)){
			if(pref.getAlcancesYLimitsSegmen()!=null){
				holder.text.setText(pref.getAlcancesYLimitsSegmen());
			}else
				holder.text.setText("");
		}
		if(list.get(position).equals(Attributes.CHKBOXTECHNOLOGIA)){
			if(pref.getAlcancesYLimitsTechnologia()!=null){
				holder.text.setText(pref.getAlcancesYLimitsTechnologia());
			}else
				holder.text.setText("");
		}
		if(list.get(position).equals(Attributes.CHKBOXOTRO1)){
			if(pref.getAlcancesYLimitsOtro1()!=null){
				holder.text.setText(pref.getAlcancesYLimitsOtro1());
			}else
				holder.text.setText("");
		}
		
		if(list.get(position).equals(Attributes.CHKBOXOTRO2)){
			if(pref.getAlcancesYLimitsOtro2()!=null){
				holder.text.setText(pref.getAlcancesYLimitsOtro2());
			}else
				holder.text.setText("");
		}
		if(list.get(position).equals(Attributes.CHKBOXOTRO3)){
			if(pref.getAlcancesYLimitsOtro3()!=null){
				holder.text.setText(pref.getAlcancesYLimitsOtro3());
			}else
				holder.text.setText("");
		}
				
//		holder.text.setOnFocusChangeListener(new OnFocusChangeListener() {
//			
//			public void onFocusChange(View v, boolean hasFocus) {
//			EditText listtext=(EditText)v;
//			map.put(list.get(position), listtext.getText().toString());
//				
//			}
//			
//		});
//				
		return convertView;
	}
	
	
//	public void getListText(){
//		
//		
//		for(int i=0;i<map.size();i++){
//			
//			String str=list.get(i);
//
//			if(str.equals(Attributes.CHKBOXTIEMPO)){
//				pref.setAlcancesYLimits(map.get(str));
//			}
//			if(str.equals(Attributes.CHKBOXCAPACIDAD)){
//				pref.setAlcancesYLimitsCapcidad(map.get(str));
//			}
//			if(str.equals(Attributes.CHKBOXHORARAIOS)){
//				pref.setAlcancesYLimitsHorarios(map.get(str));
//			}
//			if(str.equals(Attributes.CHKBOXCOBERTURA)){
//				pref.setAlcancesYLimitsCobertura(map.get(str));
//			}
//			if(str.equals(Attributes.CHKBOXCOMERCIAL)){
//				pref.setAlcancesYLimitsComercial(map.get(str));
//			}
//			if(str.equals(Attributes.CHKBOXPERSONAL)){
//				pref.setAlcancesYLimitsPersonal(map.get(str));
//			}
//			if(str.equals(Attributes.CHKBOXDEMANDA)){
//				pref.setAlcancesYLimitsDemanda(map.get(str));
//			}
//			if(str.equals(Attributes.CHKBOXDURACION)){
//				pref.setAlcancesYLimitsDuracion(map.get(str));
//			}
//			if(str.equals(Attributes.CHKBOXSEGMEN)){
//				pref.setAlcancesYLimitsSegmen(map.get(str));
//			}
//			if(str.equals(Attributes.CHKBOXTECHNOLOGIA)){
//				pref.setAlcancesYLimitsTechnologia(map.get(str));
//			}
//			if(str.equals(Attributes.CHKBOXOTRO1)){
//				pref.setAlcancesYLimitsOtro1(map.get(str));
//			}
//			if(str.equals(Attributes.CHKBOXOTRO2)){
//				pref.setAlcancesYLimitsOtro2(map.get(str));
//			}
//			if(str.equals(Attributes.CHKBOXOTRO3)){
//				pref.setAlcancesYLimitsOtro3(map.get(str));
//			}
//			
//		}
//	}
//	
	private class ViewHolder{
		EditText text;
		TextView title;
	}

}
