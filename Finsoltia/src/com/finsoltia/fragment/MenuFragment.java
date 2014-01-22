package com.finsoltia.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
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
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		menuFragment = inflater.inflate(R.layout.menu, container, false);
		return menuFragment;
	}

	@Override
	public void onResume() {

		super.onResume();
		searchContainer=(LinearLayout)menuFragment.findViewById(R.id.mainContainer);
		mapContainer=(LinearLayout)menuFragment.findViewById(R.id.mapContainer);
		favoriteContainer=(LinearLayout)menuFragment.findViewById(R.id.favoriteContainer);
				
		Button search = (Button) menuFragment.findViewById(R.id.search);
		search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				searchContainer.setBackgroundColor(Color.GRAY);
				mapContainer.setBackgroundColor(Color.TRANSPARENT);
				favoriteContainer.setBackgroundColor(Color.TRANSPARENT);
				homeActivity.commitFragment(R.id.mainContainer, new HomeFragment(), "home", "Home Screen");
			}
		});
		Button map = (Button) menuFragment.findViewById(R.id.map);
		map.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mapContainer.setBackgroundColor(Color.GRAY);
				favoriteContainer.setBackgroundColor(Color.TRANSPARENT);
				searchContainer.setBackgroundColor(Color.TRANSPARENT);
				/*homeActivity.currentTab = "map";
				homeActivity.commitFragment(R.id.mainContainer,
						new MenuFragment(), "map", null);*/

			}
		});
		Button favorite = (Button) menuFragment.findViewById(R.id.favorite);
		favorite.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				favoriteContainer.setBackgroundColor(Color.GRAY);
				mapContainer.setBackgroundColor(Color.TRANSPARENT);
				searchContainer.setBackgroundColor(Color.TRANSPARENT);
				homeActivity.currentTab = "favorite";
				homeActivity.commitFragment(R.id.mainContainer,
						new favoriteFragment(), "favorite", null);
			}
		});
	}

	@Override
	public void onAttach(Activity activity) {
		homeActivity = (HomeActivity) activity;
		super.onAttach(activity);
	}
}
