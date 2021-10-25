package com.epam.tc.hw1;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumTest extends CalculatorTest {

    @DataProvider(name = "sumDoubleDataProvider")
    public Object[][] sumDoubleDataProvider() {
        return new Object[][] {
            {2.6, 7.7, 10.3},
            {-2.1, -2.6, -4.7},
            {2.5, 0, 2.5},
            {2147480000.1, 3646.9, 2147483647}};
    }

    @Test(dataProvider = "sumDoubleDataProvider")
    public void sumDoubleTest(double x1, double x2, double expected) {
        double actual = calculator.sum(x1, x2);
        assertEquals(expected, actual);
    }

    @DataProvider(name = "sumLongDataProvider")
    public Object[][] sumLongDataProvider() {
        return new Object[][] {
            {123456789987654L, 987654321L, 123457777641975L},
            {-9223372036854775807L, -1L, -9223372036854775808L},
            {-3004230L, 0L, -3004230L},
            {9223372036854775805L, 2L, 9223372036854775807L}};
    }

    @Test(dataProvider = "sumLongDataProvider")
    public void sumLongTest(long x1, long x2, long expected) {
        long actual = calculator.sum(x1, x2);
        assertEquals(expected, actual);
    }
}
