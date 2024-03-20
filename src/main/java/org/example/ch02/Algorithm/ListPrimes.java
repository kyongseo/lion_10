package org.example.ch02.Algorithm;

public class ListPrimes {
    public static void main(String[] args) {
        int divCount = 0;
        for (int n = 2; n <= 1000; n++) {
            boolean isP = true;
            for (int div = 2; div < n; div++) {
                divCount++;
                if (n % div == 0) {
                    isP = false;
                    break;
                }
            }
            if (isP) {
                System.out.println(n);
            }
        }
        System.out.println(divCount);
    }
}

