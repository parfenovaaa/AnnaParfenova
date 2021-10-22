package com.epam.tc.hw1;

import static org.testng.AssertJUnit.assertEquals;

import com.epam.tc.hw1.CalculatorTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumTest extends CalculatorTest {

    @DataProvider(name = "sumTest")
    public Object[][] sumTest() {
        return new Object[][] {
            {20, 2, 22},
            {2, -2, 0},
            {120, 0, 120},
            {0, -2.5, -2.5},
            {123456789, 987654321, 1111111110}};
    }

    @Test(dataProvider = "sumTest")
    public void subtractTest(double x1, double x2, double expected) {
        double actual = calculator.sum(x1, x2);
        assertEquals(expected, actual);
    }
}
