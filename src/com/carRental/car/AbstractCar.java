package com.carRental.car;

public abstract class AbstractCar implements Car {
    private final RegistrationNum registrationNum;
    private final int tankCapacity;
    private int fuelLevel;
    private boolean isRented;

    public AbstractCar(RegistrationNum registrationNum, int fuelLevel, boolean isRented, int tankCapacity)
    {
        this.registrationNum = new RegistrationNum(registrationNum.GetLetter(), registrationNum.GetNumber());
        this.tankCapacity = tankCapacity;
        this.fuelLevel = fuelLevel;
        this.isRented = isRented;
    }

    public RegistrationNum GetRegistrationNum() {
        return new RegistrationNum(registrationNum.GetLetter(), registrationNum.GetNumber());
    }
    public int GetTankCapacity() {return tankCapacity;}
    public int GetFuelLevel() {return fuelLevel;}
    public boolean IsTankFull() {
        if (fuelLevel == tankCapacity)
            return true;
        else
            return false;
    }
    public boolean IsRented() {return isRented;}

    public int AddFuel(int amount)
    {
        if(IsTankFull())
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
