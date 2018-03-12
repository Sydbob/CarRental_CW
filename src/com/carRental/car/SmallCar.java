package com.carRental.car;

public class SmallCar extends AbstractCar {
    public final static int MAX_TANK_CAPACITY = 49;

    public SmallCar(RegistrationNum registrationNum, int fuelLevel, boolean isRented){
        super(registrationNum, fuelLevel, isRented, MAX_TANK_CAPACITY);
    }

    //method to driv a large car, return fuel consumed in whole L
    public int Drive(int distance) {
        if (distance <= 0)
            throw new IllegalArgumentException("Distance cannot be 0 or less");
        if(!this.TankIsEmpty() && this.IsRented()){
            if (distance <= 20)
                return 1;
            int amountConsumed = distance / 20;
            this.SetFuel(this.GetFuelLevel() - amountConsumed);
            return amountConsumed;
        }
        else
            return -1; //return -1 if the car cannot be driven
    }

}
