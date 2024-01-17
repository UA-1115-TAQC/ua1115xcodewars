package org.academy;

import org.academy.kata.implementation.hohashvili.EightImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        EightImpl i = new EightImpl();
        System.out.println(i.liters(3));
        System.out.println(i.liters(6.7));
        System.out.println(i.liters(11.8));
    }
}
