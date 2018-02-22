package com.carRental.car;

public abstract class AbstractCar implements Car {
    private final RegistrationNum registrationNum;
    private final int tankCapacity;
    private int fuelLevel;
    private boolean isRented;

    public AbstractCar(RegistrationNum registrationNum, int fuelLevel, boolean isRented, int tankCapacity)
    {
        this.registrationNum = new RegistrationNum(registrationNum);
        this.tankCapacity = tankCapacity;
        this.fuelLevel = fuelLevel;
        this.isRented = isRented;
    }

    public RegistrationNum GetRegistrationNum() {
        return new RegistrationNum(registrationNum);
    }
    public int GetTankCapacity() {return tankCapacity;}
    public int GetFuelLevel() {return fuelLevel;}
    public boolean TankIsFull() {return fuelLevel == tankCapacity;}
    public boolean TankIsEmpty() {return fuelLevel <= 0;}
    public boolean IsRented() {return isRented;}

    public int AddFuel(int amount)
    {
        if(TankIsFull())
            return 0;
        fuelLevel += amount;
        if (fuelLevel > tankCapacity)
        {
            int i = tankCapacity - fuelLevel;
            fuelLevel = tankCapacity;
            return i;
        }
        return amount;
    }

    @Override
    public void DeductFuel(int amount) {
         fuelLevel -= amount;
    }

    public int Drive(int distance) {
        //car can only be driven if it's rented and tank is full
        if(!this.TankIsEmpty() && this.IsRented()){
            return this.ConsumeFuel(distance); //consumes the fuel and return amount consumed
        }
        else
            return -1; //return -1 if the car cannot be driven
    }
    @Override
    public String toString() {
        String s = "\nCar type: ";
        if (tankCapacity == 49)
            s += "Small,";
        else
            s+= "Large";
        s+= " Registration No: " + registrationNum + ", Fuel Level: " + fuelLevel + ", Status: ";
        if (isRented)
            s+= "Rented";
        else
            s+= "Not Rented";
        return s;
    }
}
