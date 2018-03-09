package com.carRental;

import com.carRental.car.Car;
import org.junit.Test;

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
    }

    @Test
    public void availableLargeCarID() {
    }

    @Test
    public void getCar() {
    }

    @Test
    public void issueCar() {
    }

    @Test
    public void terminateRental() {
    }
}