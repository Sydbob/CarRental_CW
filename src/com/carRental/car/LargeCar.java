package com.carRental.car;

public class LargeCar extends AbstractCar {

    public LargeCar(RegistrationNum registrationNum, int tankCapacity, int fuelLevel, boolean isRented){
        super(registrationNum, tankCapacity, fuelLevel, isRented);
    }

    public int Drive(int distance){
        return -1;
    }
}
