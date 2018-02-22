package com.carRental;
import com.carRental.car.*;
import com.carRental.driver.*;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        CarFleet carFleet = new CarFleet();
        carFleet.Populate();


        for (Car c : carFleet.GetAllCars())
        {
            out.print(c);
        }

        out.println("\ndrive 200km, fuel consumed= " + carFleet.GetAllCars()[0].Drive(200));
        out.println("fuel in the tank= " + carFleet.GetAllCars()[0].GetFuelLevel());

        out.println("drive 200km, fuel consumed= " + carFleet.GetSmallCars()[0].Drive(200));
        out.println("fuel in the tank= " + carFleet.GetSmallCars()[0].GetFuelLevel());
        out.println("drive 200km, fuel consumed= " + carFleet.GetSmallCars()[0].Drive(200));
        out.println("fuel in the tank= " + carFleet.GetSmallCars()[0].GetFuelLevel());

        out.println("drive 200km, fuel consumed= " + carFleet.GetLargeCars()[0].Drive(200));
        out.println("fuel in the tank= " + carFleet.GetLargeCars()[0].GetFuelLevel());
        out.println("\ndrive 200km, fuel consumed= " + carFleet.GetAllCars()[5].Drive(200));
        out.println("fuel in the tank= " + carFleet.GetAllCars()[5].GetFuelLevel());




    }
}
