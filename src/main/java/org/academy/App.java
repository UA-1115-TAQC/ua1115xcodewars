package org.academy;

import org.academy.kata.implementation.hohashvili.SixImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String r = "Los Angeles Clippers 104 Dallas Mavericks 88,New York" +

                " Knicks 101 Atlanta Hawks 112,Indiana Pacers 103 Memphis Grizzlies" +
                " 112,  Los Angeles Clippers 100 Boston Celtics 120, Los Angeles Clippers 100 Boston Celtics 100," +
                " Los Angeles Clippers 44 Atlanta Hawks 88 \n" ;
        SixImpl sixImpl = new SixImpl();
        System.out.println(sixImpl.nbaCup(r, "Los Angeles Clippers"));
        System.out.println(sixImpl.nbaCup(r, "Atlanta Hawks"));
        System.out.println(sixImpl.nbaCup(r, "Boston Celtics"));

        System.out.println(sixImpl.nbaCup(r, "Boston Celt"));
        System.out.println(sixImpl.nbaCup(r, ""));
    }
}
