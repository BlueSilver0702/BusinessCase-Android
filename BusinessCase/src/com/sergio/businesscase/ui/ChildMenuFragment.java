package com.sergio.businesscase.ui;

import com.sergio.businesscase.R;
import com.sergio.businesscase.helper.Attributes;
import com.sergio.businesscase.helper.ChildMenuAdapter;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class ChildMenuFragment extends Fragment implements OnItemClickListener{
	
	GridView childmenu;
	int viewflag = -1;
	Intent intent;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View vi = inflater.inflate(R.layout.childmenu_fragment, container, false);
		
		childmenu = (GridView)vi.findViewById(R.id.childmenun_list);
		childmenu.setOnItemClickListener(this);
		childmenu.setCacheColorHint(Color.TRANSPARENT);
		ChildMenuAdapter adapter = new ChildMenuAdapter(getActivity(), ParentMenuFragment.position);
		childmenu.setAdapter(adapter);	
		return vi;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int childPosition, long arg3) {
		switch(ParentMenuFragment.position){
			case 0:
				
				intent= new Intent(getActivity(), EsquemaGeneralActivity.class);
				intent.putExtra(Attributes.LABEL2, childPosition);
				getActivity().startActivity(intent);
				getActivity().overridePendingTransition( R.drawable.pull_in_right ,  R.drawable.push_out_left );
				break;
			case 1:
				intent = new Intent(getActivity(), SecondStageActivity.class);
				intent.putExtra(Attributes.LABEL2,childPosition);
				getActivity().startActivity(intent);
				getActivity().overridePendingTransition( R.drawable.pull_in_right ,  R.drawable.push_out_left );
				break;
			case 4:
				if(childPosition==2){
					intent=new Intent(getActivity(), IngresosTabActivity.class);
					intent.putExtra(Attributes.LABEL2, childPosition);
					getActivity().startActivity(intent);
					getActivity().overridePendingTransition( R.drawable.pull_in_right ,  R.drawable.push_out_left );
					
				}else{
				intent=new Intent(getActivity(), ModeloFinancieroActivity.class);
				intent.putExtra(Attributes.LABEL2, childPosition);
				getActivity().startActivity(intent);
				getActivity().overridePendingTransition( R.drawable.pull_in_right ,  R.drawable.push_out_left );
				}
				break;
	
			case 6:
				intent = new Intent(getActivity(), ThreeFieldActivity.class);
				intent.putExtra(Attributes.LABEL3, childPosition);
				getActivity().startActivity(intent);
				getActivity().overridePendingTransition( R.drawable.pull_in_right ,  R.drawable.push_out_left );
				break;
			case 9:
				intent= new Intent(getActivity(), FuentesTabActivity.class);
				intent.putExtra(Attributes.LABEL3, childPosition);
				getActivity().startActivity(intent);
				getActivity().overridePendingTransition( R.drawable.pull_in_right ,  R.drawable.push_out_left );
				break;
			case 10:
				intent = new Intent(getActivity(), ConculsionActivity.class);
				intent.putExtra(Attributes.LABEL3, childPosition);
				getActivity().startActivity(intent);
				getActivity().overridePendingTransition( R.drawable.pull_in_right ,  R.drawable.push_out_left );
				break;
		}
	}
}
