package com.epam.tc.hw1;

import static org.testng.AssertJUnit.assertEquals;

import com.epam.tc.hw1.CalculatorTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivideTest extends CalculatorTest {

    @DataProvider(name = "divideTest")
    public Object[][] divTest() {
        return new Object[][] {
            {2, 2, "1.0"},
            {122, 1, "122.0"},
            {220, -2, "-110.0"},
            {10, 3, "3.3333333333333335"},
            {0, 2, "0.0"},
            {3, 0, "Infinity"},
            {987654321, 123465789, "7.999416915401561"}};
    }

    @Test(dataProvider = "divideTest")
    public void divideTest(double x1, double x2, String expected) {
        String actual = String.valueOf(calculator.div(x1, x2));
        assertEquals(expected, actual);
    }
}
