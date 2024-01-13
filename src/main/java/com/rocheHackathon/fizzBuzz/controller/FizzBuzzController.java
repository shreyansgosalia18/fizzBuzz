package com.rocheHackathon.fizzBuzz.controller;

import com.rocheHackathon.fizzBuzz.model.FizzBuzzResult;
import com.rocheHackathon.fizzBuzz.service.FizzBuzzService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/fizzbuzz")
public class FizzBuzzController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FizzBuzzController.class);

    private final FizzBuzzService fizzBuzzService;

    @Autowired
    public FizzBuzzController(FizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    @GetMapping("/generate")
    public ResponseEntity<List<FizzBuzzResult>> generateFizzBuzz(
            @RequestParam String int1,
            @RequestParam String int2,
            @RequestParam String limit,
            @RequestParam String str1,
            @RequestParam String str2
    ) {
        try {
            List<FizzBuzzResult> result = fizzBuzzService.generateFizzBuzz(
                    Integer.parseInt(int1),
                    Integer.parseInt(int2),
                    Integer.parseInt(limit),
                    str1,
                    str2
            );
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (NumberFormatException e) {
            LOGGER.error("Invalid input format. Please provide valid integer values.", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/statistics")
    public ResponseEntity<Map<String, Integer>> getStatistics() {
        Map<String, Integer> statistics = fizzBuzzService.getStatistics();
        return new ResponseEntity<>(statistics, HttpStatus.OK);
    }
}
