package org.academy;

import org.academy.kata.implementation.hohashvili.FiveImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        FiveImpl fiveImpl = new FiveImpl();
        System.out.println(fiveImpl.zeros(0));
        System.out.println(fiveImpl.zeros(14));
        System.out.println(fiveImpl.zeros(6));
        System.out.println("Hello World!");
    }
}
