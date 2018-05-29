package com.yxcoach.common.request;


public class Location {

    private String address;
    private String[] latlng;
    
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String[] getLatlng() {
		return latlng;
	}
	public void setLatlng(String[] latlng) {
		this.latlng = latlng;
	}
}
