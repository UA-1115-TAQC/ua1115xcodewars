package org.academy;

import org.academy.kata.implementation.hohashvili.EightImpl;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        EightImpl eightImpl = new EightImpl();
        int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15};
//        int[] test = {};
        int[] result = eightImpl.countPositivesSumNegatives(test);
        System.out.println(Arrays.toString(result));
    }
}
