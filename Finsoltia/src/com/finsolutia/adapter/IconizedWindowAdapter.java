package com.finsolutia.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.finsoltia.R;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.model.Marker;

public class IconizedWindowAdapter implements InfoWindowAdapter {
	LayoutInflater inflater = null;

	public IconizedWindowAdapter(LayoutInflater inflater) {
		this.inflater = inflater;
	}

	@Override
	public View getInfoWindow(Marker marker) {
		return (null);
	}

	@Override
	public View getInfoContents(Marker marker) {

		View popup = inflater.inflate(R.layout.custome_info_window, null);

		TextView textView = (TextView) popup.findViewById(R.id.button_map);
		textView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});

		return (popup);
	}
}