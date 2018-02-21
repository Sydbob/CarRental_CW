package com.carRental.car;

public class LargeCar extends AbstractCar {
    public static final int MAX_TANK_CAPACITY = 60;

    public LargeCar(RegistrationNum registrationNum, int fuelLevel, boolean isRented){
        super(registrationNum, fuelLevel, isRented, MAX_TANK_CAPACITY);
    }

    @Override
    public int ConsumeFuel(int distance) {
        int amountConsumed;
        if (distance <= 50)
        {
             amountConsumed= distance /10;
            this.DeductFuel(amountConsumed);
            return amountConsumed;
        }
        else
        {
            amountConsumed = ((distance - 50) / 15) + (50/ 10);
            this.DeductFuel(amountConsumed);
            return amountConsumed;
        }
    }
}
