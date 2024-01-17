package org.academy;

import org.academy.kata.implementation.hohashvili.FiveImpl;

import java.math.BigInteger;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        FiveImpl fiveImpl = new FiveImpl();
        System.out.println(fiveImpl.perimeter(BigInteger.valueOf(7)));
        System.out.println(fiveImpl.perimeter(BigInteger.valueOf(5)));
    }
}
