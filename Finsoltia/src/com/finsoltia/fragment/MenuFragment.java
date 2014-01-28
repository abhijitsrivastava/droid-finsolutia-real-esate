package com.finsoltia.fragment;

import android.app.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.finsoltia.HomeActivity;
import com.finsoltia.R;

public class MenuFragment extends Fragment {

	View menuFragment;
	HomeActivity homeActivity;
    LinearLayout searchContainer,mapContainer,favoriteContainer;
    MenuClickListioner menuClickListioner;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		menuFragment = inflater.inflate(R.layout.menu, container, false);
		return menuFragment;
	}

	@Override
	public void onResume() {

		super.onResume();
		searchContainer=(LinearLayout)menuFragment.findViewById(R.id.searchContainer);
		mapContainer=(LinearLayout)menuFragment.findViewById(R.id.mapContainer);
		favoriteContainer=(LinearLayout)menuFragment.findViewById(R.id.favoriteContainer);
				
		Button search = (Button) menuFragment.findViewById(R.id.search);
		search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				searchContainer.setBackgroundResource(R.color.gray);
				mapContainer.setBackgroundResource(R.color.white);
				favoriteContainer.setBackgroundResource(R.color.white);
				menuClickListioner.onMenuClicked(0);
				
			}
		});
		Button map = (Button) menuFragment.findViewById(R.id.map);
		map.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mapContainer.setBackgroundResource(R.color.gray);
				favoriteContainer.setBackgroundResource(R.color.white);
				searchContainer.setBackgroundResource(R.color.white);
				menuClickListioner.onMenuClicked(1);
			}
		});
		Button favorite = (Button) menuFragment.findViewById(R.id.favorite);
		favorite.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				favoriteContainer.setBackgroundResource(R.color.gray);
				mapContainer.setBackgroundResource(R.color.white);
				searchContainer.setBackgroundResource(R.color.white);
				menuClickListioner.onMenuClicked(2);
				
			}
		});
	}

	@Override
	public void onAttach(Activity activity) {
		menuClickListioner=(MenuClickListioner) activity;
		super.onAttach(activity);
	}
	
	public interface MenuClickListioner {
		public void onMenuClicked(int index);

	}
}
