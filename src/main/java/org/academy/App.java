package org.academy;

import org.academy.kata.implementation.hohashvili.SixImpl;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        SixImpl sixImpl = new SixImpl();
        System.out.println(sixImpl.f(2.6e-08));// 1.29999999155e-08);
        System.out.println(sixImpl.f(1.4e-09));// 6.999999997549999e-10
        System.out.println(sixImpl.f(5.0e-06));//2.499996875007812e-06
        System.out.println(sixImpl.f(2.4e-07));//1.1999999280000085e-07
    }
}
