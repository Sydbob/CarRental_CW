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

    @Test
    public void testEquals(){
        Name n = new Name("Bob", "Smith");
        assert(n.equals(n));
        assertFalse(n.equals("Bob"));
        assertFalse(n.equals(new Name("Bob", "Jones")));
        assertTrue(n.equals(new Name("Bob", "Smith")));
        assertFalse(n.equals(new Name("Bo", "Smith")));
        assertFalse(n.equals(new Name("bob", "smith")));
    }

    @Test
    public void testToString(){
        Name n = new Name("Mark", "Smith");
        assertEquals("Mark Smith", n.toString());
        assertNotEquals("MarkSmith", n.toString());
    }

}