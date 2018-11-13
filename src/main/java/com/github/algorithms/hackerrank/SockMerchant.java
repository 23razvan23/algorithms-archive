package com.github.algorithms.hackerrank;

public class SockMerchant {

    public static void main(String[] args) {
        System.out.println(sockMerchant(9, new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20}));

        System.out.println(sockMerchant(10, new int[]{1, 1, 3, 1, 2, 1, 3, 3, 3, 3}));
    }

    static int sockMerchant(int n, int[] ar) {
        int pairs = 0;
        int[] sortedPairs = new int[100];

        for (int a : ar) {
            if (++sortedPairs[a - 1] % 2 == 0) {
                pairs++;
            }
        }

        return pairs;
    }
}
