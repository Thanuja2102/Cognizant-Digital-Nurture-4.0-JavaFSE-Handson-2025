package com.cognizant.springlearn;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class CountryTest {

    private static ApplicationContext context;

    @BeforeClass
    public static void init() {
        context = new ClassPathXmlApplicationContext("country.xml");
    }

    @Test
    public void testGetCountryIN() {
        Country in = (Country) context.getBean("countryIN");
        assertEquals("IN", in.getCode());
        assertEquals("India", in.getName());
    }

    @Test
    public void testCountryListSize() {
        List<Country> countryList = (List<Country>) context.getBean("countryList");
        assertEquals(4, countryList.size());
    }

    @Test
    public void testAllCountriesHaveValidNames() {
        List<Country> countryList = (List<Country>) context.getBean("countryList");
        for (Country country : countryList) {
            assertNotNull(country.getCode());
            assertNotNull(country.getName());
        }
    }
}

