package com.finsolutia.fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.finsoltia.HomeActivity;

public class BaseFragment extends Fragment {
	HomeActivity homeActivity;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		homeActivity = (HomeActivity) activity;
		
	}

}
