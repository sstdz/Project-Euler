package com.github.sstdz.projecteulertasks.problem1;

import java.util.stream.IntStream;

public class Multiples {
    /*
    * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
    * Find the sum of all the multiples of 3 or 5 below 1000.
    * */

    public static void main(String[] args) {
        Multiples multiples = new Multiples(0, 1000, 3, 5);
        int sumOfMultiplesNumbers = multiples.getSumOfMultiplesNumbers();
        System.out.println(sumOfMultiplesNumbers);
    }



    private int min;
    private int max;
    private int[] numbers;

    public Multiples(int min, int max, int... multiplesTo){
        checkLimitationOrder(min, max);
        checkZeroValue(multiplesTo);

        this.min = min;
        this.max = max;
        this.numbers = multiplesTo;
    }

    private void checkZeroValue(int[] multiplesTo) {
        for (int i : multiplesTo) {
            if (i == 0) {
                throw new ZeroValueException("Can not to divide on zero");
            }
        }
    }

    private void checkLimitationOrder(int min, int max) {
        if (min > max){
            throw new WrongMinMaxOrderException("Wrong order, first variable should be minimum, second - maximum");
        }
    }

    public int getSumOfMultiplesNumbers(){
        return IntStream.range(min, max)
                .filter(value -> {
                    for (int number : numbers) {
                        if (value % number == 0) {
                            return true;
                        }
                    }
                    return false;
                })
                .reduce((left, right) -> left + right)
                .getAsInt();
    }
}
