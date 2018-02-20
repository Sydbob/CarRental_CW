package com.carRental;

import java.util.Random;

public class Util {

    //method to generate a random number within min-max range
    public static int GenRandomNumber(int MIN_RANGE, int MAX_RANGE)
    {
        Random rn = new Random();
        int n = rn.nextInt(MAX_RANGE-MIN_RANGE+1) + MIN_RANGE;
        return n;
    }
}
