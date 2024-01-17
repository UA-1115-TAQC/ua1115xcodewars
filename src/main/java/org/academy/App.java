package org.academy;

import org.academy.kata.implementation.hohashvili.SevenImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        SevenImpl sevenImpl  = new SevenImpl();
        System.out.println(sevenImpl.seriesSum(1));
        System.out.println(sevenImpl.seriesSum(2));
        System.out.println(sevenImpl.seriesSum(5));
    }
}
