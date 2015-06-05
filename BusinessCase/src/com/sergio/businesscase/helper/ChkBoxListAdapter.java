package com.sergio.businesscase.helper;

import java.util.ArrayList;
import java.util.List;

import com.sergio.businesscase.R;
import com.sergio.businesscase.utils.PreferenceUtils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;


public class ChkBoxListAdapter extends ArrayAdapter<String>{
	Context context;
	public  ArrayList<String> list,schedule_name;
//	AlcancesYLimites alcan;
	PreferenceUtils pref;
	ArrayList<Boolean> status=new ArrayList<Boolean>();
	
	

	public ChkBoxListAdapter(Context context, int textViewResourceId,
			List<String> objects) {
		super(context, textViewResourceId, objects);
		this.context=context;
		list=(ArrayList<String>)objects;
		schedule_name=new ArrayList<String>();
		pref = new PreferenceUtils(context);
		for(int pos=0; pos < list.size();pos++){
		     status.add(pos,false);
		    }
	}

	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder=new ViewHolder();
		if(convertView==null){
			LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView=inflater.inflate(R.layout.checkbox_row, null);	
			viewHolder.text=(TextView)convertView.findViewById(R.id.textView1);
			Typeface fonts = Typeface.createFromAsset(context.getAssets(), "fonts/Calibri.ttf");
			viewHolder.chk=(CheckBox) convertView.findViewById(R.id.chkbox_row);
			viewHolder.text.setTypeface(fonts);
			convertView.setTag(viewHolder);
	
		}
		else{
			viewHolder=(ViewHolder)convertView.getTag();
		
		}
		
			viewHolder.text.setText(list.get(position));
			
		
	        
	        viewHolder.chk.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	      
	        	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
	    
	        		if(isChecked){
	        			status.set(position, true);
	        			schedule_name.add(list.get(position));
	        			Log.d("TAG","checked is"+schedule_name);
	        		}else{
	        			status.set(position, false);
	        			schedule_name.remove(list.get(position));
	        			Log.d("TAG","unchecked is"+schedule_name+"\n status is"+status);
	  
	        		}
	        	}
	        });
	        

	  viewHolder.chk.setChecked(status.get(position));
	  String checkedCheckBox="false";
	  if(pref.getCheckedElement()!= null){
		  
		  checkedCheckBox = pref.getCheckedElement().split("~")[position];
		  viewHolder.chk.setChecked(Boolean.parseBoolean(checkedCheckBox));
	  }
	        
	        return convertView;
		
	}
	
	private class ViewHolder{
	
		TextView text;
		CheckBox chk;
	}
	
	
	public ArrayList<String> getTextList(){
		 String str="";
		  for (int i = 0; i < status.size(); i++) {
			  if(i!=status.size()-1){
				  str = str+String.valueOf(status.get(i))+"~";
			  }else
				  str = str+String.valueOf(status.get(i));
			pref.setCheckedElement(str);
			Log.d("TAG", "String checked is"+str);
		}
		  
		return schedule_name;
		
	}
	
}
