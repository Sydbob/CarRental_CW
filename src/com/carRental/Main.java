package com.carRental;
import com.carRental.car.*;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        RentAgency rentAgency = new RentAgency();
        rentAgency.Populate();


        for (Car c : rentAgency.GetAllCars())
        {
            out.print(c);
        }

        out.println();
        out.println(rentAgency.AvailableCars(49));
        out.println(rentAgency.AvailableCars(4));
        out.println(rentAgency.AvailableCars(60));
        out.println(rentAgency.AvailableCars(50));



    }
}
