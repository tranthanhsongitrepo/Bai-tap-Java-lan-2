package com.company;

import java.util.StringTokenizer;

public class PhoneNumber {
    private String phoneNumber;

    PhoneNumber(){}

    PhoneNumber(int region, int phoneNumber){
        this.phoneNumber = "0" + region + "-" + phoneNumber;
    }

    @Override
    public String toString() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getRegion(){
        return phoneNumber.split("-")[0];
    }

    public String getNumber(){
        return phoneNumber.split("-")[1];
    }

    public String getCountry(){
        return "84";
    }

    public String getThreeLastDigits(){
        return phoneNumber.substring(phoneNumber.length() - 4);
    }
}
