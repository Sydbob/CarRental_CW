package com.carRental;
import com.carRental.car.*;

import java.util.HashSet;
import java.util.Set;

import static java.lang.System.out;

public class CarFleet {
    private final Car[] smallCars;
    private final Car[] largeCars;
    private static final int MAX_SMALL_CARS = 20;
    private static final int MAX_LARGE_CARS = 10;

    public final Car[] GetSmallCars() {return smallCars;}

    //Class constructor generates the car fleet
    //Registration numbers for cars are generated randomly via given range for letters and numbers
    //All cars are created with a full tank
    //All cars are set to not rented at the start
    public CarFleet()
    {
        smallCars = new Car[MAX_SMALL_CARS];
        largeCars = new Car[MAX_LARGE_CARS];
        Set<String> hashSet = new HashSet<String>();
        String regNum;
        //generate small cars fleet first
        //to make it simpler, registration number range for small cars is 1000-5000 and 5001-9999 for large cars)
        //letters for both small and large cars are generated via ASCII range 65-90 (for upper case A-Z letters)
        for (int i = 0; i< MAX_SMALL_CARS; i++)
        {
            regNum = "" + (char)Util.GenRandomNumber(65,65) + Util.GenRandomNumber(1,20);
            while(!hashSet.add(regNum))
            {
                regNum = "" + (char)Util.GenRandomNumber(65,65) + Util.GenRandomNumber(1,20);
            }
            RegistrationNum rn = new RegistrationNum(regNum);
            smallCars[i] = new SmallCar(rn, 49, false);
        }
        //generate the large fleet same as small fleet
    }
}
