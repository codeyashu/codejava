package code.rsi.dsaalgo.algo.math;

import lombok.extern.log4j.Log4j2;

import java.util.stream.IntStream;

public class FindPrimeNumber {
    public static void main(String[] args) {
        int range = 50;
        IntStream.rangeClosed(1, range)
                .forEach(value -> System.out.println(value + " is a prime number => " + isPrimeNumber(value)));
    }

    private static boolean isPrimeNumber(int num) {
        // number should not be less than 0
        // if number is 1 or 2 , number is prime number
        // iterate number from 2 to sqrt(n)

        if (num < 0) return false;
        if (num == 1 || num == 2) return true;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
