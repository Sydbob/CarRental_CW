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
    public boolean TankIsEmpty() {return fuelLevel <= 0;}
    public boolean IsRented() {return isRented;}

    public int AddFuel(int amount)
    {
        if(amount < 0)
            throw new IllegalArgumentException("Fuel amount cannot be negative number");
        if(fuelLevel == tankCapacity)
            return 0;
        if ((fuelLevel + amount) > tankCapacity)
        {
            int i = tankCapacity - fuelLevel;
            fuelLevel = tankCapacity;
            return i;
        }
        fuelLevel += amount;
        return amount;
    }

    public void SetFuel(int amount) {
        fuelLevel = amount;
        if (fuelLevel > tankCapacity)
            fuelLevel= tankCapacity;
        if (fuelLevel < 0)
            fuelLevel = 0;
    }

    public void SetRented(boolean rented) {
        isRented = rented;
    }


    @Override
    public String toString() {
        String s = "\nCar type: ";
        if (tankCapacity == SmallCar.MAX_TANK_CAPACITY)
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
