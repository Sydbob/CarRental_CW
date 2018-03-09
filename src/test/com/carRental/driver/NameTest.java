package com.carRental.driver;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;


public class NameTest {

    @Test
    public void getFirstName() throws IllegalArgumentException{

        //normal testing
        Name n1 = new Name("Mark", "Smith");
        assertEquals("Mark", n1.GetFirstName());

        //exception testing
        boolean thrown = false;
        try {
            Name n2 = new Name("", "");
        }catch (IllegalArgumentException e)
        {
            thrown = true;
        }
        assertEquals(thrown, true);
    }

    @Test
    public void getLastName() {
        //normal testing
        Name n1 = new Name("Mark", "Smith");
        assertEquals("Smith", n1.GetLastName());

        //exception testing
        boolean thrown = false;
        try {
            Name n2 = new Name("", "");
        }catch (IllegalArgumentException e)
        {
            thrown = true;
        }
        assertEquals(thrown, true);
    }


    @Test
    public void getInitials() {
        //normal testing
        Name n1 = new Name("Mark", "Smith");
        assertEquals("MS", n1.GetInitials());

        //lower case
        Name n2 = new Name("mark", "smith");
        assertEquals("MS", n1.GetInitials());

    }

}