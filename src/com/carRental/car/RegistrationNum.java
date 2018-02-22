package com.carRental.car;

import com.carRental.Util;

import java.util.HashSet;
import java.util.Set;

import static java.lang.System.out;


public class RegistrationNum {
    private final char letter;
    private final int number;
    private final String stringRep;
    private static Set<String> numbersSet = new HashSet<String>();

    public char GetLetter() {return letter;}
    public int GetNumber(){return number;}

    //copy constructor
    public RegistrationNum(RegistrationNum rn){ this((rn.GetStringRep()));}

    private RegistrationNum(String str) {
        this.letter = str.charAt(0);
        this.number = Integer.parseInt(str.substring(1));
        this.stringRep = new String(str);
    }

    public static RegistrationNum GenRandomRegNum(int MIN_LETTER, int MAX_LETTER, int MIN_NUMBER, int MAX_NUMBER){
        String s = "" + (char)Util.GenRandomNumber(MIN_LETTER,MAX_LETTER) + Util.GenRandomNumber(MIN_NUMBER, MAX_NUMBER);
        while (!numbersSet.add(s))
            s = "" + (char)Util.GenRandomNumber(MIN_LETTER,MAX_LETTER) + Util.GenRandomNumber(MIN_NUMBER, MAX_NUMBER);
        return new RegistrationNum(s);
    }

    public String GetStringRep() {return "" + letter + number;}

    @Override
    public String toString() { return stringRep; }


}
