package com.carRental.car;

public class LargeCar extends AbstractCar {

    public LargeCar(RegistrationNum registrationNum, int fuelLevel, boolean isRented){
        super(registrationNum, fuelLevel, isRented, 60); //60L max capacity for large car
    }

    public int Drive(int distance){
        return -1;
    }
}
