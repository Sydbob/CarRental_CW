package com.carRental.car;

public class SmallCar extends AbstractCar {

    public SmallCar(RegistrationNum registrationNum, int fuelLevel, boolean isRented){
        super(registrationNum, fuelLevel, isRented, 49);//49L max tank capacity for small car
    }
    public int Drive(int distance) {return -1;}


}
