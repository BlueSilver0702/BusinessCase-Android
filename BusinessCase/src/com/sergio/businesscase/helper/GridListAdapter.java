package com.sergio.businesscase.helper;

import java.util.ArrayList;
import java.util.List;

import com.sergio.businesscase.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.TextView;


public class GridListAdapter extends BaseAdapter{
	ArrayList<String> name;
	Context context;
	
	public GridListAdapter(Context context, int textViewResourceId,
			List<String> objects) {
		this.context=context;
		name=(ArrayList<String>)objects;
		
	}

	@Override
	public int getCount() {
		
		return name.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null){
			LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView=inflater.inflate(R.layout.gridview_row, null);
			//ImageView logo= (ImageView)convertView.findViewById(R.id.iv_filelogo);
			TextView filename= (TextView)convertView.findViewById(R.id.tv_filename);
			filename.setText(name.get(position));
		}
		return convertView;
	}

}
