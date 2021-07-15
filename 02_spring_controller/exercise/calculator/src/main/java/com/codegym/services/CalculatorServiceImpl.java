package com.codegym.services;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public float calculator(Float firstNumber, Float lastNumber, String calculation)  {

        float result;
        switch (calculation){
            case "add":
                result = firstNumber + lastNumber;
                break;
            case "sub":
                result = firstNumber - lastNumber;
                break;
            case "mul":
                result = firstNumber * lastNumber;
                break;
            case "div":
                    result = firstNumber / lastNumber;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + calculation);
        }
        return result;
    }
}
