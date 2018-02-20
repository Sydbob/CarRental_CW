package com.carRental.driver;

public class Name {
    private final String firstName;
    private final String lastName;

    public String GetFirstName() {return firstName; }
    public String GetLastName() {return lastName; }

    public Name(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName= lastName;
    }

    public String GetInitials() {
        String s = "" + firstName.charAt(0) + lastName.charAt(0);
        return s.toUpperCase();
    }
}
