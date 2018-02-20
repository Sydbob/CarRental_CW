package com.carRental.car;

import com.carRental.Util;


public class RegistrationNum {
    private char letter;
    private int number;
    private String stringRep;

    public char GetLetter() {return letter;}
    public int GetNumber(){return number;}

    public RegistrationNum() {}
    //temp constructor make private/delete later
    public RegistrationNum(char letter, int number){
        this.number = number;
        this.letter = letter;
        this.stringRep = "" + letter + number;
    }

    /*public RegistrationNum GenRegistrationNum() {
        char letter = GenRandomLetter();
        int number = GenRandomNumber();
        String rep = "" + letter + number;
        return new RegistrationNum(letter,number, rep);
    }*/

    public String GenStringRep() {return "" + letter + number;}

    //65-90 ascii range for uppercase letters
    public char GenRandomLetter(){
        return (char) Util.GenRandomNumber(65,90);
    }

    //range 1111(inclusive)-9999(inclusive) to make it simpler
    public int GenRandomNumber(){
        return Util.GenRandomNumber(1111, 9999);
    }

    @Override
    public String toString() { return stringRep; }

}
