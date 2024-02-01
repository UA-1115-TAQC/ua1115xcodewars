package org.academy.kata.provider;

import org.academy.kata.Six;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SixTest {

    @Test(dataProvider = "balance_test", dataProviderClass = SixDataProvider.class)
    public void balance_test(Six impl, String input1, String expected) {
        String result = impl.balance(input1);
        result = result.replaceAll("[\\r\\n\\s]+", " ");
        result = result.replaceAll(",",".");
        result = result.replaceAll("\\\\r", "");
        result = result.replaceAll("\\\\n", "\n");
        result = result.replaceAll("\n", " ");

        expected = expected.replaceAll("[\\r\\n\\s]+", " ");
        expected = expected.replaceAll("\\\\r", "");
        expected = expected.replaceAll("\\\\n", "\n");
        expected = expected.replaceAll("\n", " ");

        assertEquals(result, expected);
    }
}
