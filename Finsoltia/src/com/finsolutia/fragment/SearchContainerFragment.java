package com.finsolutia.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.finsoltia.HomeActivity;
import com.finsoltia.R;

public class SearchContainerFragment extends BaseFragment {
	HandleSeachFragment handleSeachFragment;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		homeActivity.commitFragment(new PropertySearchFragment());
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		    View menuFragment = inflater.inflate(R.layout.search_fragment,
				container, false);

		return menuFragment;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		handleSeachFragment=(HandleSeachFragment) activity;
        handleSeachFragment.setupSeachPush(getChildFragmentManager());
		
		
	}
	
	public interface HandleSeachFragment{
		public void setupSeachPush(FragmentManager fragmentManagert); 
		
	}

}
