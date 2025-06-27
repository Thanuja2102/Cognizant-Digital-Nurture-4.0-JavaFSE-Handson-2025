package com.bankapp.test;

import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {

    @Test
    public void testAssertions() {

        int expectedSum = 5;
        int actualSum = 2 + 3;
        assertEquals("Sum should be 5", expectedSum, actualSum);


        assertTrue("5 is greater than 3", 5 > 3);


        assertFalse("5 is not less than 3", 5 < 3);


        Object obj = null;
        assertNull("Object should be null", obj);


        Object notNullObj = new Object();
        assertNotNull("Object should not be null", notNullObj);


        String str = "JUnit";
        String sameStr = str;
        assertSame("Both references should point to the same object", str, sameStr);

        
        String s1 = new String("Test");
        String s2 = new String("Test");
        assertNotSame("Different object instances", s1, s2);
    }
}

