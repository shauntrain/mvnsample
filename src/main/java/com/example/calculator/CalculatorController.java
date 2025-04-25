package com.example.calculator;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculate")
public class CalculatorController {

    @GetMapping
    public double calculate(@RequestParam double num1, 
                            @RequestParam double num2, 
                            @RequestParam char operation) {
        return switch (operation) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> {
                if (num2 == 0) throw new IllegalArgumentException("Division by zero");
                yield num1 / num2;
            }
            default -> throw new IllegalArgumentException("Invalid operation");
        };
    }
}
