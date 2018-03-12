package com.carRental.car;

public class LargeCar extends AbstractCar {
    public static final int MAX_TANK_CAPACITY = 60;

    public LargeCar(RegistrationNum registrationNum, int fuelLevel, boolean isRented){
        super(registrationNum, fuelLevel, isRented, MAX_TANK_CAPACITY);
    }

    //method to drive a large car, returns fuel consumed in whole L
    public int Drive(int distance) {
        if (distance <= 0)
            throw new IllegalArgumentException("Distance cannot be 0 or less");

        if(!this.TankIsEmpty() && this.IsRented()){
            int amountConsumed;
            if (distance <= 10)
                return 1;
            if (distance > 10 && distance <= 50)
            {
                amountConsumed= distance /10;
                this.SetFuel(this.GetFuelLevel() - amountConsumed);
                return amountConsumed;
            }
            else
            {
                amountConsumed = ((distance - 50) / 15) + (50/ 10);
                this.SetFuel(this.GetFuelLevel() - amountConsumed);
                return amountConsumed;
            }
        }
        else
            return -1; //return -1 if the car cannot be driven
    }

}
