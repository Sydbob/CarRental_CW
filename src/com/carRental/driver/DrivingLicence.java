package com.carRental.driver;

import java.util.Date;

public class DrivingLicence {

    private final Name name;
    private final LicenceNum licenceNum;
    private final Date dob; //date of birth
    private final Date doi; //date of issue
    private final boolean full; //ture if full licence, false if not

    public DrivingLicence (Name name, LicenceNum licenceNum, Date dob, Date doi, boolean full)    {
        this.name = new Name(name.GetFirstName(), name.GetLastName());
        this.licenceNum = new LicenceNum(licenceNum.GetInitials(), licenceNum.GetYear(), licenceNum.GetSerialNum());
        this.dob = new Date(dob.getTime());
        this.doi = new Date(dob.getTime());
        this.full = full;
    }

    public Name GetName(){
        return new Name(name.GetFirstName(), name.GetLastName());}

    public LicenceNum GetLicenceNum() {
        return new LicenceNum(licenceNum.GetInitials(),licenceNum.GetYear(), licenceNum.GetSerialNum());
    }
    public Date GetDob () {return new Date(dob.getTime());}
    public Date GetDoi() {return new Date(doi.getTime());}
    public boolean IsFull() {return full;} //true if full licence, false if not

}
