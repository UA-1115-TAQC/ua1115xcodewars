package org.academy.utils;

import org.academy.utils.ConsoleReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;

import static org.testng.Assert.assertEquals;
import static org.testng.FileAssert.fail;

public class ConsoleReaderTest {
    @Test(dataProvider = "validDataForIntArr", dataProviderClass = ConsoleReaderDataProvider.class)
    public void testReadIntArr(String inputString, int[] expected){
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ConsoleReader reader = new ConsoleReader();
        assertEquals(reader.readIntArr(), expected);
    }

    @Test(dataProvider = "validDataForBigInt", dataProviderClass = ConsoleReaderDataProvider.class)
    public void testReadBigInteger(String inputString, BigInteger expected){
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ConsoleReader reader = new ConsoleReader();
        assertEquals(reader.readBigInteger(), expected);
    }

    @Test(dataProvider = "validDataForDoubleArr", dataProviderClass = ConsoleReaderDataProvider.class)
    public void testReadDoubleArr_validInputs(String inputString, double[] expected){
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ConsoleReader reader = new ConsoleReader();
        assertEquals(reader.readDoubleArr(), expected);
    }


    @Test(dataProvider = "invalidDataForDoubleArr", dataProviderClass = ConsoleReaderDataProvider.class)
    public void testReadDoubleArr_invalidInputs(String inputString){
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ConsoleReader reader = new ConsoleReader();
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(testOut));
        try {
            reader.readDoubleArr();
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException e) {
            String expectedMessage = "Input should be a double array.";
            assertEquals(testOut.toString().trim(), expectedMessage);
        } finally {
            System.setOut(originalOut);
        }

    }

    @Test(dataProvider = "readFloatPositiveTest", dataProviderClass = ConsoleReaderDataProvider.class)
    public void readFloatTestPositive(String input, float expected) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ConsoleReader cr = new ConsoleReader();
        assertEquals(expected, cr.readFloat());
    }
}
