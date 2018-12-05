package com.github.algorithms.hackerrank;

public class MinimumSwaps2 {

    public static void main(String[] args) {
        int[] arr1 = {2, 31, 1, 38, 29, 5, 44, 6, 12, 18, 39, 9, 48, 49, 13, 11, 7, 27, 14, 33, 50, 21, 46, 23, 15, 26, 8, 47, 40, 3, 32, 22, 34, 42, 16, 41, 24, 10, 4, 28, 36, 30, 37, 35, 20, 17, 45, 43, 25, 19};
        // 48
        System.out.println(minimumSwaps(arr1));

        int[] arr2 = {1, 3, 5, 2, 4, 6, 7};
        // 3
        System.out.println(minimumSwaps(arr2));
    }

    static int minimumSwaps(int[] arr) {
        int wrongPositions = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                wrongPositions++;
            }
        }

        return wrongPositions - 1;
    }
}
