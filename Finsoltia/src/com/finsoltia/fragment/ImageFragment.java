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

public class ImageFragment extends Fragment{
	
	View menuFragment;
	HomeActivity homeActivity;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		 menuFragment = inflater.inflate(R.layout.image,
				container, false);
		return menuFragment;
	}


}
