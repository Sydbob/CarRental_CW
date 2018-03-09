package com.carRental.driver;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class LicenceNum {

    private final String initials;
    private final int year;
    private final int serialNum;
    private static Map<String, Integer> licenceNums = new HashMap<>();
    //map of initials+year to count

    public String GetInitials () {return initials;}
    public int GetYear() {return year;}
    public int GetSerialNum() {return serialNum;}
    public String GetStringRep() {return initials + "-" + year + "-" + serialNum;}


    //copy constructor
    public LicenceNum(LicenceNum licenceNum){
        this.initials = new String(licenceNum.initials);
        this.year = licenceNum.year;
        this.serialNum = licenceNum.serialNum;
    }
    private LicenceNum(Name name, int year, int serialNum)
    {
        this.initials = "" + name.GetFirstName().toUpperCase().charAt(0) + name.GetLastName().toUpperCase().charAt(0);
        this.year= year;
        this.serialNum = serialNum;
    }

    //this assumes that the name+year combo passed are from a unique person (i.e. this assumes that if a duplicate name + year is provided it's a different person)
    public static LicenceNum GenLicenceNum(Name name, int year){
        int serial = 10;
        LocalDate today = LocalDate.now();
        if (year > today.getYear() || year < 1900)
            throw new IllegalArgumentException("Invalid year provided");
        String string = "" + name.GetFirstName() + name.GetLastName() + year;
        //if combination of initials + year + serial number already is taken, increase serial number to make it unique
        if (licenceNums.containsKey(string)){
             serial = licenceNums.get(string) + 1;
             licenceNums.replace(string, serial);
             return new LicenceNum(name, year, serial);
        }
        //otherwise add the new combination to the list
        else{
            licenceNums.put(string,serial);
            return new LicenceNum(name, year, serial);
        }
    }

    @Override
    public String toString() {
        return initials + "-" + year + "-" + serialNum;
    }

    public boolean equals(LicenceNum licenceNum) {
        return this.initials.equals(licenceNum.initials) && this.year == licenceNum.year && this.serialNum == licenceNum.serialNum;
    }
}
