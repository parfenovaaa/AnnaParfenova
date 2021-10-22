package com.epam.tc.hw1;

import static org.testng.AssertJUnit.assertEquals;

import com.epam.tc.hw1.CalculatorTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiplyTest extends CalculatorTest {

    @DataProvider(name = "multiplyTest")
    public Object[][] multiplyTest() {
        return new Object[][] {
            {2, 2, 4},
            {2, -2, -4},
            {2, 0, 0},
            {0, 2, 0},
            {2.5, 20, 50},
            {1234567891, 987654321, 1.21932631211400704E18}};
    }

    @Test(dataProvider = "multiplyTest")
    public void multiplyTest(double x1, double x2, double expected) {
        double actual = calculator.mult(x1, x2);
        assertEquals(expected, actual);
    }
}
