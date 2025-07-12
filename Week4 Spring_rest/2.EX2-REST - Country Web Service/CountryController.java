package com.cognizant.countryservice.controller;

import com.cognizant.countryservice.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
    ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

    @RequestMapping("/country")
    public Country getCountryIndia() {
        LOGGER.info("START - getCountryIndia()");
        Country country = (Country) context.getBean("in");
        LOGGER.info("END - getCountryIndia()");
        return country;
    }

    @RequestMapping("/countries")
    public List<Country> getAllCountries() {
        LOGGER.info("START - getAllCountries()");
        List<Country> countries = (List<Country>) context.getBean("countryList");
        LOGGER.info("END - getAllCountries()");
        return countries;
    }
}
