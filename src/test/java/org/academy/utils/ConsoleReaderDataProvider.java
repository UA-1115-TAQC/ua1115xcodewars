package org.academy.utils;

import org.testng.annotations.DataProvider;

import java.math.BigInteger;

public class ConsoleReaderDataProvider {

    @DataProvider(name = "validDataForBigInt")
    private Object[][] validDataForBigInt(){
        return new Object[][]{
                {"43653664", new BigInteger("43653664")},
                {"67648656565474858", new BigInteger("67648656565474858")},
                {"9597957656756756788655685656", new BigInteger("9597957656756756788655685656")},
        };
    }

    @DataProvider(name = "validDataForDoubleArr")
    private Object[][] validDataForDoubleArr(){
        return new Object[][]{
               // {"43653664", new BigInteger("43653664")},
              //  {"67648656565474858", new BigInteger("67648656565474858")},
               // {"9597957656756756788655685656", new BigInteger("9597957656756756788655685656")},
        };
    }

    @DataProvider(name = "invalidDataForDoubleArr")
    private Object[][] invalidDataForDoubleArr(){
        return new Object[][]{
                // {"43653664", new BigInteger("43653664")},
                //  {"67648656565474858", new BigInteger("67648656565474858")},
                // {"9597957656756756788655685656", new BigInteger("9597957656756756788655685656")},
        };
    }
}
