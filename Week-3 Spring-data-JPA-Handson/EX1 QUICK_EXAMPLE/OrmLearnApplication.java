package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

	private static CountryService countryService;

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);
		LOGGER.info("Inside main");

		testGetAllCountries();
	}

	private static void testGetAllCountries() {
		System.out.println("Start");

		List<Country> countries = countryService.getAllCountries();

		for (Country country : countries) {
			System.out.println(country);
		}

		System.out.println("End");
	}
}


