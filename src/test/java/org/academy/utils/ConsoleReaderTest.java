package org.academy.utils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigInteger;

import static org.testng.Assert.assertEquals;
import static org.testng.FileAssert.fail;

public class ConsoleReaderTest {
    InputStream originalIn;
    PrintStream originalOut;

    @BeforeMethod
    public void beforeMethod() {
        originalIn = System.in;
        originalOut = System.out;
    }

    @AfterMethod
    public void afterMethod() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test(dataProvider = "validDataForIntArr", dataProviderClass = ConsoleReaderDataProvider.class)
    public void testReadIntArr(String inputString, int[] expected) {
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ConsoleReader reader = new ConsoleReader();
        assertEquals(reader.readIntArr(), expected);
    }

    @Test(dataProvider = "validDataForBigInt", dataProviderClass = ConsoleReaderDataProvider.class)
    public void testReadBigInteger(String inputString, BigInteger expected) {
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ConsoleReader reader = new ConsoleReader();
        assertEquals(reader.readBigInteger(), expected);
    }

    @Test(dataProvider = "invalidDataForBigInt", dataProviderClass = ConsoleReaderDataProvider.class)
    public void testInvalidReadBigInteger(String inputString, String expected) {
        System.setIn(new ByteArrayInputStream((inputString + System.lineSeparator() + "1").getBytes()));
        ByteArrayOutputStream testStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testStream));
        ConsoleReader reader = new ConsoleReader();
        reader.readBigInteger();
        assertEquals(testStream.toString(), expected);
    }

    @Test(dataProvider = "validDataForDoubleArr", dataProviderClass = ConsoleReaderDataProvider.class)
    public void testReadDoubleArr_validInputs(String inputString, double[] expected) {
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ConsoleReader reader = new ConsoleReader();
        assertEquals(reader.readDoubleArr(), expected);
    }


    @Test(dataProvider = "invalidDataForDoubleArr", dataProviderClass = ConsoleReaderDataProvider.class)
    public void testReadDoubleArr_invalidInputs(String inputString, String expectedMessage, double[] expectedArr) {
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ConsoleReader reader = new ConsoleReader();
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
        double[] arr = reader.readDoubleArr();
        assertEquals(testOut.toString().trim(), expectedMessage);
        assertEquals(arr, expectedArr);
    }

    @Test(dataProvider = "readFloatPositiveTest", dataProviderClass = ConsoleReaderDataProvider.class)
    public void readFloatPositiveTest(String input, float expected) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ConsoleReader cr = new ConsoleReader();
        assertEquals(cr.readFloat(), expected);
    }

    @Test(dataProvider = "readFloatNegativeTest", dataProviderClass = ConsoleReaderDataProvider.class)
    public void readFloatNegativeTest(String input, String expected) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream tempOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(tempOut));
        try {
            ConsoleReader cr = new ConsoleReader();
            cr.readFloat();
            fail("NullPointerException is expected");
        } catch (NullPointerException e) {
            String str = tempOut.toString().trim();
            assertEquals(str, expected);
        }
    }

    @Test(dataProvider = "readStringArr", dataProviderClass = ConsoleReaderDataProvider.class)
    public void readStringArr(String inputString, String[] expected) {
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ConsoleReader reader = new ConsoleReader();
        assertEquals(reader.readStringArr(), expected);
    }

    @Test(dataProvider = "readLong", dataProviderClass = ConsoleReaderDataProvider.class)
    public void readLongTest(String input, long expected) {
        InputStream inputStream = System.in;
        System.setIn(inputStream);
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ConsoleReader reader = new ConsoleReader();
        assertEquals(reader.readLong(), expected);
    }
}
