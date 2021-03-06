package com.finsolutia.fragment;

import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.finsoltia.R;

public class PropertySearchFilterFragment extends BaseFragment implements OnClickListener{

View propertySearchFilterFragment;
Button buttonAny,buttonNearMe;
ListView listViewFilterContainer;
ArrayAdapter<String> adapter;
EditText edittextSearch;
private   String[] FILTERS ;

String [] lookingFor=new String[] { "Apartment/ Flat",
	    "Detached House", "Garage", "Storage", "Store",
	    "Terranced House", "Urban Land" };
String [] where = {"Espane","Portugal"};
String [] district = {"Andalucia","Belears, Illes","Castilla - La Mancha","Cataluna","Comunitat Valenciana","Madrid, Comunidad de","Region De Murcia"};
String [] county = {"Madrid"};
String [] parish = {"Madrid","Rozas De Madrid, Las","Tielmes","Valdemoro"};


 private int filterType;
@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		filterType=getArguments().getInt("filterType");
		switch (filterType) {
		case 0:
			FILTERS=lookingFor;
			break;
		case 1:
			FILTERS=where;
			break;
		case 2:
			FILTERS=district;
			break;
		case 3:
			FILTERS=county;
			break;
		case 4:
			FILTERS=parish;
			break;

		default:
			break;
		}
		
		
	}
    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
    	propertySearchFilterFragment = inflater.inflate(R.layout.property_search_filter_fragment, container, false);
	    setUi();
		

		return propertySearchFilterFragment;
	}

	@Override
		public void onAttach(Activity activity) {
			
			super.onAttach(activity);
		}

	private void setUi() {
		
		
		edittextSearch=(EditText) propertySearchFilterFragment
		.findViewById(R.id.edittextSearch);
		edittextSearch.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				adapter.getFilter().filter(s);   
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
			
				
			}
		});
		
		buttonAny = (Button) propertySearchFilterFragment
				.findViewById(R.id.buttonAny);
		buttonAny.setOnClickListener(this);
		buttonNearMe = (Button) propertySearchFilterFragment
				.findViewById(R.id.buttonNearMe);
		buttonNearMe.setOnClickListener(this);
		listViewFilterContainer = (ListView) propertySearchFilterFragment
				.findViewById(R.id.listViewFilterContainer);
		
		adapter=new ArrayAdapter<String>(
				homeActivity, android.R.layout.simple_list_item_1, FILTERS);
		
		listViewFilterContainer.setAdapter(adapter);
		listViewFilterContainer
				.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						
						homeActivity.listMap.put(filterType, FILTERS[arg2]);
						
						homeActivity.popFragment();

					}
				});
	}
	@Override
	public void onClick(View v) {
		homeActivity.popFragment();
		
	}
}
