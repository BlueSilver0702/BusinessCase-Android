package com.sergio.businesscase.helper;

import com.sergio.businesscase.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class DialogeListAdapter extends ArrayAdapter<String>{
	Context _mContext;
	String[] dialogeItem;

	public DialogeListAdapter(Context context,int textViewResourceId, String[] objects) {
		super(context, textViewResourceId, objects);
		_mContext = context;
		dialogeItem = objects;		
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater)_mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		convertView = inflater.inflate(R.layout.inner_dialoge_row, null);
		TextView textrow = (TextView)convertView.findViewById(R.id.tv_inner_dialoge_text);
		textrow.setText(dialogeItem[position]);
		return convertView;
	}

}
