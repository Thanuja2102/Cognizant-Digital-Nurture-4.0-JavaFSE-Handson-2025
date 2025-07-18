package com.cognizant.account.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AccountController.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAccountDetails() throws Exception {
        mockMvc.perform(get("/accounts/00987987973432"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").value("00987987973432"))
                .andExpect(jsonPath("$.type").value("savings"))
                .andExpect(jsonPath("$.balance").value(234343));
    }
}

