package org.academy.kata;

import org.testng.annotations.BeforeClass;

import java.util.Locale;

public class BaseTestRunner {
    @BeforeClass
    public void config(){
        Locale enLocale = new Locale("en-US");
        Locale.setDefault(enLocale);
    }
}
