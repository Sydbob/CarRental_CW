package com.carRental.car;

import com.carRental.Util;

import java.util.HashSet;
import java.util.Set;


public class RegistrationNum {
    private final char letter;
    private final int number;
    private final String stringRep;
    private static Set<String> numbersSet = new HashSet<>();
    //to make it simpler, registration numbers are in 1000-9999 range
    //letters for registration number are A-Z (capital only) 60-90
    private static final int MIN_LETTER = 65; //ascii
    private static final int MAX_LETTER = 90; //ascii
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 5;
    public static final int MAX_UNIQUE_COMBOS = (MAX_LETTER - MIN_LETTER + 1 ) * (MAX_NUMBER - MIN_NUMBER + 1);

    public char GetLetter() {return letter;}
    public int GetNumber(){return number;}
    //copy constructor
    public RegistrationNum(RegistrationNum rn){ this((rn.GetStringRep()));}

    private RegistrationNum(String str) {
        this.letter = str.charAt(0);
        this.number = Integer.parseInt(str.substring(1));
        this.stringRep = str;
    }

    //validity check fot this method is being handles at a higher level, but
    //as a precaution a count was added to stop the loop from infinitely running
    public static RegistrationNum GenRandomRegNum(){
        String s = "" + (char)Util.GenRandomNumber(MIN_LETTER, MAX_LETTER) + Util.GenRandomNumber(MIN_NUMBER, MAX_NUMBER);
        int count = 0;
        while (!numbersSet.add(s)) {
            s = "" + (char) Util.GenRandomNumber(MIN_LETTER, MAX_LETTER) + Util.GenRandomNumber(MIN_NUMBER, MAX_NUMBER);
            count++;
            if (count == MAX_UNIQUE_COMBOS)
                throw new IndexOutOfBoundsException("No more unique combinations exist");
        }
        return new RegistrationNum(s);
    }

    public String GetStringRep() {return "" + letter + number;}

    @Override
    public String toString() {return stringRep;}


}
