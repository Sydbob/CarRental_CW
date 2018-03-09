package com.carRental;

import static java.lang.System.*;
import com.carRental.car.*;
import com.carRental.driver.DrivingLicence;
import com.carRental.driver.Name;

import java.util.Calendar;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        RentAgency rentAgency = new RentAgency();
        rentAgency.Populate();

        Name n1 = new Name("Mike", "Smith");
        Calendar db1 = Calendar.getInstance();
        Calendar di1 = Calendar.getInstance();
        di1.set(1990, 6,17);
        db1.set(1980, 5,23);
        DrivingLicence l1 = new DrivingLicence(n1, db1, di1, true);
        Name n2 = new Name("Mike", "Smith");
        Calendar db2 = Calendar.getInstance();
        Calendar di2 = Calendar.getInstance();
        di2.set(1996, 6,17);
        db2.set(1996, 5,23);
        DrivingLicence l2 = new DrivingLicence(n2, db2, di2, true);



        int a = rentAgency.AvailableSmallCarID();
        int d = rentAgency.AvailableSmallCarID();

        rentAgency.IssueCar(l2, 60);
        rentAgency.GetSmallCars()[0].Drive(20000);

        //rentAgency.TerminateRental(l1);

        out.println("end");



    }
}
