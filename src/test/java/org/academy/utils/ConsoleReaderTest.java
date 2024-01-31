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

public class ConsoleReaderTest {

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
        Assert.expectThrows(NullPointerException.class, () -> {
            reader.readDoubleArr();
            PrintStream output = new PrintStream(new ByteArrayOutputStream());
            System.setOut(output);
            String expectedMessage="Input should be a double array.";
            assertEquals(expectedMessage, output.toString()
                    .trim());
        });
    }
}
