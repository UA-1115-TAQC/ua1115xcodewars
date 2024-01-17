package org.academy;

import org.academy.kata.implementation.hohashvili.SevenImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        SevenImpl sevenImpl = new SevenImpl();
        double[] test = {14, 30, 5, 7, 9, 11, 15};
        try {
            System.out.println(sevenImpl.newAvg(test, 30));
            System.out.println(sevenImpl.newAvg(test, 92));
            System.out.println(sevenImpl.newAvg(test, 2));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
