package org.academy;

import org.academy.kata.implementation.hohashvili.FiveImpl;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        testing(261235, "[126235, 2, 0]");
//        testing(209917, "[29917, 0, 1]");
//        testing(285365, "[238565, 3, 1]");
//        testing(269045, "[26945, 3, 0]");
//        testing(296837, "[239687, 4, 1]");

        FiveImpl fiveImpl = new FiveImpl();
        System.out.println(Arrays.toString(fiveImpl.smallest(261235)));
        System.out.println(Arrays.toString(fiveImpl.smallest(209917)));
        System.out.println(Arrays.toString(fiveImpl.smallest(285365)));
        System.out.println(Arrays.toString(fiveImpl.smallest(269045)));
        System.out.println(Arrays.toString(fiveImpl.smallest(296837)));

//        System.out.println("Hello World!");
    }
}
