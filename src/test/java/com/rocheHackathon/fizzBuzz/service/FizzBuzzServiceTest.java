package com.rocheHackathon.fizzBuzz.service;

import com.rocheHackathon.fizzBuzz.model.FizzBuzzResult;
import com.rocheHackathon.fizzBuzz.service.FizzBuzzService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
class FizzBuzzServiceTest {

    @Autowired
    private FizzBuzzService fizzBuzzService;

    @Test
    void testGenerateFizzBuzz() {
        // Test the FizzBuzz generation logic with some sample input
        List<FizzBuzzResult> result = fizzBuzzService.generateFizzBuzz(3, 5, 15, "Fizz", "Buzz");

        // Assertions based on the FizzBuzz logic and 0-based indexing
        assertThat(result).hasSize(15);
        assertThat(result.get(2).getValue()).isEqualTo("Fizz");
        assertThat(result.get(4).getValue()).isEqualTo("Buzz");
        assertThat(result.get(14).getValue()).isEqualTo("FizzBuzz");
    }

    @Test
    void testGetStatistics() {
        // Assuming some statistics are already present in the service
        Map<String, Integer> statistics = fizzBuzzService.getStatistics();

        // Your assertions based on the expected statistics
        assertThat(statistics).isNotNull();
        assertThat(statistics).containsKey("3-5-15-Fizz-Buzz");
    }
}