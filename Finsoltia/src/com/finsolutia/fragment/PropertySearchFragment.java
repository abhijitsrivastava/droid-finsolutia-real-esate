package com.finsolutia.fragment;

import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.finsoltia.R;
import com.finsolutia.wheelpicker.ArrayWheelAdapter;
import com.finsolutia.wheelpicker.OnWheelChangedListener;
import com.finsolutia.wheelpicker.OnWheelScrollListener;
import com.finsolutia.wheelpicker.WheelView;

public class PropertySearchFragment extends BaseFragment {

	private View propertySearchFragment;
	private Button buttonLookingFor, buttonWhere, buttonDistrict, buttonCounty,
			buttonParish, buttonMoreOption,

			buttonPropertySearch, buttonClear;
	private RelativeLayout relativeLayoutBedroomsFrom,
			relativeLayoutBedroomsTo, relativeLayoutPriceMin,
			relativeLayoutPriceMax;
	private TextView textViewBedroomsFrom, textViewBedroomsTo,
			textViewPriceMin, textViewPriceMax;

	private WheelView wheel;
	private LinearLayout linearlayoutHiddenOption, pickerContainer;
	private LinearLayout linearLayoutParentContainer;
	Bundle savedInstanceState;
	private boolean wheelScrolled = false;

	private enum PickerValueContainer {
		BEDROOMS_FROM, BEDROOMS_TO, PRICE_MIN, PRICE_MAX
	};

	private PickerValueContainer pickerValueContainer;
	String wheelMenu1[] = new String[] { "0","1", "2", "3", "4", "5", "6", "7",
			"8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18",
			"19", "20" };
	Map<Integer, String> list;

	int[] bedRoomRange = new int[21];

	// long [] priceRange = new long[1000001];

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.savedInstanceState = savedInstanceState;

