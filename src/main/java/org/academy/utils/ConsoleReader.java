package org.academy.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {
    public BufferedReader reader;

    public ConsoleReader() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(reader.readLine());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Input should be double.");
            }
        }
    }

    public double[] readDoubleArr() {
        while (true) {
            try {
                String[] in = reader.readLine().trim().split("\\s+");
                double[] arr = new double[in.length];
                for (int i = 0; i < in.length; i++) {
                    arr[i] = Double.parseDouble(in[i]);
                }
                return arr;
            } catch (IOException | NumberFormatException e) {
                System.out.println("Input should be double array.");
            }
        }
    }
}
