package com.finsolutia.fragment;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;

import com.finsoltia.R;
import com.finsolutia.adapter.PropertySearchAdapter;
import com.finsolutia.model.ListItem;

public class PropertySearchResultFragment extends BaseFragment {
private final int baseId=12345;
private final int basePrice=540000;
Button buttonBack;
View propertySearchFragment;
List<ListItem> propertyList;

@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		if (savedInstanceState==null) {
			propertyList = new ArrayList<ListItem>();

			
				ListItem listItem = new ListItem("" + (baseId + 0), null,
						" Apartment / Flat, " , "Madrid, ", "Madrid ", "3 Bed...",
						 "47.000,00"+getResources().getString(R.string.euro), false);
				propertyList.add(listItem);
				
				ListItem listItem1 = new ListItem("" + (baseId + 0), null,
						" Apartment / Flat, " , "Madrid, ", "Madrid ", "2 Bed...",
						 "49.000,00"+getResources().getString(R.string.euro), false);
				propertyList.add(listItem1);
				
				ListItem listItem2 = new ListItem("" + (baseId + 0), null,
						" Apartment / Flat, " , "Madrid, ", "Madrid ", "4 Bed...",
						 "47.000,00"+getResources().getString(R.string.euro), false);
				propertyList.add(listItem2);
		}
		
	}
    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
    	propertySearchFragment = inflater.inflate(R.layout.property_search_result_fragment, container, false);
	
		GridView gridView =(GridView)propertySearchFragment.findViewById(R.id.propertyListGrid);
        gridView.setAdapter(new PropertySearchAdapter(getActivity(),
				R.layout.property_search_item, propertyList));
        gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				homeActivity.commitFragment(new PropertyDetailFragment());
				
			}
		});
        buttonBack=(Button)propertySearchFragment.findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				homeActivity.popFragment();
				
			}
		});
		return propertySearchFragment;
	}

	@Override
		public void onAttach(Activity activity) {
			
			super.onAttach(activity);
		}
}
