package com.github.sstdz.projecteulertasks.problem4;

import java.util.Arrays;
import java.util.Collections;

public class LargestPalindromeNumbers {

    /**
     * A palindromic number reads the same both ways.
     * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
     * Find the largest palindrome made from the product of two 3-digit numbers.
     */

    public static void main(String[] args) {
        int biggestMultiplyPalindrome = LargestPalindromeNumbers.getBiggestMultiplyPalindrome(2, 2);
    }

    public static int getBiggestMultiplyPalindrome(int... bases) {
        int[] maxs = getGroupMaxNumbers(bases);

        int maxLimit = 9;
        int minLimit = maxLimit;

        while (minLimit >= 0){
            int result = getAllNumbersMult(maxs);

            if (isPalindrome(result)){
                return result;
            }

            if (allValuesEquals(maxs, minLimit)){
                minLimit--;
            }

            updateValues(maxs, minLimit);
        }



        return 0;
    }

    private static void updateValues(int[] maxs, int minLimit) {
        for (int i = maxs.length - 1; i >= 0 ; i++) {
            int numb = maxs[i];

            if (numb != minLimit) {
                maxs[i] = minLimit;
                break;
            }
        }
    }

    private static boolean allValuesEquals(int[] numbers, int x) {
        for (int number : numbers) {
            if (number != x){
                return false;
            }
        }

        return true;
    }

    private static int getAllNumbersMult(int[] numbers) {
        return Arrays.stream(numbers)
                .reduce((left, right) -> left * right)
                .getAsInt();
    }

    private static int[] getGroupMaxNumbers(int[] bases) {
        return Arrays.stream(bases)
                .map(LargestPalindromeNumbers::buildMaxNumberWithBase)
                .toArray();
    }

    private static int buildMaxNumberWithBase(int base) {
        String maxNumberWithBase = String.join("", Collections.nCopies(base, "9"));
        return Integer.parseInt(maxNumberWithBase);
    }

    private static boolean isPalindrome(int result) {
        return isPalindrome(String.valueOf(result));
    }

    private static boolean isPalindrome(String value) {
        char[] chars = value.toCharArray();

        int arrayLength = chars.length;
        for (int i = 0; i < arrayLength / 2; i++) {
            char startChar = chars[i];
            char endChar = chars[arrayLength - i - 1];

            if (startChar != endChar) {
                return false;
            }
        }

        return true;
    }
}
