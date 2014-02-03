package com.finsolutia.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.finsoltia.R;

public class PropertySearchFragment extends BaseFragment {

    private View propertySearchFragment;
	private Button buttonLookingFor, buttonWhere, buttonDistrict, buttonCounty,
			buttonParish, buttonMoreOption,
			buttonBedroomsFrom,buttonBedroomsTo,buttonPriceMin,buttonPriceMax,
			buttonPropertySearch;

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
    	    propertySearchFragment = inflater.inflate(R.layout.property_search_fragment, container, false);
    	    setUi();
    	    return propertySearchFragment;
	}
private void setUi() {
	buttonLookingFor=(Button)propertySearchFragment.findViewById(R.id.buttonLookingFor);
	buttonLookingFor.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			startFragmentForResult();
			
		}
	});
	
	buttonWhere=(Button)propertySearchFragment.findViewById(R.id.buttonWhere);
	buttonWhere.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			startFragmentForResult();	
		}
	});
	
	buttonDistrict=(Button)propertySearchFragment.findViewById(R.id.buttonDistrict);
	buttonDistrict.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			startFragmentForResult();
		}
	});
	
	buttonCounty=(Button)propertySearchFragment.findViewById(R.id.buttonCounty);
	buttonCounty.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			startFragmentForResult();
			
		}
	});
	
	buttonParish=(Button)propertySearchFragment.findViewById(R.id.buttonParish);
	buttonParish.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			startFragmentForResult();
			
		}
	});
	
	buttonMoreOption=(Button)propertySearchFragment.findViewById(R.id.buttonMoreOption);
	buttonMoreOption.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			startFragmentForResult();
		}
	});

	buttonBedroomsFrom=(Button)propertySearchFragment.findViewById(R.id.buttonBedroomsFrom);
	buttonBedroomsFrom.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			startFragmentForResult();
		}
	});
	
	buttonBedroomsTo=(Button)propertySearchFragment.findViewById(R.id.buttonBedroomsTo);
	buttonBedroomsTo.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			startFragmentForResult();
			
		}
	});
	
	buttonPriceMin=(Button)propertySearchFragment.findViewById(R.id.buttonPriceMin);
	buttonPriceMin.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			startFragmentForResult();
			
		}
	});

	buttonPriceMax=(Button)propertySearchFragment.findViewById(R.id.buttonPriceMax);
	buttonPriceMax.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			startFragmentForResult();
		}
	});
	
	
	buttonPropertySearch=(Button)propertySearchFragment.findViewById(R.id.buttonPropertySearch);
	buttonPropertySearch.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			homeActivity.commitFragment(new PropertySearchResultFragment());
		}
	});
}
	@Override
	public void onAttach(Activity activity) {
		
		super.onAttach(activity);
	}
	private void startFragmentForResult() {
		homeActivity.commitFragment(new PropertySearchFilterFragment());
	}
}
