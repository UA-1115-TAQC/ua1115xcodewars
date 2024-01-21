package org.academy;

import org.academy.kata.implementation.hohashvili.FiveImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        FiveImpl fiveImpl = new FiveImpl();
        System.out.println(fiveImpl.solve(2.00)); // 5.000000000000e-01
        System.out.println(fiveImpl.solve(4.00)); // 6.096117967978e-01
        System.out.println(fiveImpl.solve(5.00)); // 6.417424305044e-01

    }
}
