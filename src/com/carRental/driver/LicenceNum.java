package com.carRental.driver;

public class LicenceNum {

    private final String initials;
    private final int year;
    private final int serialNum;

    public String GetInitials () {return initials;}
    public int GetYear() {return year;}
    public int GetSerialNum() {return serialNum;}


    public LicenceNum(String initials, int year, int serialNum)
    {
        this.initials = initials;
        this.year= year;
        this.serialNum = serialNum;
    }

    //may not be necessary later...
    public String StringRep() {return initials + "-" + year + "-" + serialNum;}

    @Override
    public String toString() {
        return initials + "-" + year + "-" + serialNum;
    }
}
