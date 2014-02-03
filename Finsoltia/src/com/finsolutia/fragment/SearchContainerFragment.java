package com.finsolutia.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.finsoltia.HomeActivity;
import com.finsoltia.R;

public class SearchContainerFragment extends Fragment {
	HomeActivity homeActivity;
	HandlSeachFragment handlSeachFragment;
	public static final int TAB_ID=0;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		homeActivity.commitFragment(new PropertyDetailFragment(),TAB_ID);
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
		
		handlSeachFragment=(HandlSeachFragment) activity; 
		handlSeachFragment.setupSeachPush(getChildFragmentManager());
		homeActivity=(HomeActivity) activity;
		super.onAttach(activity);
	}
	
	public interface HandlSeachFragment{
		public void setupSeachPush(FragmentManager fragmentManagert); 
		
	}

}
