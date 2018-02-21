package com.carRental.car;

public interface Car {
   public RegistrationNum GetRegistrationNum();
   public int GetTankCapacity();
   public int GetFuelLevel();
   public boolean TankIsFull();
   public boolean TankIsEmpty();
   public boolean IsRented();
   public int AddFuel(int amount);
   public void DeductFuel(int amount);
   public int Drive(int distance);
   public int ConsumeFuel(int distance);

}
