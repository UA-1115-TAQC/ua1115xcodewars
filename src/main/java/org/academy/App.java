package org.academy;

import org.academy.kata.implementation.hohashvili.EightImpl;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        EightImpl eightImpl = new EightImpl();
        int[] test = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(eightImpl.divisibleBy(test, 2)));
    }
}
