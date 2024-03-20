package org.example.ch02.Algorithm;

public class ListPrimes2 {
    public static void main(String[] args) {
        isPrime();
    }

    private static void isPrime(){
        for (int i = 2; i <= 1000; i++){
            boolean isPrime = true;
            for (int j =2;j<i;j++){
                if (i%j ==0){
                    isPrime = false;
                }
            }
            if(isPrime){
                System.out.println(i);
            }
        }
    }
}
