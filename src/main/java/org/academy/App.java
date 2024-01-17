package org.academy;

import org.academy.kata.implementation.hohashvili.EightImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println(String.valueOf(Math.ceil(5.0)));
        System.out.println(String.valueOf(Math.ceil(5.1)));

        EightImpl eightImpl = new EightImpl();
        int[] testArray = {4, 3, 9, 7, 2, 1};
        int [] result = eightImpl.squareOrSquareRoot(testArray);
        for (int r: result) {
            System.out.print(r);
            System.out.print(',');
        }

    }
}
