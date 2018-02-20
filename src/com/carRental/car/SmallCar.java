package com.carRental.car;

public class SmallCar extends AbstractCar {
    public SmallCar(RegistrationNum registrationNum, int tankCapacity, int fuelLevel, boolean isRented){
        super(registrationNum, tankCapacity, fuelLevel, isRented);
    }
    public int Drive(int distance) {return -1;}
}
