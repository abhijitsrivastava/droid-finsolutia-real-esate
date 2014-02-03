package com.finsolutia.fragment;

import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.finsoltia.R;

public class PropertySearchFilterFragment extends BaseFragment implements OnClickListener{

View propertySearchFilterFragment;
Button buttonAny,buttonNearMe;
ListView listViewFilterContainer;

@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		if (savedInstanceState==null) {
			
		}
		
	}
    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
    	propertySearchFilterFragment = inflater.inflate(R.layout.property_search_filter_fragment, container, false);
	    setUi();
		

		return propertySearchFilterFragment;
	}

	@Override
		public void onAttach(Activity activity) {
			
			super.onAttach(activity);
		}

	private void setUi() {
		
		final String[] MOBILE_OS = new String[] { "Android", "iOS",
				"WindowsMobile", "Blackberry" };
		
		buttonAny = (Button) propertySearchFilterFragment
				.findViewById(R.id.buttonAny);
		buttonAny.setOnClickListener(this);
		buttonNearMe = (Button) propertySearchFilterFragment
				.findViewById(R.id.buttonNearMe);
		buttonNearMe.setOnClickListener(this);
		listViewFilterContainer = (ListView) propertySearchFilterFragment
				.findViewById(R.id.listViewFilterContainer);
		listViewFilterContainer.setAdapter(new ArrayAdapter<String>(
				homeActivity, android.R.layout.simple_list_item_1, MOBILE_OS));
		listViewFilterContainer
				.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						homeActivity.popFragment();

					}
				});
	}
	@Override
	public void onClick(View v) {
		homeActivity.popFragment();
		
	}
}
