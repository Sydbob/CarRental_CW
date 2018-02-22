package com.carRental;
import com.carRental.car.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class CarFleet {
    private final Car[] smallCars;
    private final Car[] largeCars;
    private static final int MAX_SMALL_CARS = 5;
    private static final int MAX_LARGE_CARS = 5;
    private static final int MIN_LETTER = 65; //ascii
    private static final int MAX_LETTER = 66; //ascii
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 5;

    public final Car[] GetSmallCars() {return Arrays.copyOf(smallCars, smallCars.length);}
    public final Car[] GetLargeCars() {return Arrays.copyOf(largeCars, largeCars.length);}
    public final Car[] GetAllCars() {
        Car[] allCars = new Car[MAX_LARGE_CARS + MAX_SMALL_CARS];
        System.arraycopy(smallCars, 0, allCars, 0,smallCars.length);
        System.arraycopy(largeCars, 0, allCars, smallCars.length, largeCars.length);
        return allCars;
    }

    public CarFleet()
    {
        smallCars = new Car[MAX_SMALL_CARS];
        largeCars = new Car[MAX_LARGE_CARS];
    }

    /*Method that populates the fleet
    -All cars are created with a full tank
    -All cars are set to not rented at the start*/
    public void Populate()
    {
        //to make it simpler, registration number range for small cars is 1000-5000 and 5001-9999 for large cars)
        //letters for both small and large cars are generated via ASCII range 65-90 (for upper case A-Z letters)

        //generate small cars fleet first
        for (int i = 0; i< MAX_SMALL_CARS; i++)
        {
            RegistrationNum rn = RegistrationNum.GenRandomRegNum(MIN_LETTER,MAX_LETTER,MIN_NUMBER,MAX_NUMBER);
            smallCars[i] = new SmallCar(rn, SmallCar.MAX_TANK_CAPACITY, true);
        }
        //generate the large fleet same as small fleet
        for (int i = 0; i< MAX_LARGE_CARS; i++)
        {
            RegistrationNum rn = RegistrationNum.GenRandomRegNum(MIN_LETTER, MAX_LETTER, MIN_NUMBER, MAX_NUMBER);
            largeCars[i] = new LargeCar(rn, LargeCar.MAX_TANK_CAPACITY, true);
        }
    }
}
