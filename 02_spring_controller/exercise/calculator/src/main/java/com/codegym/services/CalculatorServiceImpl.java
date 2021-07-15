package com.codegym.services;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public double getAdd(int fistNum, int lastNum) {
        double firstNumber=fistNum;
        double lastNumber=lastNum;
        double result=firstNumber+lastNumber;
        return result;
    }

    @Override
    public double getSub(int fistNum, int lastNum) {
        double firstNumber=fistNum;
        double lastNumber=lastNum;
        double result=firstNumber-lastNumber;
        return result;
    }

    @Override
    public double getMul(int fistNum, int lastNum) {
        double firstNumber=fistNum;
        double lastNumber=lastNum;
        double result=firstNumber*lastNumber;
        return result;
    }

    @Override
    public double getDiv(int fistNum, int lastNum) {
        double firstNumber=fistNum;
        double lastNumber=lastNum;
        double result=firstNumber/lastNumber;
        return result;
    }
}
