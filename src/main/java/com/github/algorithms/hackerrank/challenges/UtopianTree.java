package com.github.algorithms.hackerrank.challenges;

public class UtopianTree {
    public static void main(String[] args) {
        //1
        System.out.println(utopianTree(0));
        //2
        System.out.println(utopianTree(1));
        //7
        System.out.println(utopianTree(4));
        //6
        System.out.println(utopianTree(3));
    }

    // Complete the utopianTree function below.
    static int utopianTree(int n) {
        int period = 0;
        int h = 1;

        while (period++ < n) {
            if (period % 2 == 0) {
                h++;
            } else {
                h *= 2;
            }
        }

        return h;
    }
}
