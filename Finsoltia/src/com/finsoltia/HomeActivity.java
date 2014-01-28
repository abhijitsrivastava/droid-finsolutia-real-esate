package com.finsoltia;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;

import com.finsoltia.fragment.FavoriteFragment;
import com.finsoltia.fragment.FavoriteFragment.HandleFavoriteFragment;
import com.finsoltia.fragment.MenuFragment;
import com.finsoltia.fragment.MenuFragment.MenuClickListioner;
import com.finsoltia.fragment.MyMapFragment;
import com.finsoltia.fragment.MyMapFragment.HandleMapFragment;
import com.finsoltia.fragment.SearchFragment;
import com.finsoltia.fragment.SearchFragment.HandlSeachFragment;



public class HomeActivity extends FragmentActivity implements
		MenuClickListioner, HandleFavoriteFragment, HandleMapFragment,
		HandlSeachFragment{
	public int currentTab;
	
 private FragmentTabHost mTabHost;
	public FragmentManager favoriteFragmentManager,searchFragmentManager,mapFragmentManager;
	FrameLayout search,map,favorite;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		currentTab=0;
		initialCommitFragment(R.id.fragment0, new MenuFragment());
		/*search=(FrameLayout)findViewById(R.id.fragment1);
		map=(FrameLayout)findViewById(R.id.fragment2);
		favorite=(FrameLayout)findViewById(R.id.fragment3);*/
		
	/*	map.setVisibility(View.GONE);
		favorite.setVisibility(View.GONE);*/
		
		initialCommitFragment(R.id.fragment0, new MenuFragment());
		    mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
	        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

	        mTabHost.addTab(mTabHost.newTabSpec("simple").setIndicator("Simple"),
	                SearchFragment.class, null);
	        mTabHost.addTab(mTabHost.newTabSpec("contacts").setIndicator("Contacts"),
	                MyMapFragment.class, null);
	        mTabHost.addTab(mTabHost.newTabSpec("custom").setIndicator("Custom"),
	                FavoriteFragment.class, null);
	        mTabHost.getTabWidget().getChildAt(0).setVisibility(View.GONE);
	        mTabHost.getTabWidget().getChildAt(1).setVisibility(View.GONE);
	        mTabHost.getTabWidget().getChildAt(2).setVisibility(View.GONE);
		/*initialCommitFragment(R.id.fragment1, new SearchFragment());
		initialCommitFragment(R.id.fragment2, new MyMapFragment());
		initialCommitFragment(R.id.fragment3, new FavoriteFragment());*/
		 
	}



	public void initialCommitFragment(int containerId, Fragment fragment) {

		try {
		
			FragmentTransaction fragmentTransaction =getSupportFragmentManager()
					.beginTransaction();
			fragmentTransaction.add(containerId, fragment);
			fragmentTransaction.commit();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}



	@Override
	public void onMenuClicked(int index) {
		currentTab=index;
		mTabHost.setCurrentTab(index);
		
	}

	public void commitFragment(Fragment fragment,int Tab) {
		FragmentTransaction ft;
		switch (Tab) {
		case SearchFragment.TAB_ID:
			ft = searchFragmentManager.beginTransaction();
			ft.replace(R.id.searchContainer, fragment);
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
			ft.addToBackStack(null);
			ft.commit();
			break;
		case MyMapFragment.TAB_ID:
			ft = mapFragmentManager.beginTransaction();
			ft.replace(R.id.mapContainer, fragment);
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
			ft.addToBackStack(null);
			ft.commit();
			break;
		case 2:
			ft = favoriteFragmentManager.beginTransaction();
			ft.replace(R.id.favoriteContainer, fragment);
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
			ft.addToBackStack(null);
			ft.commit();
			break;
		default:
			break;
		}

	}

	public void popFragment() {
		switch (currentTab) {
		case 0:
			searchFragmentManager.popBackStack();

			break;
		case 1:
			mapFragmentManager.popBackStack();

			break;
		case 2:
			favoriteFragmentManager.popBackStack();

			break;
		default:
			break;
		}
		
	}


	@Override
	public void setupSeachPush(FragmentManager fragmentManager) {
		searchFragmentManager=fragmentManager;
		
	}

	@Override
	public void setupMapPush(FragmentManager fragmentManager) {
		mapFragmentManager=fragmentManager;
		
	}
	@Override
	public void setupFavoritePush(FragmentManager fragmentManager) {
		favoriteFragmentManager=fragmentManager;
		
	}



	
	
}
