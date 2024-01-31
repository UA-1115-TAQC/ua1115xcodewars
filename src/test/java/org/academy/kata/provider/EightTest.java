package org.academy.kata.provider;

import org.academy.kata.Eight;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class EightTest {
    @Test(dataProvider = "test_data_wilson", dataProviderClass = EightDataProvider.class)
    public void test_am_i_wilson(Eight impl, double n, boolean expected){
        assertEquals(impl.am_i_wilson(n), expected);
    }

}
