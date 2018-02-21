package com.carRental.car;

import com.carRental.Util;

import static java.lang.System.out;


public class RegistrationNum {
    private char letter;
    private int number;
    private String stringRep;

    public char GetLetter() {return letter;}
    public int GetNumber(){return number;}

    public RegistrationNum(String str) {
        this.letter = str.charAt(0);
        this.number = Integer.parseInt(str.substring(1));
    }
    //temp constructor make private/delete later
    public RegistrationNum(char letter, int number){
        this.number = number;
        this.letter = letter;
        this.stringRep = "" + letter + number;
    }


    public String GenStringRep() {return "" + letter + number;}

    @Override
    public String toString() { return stringRep; }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RegistrationNum))
            return false;
        RegistrationNum rn = (RegistrationNum) obj;
        return this.number == rn.number && this.letter == rn.letter;
    }

    /*
    public boolean equals(RegistrationNum rn) {
        return  this.number == rn.GetNumber();
    }*/
}
