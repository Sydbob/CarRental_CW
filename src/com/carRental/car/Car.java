package com.carRental.car;

public interface Car {
   public RegistrationNum GetRegistrationNum();
   public int GetTankCapacity();
   public int GetFuelLevel();
   public boolean IsTankFull();
   public boolean IsRented();
   public int AddFuel(int amount);
   public int Drive(int distance);

}
