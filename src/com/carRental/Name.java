package com.carRental;

public class Name {
    private String firstName;
    private String lastName;

    public String GetFirstName() {return new String(firstName); }
    public String GetLastName() {return new String(lastName); }

    public void SetFirstName(String firstName) {this.firstName = new String(firstName);}
    public void SetLastName(String lastName) {this.lastName = new String(lastName);}
}
