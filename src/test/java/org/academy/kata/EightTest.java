package org.academy.kata;

import org.academy.kata.provider.EightDataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class EightTest extends BaseTestRunner {

    @Test(dataProvider = "test_data_wilson", dataProviderClass = EightDataProvider.class)
    public void test_am_i_wilson(Eight impl, double n, boolean expected) {
        assertEquals(impl.am_i_wilson(n), expected);
    }

    @Test(dataProvider = "VolumeOfCuboid_validInputs", dataProviderClass = EightDataProvider.class)
    public void volumeOfCuboid_ValidInputsTest(Eight impl, double length, double width, double height, double expectedVolume) {
        assertEquals((expectedVolume - impl.getVolumeOfCuboid(length, width, height) <= 0.0001), true);
    }

    @Test(dataProvider = "divisibleByData", dataProviderClass = EightDataProvider.class)
    public void divisibleBy_validData_ok(Eight eight, int[] firstInput, int secondInput, int[] expected) {
        assertEquals(eight.divisibleBy(firstInput, secondInput), expected);
    }

    @Test(dataProvider = "squareOrSquareRoot", dataProviderClass = EightDataProvider.class)
    public void test_squareOrSquareRoot(Eight impl, int[] array, int[] expected) {
        assertEquals(impl.squareOrSquareRoot(array), expected);
    }

    @Test(dataProvider = "countPositivesSumNegatives", dataProviderClass = EightDataProvider.class)
    public void countPositivesSumNegativesTest(Eight eight, int[] input, int[] expected) {
        assertEquals(eight.countPositivesSumNegatives(input), expected);
    }

    @Test(dataProvider = "stringToNumber", dataProviderClass = EightDataProvider.class)
    public void convertStringToNumberTest(Eight eight, String input, int expected) {
        assertEquals(eight.stringToNumber(input), expected);
    }

    @Test (dataProvider = "liters_test", dataProviderClass = EightDataProvider.class)
    public void liters_ValidInputsTest(Eight impl, double time, double expectedLiters) {
        assertEquals((expectedLiters - impl.liters(time) <= 0.0001),true);
    }

    @Test(dataProvider = "mpgToKpmValid", dataProviderClass = EightDataProvider.class)
    public void mpgToKpm_ValidData_Ok(Eight eightImpl, float argument, float expected) {
        assertEquals(eightImpl.mpgToKPM(argument), expected, 0.001f);
    }

    @Test(dataProvider = "TwoDecimalPlacesData", dataProviderClass = EightDataProvider.class)
    public void TwoDecimalPlacesTest(Eight impl, double number, double expected){
        assertEquals(impl.TwoDecimalPlaces(number), expected);
    }
}
