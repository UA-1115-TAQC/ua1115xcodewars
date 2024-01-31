package org.academy.kata.provider;

import org.academy.kata.Eight;
import org.academy.kata.Six;
import org.academy.kata.Five;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class AbstractDataProvider {
    protected static final List<Eight> EIGHTS = List.of(
            new org.academy.kata.implementation.alevtyna30.EightImpl(),
            new org.academy.kata.implementation.hohashvili.EightImpl(),
            new org.academy.kata.implementation.Julyuk.EightImpl(),
            new org.academy.kata.implementation.KhrystynaPavlikovska.EightImpl(),
            new org.academy.kata.implementation.nasock.EightImpl(),
            new org.academy.kata.implementation.Natalia62.EightImpl(),
            new org.academy.kata.implementation.Natalsa566.EightImpl(),
            new org.academy.kata.implementation.OksankaV.EightImpl(),
            new org.academy.kata.implementation.Oleghon.EightImpl(),
            new org.academy.kata.implementation.s_hrynus.EightImpl(),
            new org.academy.kata.implementation.ystankevych.EightImpl(),
            new org.academy.kata.implementation.Zakotiuk.EightImpl());
    protected static final List<Six> SIXES = List.of(
            new org.academy.kata.implementation.alevtyna30.SixImpl(),
            new org.academy.kata.implementation.hohashvili.SixImpl(),
            new org.academy.kata.implementation.Julyuk.SixImpl(),
            new org.academy.kata.implementation.KhrystynaPavlikovska.SixImpl(),
            new org.academy.kata.implementation.nasock.SixImpl(),
            new org.academy.kata.implementation.Natalia62.SixImpl(),
            new org.academy.kata.implementation.Natalsa566.SixImpl(),
            new org.academy.kata.implementation.OksankaV.SixImpl(),
            new org.academy.kata.implementation.Oleghon.SixImpl(),
            new org.academy.kata.implementation.s_hrynus.SixImpl(),
            new org.academy.kata.implementation.ystankevych.SixImpl(),
            new org.academy.kata.implementation.Zakotiuk.SixImpl());
    protected static final List<Five> FIVES = List.of(
            new org.academy.kata.implementation.alevtyna30.FiveImpl(),
            new org.academy.kata.implementation.hohashvili.FiveImpl(),
            new org.academy.kata.implementation.Julyuk.FiveImpl(),
            new org.academy.kata.implementation.KhrystynaPavlikovska.FiveImpl(),
            new org.academy.kata.implementation.nasock.FiveImpl(),
            new org.academy.kata.implementation.Natalia62.FiveImpl(),
            new org.academy.kata.implementation.Natalsa566.FiveImpl(),
            new org.academy.kata.implementation.OksankaV.FiveImpl(),
            new org.academy.kata.implementation.Oleghon.FiveImpl(),
            new org.academy.kata.implementation.s_hrynus.FiveImpl(),
            new org.academy.kata.implementation.ystankevych.FiveImpl(),
            new org.academy.kata.implementation.Zakotiuk.FiveImpl());

    protected static Iterator<Object[]> combineData(List<Object[]> objects, List impls) {
        ArrayList<Object[]> data = new ArrayList<>();
        for (Object impl : impls) {
            objects.forEach(o -> data.add(Stream.concat(Stream.of(impl), Arrays.stream(o)).toArray()));
        }
        return data.iterator();
    }
}
