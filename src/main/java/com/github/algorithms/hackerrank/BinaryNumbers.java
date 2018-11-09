package com.github.algorithms.hackerrank;

import java.util.Arrays;

/**
 * Objective
 * Today, we're working with binary numbers. Check out the Tutorial tab for learning materials and an instructional video!
 * <p>
 * Task
 * Given a base- integer, , convert it to binary (base-). Then find and print the base- integer denoting the maximum number of consecutive 's in 's binary representation.
 * <p>
 * Input Format
 * <p>
 * A single integer, .
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Print a single base- integer denoting the maximum number of consecutive 's in the binary representation of .
 * <p>
 * Sample Input 1
 * <p>
 * 5
 * Sample Output 1
 * <p>
 * 1
 * Sample Input 2
 * <p>
 * 13
 * Sample Output 2
 * <p>
 * 2
 * Explanation
 * <p>
 * Sample Case 1:
 * The binary representation of  is , so the maximum number of consecutive 's is .
 * <p>
 * Sample Case 2:
 * The binary representation of  is , so the maximum number of consecutive 's is .
 */
public class BinaryNumbers {

    public static void main(String[] args) {
        BinaryNumbers binaryNumbers = new BinaryNumbers();
        int[] tests = {5, 13, 27, 81, 100, 200, 1_000_001};

        Arrays.stream(tests)
                .forEach(binaryNumbers::printResults);
    }

    private int max0or1ConfigurableBase2(int n, int expected) {
        int max = 0;
        int counter = 0;

        while (n >= 1) {
            if (n % 2 == expected) {
                counter++;
            } else {
                if (counter > max) {
                    max = counter;
                }
                counter = 0;
            }
            n /= 2;
        }

        return counter > max ? counter : max;
    }

    private int max0or1Base2(int n) {
        int max = 0;
        int counter = n >= 1 ? 1 : 0;
        int previous = n >= 1 ? n % 2 : 0;
        n = n >= 1 ? n / 2 : n;

        while (n >= 1) {
            int remainder = n % 2;

            if (remainder == previous) {
                counter++;
            } else {
                previous = remainder;
                if (counter > max) {
                    max = counter;
                }
                counter = 1;
            }
            n /= 2;
        }

        return counter > max ? counter : max;
    }

    private void printResults(int n) {
        System.out.println("decimal(" + n + ") = binary(" + Integer.toBinaryString(n) + ")");
        System.out.println("max0Base2: " + max0or1ConfigurableBase2(n, 0));
        System.out.println("max1Base2: " + max0or1ConfigurableBase2(n, 1));
        System.out.println("max0or1Base2: " + max0or1Base2(n));
        System.out.println();
    }
}
