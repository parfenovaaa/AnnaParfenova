package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivideTest extends CalculatorTest {

    @DataProvider(name = "divideDoubleDataProvider")
    public Object[][] divDoubleDataProvider() {
        return new Object[][] {
            {2.6, 7.2, 0.3611111111111111},
            {-2.5, 2.5, -1},
            {2.5, 0, 0},
            {123456789.5, 2.5, 49382715.8}};
    }

    @Test(dataProvider = "divideDoubleDataProvider")
    public void divideDoubleTest(double x1, double x2, double expected) {

        if (x2 == 0L) {
            Throwable thrown = catchThrowable(() -> calculator.div(x1, x2));
            assertThat(thrown)
                .hasMessageContaining("Attempt to divide by zero");
        } else {
            assertEquals(expected, calculator.div(x1, x2));
        }
    }

    @DataProvider(name = "divideLongDataProvider")
    public Object[][] divLongDataProvider() {
        return new Object[][] {
            {0L, 123456789L, 0L},
            {123456789L, 0L, 0L},
            {123456789L, 123456789L, 1L},
            {92233720946L, -2L, -46116860473L},
            {9223372036854775807L, 1L, 9223372036854775807L}};
    }

    @Test(dataProvider = "divideLongDataProvider")
    public void divideLongTest(long x1, long x2, long expected) {

        if (x2 == 0L) {
            Throwable thrown = catchThrowable(() -> calculator.div(x1, x2));
            assertThat(thrown)
                .hasMessageContaining("Attempt to divide by zero");
        } else {
            assertEquals(expected, calculator.div(x1, x2));
        }
    }
}
