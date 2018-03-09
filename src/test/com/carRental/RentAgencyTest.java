package com.carRental;

import com.carRental.car.Car;
import com.carRental.driver.DrivingLicence;
import com.carRental.driver.Name;
import org.junit.Test;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class RentAgencyTest {
    RentAgency r = new RentAgency();


    @Test
    public void getRentedCars() {
        r.Populate();
        Set<Car> cars = new HashSet<>();
        for (int i = 0; i < r.GetAllCars().length; i ++){
            if (r.GetAllCars()[i].IsRented())
                cars.add(r.GetAllCars()[i]);
        }
        assertEquals(cars, r.GetRentedCars());
    }

    @Test
    public void getSmallCars() {
        r.Populate();
        Car[] cars = new Car[RentAgency.MAX_SMALL_CARS];
        Car[] cars2 = new Car[RentAgency.MAX_SMALL_CARS];
        //normal case
        for (int i = 0; i < RentAgency.MAX_SMALL_CARS; i ++){
                cars[i] = r.GetAllCars()[i];
        }
        assertArrayEquals(cars, r.GetSmallCars());
        //fail case
        for (int i = 0; i < RentAgency.MAX_SMALL_CARS - 5; i ++){
            cars2[i] = r.GetAllCars()[i];
        }
        assertNotEquals(cars2, r.GetSmallCars());

    }

    @Test
    public void getLargeCars() {
        r.Populate();
        Car[] cars = new Car[RentAgency.MAX_LARGE_CARS];
        //normal case
        int j = 0;
        for (int i = RentAgency.MAX_SMALL_CARS; i <(RentAgency.MAX_LARGE_CARS + RentAgency.MAX_SMALL_CARS); i ++){

            cars[j] = r.GetAllCars()[i];
            j++;
        }
        assertArrayEquals(cars, r.GetLargeCars());
        //fail case
        j = 0;
        for (int i = RentAgency.MAX_SMALL_CARS; i <(RentAgency.MAX_LARGE_CARS + RentAgency.MAX_SMALL_CARS - 5); i ++){

            cars[j] = r.GetAllCars()[i];
            j++;
        }
        assertNotEquals(cars, r.GetLargeCars());

    }


    @Test
    public void populate() {
        r.Populate();
        boolean sPopulated = true;
        boolean lPopulated = true;
        //assert that fleet is fully populated
        for (int i = 0; i < RentAgency.MAX_SMALL_CARS; i++)
        {
            if (r.GetSmallCars()[i] == null) {
                sPopulated = false;
                break;
            }
        }
        for (int i = 0; i < RentAgency.MAX_LARGE_CARS; i++)
        {
            if (r.GetLargeCars()[i] == null) {
                lPopulated = false;
                break;
            }
        }
        assertEquals(true, sPopulated && lPopulated);
    }

    @Test
    public void availableCars() {
        r.Populate();

        //normal case
        assertEquals(30, r.AvailableCars(40));
        assertEquals(20, r.AvailableCars(50));
        //boundry case
        assertEquals(30, r.AvailableCars(1));
        assertEquals(20, r.AvailableCars(60));

        //some cars unavailable
        for (int i = 0; i < 10; i++)
            r.GetSmallCars()[i].SetRented(true);
        assertEquals(20, r.AvailableCars(40));

        //cars are rented out (small unavailable only)
        for (Car c : r.GetSmallCars())
            c.SetRented(true);
        assertEquals(0, r.AvailableCars(49));
        assertEquals(20, r.AvailableCars(60));

        //cars are rented out (all unavailable)
        for (Car c : r.GetAllCars())
            c.SetRented(true);

        //cars are rented out (all unavailable)
        assertEquals(0, r.AvailableCars(49));
        assertEquals(0, r.AvailableCars(60));

        //exception
        boolean thrown = false;
        try{
            r.AvailableCars(500);
        }catch (IllegalArgumentException e)
        {
            thrown = true;
        }
        assertEquals(true, thrown);
    }

    @Test
    public void availableSmallCarID() {
        r.Populate();

        //normal cases
        assertEquals(0, r.AvailableSmallCarID());
        r.GetAllCars()[0].SetRented(true);
        assertEquals(1, r.AvailableSmallCarID());
       for (Car c:  r.GetSmallCars())
           c.SetRented(true);
       //no small cars available
       assertEquals(-1,r.AvailableSmallCarID());
    }

    @Test
    public void availableLargeCarID() {
        r.Populate();
        //normal cases
        assertEquals(0, r.AvailableLargeCarID());
        r.GetLargeCars()[0].SetRented(true);
        assertEquals(1, r.AvailableLargeCarID());
        for (Car c:  r.GetLargeCars())
            c.SetRented(true);
        //no large cars available
        assertEquals(-1,r.AvailableLargeCarID());
    }

    @Test
    public void getCar() {
        r.Populate();
        Calendar doi = Calendar.getInstance();
        Calendar dob = Calendar.getInstance();
        doi.set(2012, 12, 9);
        dob.set(1989, 12,9);
        DrivingLicence dl = new DrivingLicence(new Name("Jon", "Snow"), dob, doi, true);

        //no cars rented
        assertEquals(null, r.GetCar(dl));

        //one car rented
        r.IssueCar(dl, 40);
        assertEquals(r.GetSmallCars()[0], r.GetCar(dl));
        assertNotEquals(r.GetSmallCars()[1], r.GetCar(dl));
        assertEquals(r.GetAllCars()[0], r.GetCar(dl));
        assertNotEquals(r.GetAllCars()[1], r.GetCar(dl));

    }

    @Test
    public void issueCar() {
        r.Populate();

        //normal case
        Calendar doi1 = Calendar.getInstance();
        Calendar dob1 = Calendar.getInstance();
        Calendar doi2 = Calendar.getInstance();
        Calendar dob2 = Calendar.getInstance();
        Calendar dob3 = Calendar.getInstance();
        Calendar doi3 = Calendar.getInstance();
        doi1.set(2000, 12, 9); //more than 5 years of issue
        dob1.set(1989, 12,9); //more than 25 years of age
        doi2.set(2018, 1, 9); //less tha 1 year of issue
        dob2.set(2005, 12,9); //less than 21 years of age
        dob3.set(1994, 1,9); //over 21 but under 25 years of age
        doi3.set(2014, 1, 9); //over 1 but under 5 years of issue
        DrivingLicence dl1 = new DrivingLicence(new Name("Jon", "Snow"), dob1, doi1, true);
        DrivingLicence dl2 = new DrivingLicence(new Name("Mark", "Smith"), dob1, doi1, true);

        //normal cases: can rent small or large car, can rent only 1 car
        assertEquals("A car was successfully issued",  r.IssueCar(dl1, 40 ));
        assertEquals("A car cannot be issued",  r.IssueCar(dl1, 60 ));
        assertEquals("A car was successfully issued",  r.IssueCar(dl2, 60 ));

        //drivers licence failed: underage/not full/less than 1 year of holding licence
        dl1 = new DrivingLicence(new Name("Juan", "Snow"), dob2, doi1, true);
        assertEquals("A car cannot be issued",  r.IssueCar(dl1, 60 ));
        assertEquals("A car cannot be issued",  r.IssueCar(dl1, 40 ));
        dl1 = new DrivingLicence(new Name("Juan", "Snowed"), dob1, doi1, false);
        assertEquals("A car cannot be issued",  r.IssueCar(dl1, 60 ));
        assertEquals("A car cannot be issued",  r.IssueCar(dl1, 40 ));
        dl1 = new DrivingLicence(new Name("Bob", "Snowed"), dob1, doi2, true);
        assertEquals("A car cannot be issued",  r.IssueCar(dl1, 60 ));
        assertEquals("A car cannot be issued",  r.IssueCar(dl1, 40 ));

        //drivers licence failed: over 21 but under 25/over 1 year but under 5 years of holding licence
        dl1 = new DrivingLicence(new Name("Mark", "Snowing"), dob3, doi1, true);
        assertEquals("A car cannot be issued",  r.IssueCar(dl1, 60 ));
        assertEquals("A car was successfully issued",  r.IssueCar(dl1, 40 ));
        dl1 = new DrivingLicence(new Name("Mike", "Jones"), dob1, doi3, true);
        assertEquals("A car cannot be issued",  r.IssueCar(dl1, 60 ));
        assertEquals("A car was successfully issued",  r.IssueCar(dl1, 40 ));

    }

    @Test
    public void terminateRental() {
        r.Populate();
        Calendar doi = Calendar.getInstance();
        Calendar dob = Calendar.getInstance();
        doi.set(2000, 12, 9); //more than 5 years of issue
        dob.set(1989, 12,9); //more than 25 years of age
        DrivingLicence dl = new DrivingLicence(new Name("Mark", "Snowing"), dob, doi, true);

       //customer returns a car with a full tank
        r.IssueCar(dl, 40);
        assertEquals(0, r.TerminateRental(dl));
        //customer returns a car with a tank not full
        r.IssueCar(dl, 40);
        r.GetSmallCars()[0].Drive(400);
        assertEquals(20, r.TerminateRental(dl));
        //customer returns a car with negative fuel
        r.IssueCar(dl, 40);
        r.GetSmallCars()[0].Drive(10000);
        assertEquals(500, r.TerminateRental(dl));
        //customer is not renting a car
        assertEquals(0, r.TerminateRental(dl));

    }
}