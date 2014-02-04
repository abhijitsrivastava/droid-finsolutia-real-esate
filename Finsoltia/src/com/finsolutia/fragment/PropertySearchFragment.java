package com.finsolutia.fragment;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.finsoltia.R;
import com.finsolutia.wheelpicker.ArrayWheelAdapter;
import com.finsolutia.wheelpicker.OnWheelChangedListener;
import com.finsolutia.wheelpicker.OnWheelScrollListener;
import com.finsolutia.wheelpicker.WheelView;
import com.google.android.gms.internal.el;

public class PropertySearchFragment extends BaseFragment {

    private View propertySearchFragment;
	private Button buttonLookingFor, buttonWhere, buttonDistrict, buttonCounty,
			buttonParish, buttonMoreOption,
			buttonBedroomsFrom,buttonBedroomsTo,buttonPriceMin,buttonPriceMax,
			buttonPropertySearch,buttonClear;
    private LinearLayout  linearlayoutHiddenOption;
    Bundle savedInstanceState;
    private boolean wheelScrolled = false;
	String wheelMenu1[] = new String[]{"Country 1", "Country 2", "Country 3", "Country 4", "Country 5"};

    
@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.savedInstanceState=savedInstanceState;
		
	}
    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
    	    propertySearchFragment = inflater.inflate(R.layout.property_search_fragment, container, false);
    	    Toast.makeText(homeActivity, "onCreateView", 1).show();
    	    setUi();
    	    setFilterValue();
    	    return propertySearchFragment;
	}

	private void setUi() {
		buttonClear= (Button) propertySearchFragment
				.findViewById(R.id.buttonClear);
		buttonClear.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				homeActivity.listMap.clear();
                setFilterValue();
			}
		});
		inVisibleView(buttonClear);
		buttonLookingFor = (Button) propertySearchFragment
				.findViewById(R.id.buttonLookingFor);
		buttonLookingFor.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startFragmentForResult(0);

			}
		});

	buttonWhere =(Button)propertySearchFragment.findViewById(R.id.buttonWhere);
	buttonWhere.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			startFragmentForResult(1);	
		}
	});
	
	buttonDistrict=(Button)propertySearchFragment.findViewById(R.id.buttonDistrict);
	buttonDistrict.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			startFragmentForResult(2);
		}
	});
	
	buttonCounty=(Button)propertySearchFragment.findViewById(R.id.buttonCounty);
	buttonCounty.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			startFragmentForResult(3);
			
		}
	});
	
	buttonParish=(Button)propertySearchFragment.findViewById(R.id.buttonParish);
	buttonParish.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			startFragmentForResult(4);
			
		}
	});
	
	buttonMoreOption=(Button)propertySearchFragment.findViewById(R.id.buttonMoreOption);
	buttonMoreOption.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			if (linearlayoutHiddenOption.getVisibility()==View.VISIBLE) {
				inVisibleView(linearlayoutHiddenOption);
				buttonMoreOption.setText("More options");
			}else{
				visibleView(linearlayoutHiddenOption);
				
				buttonMoreOption.setText("Less options");
			}
			
		}
	});

	buttonBedroomsFrom=(Button)propertySearchFragment.findViewById(R.id.buttonBedroomsFrom);
	buttonBedroomsFrom.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			
		}
	});
	
	buttonBedroomsTo=(Button)propertySearchFragment.findViewById(R.id.buttonBedroomsTo);
	buttonBedroomsTo.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			
		}
	});
	
	buttonPriceMin=(Button)propertySearchFragment.findViewById(R.id.buttonPriceMin);
	buttonPriceMin.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
		
			
		}
	});

	buttonPriceMax=(Button)propertySearchFragment.findViewById(R.id.buttonPriceMax);
	buttonPriceMax.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			
		}
	});
	
	
	buttonPropertySearch=(Button)propertySearchFragment.findViewById(R.id.buttonPropertySearch);
	buttonPropertySearch.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			homeActivity.commitFragment(new PropertySearchResultFragment());
		}
	});
	
	
	linearlayoutHiddenOption=(LinearLayout)propertySearchFragment.findViewById(R.id.linearlayoutHiddenOption);
	if (savedInstanceState == null) {
		inVisibleView(linearlayoutHiddenOption);
	}
	
	WheelView wheel = (WheelView) propertySearchFragment.findViewById(R.id.p1);
	wheel.setViewAdapter(new ArrayWheelAdapter(homeActivity,wheelMenu1));
	wheel.setVisibleItems(2);
	wheel.setCurrentItem(0);
	wheel.addChangingListener(changedListener);
	wheel.addScrollingListener(scrolledListener);
}
	
	OnWheelScrollListener scrolledListener = new OnWheelScrollListener()
	{
		public void onScrollStarts(WheelView wheel)
			{
				wheelScrolled = true;
			}

		public void onScrollEnds(WheelView wheel)
			{
				wheelScrolled = false;
				updateStatus();
			}

		@Override
		public void onScrollingStarted(WheelView wheel) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onScrollingFinished(WheelView wheel) {
			// TODO Auto-generated method stub
			
		}
	};

