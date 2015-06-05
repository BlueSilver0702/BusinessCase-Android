package com.sergio.businesscase.ui;


import java.util.ArrayList;

import com.sergio.businesscase.R;
import com.sergio.businesscase.helper.Attributes;
import com.sergio.businesscase.helper.MenuAdapterNew;

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

public class ParentMenuFragment extends Fragment implements OnItemClickListener{
	public static int position = -1;
	private GridView parentmenu;
	Intent intent;
	ChildMenuFragment childfragment = new ChildMenuFragment();
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View vi = inflater.inflate(R.layout.parentmenu_fragment, container, false);
		
		parentmenu = (GridView)vi.findViewById(R.id.groupmenu_list);
		parentmenu.setOnItemClickListener(this);
		MenuAdapterNew adapter = new MenuAdapterNew(getActivity());
		parentmenu.setAdapter(adapter);	
		return vi;
	}
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		// TODO Auto-generated method stub
		this.position = position;
		ArrayList<Object> childList = new ArrayList<Object>();
		childList = Attributes.getChildList();
		
		ArrayList<String>tempChild = new ArrayList<String>();
		
		tempChild = (ArrayList<String>)childList.get(position);
		if(tempChild == null){
			switch (position) {
//			case 0:
//				
//				intent= new Intent(context, EsquemaGeneralActivity.class);
//				context.startActivity(intent);
//				
//				break;
			
			case 2:
				intent=new  Intent(getActivity(), IntroductionActivity.class);
				getActivity().startActivity(intent);
				getActivity().overridePendingTransition( R.drawable.pull_in_right ,  R.drawable.push_out_left );
				break;
				
			case 3:
				intent=new  Intent(getActivity(), FillDetailActivity.class);
				intent.putExtra(Attributes.RIESGOS, position);
				getActivity().startActivity(intent);
				getActivity().overridePendingTransition( R.drawable.pull_in_right ,  R.drawable.push_out_left );
				break;
				
				
			case 5:
				intent=new  Intent(getActivity(), AlcancesYLimites.class);
				getActivity().startActivity(intent);
				getActivity().overridePendingTransition( R.drawable.pull_in_right ,  R.drawable.push_out_left );
				break;
			case 7:
				intent=new  Intent(getActivity(), ThreeFieldActivity.class);
				intent.putExtra(Attributes.RESULTADOS, position);
				getActivity().startActivity(intent);
				getActivity().overridePendingTransition( R.drawable.pull_in_right ,  R.drawable.push_out_left );
				break;
				
			case 8:
				intent= new Intent(getActivity(), SupuestosActivity.class);
				getActivity().startActivity(intent);
				getActivity().overridePendingTransition( R.drawable.pull_in_right ,  R.drawable.push_out_left );
				break;
				
			case 11:
				intent = new Intent(getActivity(), SuamrioEjecutivoActivity.class);
				getActivity().startActivity(intent);
				getActivity().overridePendingTransition( R.drawable.pull_in_right ,  R.drawable.push_out_left );
				break;
				
			}
		}else{
			
			FragmentTransaction transation = getFragmentManager().beginTransaction();
			transation.setCustomAnimations(R.drawable.slide_in_left, R.drawable.slide_out_right);
			transation.addToBackStack("b");
			transation.replace(R.id.menu_frame, childfragment).commit();
			
			TextView title = (TextView)getActivity().findViewById(R.id.content_title);
			
			switch(position){
				case 0:
					title.setText("Esquema General");
					break;
					
				case 1:
					title.setText("Propósito del Caso");
					break;
					
				case 4:
					title.setText("Modelo Financiero");
					break;
				case 6:
					title.setText(" Contingencias \ny Dependencias");
					break;
					
				case 9:
					title.setText("Fuente de Datos\n     y Métodos");
					break;
					
				case 10:
					title.setText("   Conclusiones y\n recomendaciones");
					break;
								
			}
		}	
	}

	
}
