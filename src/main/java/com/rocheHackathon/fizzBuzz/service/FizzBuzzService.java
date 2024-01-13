package com.rocheHackathon.fizzBuzz.service;

import com.rocheHackathon.fizzBuzz.model.FizzBuzzResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FizzBuzzService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FizzBuzzService.class);

    private static Map<String, Integer> statistics = new HashMap<>();

    public List<FizzBuzzResult> generateFizzBuzz(int int1, int int2, int limit, String str1, String str2) {
        List<FizzBuzzResult> result = new ArrayList<>();

        try {
            for (int i = 1; i <= limit; i++) {
                StringBuilder value = new StringBuilder();

                if (i % int1 == 0) {
                    value.append(str1);
                }
                if (i % int2 == 0) {
                    value.append(str2);
                }
                if (value.isEmpty()) {
                    value.append(i);
                }

                result.add(new FizzBuzzResult(value.toString()));
            }
        } catch (ArithmeticException | NullPointerException e) {
            LOGGER.error("Exception occurred during FizzBuzz computation", e);
        }

        updateStatistics(int1, int2, limit, str1, str2);

        return result;
    }

    public Map<String, Integer> getStatistics() {
        return statistics;
    }

    private void updateStatistics(int int1, int int2, int limit, String str1, String str2) {
        String key = int1 + "-" + int2 + "-" + limit + "-" + str1 + "-" + str2;
        statistics.put(key, statistics.getOrDefault(key, 0) + 1);
    }
}
