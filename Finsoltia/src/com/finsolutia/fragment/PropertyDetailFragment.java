package com.finsolutia.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.finsoltia.R;
import com.finsolutia.adapter.IconizedWindowAdapter;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class PropertyDetailFragment extends BaseFragment {

	private static View detailFragment = null;
	private Button detailPropertyBack;
	private GoogleMap googleMap;
	MapFragment mapFragment;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		  
		    
		    	detailFragment = inflater.inflate(R.layout.detail_property, container, false);
		    	detailPropertyBack=(Button)detailFragment.findViewById(R.id.detailPropertyBack);
		    	detailPropertyBack.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						homeActivity.popFragment();
						
					}
				});
		    	int status = GooglePlayServicesUtil
						.isGooglePlayServicesAvailable(getActivity());

				// Check Google Play Service Available
				try {
					if (status != ConnectionResult.SUCCESS) {
						GooglePlayServicesUtil.getErrorDialog(status, getActivity(), 1)
								.show();
					}
				} catch (Exception e) {
					Log.e("Error: GooglePlayServiceUtil: ", "" + e);
				}

				try {
					// Loading map
					initilizeMap();

					// Changing map type
					// googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
					 googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
					 /* googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
					 googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);*/
					// googleMap.setMapType(GoogleMap.MAP_TYPE_NONE);

					// Showing / hiding your current location
					googleMap.setMyLocationEnabled(true);

					// Enable / Disable zooming controls
					googleMap.getUiSettings().setZoomControlsEnabled(true);

					// Enable / Disable my location button
					googleMap.getUiSettings().setMyLocationButtonEnabled(true);

					// Enable / Disable Compass icon
					googleMap.getUiSettings().setCompassEnabled(true);

					// Enable / Disable Rotate gesture
					googleMap.getUiSettings().setRotateGesturesEnabled(true);

					// Enable / Disable zooming functionality
					googleMap.getUiSettings().setZoomGesturesEnabled(true);

					double latitude = 40.416044;
					double longitude = -3.709091;

					// lets place some 10 random markers
					for (int i = 0; i < 10; i++) {
						// random latitude and logitude
						double[] randomLocation = createRandLocation(latitude,
								longitude);

						// Adding a marker
						MarkerOptions marker = new MarkerOptions().position(
								new LatLng(randomLocation[0], randomLocation[1]))
								.title("Hello Maps " + i);
						
						Log.e("Random", "> " + randomLocation[0] + ", "
								+ randomLocation[1]);

						// changing marker color
						if (i == 0)
							marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_red));
						if (i == 1)
							marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_red));
						if (i == 2)
							marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_red));
						if (i == 3)
							marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_red));
						if (i == 4)
							marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_red));
						if (i == 5)
							marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_red));
						if (i == 6)
							marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_red));
						if (i == 7)
							marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_red));
						if (i == 8)
							marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_red));
						if (i == 9)
							marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_red));
							/*marker.icon(BitmapDescriptorFactory
									.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));*/

						googleMap.addMarker(marker);
						

						// Move the camera to last position with a zoom level
						if (i == 9) {
							CameraPosition cameraPosition = new CameraPosition.Builder()
									.target(new LatLng(randomLocation[0],
											randomLocation[1])).zoom(15).build();

							googleMap.animateCamera(CameraUpdateFactory
									.newCameraPosition(cameraPosition));
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
		    


		return detailFragment;
	}

	@Override
	public void onPause() {
		/*Toast.makeText(getActivity(), "onPause",
				Toast.LENGTH_SHORT).show();*/
		super.onPause();
	//	mMapView.onPause();
	}

	@Override
	public void onResume() {
		super.onResume();
		//Toast.makeText(getActivity(), "resume", 1).show();
	     initilizeMap();
		final ScrollView mainScrollView = (ScrollView) detailFragment.findViewById(R.id.main_scrollview);
		ImageView transparentImageView = (ImageView) detailFragment.findViewById(R.id.transparent_image);

		transparentImageView.setOnTouchListener(new View.OnTouchListener() {

		    @Override
		    public boolean onTouch(View v, MotionEvent event) {
		        int action = event.getAction();
		        switch (action) {
		           case MotionEvent.ACTION_DOWN:
		                // Disallow ScrollView to intercept touch events.
		        	   mainScrollView.requestDisallowInterceptTouchEvent(true);
		                // Disable touch on transparent view
		                return false;

		           case MotionEvent.ACTION_UP:
		                // Allow ScrollView to intercept touch events.
		                mainScrollView.requestDisallowInterceptTouchEvent(false);
		                return true;

		           case MotionEvent.ACTION_MOVE:
		                mainScrollView.requestDisallowInterceptTouchEvent(true);
		                return false;

		           default: 
		                return true;
		        }   
		    }

			
		});
		
	}

	/**
	 * function to load map If map is not created it will create it for you
	 * */
	private void initilizeMap(/*Bundle savedInstanceState*/) {
		if (googleMap == null) {
			
		 mapFragment=(MapFragment) getActivity().getFragmentManager().findFragmentById(
				R.id.map1);
		  
	       
		googleMap=mapFragment.getMap();
		googleMap.setInfoWindowAdapter(new IconizedWindowAdapter(
                getActivity().getLayoutInflater()));
			/*googleMap = ( (MapFragment) getActivity().getFragmentManager().findFragmentById(
					R.id.map1)).getMap();*/
			
			// check if map is created successfully or not
			if (googleMap == null) {
				/*Toast.makeText(getActivity(), "Sorry! unable to create maps",
						Toast.LENGTH_SHORT).show();*/
			}
			//removeMapView.removeMap(mMapView,googleMap);
		}
	}

	/*
	 * creating random postion around a location for testing purpose only
	 */
	private double[] createRandLocation(double latitude, double longitude) {

		return new double[] { latitude + ((Math.random() - 0.8) / 100),
				longitude + ((Math.random() - 0.8) / 100),
				500 + ((Math.random() - 0.5) * 20) };
	}
	 
	   

	  
	 @Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	
		
	}

	

	

	
	 
}
