package com.finsolutia.fragment;

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
import android.widget.TextView;

import com.finsoltia.HomeActivity;
import com.finsoltia.R;

public class MenuFragment extends BaseFragment {

	View menuFragment;
	LinearLayout searchContainer, mapContainer, favoriteContainer;
	MenuClickListioner menuClickListioner;
	TextView menuSearchSelected, menuSearchDeselected, menuMapSelected,
			menuMapDeselected, menuFavoriteSelected, menuFavoriteDeselected;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		menuFragment = inflater.inflate(R.layout.menu, container, false);

		menuSearchSelected = (TextView) inflater.inflate(
				R.layout.menu_search_selected, null);
		menuSearchDeselected = (TextView) inflater.inflate(
				R.layout.menu_search_deselected, null);
		menuMapSelected = (TextView) inflater.inflate(
				R.layout.menu_map_selected, null);
		menuMapDeselected = (TextView) inflater.inflate(
				R.layout.menu_map_deselected, null);
		menuFavoriteSelected = (TextView) inflater.inflate(
				R.layout.menu_favorite_selected, null);
		menuFavoriteDeselected = (TextView) inflater.inflate(
				R.layout.menu_favorite_deselected, null);
		return menuFragment;
	}

	@Override
	public void onResume() {

		super.onResume();
		searchContainer = (LinearLayout) menuFragment
				.findViewById(R.id.linearLayoutMenuSearchContainer);
		mapContainer = (LinearLayout) menuFragment
				.findViewById(R.id.linearLayoutMenuMapContainer);
		favoriteContainer = (LinearLayout) menuFragment
				.findViewById(R.id.linearLayoutMenuFavoriteContainer);

		searchContainer.addView(menuSearchSelected);
		mapContainer.addView(menuMapDeselected);
		favoriteContainer.addView(menuFavoriteDeselected);

		searchContainer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				searchContainer.removeAllViews();
				mapContainer.removeAllViews();
				favoriteContainer.removeAllViews();

				searchContainer.addView(menuSearchSelected);
				mapContainer.addView(menuMapDeselected);
				favoriteContainer.addView(menuFavoriteDeselected);
				menuClickListioner.onMenuClicked(0);

			}
		});

		mapContainer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				searchContainer.removeAllViews();
				mapContainer.removeAllViews();
				favoriteContainer.removeAllViews();

				searchContainer.addView(menuSearchDeselected);
				mapContainer.addView(menuMapSelected);
				favoriteContainer.addView(menuFavoriteDeselected);
				menuClickListioner.onMenuClicked(1);

			}
		});

		favoriteContainer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				searchContainer.removeAllViews();
				mapContainer.removeAllViews();
				favoriteContainer.removeAllViews();

				searchContainer.addView(menuSearchDeselected);
				mapContainer.addView(menuMapDeselected);
				favoriteContainer.addView(menuFavoriteSelected);
				menuClickListioner.onMenuClicked(2);

			}
		});
		/*
		 * Button search = (Button) menuFragment.findViewById(R.id.search);
		 * search.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View v) {
		 * searchContainer.setBackgroundResource(R.color.gray);
		 * mapContainer.setBackgroundResource(R.color.white);
		 * favoriteContainer.setBackgroundResource(R.color.white);
		 * menuClickListioner.onMenuClicked(0);
		 * 
		 * } });
		 */
		/*
		 * Button map = (Button) menuFragment.findViewById(R.id.map);
		 * map.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View v) {
		 * mapContainer.setBackgroundResource(R.color.gray);
		 * favoriteContainer.setBackgroundResource(R.color.white);
		 * searchContainer.setBackgroundResource(R.color.white);
		 * menuClickListioner.onMenuClicked(1); } });
		 */
		/*
		 * Button favorite = (Button) menuFragment.findViewById(R.id.favorite);
		 * favorite.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View v) {
		 * favoriteContainer.setBackgroundResource(R.color.gray);
		 * mapContainer.setBackgroundResource(R.color.white);
		 * searchContainer.setBackgroundResource(R.color.white);
		 * menuClickListioner.onMenuClicked(2);
		 * 
		 * } });
		 */
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		menuClickListioner = (MenuClickListioner) activity;

	}

	public interface MenuClickListioner {
		public void onMenuClicked(int index);

	}
}
