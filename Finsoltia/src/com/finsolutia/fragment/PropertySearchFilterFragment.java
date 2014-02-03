package com.finsolutia.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.finsoltia.R;
import com.finsolutia.adapter.PropertySearchAdapter;
import com.finsolutia.model.ListItem;

public class PropertySearchFilterFragment extends Fragment {

View propertySearchFragment;
List<ListItem> propertyList;

@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		if (savedInstanceState==null) {
			
		}
		
	}
    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
    	propertySearchFragment = inflater.inflate(R.layout.property_search_filter_fragment, container, false);
	
		

		return propertySearchFragment;
	}

	
}
