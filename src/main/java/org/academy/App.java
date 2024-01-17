package org.academy;

import org.academy.kata.implementation.hohashvili.EightImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        EightImpl eightImpl = new EightImpl();
        System.out.println(eightImpl.TwoDecimalPlaces(5.5589));
        System.out.println(eightImpl.TwoDecimalPlaces(3.3424));
    }
}
