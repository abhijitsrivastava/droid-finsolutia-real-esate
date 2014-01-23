package com.finsoltia.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.finsoltia.HomeActivity;
import com.finsoltia.R;

public class favoriteFragment extends Fragment {
	HomeActivity mainactivity;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View menuFragment = inflater.inflate(R.layout.favorite_fragment,
				container, false);
		

	
		return menuFragment;
	}

	@Override
	public void onAttach(Activity activity) {
		mainactivity = (HomeActivity) activity;
		/*
		 * mainactivity.share.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View v) { mainactivity.finish();
		 * 
		 * } });
		 */
		super.onAttach(activity);
	}

}
