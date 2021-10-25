package com.epam.tc.hw1;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiplyTest extends CalculatorTest {

    @DataProvider(name = "multiplyDoubleDataProvider")
    public Object[][] multiplyDoubleDataProvider() {
        return new Object[][] {
            {2.6, 7.3, 18.98},
            {-2.5, 2.5, -6.25},
            {123456789.5, 2.5, 308641973.75},
            {2.5, 0, 0}};
    }

    @Test(dataProvider = "multiplyDoubleDataProvider")
    public void multiplyDoubleTest(double x1, double x2, double expected) {
        double actual = calculator.mult(x1, x2);
        assertEquals(expected, actual);
    }

    @DataProvider(name = "multiplyLongDataProvider")
    public Object[][] multiplyLongDataProvider() {
        return new Object[][] {
            {0L, 123456789L, 0L},
            {123456789L, 123456789L, 15241578750190521L},
            {92233720946L, -2L, -184467441892L},
            {9223372036854775807L, 1L, 9223372036854775807L}};
    }

    @Test(dataProvider = "multiplyLongDataProvider")
    public void multiplyLongTest(long x1, long x2, long expected) {
        long actual = calculator.mult(x1, x2);
        assertEquals(expected, actual);

    }
}
