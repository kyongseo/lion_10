package org.example.ch02.Algorithm;

import java.util.Scanner;

public class HealthCheck {
    static final int PMAX = 16;

    static class HealthData {
        String name;
        int weight;
        double bloodPressure;

        HealthData(String name, int weight, double bloodPressure) {
            this.name = name;
            this.weight = weight;
            this.bloodPressure = bloodPressure;
        }
    }

    static double aveWeight(HealthData[] dat) {
        double sum = 0;
        for (int i = 0; i < dat.length; i++)
            sum += dat[i].weight;

        return sum / dat.length;
    }

    static void distBloodPressure(HealthData[] dat, int[] dist) {
        for (int i = 0;


             i < dat.length; i++) {
            if (dat[i].bloodPressure >= 60.0 && dat[i].bloodPressure <= 150.0)
                dist[(int)(dat[i].bloodPressure / 10) - 6]++;
        }
    }
}
