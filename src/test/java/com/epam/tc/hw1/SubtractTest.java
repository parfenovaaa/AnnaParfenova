package com.epam.tc.hw1;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubtractTest extends CalculatorTest {

    @DataProvider(name = "subtractDoubleDataProvider")
    public Object[][] subtractDoubleDataProvider() {
        return new Object[][] {
            {2.7, 2.7, 0},
            {2.1, -2.5, 4.6},
            {2.5, 0, 2.5},
            {2147483647.6, 47483646, 2100000001.6}};
    }

    @Test(dataProvider = "subtractDoubleDataProvider")
    public void subtractDoubleTest(double x1, double x2, double expected) {
        double actual = calculator.sub(x1, x2);
        assertEquals(expected, actual);
    }

    @DataProvider(name = "subtractLongDataProvider")
    public Object[][] subtractLongDataProvider() {
        return new Object[][] {
            {123457777641975L, 123456789987654L, 987654321L},
            {-9223372036854775806L, -9223372036854775807L, 1L},
            {3004230L, 0L, 3004230L},
            {9223372036854775807L, 2L, 9223372036854775805L}};
    }

    @Test(dataProvider = "subtractLongDataProvider")
    public void subtractLongTest(long x1, long x2, long expected) {
        long actual = calculator.sub(x1, x2);
        assertEquals(expected, actual);
    }
}
