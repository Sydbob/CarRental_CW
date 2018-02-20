package com.carRental;
import com.carRental.car.*;
import com.carRental.driver.*;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        RegistrationNum rn = new RegistrationNum();
        CarFleet carFleet = new CarFleet();


        for (Car c : carFleet.GetSmallCars())
        {
            out.print(c);
        }







    }
}
