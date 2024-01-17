package org.academy;

import org.academy.kata.implementation.hohashvili.SixImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

//        String[] stock = {"ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"};
        String[] stock = {"BBAR 150", "CDXE 515", "BKWR 250", "BTSQ 890", "DRTY 600"};
//        String[] letters =  {"A", "B", "C", "W"};
        String[] letters =  {"A", "B", "C", "D"};
        SixImpl sixImpl = new SixImpl();
        System.out.println(sixImpl.stockSummary(stock, letters));
    }
}
