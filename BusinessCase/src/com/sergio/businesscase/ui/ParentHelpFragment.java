package com.sergio.businesscase.ui;


import java.util.ArrayList;

import com.sergio.businesscase.R;
import com.sergio.businesscase.helper.Attributes;
import com.sergio.businesscase.helper.MenuAdapterNew;
import com.sergio.businesscase.helper.MenuHelpAdapter;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

public class ParentHelpFragment extends Fragment implements OnItemClickListener{
	public static int position = -1;
	private GridView parentmenu;
	Intent intent;
	ChildHelpFragment childfragment = new ChildHelpFragment();
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View vi = inflater.inflate(R.layout.parentmenu_fragment, container, false);
		
		parentmenu = (GridView)vi.findViewById(R.id.groupmenu_list);
		parentmenu.setOnItemClickListener(this);
		MenuHelpAdapter adapter = new MenuHelpAdapter(getActivity());
		parentmenu.setAdapter(adapter);	
		return vi;
	}
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		// TODO Auto-generated method stub
		this.position = position;
		ArrayList<Object> childList = new ArrayList<Object>();
		childList = Attributes.getHelpChildList();
		
		ArrayList<String>tempChild = new ArrayList<String>();
		
		tempChild = (ArrayList<String>)childList.get(position);
		if(tempChild == null){
			intent= new Intent(getActivity(), TitleDescription.class);
			switch (position) {	
				
				case 2:
					//introducton help message is selected
					
					intent.putExtra(Attributes.TITLETEXT, position);
					getActivity().startActivity(intent);
					break;
				case 3:
					//Riegros help message selected
					intent.putExtra(Attributes.TITLETEXT, position);
					getActivity().startActivity(intent);
					break;
				
					
				case 5:
					//Alcances y limited help message
					
					intent.putExtra(Attributes.TITLETEXT, position);
					getActivity().startActivity(intent);
					break;
					
					
				case 7:
					
					intent.putExtra(Attributes.TITLETEXT, position);
					getActivity().startActivity(intent);
					break;
				case 8:
					
					//supuestos help message is selected
					intent.putExtra(Attributes.TITLETEXT, position);
					getActivity().startActivity(intent);
					break;
					
				case 9:
					
					intent.putExtra(Attributes.TITLETEXT, position);
					getActivity().startActivity(intent);
					break;
				case 10:
				
					intent.putExtra(Attributes.TITLETEXT, position);
					getActivity().startActivity(intent);
					break;
		
				case 11:
					//sumario ejecutivo help message is selected
					intent.putExtra(Attributes.TITLETEXT, position);
					getActivity().startActivity(intent);
					break;
			}
		}else{
			
			FragmentTransaction transation = getFragmentManager().beginTransaction();
			transation.setCustomAnimations(R.drawable.slide_in_left, R.drawable.slide_out_right);
			transation.addToBackStack("b");
			transation.replace(R.id.helplists, childfragment).commit();
		}	
	}

	
}
