package com.carRental.car;

public interface Car {
   public RegistrationNum GetRegistrationNum();
   public int GetTankCapacity(); //in whole Litres(L)
   public int GetFuelLevel(); //current fuel level in the car, L
   public boolean TankIsEmpty(); //return true if tank has 0 or less fuel level
   public boolean IsRented(); //return true if a car is currently rented
   public int AddFuel(int amount); //adds fuel to car tank, returns amount it added, doesn't let it go over tank capacity, if no fuel was added returns 0
   public void SetFuel(int amount); //sets fuel level to given number
   public int Drive(int distance); //returns fuel consumed in whole L, based on distance driven,returns -1 if car cannot be driven
   public void SetRented(boolean rented); //sets car's rented status to either true (rented) or false (not rented)

}
