package com.carRental.driver;

import org.junit.Test;

import static org.junit.Assert.*;

public class LicenceNumTest {
    Name n1 = new Name("Mark", "Smith");
    Name n2 = new Name("mike", "smith");

    @Test
    public void getInitials() {
        //normal case
        LicenceNum ln = LicenceNum.GenLicenceNum(n1, 1990);
        assertEquals("MS", ln.GetInitials());

        //lower case letters
        LicenceNum ln2 = LicenceNum.GenLicenceNum(n2, 1990);
        assertEquals("MS", ln2.GetInitials());
    }

    @Test
    public void getYear() {
        //normal testing
        LicenceNum ln = LicenceNum.GenLicenceNum(n1, 1993);
        assertEquals(1993, ln.GetYear());
    }

    @Test
    public void getSerialNum() {
        //normal testing
        LicenceNum ln = LicenceNum.GenLicenceNum(n1, 1990);
        assertEquals(10, ln.GetSerialNum());
    }

    @Test
    public void getStringRep() {
        LicenceNum ln = LicenceNum.GenLicenceNum(n2, 2000);
        assertEquals("MS-2000-10", ln.GetStringRep());
    }

    @Test
    public void genLicenceNum() {
        //normal testing
        LicenceNum ln = LicenceNum.GenLicenceNum(n1, 1990);
        assertEquals("MS", ln.GetInitials());
        assertEquals(1990, ln.GetYear());
        assertEquals(10, ln.GetSerialNum());
        assertEquals("MS-1990-10", ln.GetStringRep());


        //boundry testing
        ln= LicenceNum.GenLicenceNum(n1, 1900);
        assertEquals("MS", ln.GetInitials());
        assertEquals(1900, ln.GetYear());
        assertEquals(10, ln.GetSerialNum());
        assertEquals("MS-1900-10", ln.GetStringRep());

        //exception testing
        boolean thrown = false;
        try {
            ln = LicenceNum.GenLicenceNum(n1, 3000);
        }catch (IllegalArgumentException e)
        {
            thrown = true;
        }
        assertEquals(thrown, true);

        //clashing initials and year testing
        LicenceNum ln2= LicenceNum.GenLicenceNum(n2, 1990);
        ln = LicenceNum.GenLicenceNum(n1, 1990);
        assertNotEquals(ln.GetStringRep(), ln2.GetStringRep());
    }
}