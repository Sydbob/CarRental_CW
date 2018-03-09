package com.carRental.car;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

//this class is a bit tricky to test since numbers and letters are randomly generated using java.util.Random
public class RegistrationNumTest {

    @Test
    public void getLetter()
    {
        RegistrationNum rn = RegistrationNum.GenRandomRegNum();
        char letter = rn.toString().charAt(0);
        assertEquals(letter, rn.GetLetter());
    }

    @Test
    public void getNumber(){
        RegistrationNum rn = RegistrationNum.GenRandomRegNum();
        String substring = rn.toString().substring(1);
        int number = Integer.parseInt(substring);
        assertEquals(number, rn.GetNumber());
    }

    @Test
    public void genRandomRegNum() {
        boolean unique = true;
        //testing if every single registration number generated is unique by adding every number generated to hashset
        HashSet<RegistrationNum> allRegNums = new HashSet<>();
        for (int i = 1; i < RegistrationNum.MAX_UNIQUE_COMBOS; i++)
        {
            RegistrationNum rn = RegistrationNum.GenRandomRegNum();
            //if a number cannot be added means it's not unique and test failed
            if (!allRegNums.add(rn)) {
                unique = false;
                break;
            }
        }
        assert (unique == true);
    }

    @Test
    public void getStringRep() {
        RegistrationNum rn = RegistrationNum.GenRandomRegNum();
        String toStr = rn.toString();
        assertEquals(toStr, rn.GetStringRep());
    }
}