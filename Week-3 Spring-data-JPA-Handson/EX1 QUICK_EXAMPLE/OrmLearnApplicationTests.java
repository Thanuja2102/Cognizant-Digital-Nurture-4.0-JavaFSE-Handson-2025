package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.CountryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class OrmLearnApplicationTests {

    @Autowired
    private CountryService countryService;

    @Autowired
    private CountryRepository countryRepository;

    @Test
    void testGetAllCountries() {
        List<Country> countries = countryService.getAllCountries();
        Assertions.assertNotNull(countries, "Country list should not be null");
        Assertions.assertEquals(4, countries.size(), "There should be 4 countries in the database");
    }

    @Test
    void testCountryExistsIndia() {
        List<Country> countries = countryService.getAllCountries();
        boolean hasIndia = countries.stream()
                .anyMatch(c -> c.getCode().equals("IN") && c.getName().equals("India"));

        Assertions.assertTrue(hasIndia, "India should be in the list");
    }

    @Test
    void testFindCountryByCode() {
        Country country = countryRepository.findById("US").orElse(null);
        Assertions.assertNotNull(country, "Country with code 'US' should exist");
        Assertions.assertEquals("United States of America", country.getName());
    }

    @Test
    void testCountryNotFound() {
        Country country = countryRepository.findById("XX").orElse(null);
        Assertions.assertNull(country, "Country with code 'XX' should not exist");
    }
}

