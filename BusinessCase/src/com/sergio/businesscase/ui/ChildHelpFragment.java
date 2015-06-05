package com.sergio.businesscase.ui;

import com.sergio.businesscase.R;
import com.sergio.businesscase.helper.Attributes;
import com.sergio.businesscase.helper.ChildHelpAdapter;
import com.sergio.businesscase.helper.ChildMenuAdapter;
import com.sergio.businesscase.helper.MenuAdapterNew;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class ChildHelpFragment extends Fragment implements OnItemClickListener{
	
	GridView childmenu;
	int viewflag = -1;
	Intent intent;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View vi = inflater.inflate(R.layout.childmenu_fragment, container, false);
		
		childmenu = (GridView)vi.findViewById(R.id.childmenun_list);
		childmenu.setOnItemClickListener(this);
		childmenu.setCacheColorHint(Color.TRANSPARENT);
		ChildHelpAdapter adapter = new ChildHelpAdapter(getActivity(), ParentHelpFragment.position);
		childmenu.setAdapter(adapter);	
		return vi;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int childPosition, long arg3) {
		intent = new Intent(getActivity(), TitleDescription.class);
		
		switch (ParentHelpFragment.position) {
			case 0:
				//Esquema general is clicked  setting help message of esquema general
				
				intent.putExtra(Attributes.TITLETEXT, ParentHelpFragment.position);
				intent.putExtra(Attributes.LABEL2, childPosition);
				getActivity().startActivity(intent);
				break;
			
			case 1:
				intent.putExtra(Attributes.TITLETEXT, ParentHelpFragment.position);
				intent.putExtra(Attributes.LABEL2,childPosition);
				getActivity().startActivity(intent);
				
				break;
			case 4:
				intent.putExtra(Attributes.TITLETEXT, ParentHelpFragment.position);
				intent.putExtra(Attributes.LABEL2, childPosition);
				getActivity().startActivity(intent);
				break;
	
			case 6:
				intent.putExtra(Attributes.TITLETEXT, ParentHelpFragment.position);
				intent.putExtra(Attributes.LABEL2, childPosition);
				getActivity().startActivity(intent);
				break;
			
		}
	}
}
