package com.company;

public class IntPhoneNumber extends PhoneNumber {
    IntPhoneNumber(){}
    IntPhoneNumber(int country, int region, int number){
        super.setPhoneNumber(country + "-" + region + "-" + number);
    }

    @Override
    public String getRegion(){
        return super.getPhoneNumber().split("-")[1];
    }

    public String getNumber(){
        return super.getPhoneNumber().split("-")[2];
    }

    public String getCountry(){
        return super.getPhoneNumber().split("-")[0];
    }


}
