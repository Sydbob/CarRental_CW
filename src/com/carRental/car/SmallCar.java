package com.carRental.car;

public class SmallCar extends AbstractCar {
    public final static int MAX_TANK_CAPACITY = 49;

    public SmallCar(RegistrationNum registrationNum, int fuelLevel, boolean isRented){
        super(registrationNum, fuelLevel, isRented, MAX_TANK_CAPACITY);
    }

    @Override
    public int ConsumeFuel(int distance) {
        int amountConsumed = distance / 20;
        this.DeductFuel(amountConsumed);
        return amountConsumed;
    }
}
