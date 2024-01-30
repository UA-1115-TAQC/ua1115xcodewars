package org.academy;

import org.academy.utils.ConsoleReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;


public class DoubleReaderTest {

    private ConsoleReader consoleReader;

    @BeforeMethod
    public void setUp() {
        consoleReader = new ConsoleReader();
    }

    @Test
    public void testReadDoubleValidInput() throws IOException {
        consoleReader.reader = new BufferedReader(new StringReader("3.14")); //valid
        double result = consoleReader.readDouble();
        Assert.assertEquals(result, 3.14, 0.001);
    }

    @Test
    public void testReadDoubleInvalidInput() {
        consoleReader.reader = new BufferedReader(new StringReader("Abc")); // invalid
        try {
            consoleReader.readDouble();
        } catch (NumberFormatException e) {
            Assert.assertEquals(e.getMessage(), "Input should be a double.");
            throw e;
        } catch (Exception e) {
            // different type of exception
        }
    }
}