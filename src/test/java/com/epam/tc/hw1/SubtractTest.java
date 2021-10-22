package com.epam.tc.hw1;

import static org.testng.AssertJUnit.assertEquals;

import com.epam.tc.hw1.CalculatorTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubtractTest extends CalculatorTest {

    @DataProvider(name = "subtractTest")
    public Object[][] subtractTest() {
        return new Object[][] {
            {2, 2, 0},
            {2, -2, 4},
            {2, 0, 2},
            {10, 20, -10},
            {0, 2.5, -2.5},
            {987654321, 123456789, 864197532}};
    }

    @Test(dataProvider = "subtractTest")
    public void subtractTest(double x1, double x2, double expected) {
        double actual = calculator.sub(x1, x2);
        assertEquals(expected, actual);
    }
}
