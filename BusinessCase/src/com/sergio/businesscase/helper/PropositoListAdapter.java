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

public class PropositoListAdapter extends BaseAdapter{

	ArrayList<String> menulist = new ArrayList<String>();
	Typeface fonts ;
	private Activity activity;
	private static LayoutInflater inflater=null;
	
	public PropositoListAdapter(Context context, ArrayList<String> lists){
		menulist = lists;
		fonts= Typeface.createFromAsset(context.getAssets(), "fonts/Calibri-bold.ttf");
		activity = (Activity)context;
		inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return menulist.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return menulist.get(position);
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
    		vi = inflater.inflate(R.layout.childmenu_item, parent, false);
    	}
		
		TextView title =(TextView)vi.findViewById(R.id.childmenuname);
		title.setTypeface(fonts);
		title.setText(menulist.get(position));
		
		return vi;
	}

}
