package com.carRental.driver;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class DrivingLicenceTest {
    Name n1 = new Name("Mark", "Smith");
    Name n2 = new Name("Mike", "Smith");
    Calendar dob1 = Calendar.getInstance();
    Calendar dob2 = Calendar.getInstance();
    Calendar doi1 = Calendar.getInstance();
    Calendar doi2 = Calendar.getInstance();

    @Test
    public void getName() {
        dob1.set(1993, 10, 12);
        doi1.set(2015, 9,20);
        DrivingLicence dl = new DrivingLicence(n1, dob1, doi1, true);
        assertTrue(n1.equals(dl.GetName()));
        assertFalse(n2.equals(dl.GetName()));
    }

    @Test
    public void getLicenceNum() {
        dob1.set(1993, 10, 12);
        doi1.set(2015, 9,20);
        DrivingLicence dl = new DrivingLicence(n1, dob1, doi1, true);
        assertEquals("MS-2015-10", dl.GetLicenceNum().GetStringRep());
    }

    @Test
    public void getDob() {
        //normal
        dob1.set(1993, 10, 12);
        doi1.set(2015, 9,20);
        Calendar db = Calendar.getInstance();
        db.set(1993, 10, 12);
        DrivingLicence dl = new DrivingLicence(n1, dob1, doi1, true);
        assert(db.getTime().equals(dl.GetDob()));

        //fail case
        db.set(1990,10,11);
        assertFalse(db.getTime().equals(dl.GetDob()));
    }

    @Test
    public void getDoi() {
        //normal
        dob1.set(1993, 10, 12);
        doi1.set(2015, 9,20);
        Calendar di = Calendar.getInstance();
        di.set(2015, 9, 20);
        DrivingLicence dl = new DrivingLicence(n1, dob1, doi1, true);
        assert(di.getTime().equals(dl.GetDoi()));

        //fail case
        di.set(1990,10,11);
        assertFalse(di.getTime().equals(dl.GetDoi()));
    }

    @Test
    public void isFull() {
        dob1.set(1993, 10, 12);
        doi1.set(2015, 9,20);
        DrivingLicence dl = new DrivingLicence(n1, dob1, doi1, true);
        assertEquals(true, dl.IsFull());
        assertFalse(false == dl.IsFull());
    }
}