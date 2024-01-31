package org.academy.utils;

import org.academy.utils.ConsoleReader;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
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
    public void testReadDoubleArr(String inputString, double[] expected){
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        ConsoleReader reader = new ConsoleReader();
        assertEquals(reader.readBigInteger(), expected);
    }
}
