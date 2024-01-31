package org.academy.kata.implementation;

import org.academy.kata.Eight;
import org.academy.kata.provider.EightDataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class EightImplTest {

    @Test(dataProvider = "stringToNumber", dataProviderClass = EightDataProvider.class)
    public void convertStringToNumberTest(Eight eight, String input, int expected) {
        assertEquals(eight.stringToNumber(input), expected);
    }

    @Test(dataProvider = "divisibleByData", dataProviderClass = EightDataProvider.class)
    public void divisibleBy_validData_ok(Eight eight, int[] firstInput, int secondInput, int[] expected) {
        assertEquals(eight.divisibleBy(firstInput, secondInput), expected);
    }
}