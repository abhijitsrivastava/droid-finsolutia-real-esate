package com.finsolutia.model;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class ListItem {

	private String propertyId;
	private Drawable propertyImage;
	private String propertyType;
	private String propertyCounty;
	private String propertyParish;
	private String propertyBedroom;
	private String propertyPrice;
	private boolean isBookmark;
	
	
	
	public ListItem(String propertyId, Drawable propertyImage,
			String propertyType, String propertyCounty, String propertyParish,
			String propertyBedroom, String propertyPrice, boolean isBookmark) {
		super();
		this.propertyId = propertyId;
		this.propertyImage = propertyImage;
		this.propertyType = propertyType;
		this.propertyCounty = propertyCounty;
		this.propertyParish = propertyParish;
		this.propertyBedroom = propertyBedroom;
		this.propertyPrice = propertyPrice;
		this.isBookmark = isBookmark;
	}
	public String getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}
	public Drawable getPropertyImage() {
		return propertyImage;
	}
	public void setPropertyImage(Drawable propertyImage) {
		this.propertyImage = propertyImage;
	}
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	public String getPropertyCounty() {
		return propertyCounty;
	}
	public void setPropertyCounty(String propertyCounty) {
		this.propertyCounty = propertyCounty;
	}
	public String getPropertyParish() {
		return propertyParish;
	}
	public void setPropertyParish(String propertyParish) {
		this.propertyParish = propertyParish;
	}
	public String getPropertyBedroom() {
		return propertyBedroom;
	}
	public void setPropertyBedroom(String propertyBedroom) {
		this.propertyBedroom = propertyBedroom;
	}
	public String getPropertyPrice() {
		return propertyPrice;
	}
	public void setPropertyPrice(String propertyPrice) {
		this.propertyPrice = propertyPrice;
	}
	public boolean isBookmark() {
		return isBookmark;
	}
	public void setBookmark(boolean isBookmark) {
		this.isBookmark = isBookmark;
	}
	
	
}
