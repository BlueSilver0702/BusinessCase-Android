package com.sergio.businesscase.helper;

import java.util.ArrayList;

import com.sergio.businesscase.R;

import android.R.string;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.text.NoCopySpan.Concrete;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuAdapterNew extends BaseAdapter{
	
	ArrayList<String> groupList;
	ArrayList<String> sub_scrib;
	Typeface fonts1, fonts2 ;
	private Activity activity;
	private static LayoutInflater inflater=null;
	
	int[] image_source = {R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,R.drawable.menu5,
			R.drawable.menu6,R.drawable.menu7,R.drawable.menu8,R.drawable.menu9,R.drawable.menu10,R.drawable.menu11,R.drawable.menu12};
	
	public MenuAdapterNew(Context context){
		this.groupList = Attributes.getParentList();
		this.sub_scrib = Attributes.getSubDescription();
		fonts1 = Typeface.createFromAsset(context.getAssets(), "fonts/Calibri.ttf");
		fonts2 = Typeface.createFromAsset(context.getAssets(), "fonts/Calibri-bold.ttf");
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
    		vi = inflater.inflate(R.layout.parentmenu_item, parent, false);
    	}
		
		TextView title =(TextView)vi.findViewById(R.id.parent_title);
		title.setTypeface(fonts2);
		title.setText(groupList.get(position));
		
		TextView sub_title = (TextView)vi.findViewById(R.id.child_title);
		sub_title.setTypeface(fonts1);
		sub_title.setText(sub_scrib.get(position));
		
		ImageView img = (ImageView)vi.findViewById(R.id.business_img);
		img.setBackgroundResource(image_source[position]);
		
		return vi;
	}
}
