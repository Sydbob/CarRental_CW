package com.carRental;
import com.carRental.car.*;
import com.carRental.driver.DrivingLicence;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;

/*
Author: Irina Kovalova
Student Number: 170716899
Software used: Intellij IDEA, Java v 1.8, Junit v 4.12
OS: Windows 10
Git repository: https://github.com/Sydbob/CarRental_CW/tree/master/src
Last updated: 12/03/2018
Notes: com.carRental folder contains all .java files with developed classes, test folder contains tests for each class.
 */

public class RentAgency {
    private final Car[] smallCars;
    private final Car[] largeCars;
    private Map<DrivingLicence,Car> rentedCars = new HashMap<>();

    public static final int MAX_SMALL_CARS = 30;
    public static final int MAX_LARGE_CARS = 20;
    public static final int MIN_AGE = 21;
    public static final int MIN_LICENCE_YEARS = 1;
    public static final int LARGE_CAR_AGE = 25;
    public static final int LARGE_CAR_LICENCE_YEARS = 5;



    public final Set<Car> GetRentedCars() {return new HashSet<>(rentedCars.values());}
    public final Car[] GetSmallCars() {return Arrays.copyOf(smallCars, smallCars.length);}
    public final Car[] GetLargeCars() {return Arrays.copyOf(largeCars, largeCars.length);}
    public final Car[] GetAllCars() {
        Car[] allCars = new Car[MAX_LARGE_CARS + MAX_SMALL_CARS];
        System.arraycopy(smallCars, 0, allCars, 0,smallCars.length);
        System.arraycopy(largeCars, 0, allCars, smallCars.length, largeCars.length);
        return allCars;
    }

    public RentAgency()
    {
        if (MAX_SMALL_CARS < 0 || MAX_LARGE_CARS < 0)
            throw new IllegalArgumentException("Max cars cannot be negative");
        if (MAX_SMALL_CARS==0 && MAX_LARGE_CARS == 0)
            throw new IllegalArgumentException("Your fleet must have at least 1 car");
        smallCars = new Car[MAX_SMALL_CARS];
        largeCars = new Car[MAX_LARGE_CARS];
    }

    /*Method that populates the fleet
    -All cars are created with a full tank
    -All cars are set to not rented at the start
    -Throws exception if too many cars are provided and it's not possible to have unique registration numbers for them all*/
    public void Populate()
    {
        if ((MAX_LARGE_CARS + MAX_SMALL_CARS) > RegistrationNum.MAX_UNIQUE_COMBOS)
            throw new IllegalArgumentException("Too many cars provided. Decrease amount of cars or increase registration number range.");
        //generate small cars fleet
        for (int i = 0; i< MAX_SMALL_CARS; i++)
        {
            RegistrationNum rn = RegistrationNum.GenRandomRegNum();
            smallCars[i] = new SmallCar(rn, SmallCar.MAX_TANK_CAPACITY, false);
        }
        //generate the large fleet
        for (int i = 0; i< MAX_LARGE_CARS; i++)
        {
            RegistrationNum rn = RegistrationNum.GenRandomRegNum();
            largeCars[i] = new LargeCar(rn, LargeCar.MAX_TANK_CAPACITY, false);
        }
    }

    //This method returns the number of cars of the specified type (based on desired tank capacity) that are available to rent
    public int AvailableCars(int tankCapacity){
        if(tankCapacity <= 0 || tankCapacity > LargeCar.MAX_TANK_CAPACITY)
            throw new IllegalArgumentException("Invalid tank capacity provided");
        int availableCars = 0;
        if (tankCapacity > SmallCar.MAX_TANK_CAPACITY)
        {
            for (Car c: largeCars) {
                if (!c.IsRented())
                    availableCars++;
            }
            return availableCars;
        }
        else
        {
            for (Car c: smallCars) {
                if (!c.IsRented())
                    availableCars++;
            }
            return availableCars;
        }
    }

    //method that finds an id of next available small car
    public int AvailableSmallCarID()
    {
        for (int i =0; i <smallCars.length; i++){
            if (!smallCars[i].IsRented())
            {
                return i;
            }
        }
        return -1;
    }

    //method that finds an id of next available large car
    public int AvailableLargeCarID()
    {
        for (int i =0; i <largeCars.length; i++){
            if (!largeCars[i].IsRented())
            {
                return i;
            }
        }
        return -1;
    }

    //gets a car person is renting, or null if a person is not renting any
    public Car GetCar(DrivingLicence drivingLicence){
        return rentedCars.get(drivingLicence);
    }

    //method to rent out a car to a person
    public String IssueCar(DrivingLicence drivingLicence, int tankCapacity){
        boolean canBeIssued = false;
        LocalDate now = LocalDate.now();
        LocalDate dob = drivingLicence.GetDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate doi = drivingLicence.GetDoi().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int age = Period.between(dob, now).getYears();
        int licenceYears = Period.between(doi, now).getYears();

        //initial check if a person can even rent a car (min requirements: 21 y.o, full licence, 1 year of having licence)
        //cannot be renting more than 1 car
        if (!drivingLicence.IsFull() || age < MIN_AGE || licenceYears < MIN_LICENCE_YEARS || rentedCars.containsKey(drivingLicence))
            return "A car cannot be issued";

        //small car: age 21+, licence years 1+
        if (tankCapacity <= SmallCar.MAX_TANK_CAPACITY)
        {
            if (AvailableCars(tankCapacity) <= 0) {
                return "No cars are available of the required type(small)";
            }
            else{
                int carID = AvailableSmallCarID();
                smallCars[carID].SetRented(true);
                rentedCars.put(drivingLicence, smallCars[carID]);
                return "A car was successfully issued";
            }
        }

        //large car: age 25+, licence years 5+
        if (tankCapacity > SmallCar.MAX_TANK_CAPACITY && tankCapacity <= LargeCar.MAX_TANK_CAPACITY)
        {
            if (age < LARGE_CAR_AGE || licenceYears < LARGE_CAR_LICENCE_YEARS || AvailableCars(tankCapacity) <= 0)
                return "A car cannot be issued";
            else{
                int carID = AvailableLargeCarID();
                largeCars[carID].SetRented(true);
                rentedCars.put(drivingLicence, largeCars[carID]);
                return "A car was successfully issued";
            }
        }

        return "Required car cannot be issued";
    }

    //method to terminate persons car renting contract, returns whole Litres they're liable for if returned car's tank is not full
    public int TerminateRental(DrivingLicence dl){
        if (!rentedCars.containsKey(dl))
            return 0;
        else{
            if (rentedCars.get(dl).GetFuelLevel() < rentedCars.get(dl).GetTankCapacity()){
                int fuelToFill = rentedCars.get(dl).GetTankCapacity() - rentedCars.get(dl).GetFuelLevel();
                rentedCars.get(dl).SetRented(false);
                rentedCars.get(dl).SetFuel(rentedCars.get(dl).GetTankCapacity());
                rentedCars.remove(dl);
                return  fuelToFill;
            }
            else
                return 0;
        }
    }
}
