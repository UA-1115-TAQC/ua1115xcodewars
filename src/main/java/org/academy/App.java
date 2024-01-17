package org.academy;

import org.academy.kata.implementation.hohashvili.EightImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        EightImpl eightImpl = new EightImpl();
        System.out.println(eightImpl.stringToNumber("1234"));
        System.out.println(eightImpl.stringToNumber("-7"));
        System.out.println(eightImpl.stringToNumber("0"));
    }
}
