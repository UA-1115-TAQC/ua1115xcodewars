package org.academy;

import org.academy.kata.implementation.hohashvili.FiveImpl;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        FiveImpl fiveImpl = new FiveImpl();
        System.out.println(Arrays.toString(fiveImpl.gap(2, 100, 110)));
        System.out.println(Arrays.toString(fiveImpl.gap(4, 100, 110)));
        System.out.println(Arrays.toString(fiveImpl.gap(8, 300, 400)));

    }
}
