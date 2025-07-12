package com.cognizant.countryservice.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CountryController.class)
public class CountryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetCountryIndia() throws Exception {
        mockMvc.perform(get("/country"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("IN"))
                .andExpect(jsonPath("$.name").value("India"));
    }

    @Test
    public void testGetAllCountries() throws Exception {
        mockMvc.perform(get("/countries"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(4))))
                .andExpect(jsonPath("$[?(@.code == 'US')].name", hasItem("United States")))
                .andExpect(jsonPath("$[?(@.code == 'DE')].name", hasItem("Germany")))
                .andExpect(jsonPath("$[?(@.code == 'IN')].name", hasItem("India")))
                .andExpect(jsonPath("$[?(@.code == 'JP')].name", hasItem("Japan")));
    }
}
