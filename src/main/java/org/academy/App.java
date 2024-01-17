package org.academy;

import org.academy.kata.implementation.hohashvili.SixImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String test = "1000.00\n125 Market 125.45\n126 Hardware 34.95\n127 Video 7.45\n128 Book 14.32 " +
                "\n129 Gasoline 16.10";
        SixImpl sixImpl = new SixImpl();
        System.out.println(sixImpl.balance(test));
    }
}
