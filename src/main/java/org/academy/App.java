package org.academy;

import org.academy.kata.implementation.hohashvili.SixImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String[] stock = {"ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"};
        String[] letters =  {"A", "B", "C", "W"};
        SixImpl sixImpl = new SixImpl();
        System.out.println(sixImpl.stockSummary(stock, letters));
    }
}
