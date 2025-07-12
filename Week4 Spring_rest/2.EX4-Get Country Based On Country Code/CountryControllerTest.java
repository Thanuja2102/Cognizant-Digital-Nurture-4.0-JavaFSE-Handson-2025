package com.cognizant.countrycode;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CountryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetCountry_India() throws Exception {
        mockMvc.perform(get("/countries/in"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("IN"))
                .andExpect(jsonPath("$.name").value("India"));
    }

    @Test
    public void testGetCountry_US() throws Exception {
        mockMvc.perform(get("/countries/US"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("US"))
                .andExpect(jsonPath("$.name").value("United States"));
    }

    @Test
    public void testGetCountry_NotFound() throws Exception {
        mockMvc.perform(get("/countries/XX"))
                .andExpect(status().isOk())
                .andExpect(content().string("")); // since service returns null
    }
}
