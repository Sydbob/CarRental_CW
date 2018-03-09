package com.carRental.car;

import org.junit.Test;

import static org.junit.Assert.*;

public class LargeCarTest {

    RegistrationNum rn1 = RegistrationNum.GenRandomRegNum();
    Car sc = new LargeCar(rn1, 60, true);

    @Test
    public void drive() {
        //normal case
        assertEquals(4, sc.Drive(40));
        //boundry case
        assertEquals(1, sc.Drive(1));
        //large numers case
        assertEquals(268, sc.Drive(4000));
        //car cant be driven (tank empty)
        assertEquals(-1, sc.Drive(20));
        sc.SetFuel(40);
        sc.SetRented(false);
        //car cannot be driven (not rented)
        assertEquals(-1, sc.Drive(30));
        //exception
        boolean thrown = false;
        try {
            sc.Drive(-20);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertEquals(true, thrown);
    }
}