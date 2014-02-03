package com.finsolutia.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.finsoltia.HomeActivity;
import com.finsoltia.R;

public class MapContainerFragment extends BaseFragment {
	HandleMapFragment handleMapFragment;
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	
    	homeActivity.commitFragment(new MapDetailFragment());		
    		
           
		
    	
    }
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View menuFragment = inflater.inflate(R.layout.map_fragment,
				container, false);
	
		return menuFragment;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		handleMapFragment=(HandleMapFragment) activity;
		handleMapFragment.setupMapPush(getChildFragmentManager());
		
		
	}
	public interface HandleMapFragment{
		public void setupMapPush(FragmentManager fragmentManagert); 
		
	}
	
}