// Wheel changed listener
private final OnWheelChangedListener changedListener = new OnWheelChangedListener()
	{
		public void onChanged(WheelView wheel, int oldValue, int newValue)
			{
				if (!wheelScrolled)
					{
						updateStatus();
					}
			}
	};

/**
 * Updates entered PIN status
 */
private void updateStatus()
	{
		//text1.setText(wheelMenu1[getWheel(R.id.p1).getCurrentItem()]);
			
	}
	
	@Override
	public void onAttach(Activity activity) {
		
		super.onAttach(activity);
		Toast.makeText(homeActivity, "onAttach", 1).show();
	}
	private void startFragmentForResult(int i) {
		PropertySearchFilterFragment propertySearchFilterFragment=new PropertySearchFilterFragment();
		Bundle args = new Bundle();
        args.putInt("filterType", i);
        propertySearchFilterFragment.setArguments(args);
		homeActivity.commitFragment(propertySearchFilterFragment);
	}
	
	private void setFilterValue() {
		setInitialPropertyToButton();
		Map<Integer, String> list=homeActivity.listMap;
		if (list.get(0) != null) {
			
			buttonLookingFor.setText(list.get(0));
			buttonLookingFor.setGravity(Gravity.CENTER_VERTICAL|Gravity.RIGHT);
			visibleView(buttonClear);
		
		}  if (list.get(1) != null) {
			buttonWhere.setText(list.get(1));
			buttonWhere.setGravity(Gravity.CENTER_VERTICAL|Gravity.RIGHT);
			visibleView(buttonDistrict);
			
			
		}  if (list.get(2) != null) {
			buttonDistrict.setText(list.get(2));
			buttonDistrict.setGravity(Gravity.CENTER_VERTICAL|Gravity.RIGHT);
			buttonDistrict.setVisibility(View.VISIBLE);
			visibleView(buttonCounty);
			
		}  if (list.get(3) != null) {
			buttonCounty.setText(list.get(3));
			buttonCounty.setGravity(Gravity.CENTER_VERTICAL|Gravity.RIGHT);
			buttonCounty.setVisibility(View.VISIBLE);
			visibleView(buttonParish);
			
		}  if (list.get(4) != null) {
			buttonParish.setText(list.get(4));
			buttonParish.setGravity(Gravity.CENTER_VERTICAL|Gravity.RIGHT);
			buttonParish.setVisibility(View.VISIBLE);
			
			
		}  if (list.get(5) != null) {
			
			
			
		}  if (list.get(6) != null) {
			
			
			
		}  if (list.get(7) != null) {
			
			
			
		}  if (list.get(8) != null) {
			
		}
	}
	@Override
	public void onResume() {
		super.onResume();
		
	}
	private void visibleView(View view) {
		view.setVisibility(View.VISIBLE);
	}
	private void inVisibleView(View view) {
		view.setVisibility(View.GONE);
	}
	private void setInitialPropertyToButton() {
		buttonLookingFor.setText("Looking for ...");
		buttonLookingFor.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
		
		buttonWhere.setText("Where");
		buttonWhere.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
		
		buttonDistrict.setText("District"); 
		inVisibleView(buttonDistrict);
		
		buttonCounty.setText("County?");
		inVisibleView(buttonCounty);
		
		buttonParish.setText("Parish?");
		inVisibleView(buttonParish);
		
		//buttonMoreOption.setText("County?");
		buttonBedroomsFrom.setText("From?");
		buttonBedroomsTo.setText("To?");
		buttonPriceMin.setText("Min?");
		buttonPriceMax.setText("Max?");
		
		
	}
}
