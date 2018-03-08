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



        int a = rentAgency.AvailableSmallCarID();
        int d = rentAgency.AvailableSmallCarID();

        rentAgency.IssueCar(l1, 49);
        rentAgency.GetSmallCars()[0].Drive(200);
        rentAgency.TerminateRental(l1);

        out.println("end");



    }
}
