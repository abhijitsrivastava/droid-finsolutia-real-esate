package com.finsolutia.adapter;

import java.util.List;

import com.finsoltia.R;
import com.finsolutia.model.ListItem;


import android.app.Service;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PropertySearchAdapter extends ArrayAdapter<ListItem>{
	  public PropertySearchAdapter(Context context, int viewResourceId, List<ListItem> objects) {
	        super(context, viewResourceId, objects);
	    }
	    
	    @Override
	    public View getView(int position, View convertView, ViewGroup parent) {
	        
	      ListItem  item = getItem(position);
	        
	        ViewHolder holder;
	        if (convertView == null) {
	            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Service.LAYOUT_INFLATER_SERVICE);
	            convertView = inflater.inflate(R.layout.property_search_item, parent, false);
	            holder = new ViewHolder();
	            holder.propertyIcon = (ImageView) convertView.findViewById(R.id.imageview_property_image);
	            holder .propertyType = (TextView) convertView.findViewById(R.id.textview_property_type);
	            holder .propertyCounty = (TextView) convertView.findViewById(R.id.textview_property_county);
	            holder .propertyParish = (TextView) convertView.findViewById(R.id.textview_property_parish);
	            holder .propertyBedroom = (TextView) convertView.findViewById(R.id.textview_property_bedrooms);
	            holder .propertyPrice = (TextView) convertView.findViewById(R.id.textview_property_cost);
	            holder.propertyBookmarkIcon = (ImageView) convertView.findViewById(R.id.imageview_property_favourite);
		          
	            convertView.setTag(holder);
	        } else {
	            holder = (ViewHolder) convertView.getTag();
	            
	        }
	        //holder.propertyIcon;
            holder .propertyType.setText(item.getPropertyType());
            holder .propertyCounty.setText(item.getPropertyCounty());
            holder .propertyParish.setText(item.getPropertyParish());
            holder .propertyBedroom.setText(item.getPropertyBedroom());
            holder .propertyPrice.setText(item.getPropertyPrice());
	       
	        
	        return convertView;
	    }
	    
	    /**
	* ViewHolder.
	*/
	    private class ViewHolder {
	        
	       
	    	private String propertyId;
	    	private ImageView propertyIcon;
	    	private Drawable propertyImage;
	    	private TextView propertyType;
	    	private TextView propertyCounty;
	    	private TextView propertyParish;
	    	private TextView propertyBedroom;
	    	private TextView propertyPrice;
	    	private ImageView propertyBookmarkIcon;
	        
	    }
}
