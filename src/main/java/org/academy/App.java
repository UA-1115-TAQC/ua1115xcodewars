package org.academy;

import org.academy.kata.implementation.hohashvili.EightImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        EightImpl eightImpl = new EightImpl();
        System.out.println(eightImpl.am_i_wilson(5));
        System.out.println(eightImpl.am_i_wilson(13));
        System.out.println(eightImpl.am_i_wilson(563));
        System.out.println(eightImpl.am_i_wilson(10));
    }
}
