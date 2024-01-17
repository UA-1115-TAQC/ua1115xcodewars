package org.academy;

import org.academy.kata.implementation.s_hrynus.EightImpl;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        EightImpl eight = new EightImpl();
        System.out.println(Arrays.toString(eight.squareOrSquareRoot(new int[]{4, 3, 9, 7, 2, 1})));
    }
}
