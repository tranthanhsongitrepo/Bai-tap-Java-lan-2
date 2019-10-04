package com.company;

import java.util.ArrayList;

public class PhoneBook {
    private ArrayList<PhoneNumber> phoneNumbers;

    PhoneBook(){
        phoneNumbers = new ArrayList<>();
    }
    public void add(PhoneNumber number){
        phoneNumbers.add(number);
    }

    public PhoneBook getPhoneNumbersByRegion(Integer region){
        String r = "0" + region.toString();
        PhoneBook res = new PhoneBook();
        for (PhoneNumber number : phoneNumbers){
            if (number.getRegion().equals(r)) {
                res.add(number);
            }
        }
        return res;
    }

    public PhoneBook getPhoneNumbersByCountry(int mode){
        PhoneBook res = new PhoneBook();
        for (PhoneNumber phoneNumber : phoneNumbers){
            String country = phoneNumber.getCountry();
            if (mode == 0 || (mode == 1 && country.equals("84")) || (mode == 2 && !country.equals("84"))){
                res.add(phoneNumber);
            }
        }

        return res;
    }

    public int getSize(){
        return phoneNumbers.size();
    }

    public int sumOfPhoneNumbersInRegion(Integer region){
        return this.getPhoneNumbersByRegion(region).getSize();
    }

    public PhoneBook findNumberByLast3Digits(Integer t){
        PhoneBook res = new PhoneBook();
        for (PhoneNumber number : phoneNumbers){
            if (number.getThreeLastDigits().equals(t.toString()))
                res.add(number);
        }

        return res;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        for (PhoneNumber phoneNumber : phoneNumbers){
            res.append(phoneNumber.toString()).append("\n");
        }

        return res.toString();
    }
}
