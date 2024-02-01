package org.academy.kata.provider;

import org.academy.kata.Eight;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class EightTest {
    @Test(dataProvider = "test_data_wilson", dataProviderClass = EightDataProvider.class)
    public void test_am_i_wilson(Eight impl, double n, boolean expected){
        assertEquals(impl.am_i_wilson(n), expected);
    }

    @Test (dataProvider = "VolumeOfCuboid_validInputs", dataProviderClass = EightDataProvider.class)
    public void volumeOfCuboid_ValidInputsTest(Eight impl, double length, double width, double height, double expectedVolume) {
        assertEquals((expectedVolume - impl.getVolumeOfCuboid(length,width,height) <= 0.0001),true);
    }

    @Test (dataProvider = "liters_test", dataProviderClass = EightDataProvider.class)
    public void liters_ValidInputsTest(Eight impl, double time, double expectedLiters) {
        assertEquals((expectedLiters - impl.liters(time) <= 0.0001),true);
    }

}