		/*
		 * for(int bedroomIndex=0;bedroomIndex<=20;bedroomIndex++){
		 * bedRoomRange[bedroomIndex]=bedroomIndex; } int priceRangeIndex = 0;
		 * while(priceRangeIndex<=1000000){ priceRangeIndex+=10000; //priceRange
		 * = (float) priceRangeIndex; }
		 */
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		propertySearchFragment = inflater.inflate(
				R.layout.property_search_fragment, container, false);
		// Toast.makeText(homeActivity, "onCreateView", 1).show();
		setUi();
		setFilterValue();
		return propertySearchFragment;
	}

	private void setUi() {
		buttonClear = (Button) propertySearchFragment
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

		buttonWhere = (Button) propertySearchFragment
				.findViewById(R.id.buttonWhere);
		buttonWhere.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				startFragmentForResult(1);
			}
		});

		buttonDistrict = (Button) propertySearchFragment
				.findViewById(R.id.buttonDistrict);
		buttonDistrict.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				startFragmentForResult(2);
			}
		});

		buttonCounty = (Button) propertySearchFragment
				.findViewById(R.id.buttonCounty);
		buttonCounty.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startFragmentForResult(3);

			}
		});

		buttonParish = (Button) propertySearchFragment
				.findViewById(R.id.buttonParish);
		buttonParish.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startFragmentForResult(4);

			}
		});

		buttonMoreOption = (Button) propertySearchFragment
				.findViewById(R.id.buttonMoreOption);
		buttonMoreOption.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (linearlayoutHiddenOption.getVisibility() == View.VISIBLE) {
					inVisibleView(linearlayoutHiddenOption);
					buttonMoreOption.setText("More options");
				} else {
					visibleView(linearlayoutHiddenOption);

					buttonMoreOption.setText("Less options");
				}

			}
		});

		relativeLayoutBedroomsFrom = (RelativeLayout) propertySearchFragment
				.findViewById(R.id.relativeLayoutBedroomsFrom);
		relativeLayoutBedroomsFrom.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pickerValueContainer = PickerValueContainer.BEDROOMS_FROM;
				visibleView(pickerContainer);
			}
		});

		relativeLayoutBedroomsTo = (RelativeLayout) propertySearchFragment
				.findViewById(R.id.relativeLayoutBedroomsTo);
		relativeLayoutBedroomsTo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pickerValueContainer = PickerValueContainer.BEDROOMS_TO;
				// visibleView(pickerContainer);
			}
		});

		relativeLayoutPriceMin = (RelativeLayout) propertySearchFragment
				.findViewById(R.id.relativeLayoutPriceMin);
		relativeLayoutPriceMin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pickerValueContainer = PickerValueContainer.PRICE_MIN;
				// visibleView(pickerContainer);
			}
		});

		relativeLayoutPriceMax = (RelativeLayout) propertySearchFragment
				.findViewById(R.id.relativeLayoutPriceMax);
		relativeLayoutPriceMax.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				pickerValueContainer = PickerValueContainer.PRICE_MAX;
				// visibleView(pickerContainer);
			}
		});
		textViewBedroomsFrom = (TextView) propertySearchFragment
				.findViewById(R.id.textViewBedroomsFrom);
		textViewBedroomsTo = (TextView) propertySearchFragment
				.findViewById(R.id.textViewBedroomsTo);
		textViewPriceMax = (TextView) propertySearchFragment
				.findViewById(R.id.textViewPriceMax);
		textViewPriceMin = (TextView) propertySearchFragment
				.findViewById(R.id.textViewPriceMin);

		buttonPropertySearch = (Button) propertySearchFragment
				.findViewById(R.id.buttonPropertySearch);
		buttonPropertySearch.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				homeActivity.commitFragment(new PropertySearchResultFragment());
			}
		});

		linearlayoutHiddenOption = (LinearLayout) propertySearchFragment
				.findViewById(R.id.linearlayoutHiddenOption);
		pickerContainer = (LinearLayout) propertySearchFragment
				.findViewById(R.id.pickerContainer);

		if (savedInstanceState == null) {
			inVisibleView(linearlayoutHiddenOption);
		}

		wheel = (WheelView) propertySearchFragment.findViewById(R.id.p1);
		wheel.setViewAdapter(new ArrayWheelAdapter(homeActivity, wheelMenu1));
		wheel.setVisibleItems(2);
		wheel.setCurrentItem(0);
		wheel.addChangingListener(changedListener);
		wheel.addScrollingListener(scrolledListener);
		linearLayoutParentContainer = (LinearLayout) propertySearchFragment
				.findViewById(R.id.linearLayoutParentContainer);
		linearLayoutParentContainer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				inVisibleView(pickerContainer);
			}
		});
	}

	OnWheelScrollListener scrolledListener = new OnWheelScrollListener() {
		public void onScrollStarts(WheelView wheel) {
			wheelScrolled = true;
		}

		public void onScrollEnds(WheelView wheel) {
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
	private final OnWheelChangedListener changedListener = new OnWheelChangedListener() {
		public void onChanged(WheelView wheel, int oldValue, int newValue) {
			if (!wheelScrolled) {
				updateStatus();
			}
		}
	};

	/**
	 * Updates entered PIN status
	 */
	private void updateStatus() {

		String whealValue = "" + wheel.getCurrentItem();
		switch (pickerValueContainer) {
		case BEDROOMS_FROM:
			list.put(5, whealValue);
			break;
		case BEDROOMS_TO:
			list.put(6, whealValue);
			break;
		case PRICE_MAX:
			list.put(7, whealValue);
			break;
		case PRICE_MIN:
			list.put(8, whealValue);
			break;

		default:
			break;
		}
		setFilterValue();
	}

	@Override
	public void onAttach(Activity activity) {

		super.onAttach(activity);
		list = homeActivity.listMap;
	}

	private void startFragmentForResult(int i) {
		PropertySearchFilterFragment propertySearchFilterFragment = new PropertySearchFilterFragment();
		Bundle args = new Bundle();
		args.putInt("filterType", i);
		propertySearchFilterFragment.setArguments(args);
		homeActivity.commitFragment(propertySearchFilterFragment);
	}

	private void setFilterValue() {
		setInitialPropertyToButton();

		if (list.get(0) != null) {

			buttonLookingFor.setText(list.get(0));
			buttonLookingFor
					.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);
			visibleView(buttonClear);

		}
		if (list.get(1) != null) {
			buttonWhere.setText(list.get(1));
			buttonWhere.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);
			visibleView(buttonDistrict);

		}
		if (list.get(2) != null) {
			buttonDistrict.setText(list.get(2));
			buttonDistrict.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);
			buttonDistrict.setVisibility(View.VISIBLE);
			visibleView(buttonCounty);

		}
		if (list.get(3) != null) {
			buttonCounty.setText(list.get(3));
			buttonCounty.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);
			buttonCounty.setVisibility(View.VISIBLE);
			visibleView(buttonParish);

		}
		if (list.get(4) != null) {
			buttonParish.setText(list.get(4));
			buttonParish.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);
			buttonParish.setVisibility(View.VISIBLE);

		}
		if (list.get(5) != null) {

			textViewBedroomsFrom.setText(list.get(5));

		}
		if (list.get(6) != null) {

			textViewBedroomsTo.setText(list.get(6));

		}
		if (list.get(7) != null) {

			textViewPriceMax.setText(list.get(7));

		}
		if (list.get(8) != null) {
			textViewPriceMin.setText(list.get(8));
		}
	}

	@Override
	public void onResume() {
		super.onResume();
		inVisibleView(pickerContainer);
	}

	private void visibleView(View view) {
		view.setVisibility(View.VISIBLE);
	}

	private void inVisibleView(View view) {
		view.setVisibility(View.GONE);
	}

	private void setInitialPropertyToButton() {
		buttonLookingFor.setText("Looking for ...");
		buttonLookingFor.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);

		buttonWhere.setText("Where");
		buttonWhere.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);

		buttonDistrict.setText("District");
		inVisibleView(buttonDistrict);

		buttonCounty.setText("County?");
		inVisibleView(buttonCounty);

		buttonParish.setText("Parish?");
		inVisibleView(buttonParish);

		// buttonMoreOption.setText("County?");
		textViewBedroomsFrom.setText("0");
		textViewBedroomsTo.setText("0");
		textViewPriceMax.setText("0");
		textViewPriceMin.setText("0");

	}
}
