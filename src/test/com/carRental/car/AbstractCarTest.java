package com.carRental.car;

import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractCarTest {


    RegistrationNum rn1 = RegistrationNum.GenRandomRegNum();
    RegistrationNum rn2 = RegistrationNum.GenRandomRegNum();

    @Test
    public void getTankCapacity() {
        AbstractCar car = new AbstractCar(rn1, 40, true, 50) {
            @Override
            public int Drive(int distance) {
                return 0;
            }
        };
        assertEquals(50, car.GetTankCapacity());
        assertNotEquals(40, car.GetTankCapacity());
    }

    @Test
    public void getFuelLevel() {
        AbstractCar car = new AbstractCar(rn1, 40, true, 50) {
            @Override
            public int Drive(int distance) {
                return 0;
            }
        };
        assertEquals(40, car.GetFuelLevel());
        assertNotEquals(20, car.GetFuelLevel());
    }

    @Test
    public void tankIsEmpty() {
        AbstractCar car = new AbstractCar(rn1, 40, true, 50) {
            @Override
            public int Drive(int distance) {
                return 0;
            }
        };
        assertEquals(false, car.TankIsEmpty());
    }

    @Test
    public void isRented() {
        AbstractCar car = new AbstractCar(rn1, 40, true, 50) {
            @Override
            public int Drive(int distance) {
                return 0;
            }
        };
        assertEquals(true, car.IsRented());
    }

    @Test
    public void addFuel() {
        AbstractCar car = new AbstractCar(rn1, 40, true, 50) {
            @Override
            public int Drive(int distance) {
                return 0;
            }
        };
        //normal case
        assertEquals(5, car.AddFuel(5));
        //too much fuel
        assertEquals(5, car.AddFuel(20));
        //car is full
        assertEquals(0, car.AddFuel(100));
        //exception
        boolean thrown = false;
        try{
            car.AddFuel(-20);
        }catch (IllegalArgumentException e)
        {
            thrown = true;
        }
        assertEquals(true, thrown);

    }

    @Test
    public void setFuel() {
        AbstractCar c = new AbstractCar(rn1, 10, false, 50) {
            @Override
            public int Drive(int distance) {
                return 0;
            }
        };

        //normal case
        c.SetFuel(20);
        assertEquals(20, c.GetFuelLevel());
        //boundry case
        c.SetFuel(50);
        assertEquals(50, c.GetFuelLevel());
        //our of range cases
        c.SetFuel(500);
        assertEquals(50, c.GetFuelLevel());
        c.SetFuel(-20);
        assertEquals(0, c.GetFuelLevel());
    }

    @Test
    public void setRented() {
        AbstractCar c = new AbstractCar(rn1, 10, false, 50) {
            @Override
            public int Drive(int distance) {
                return 0;
            }
        };

        c.SetRented(true);
        assertEquals(true, c.IsRented());
        c.SetRented(false);
        assertEquals(false, c.IsRented());
    }
}