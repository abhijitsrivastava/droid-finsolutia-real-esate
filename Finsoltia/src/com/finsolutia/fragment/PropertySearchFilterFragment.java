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
private final int baseId=12345;
private final int basePrice=540000;
View propertySearchFragment;
List<ListItem> propertyList;

@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		if (savedInstanceState==null) {
			propertyList = new ArrayList<ListItem>();

			for (int i = 0; i < 10; i++) {
				ListItem listItem = new ListItem("" + (baseId + i), getDrawable(),
						"Type" + i, "County " + i, "Parish " + i, i + " Bedroom",
						(i + basePrice) + " $", false);
				propertyList.add(listItem);
			}	
		}
		
	}
    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
    	propertySearchFragment = inflater.inflate(R.layout.property_search_filter_fragment, container, false);
	
		

		return propertySearchFragment;
	}

	private Drawable getDrawable() {
		return new RoundedAvatarDrawable(BitmapFactory.decodeResource(
				getResources(), R.drawable.im_1));
	}
}
