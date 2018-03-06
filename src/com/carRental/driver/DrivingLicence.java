package com.carRental.driver;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;


public class DrivingLicence {

    private final Name name;
    private final LicenceNum licenceNum;
    private final Date dob; //date of birth
    private final Date doi; //date of issue
    private final boolean full; //true if full licence, false if not

    //a constructor to create new drivers licence (generates new unique licence number)
    public DrivingLicence (Name name, Calendar dob, Calendar doi, boolean full)    {
        this.name = new Name(name.GetFirstName(), name.GetLastName());
        LocalDate localDate = doi.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        this.licenceNum = LicenceNum.GenLicenceNum(name, localDate.getYear());
        this.dob = dob.getTime();
        this.doi = doi.getTime();
        this.full = full;
    }

    public Name GetName(){return new Name(name.GetFirstName(), name.GetLastName());}
    public LicenceNum GetLicenceNum() {return new LicenceNum(licenceNum);}
    public Date GetDob () {return new Date(dob.getTime());}
    public Date GetDoi() {return new Date(doi.getTime());}
    public boolean IsFull() {return full;} //true if full licence, false if not

    public boolean equals(DrivingLicence drivingLicence) {
        return this.name.equals(drivingLicence.name) && this.licenceNum.equals(drivingLicence.licenceNum) && this.dob.equals(dob) && this.doi.equals(doi) && this.full == drivingLicence.full;
    }
}
