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
import android.widget.ImageView;
import android.widget.TextView;

public class MenuHelpAdapter extends BaseAdapter{

	ArrayList<String> groupList;
	Typeface fonts ;
	Typeface fonts1 ;
	private Activity activity;
	ArrayList<String> sub_scrib;
	private static LayoutInflater inflater=null;
	int[] image_source = {R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,R.drawable.menu5,
			R.drawable.menu6,R.drawable.menu7,R.drawable.menu8,R.drawable.menu9,R.drawable.menu10,R.drawable.menu11,R.drawable.menu12};
	
	public MenuHelpAdapter(Context context){
		this.groupList = Attributes.getParentList();
		fonts= Typeface.createFromAsset(context.getAssets(), "fonts/Calibri-bold.ttf");
		fonts1= Typeface.createFromAsset(context.getAssets(), "fonts/Calibri.ttf");
		this.sub_scrib = Attributes.getSubDescription();
		activity = (Activity)context;
		inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return groupList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return groupList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View contentView, ViewGroup parent) {
		View vi = contentView;
		if(vi==null){
    		vi = inflater.inflate(R.layout.parenthelp_item, parent, false);
    	}
		
		TextView title =(TextView)vi.findViewById(R.id.parenthelp_title);
		title.setTypeface(fonts);
		title.setText(groupList.get(position));
		
		TextView sub_title = (TextView)vi.findViewById(R.id.childhelp_title);
		sub_title.setTypeface(fonts1);
		sub_title.setText(sub_scrib.get(position));
		
		ImageView img = (ImageView)vi.findViewById(R.id.businesshelp_images);
		img.setBackgroundResource(image_source[position]);
		
		return vi;
	}

}
