package org.academy.kata.provider;

import org.academy.kata.Eight;
import org.academy.kata.Five;

import java.util.ArrayList;
import java.util.List;

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

    protected static Object[][] getDataOneParam(List<Object[]> objects, List impls) {
        ArrayList<Object[]> data = new ArrayList<>();
        for (Object impl : impls) {
            for (Object[] object : objects) {
                data.add(new Object[]{impl, object[0], object[1]}); // impl, input, result
            }
        }
        return data.toArray(new Object[data.size()][3]);
    }

    protected static Object[][] getDataTwoParams(List<Object[]> objects, List impls) {
        ArrayList<Object[]> data = new ArrayList<>();
        for (Object impl : impls) {
            for (Object[] object : objects) {
                data.add(new Object[]{impl, object[0], object[1], object[2]}); // impl, input1, input2, result
            }
        }
        return data.toArray(new Object[data.size()][4]);
    }

    protected static Object[][] getDataThreeParams(List<Object[]> objects, List impls) {
        ArrayList<Object[]> data = new ArrayList<>();
        for (Object impl : impls) {
            for (Object[] object : objects) {
                // impl, input1, input2, input3, result
                data.add(new Object[]{impl, object[0], object[1], object[2], object[3]});
            }
        }
        return data.toArray(new Object[data.size()][5]);
    }
}
