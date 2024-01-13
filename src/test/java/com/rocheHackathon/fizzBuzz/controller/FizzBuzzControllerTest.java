package com.rocheHackathon.fizzBuzz.controller;

import com.rocheHackathon.fizzBuzz.model.FizzBuzzResult;
import com.rocheHackathon.fizzBuzz.service.FizzBuzzService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(FizzBuzzController.class)
class FizzBuzzControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FizzBuzzService fizzBuzzService;

    @Test
    void testGenerateFizzBuzz() throws Exception {
        // Mock the service response
        List<FizzBuzzResult> mockResult = Arrays.asList(new FizzBuzzResult("Fizz"), new FizzBuzzResult("Buzz"));
        when(fizzBuzzService.generateFizzBuzz(3, 5, 10, "Fizz", "Buzz")).thenReturn(mockResult);

        // Perform the GET request
        mockMvc.perform(get("/fizzbuzz/generate")
                        .param("int1", "3")
                        .param("int2", "5")
                        .param("limit", "10")
                        .param("str1", "Fizz")
                        .param("str2", "Buzz"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].value").value("Fizz"))
                .andExpect(jsonPath("$[1].value").value("Buzz"));
    }

    @Test
    void testGetStatistics() throws Exception {
        // Mock the service response
        Map<String, Integer> mockStatistics = Collections.singletonMap("3-5-15-Fizz-Buzz", 5);
        when(fizzBuzzService.getStatistics()).thenReturn(mockStatistics);

        // Perform the GET request
        mockMvc.perform(get("/fizzbuzz/statistics"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.['3-5-15-Fizz-Buzz']").value(5));
    }
}