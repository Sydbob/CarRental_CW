package com.carRental;
import com.carRental.car.*;

import static java.lang.System.out;

public class CarFleet {
    private final Car[] smallCars;
    private final Car[] largeCars;
    private static final int MAX_SMALL_CARS = 6;
    private static final int MAX_LARGE_CARS = 10;

    public final Car[] GetSmallCars() {return smallCars;}

    //constructs the fleet -> generates all small and large cars
    public CarFleet()
    {
        smallCars = new Car[MAX_SMALL_CARS];
        largeCars = new Car[MAX_LARGE_CARS];

        for (int i = 0; i< MAX_SMALL_CARS; i++)
        {
            //gen reg number, make sure it;s unique, then add a new car w/ it
            boolean unique = false;
            //65-90 range for ASCII upper case letters A-Z (for both small and large cars)
            //to make it simpler, registration number range for small cars is 1000-5000 and 5001-9999 for large cars)
            RegistrationNum rn = new RegistrationNum((char)Util.GenRandomNumber(65,65), Util.GenRandomNumber(1,6));
            if (i == 0){
                smallCars[i] = new SmallCar(rn, 49, false);
                out.print("\nfirst car" + rn);
                }
            while(!unique)
            {
                rn = new RegistrationNum((char)Util.GenRandomNumber(65,65), Util.GenRandomNumber(1,6));
                //check each rn of each car, if not unique, generate rn again, check again until unique
                for (int j = 0; j < MAX_SMALL_CARS; j++)
                {
                    if (smallCars[j] == null)
                        break;
                    else if (smallCars[j] != null && smallCars[j].GetRegistrationNum().equals(rn))
                    {
                        out.print("failed equals, back to generate the number");
                        unique = false;
                        break;
                    }
                    else
                    {
                        unique = true;
                    }
                }

            }
            out.print("\nmaking car " + rn + " " + i);
            smallCars[i] = new SmallCar(rn, 49, false);

        }
        //make sure licences are unique
        //set rented to false for all at the start
        //set tanks to full
    }
}
