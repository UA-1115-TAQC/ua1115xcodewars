package org.academy.utils;

import org.academy.kata.Eight;
import org.academy.kata.Five;
import org.academy.kata.Seven;
import org.academy.kata.Six;

public enum Author {
    ALEVTYNA30(1, "alevtyna30",
            new org.academy.kata.implementation.alevtyna30.EightImpl(),
            new org.academy.kata.implementation.alevtyna30.SevenImpl(),
            new org.academy.kata.implementation.alevtyna30.SixImpl(),
            new org.academy.kata.implementation.alevtyna30.FiveImpl()),
    HOHASHVILI(2, "hohashvili",
            new org.academy.kata.implementation.hohashvili.EightImpl(),
            new org.academy.kata.implementation.hohashvili.SevenImpl(),
            new org.academy.kata.implementation.hohashvili.SixImpl(),
            new org.academy.kata.implementation.hohashvili.FiveImpl()),
    JULYUK(3, "Julyuk",
            new org.academy.kata.implementation.Julyuk.EightImpl(),
            new org.academy.kata.implementation.Julyuk.SevenImpl(),
            new org.academy.kata.implementation.Julyuk.SixImpl(),
            new org.academy.kata.implementation.Julyuk.FiveImpl()),
    KHRYSTYNA_PAVLIKOVSKA(4, "KhrystynaPavlikovska",
            new org.academy.kata.implementation.KhrystynaPavlikovska.EightImpl(),
            new org.academy.kata.implementation.KhrystynaPavlikovska.SevenImpl(),
            new org.academy.kata.implementation.KhrystynaPavlikovska.SixImpl(),
            new org.academy.kata.implementation.KhrystynaPavlikovska.FiveImpl()),
    NASOCK(5, "nasock",
            new org.academy.kata.implementation.nasock.EightImpl(),
            new org.academy.kata.implementation.nasock.SevenImpl(),
            new org.academy.kata.implementation.nasock.SixImpl(),
            new org.academy.kata.implementation.nasock.FiveImpl()),
    NATALIA62(6, "Natalia62",
            new org.academy.kata.implementation.Natalia62.EightImpl(),
            new org.academy.kata.implementation.Natalia62.SevenImpl(),
            new org.academy.kata.implementation.Natalia62.SixImpl(),
            new org.academy.kata.implementation.Natalia62.FiveImpl()),
    NATALSA566(7, "Natalsa566",
            new org.academy.kata.implementation.Natalsa566.EightImpl(),
            new org.academy.kata.implementation.Natalsa566.SevenImpl(),
            new org.academy.kata.implementation.Natalsa566.SixImpl(),
            new org.academy.kata.implementation.Natalsa566.FiveImpl()),
    OKSANKA_V(8, "OksankaV",
            new org.academy.kata.implementation.OksankaV.EightImpl(),
            new org.academy.kata.implementation.OksankaV.SevenImpl(),
            new org.academy.kata.implementation.OksankaV.SixImpl(),
            new org.academy.kata.implementation.OksankaV.FiveImpl()),
    OLEGHON(9, "Oleghon",
            new org.academy.kata.implementation.Oleghon.EightImpl(),
            new org.academy.kata.implementation.Oleghon.SevenImpl(),
            new org.academy.kata.implementation.Oleghon.SixImpl(),
            new org.academy.kata.implementation.Oleghon.FiveImpl()),
    S_HRYNUS(10, "s_hrynus",
            new org.academy.kata.implementation.s_hrynus.EightImpl(),
            new org.academy.kata.implementation.s_hrynus.SevenImpl(),
            new org.academy.kata.implementation.s_hrynus.SixImpl(),
            new org.academy.kata.implementation.s_hrynus.FiveImpl()),
    YSTANKEVYCH(11, "ystankevych",
            new org.academy.kata.implementation.ystankevych.EightImpl(),
            new org.academy.kata.implementation.ystankevych.SevenImpl(),
            new org.academy.kata.implementation.ystankevych.SixImpl(),
            new org.academy.kata.implementation.ystankevych.FiveImpl()),
    ZAKOTIUK(12, "Zakotiuk",
            new org.academy.kata.implementation.Zakotiuk.EightImpl(),
            new org.academy.kata.implementation.Zakotiuk.SevenImpl(),
            new org.academy.kata.implementation.Zakotiuk.SixImpl(),
            new org.academy.kata.implementation.Zakotiuk.FiveImpl());

    private final int id;
    private final String name;
    private final Eight eight;
    private final Seven seven;
    private final Six sixImpl;
    private final Five five;

    Author(int id, String name, Eight eight, Seven seven, Six sixImpl, Five five) {
        this.id = id;
        this.name = name;
        this.eight = eight;
        this.seven = seven;
        this.sixImpl = sixImpl;
        this.five = five;
    }

    public static Author getAuthorById(int id) {
        for (Author author : values()) {
            if (author.id == id)
                return author;
        }
        return null;
    }

    public static void printAuthors() {
        for (Author author : values()) {
            System.out.println(author);
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Eight getEight() {
        return eight;
    }

    public Seven getSeven() {
        return seven;
    }

    public Six getSix() {
        return sixImpl;
    }

    public Five getFive() {
        return five;
    }

    @Override
    public String toString() {
        return id + " " + name;
    }
}
