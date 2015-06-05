package com.sergio.businesscase.helper;

import java.util.ArrayList;

import com.sergio.businesscase.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ChildHelpAdapter extends BaseAdapter {
	ArrayList<Object>childList = new ArrayList<Object>();
	ArrayList<String>childItem = new ArrayList<String>();
	private Activity activity;
	private static LayoutInflater inflater=null;
	Typeface fonts ;
	
	public ChildHelpAdapter(Context context, int position) {
		childList = Attributes.getHelpChildList();
		childItem = (ArrayList<String>)childList.get(position);
		activity = (Activity)context;
		fonts= Typeface.createFromAsset(context.getAssets(), "fonts/Calibri-bold.ttf");
		inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return childItem.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return childItem.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View contentView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View vi = contentView;
		if(vi==null){
    		vi = inflater.inflate(R.layout.childhelp_item, parent, false);
    	}
		
		TextView title =(TextView)vi.findViewById(R.id.childhelpname);
		title.setTypeface(fonts);
		title.setText(childItem.get(position));
		
		return vi;
	}
}
