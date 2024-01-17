package org.academy;

import org.academy.kata.implementation.hohashvili.SixImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        SixImpl sixImpl = new SixImpl();
        System.out.println(sixImpl.findNb(1071225));
        System.out.println(sixImpl.findNb(91716553919377L));
    }
}
