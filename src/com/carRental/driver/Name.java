package com.carRental.driver;

public class Name {
    private final String firstName;
    private final String lastName;

    public String GetFirstName() {return firstName; }
    public String GetLastName() {return lastName; }

    public Name(String firstName, String lastName){
        if (firstName == null || firstName.equals("") || lastName == null || lastName.equals(""))
            throw new IllegalArgumentException("Name or surname cannot be null");
        this.firstName = firstName;
        this.lastName= lastName;
    }

    public String GetInitials() {
        String s = "" + firstName.charAt(0) + lastName.charAt(0);
        return s.toUpperCase();
    }

     public boolean equals(Name name) {
        return this.firstName.equals(name.GetFirstName()) && this.lastName.equals(name.GetLastName());
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
