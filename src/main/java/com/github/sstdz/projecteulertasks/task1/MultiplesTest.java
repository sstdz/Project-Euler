package com.github.sstdz.projecteulertasks.task1;

import org.junit.Assert;
import org.junit.Test;

public class MultiplesTest {
    @Test
    public void multiplesSumGettingTest() {
        Multiples multiples = new Multiples(0, 10, 3, 5);
        int sumOfMultiplesNumbers = multiples.getSumOfMultiplesNumbers();
        Assert.assertEquals(sumOfMultiplesNumbers, 23);

        Multiples multiples2 = new Multiples(0, 1000, 3, 5);
        int sumOfMultiplesNumbers2 = multiples2.getSumOfMultiplesNumbers();
        Assert.assertEquals(sumOfMultiplesNumbers2, 233168);
    }

    @Test(expected = WrongMinMaxOrderException.class)
    public void multiplesWrongMinMaxOrderTest() {
        Multiples multiples = new Multiples(10, 1, 3, 5);
        int sumOfMultiplesNumbers = multiples.getSumOfMultiplesNumbers();
    }

    @Test(expected = ZeroValueException.class)
    public void zeroInArray() {
        Multiples multiples = new Multiples(1, 5, 0, 2, 3, 5);
        int sumOfMultiplesNumbers = multiples.getSumOfMultiplesNumbers();
    }

    @Test
    public void multiplesEmptyArray() {
        Multiples multiples = new Multiples(0, 10);
        int sumOfMultiplesNumbers = multiples.getSumOfMultiplesNumbers();
        Assert.assertEquals(sumOfMultiplesNumbers, 0);
    }
}
