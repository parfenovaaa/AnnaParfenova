package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeClass;

public abstract class CalculatorTest {

    protected Calculator calculator;

    @BeforeClass
    public void setCalculator() {
        calculator = new Calculator();
    }

}
