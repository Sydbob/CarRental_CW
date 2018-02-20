package com.carRental;

import java.util.Random;

public class RegistrationNum {
    private char letter;
    private int number;

    public char GetLetter() {return letter;}
    public int GetNumber(){return number;}

    public RegistrationNum() {}
    //temp constructor make private/delete later
    public RegistrationNum(char letter, int number){
        this.number = number;
        this.letter = letter;
    }

    //65-90 ascii range for uppercase letters
    public char GenRandomLetter(){
        Random rn = new Random();
        int n = rn.nextInt(90-65+1) + 65;
        char c = (char) n;
        return c;
    }

    //range 1111(inclusive)-9999(inclusive) to make it simpler
    public int GenRandomNumber(){
        Random rn = new Random();
        int n = rn.nextInt(9999-1111+1) + 1111;
        return n;
    }
}
