package com.example.fooddelivery.model;

public class Address {
    private String pincode;
    private String locality;
    private double longitude;
    private double latitude;

    public Address(String pincode, String locality, double longitude, double latitude) {
        this.pincode = pincode;
        this.locality = locality;
        this.longitude = longitude;
        this.latitude = latitude;
    }
    
    public String getPincode() {
        return pincode;
    }
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
    public String getLocality() {
        return locality;
    }
    public void setLocality(String locality) {
        this.locality = locality;
    }
    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }


}
