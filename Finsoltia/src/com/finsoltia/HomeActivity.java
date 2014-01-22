package com.finsoltia;


import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.finsoltia.fragment.DetailFragment;

public class HomeActivity extends Activity {
	ActionBar actionBar;
	public Button share, back, favorite;
	public String currentTab;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		DetailFragment homeFragment = new DetailFragment();
		commitFragment(R.id.mainContainer, homeFragment, "home", "Home Screen");
		share = (Button) findViewById(R.id.share);
		back = (Button) findViewById(R.id.back);
		favorite = (Button) findViewById(R.id.favorite);
		// setActionbar();

	}

	private void setActionbar() {
		ActionBar actionBar = getActionBar();
		actionBar.setHomeButtonEnabled(true);
		actionBar.setDisplayShowHomeEnabled(true);
		actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		LayoutInflater inflator = (LayoutInflater) this
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v = inflator.inflate(R.layout.actionbar, null);
		share = (Button) v.findViewById(R.id.share);
		back = (Button) v.findViewById(R.id.back);
		favorite = (Button) v.findViewById(R.id.favorite);
		actionBar.setCustomView(v);
		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), currentTab, 1).show();
				popFragment(currentTab);
			}
		});
	}

	public void commitFragment(int containerId, Fragment fragment,
			String addTobackstack, String title) {

		try {
			FragmentTransaction fragmentTransaction = getFragmentManager()
					.beginTransaction();
			fragmentTransaction.replace(containerId, fragment);
			if (addTobackstack != null) {
				fragmentTransaction.addToBackStack(addTobackstack);
			}
			fragmentTransaction.commit();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void popFragment(String name) {
		FragmentManager fm = getFragmentManager();
		fm.popBackStack(currentTab, FragmentManager.POP_BACK_STACK_INCLUSIVE);

	}

}
