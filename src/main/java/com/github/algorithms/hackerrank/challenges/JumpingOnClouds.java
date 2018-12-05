package com.github.algorithms.hackerrank.challenges;

public class JumpingOnClouds {
    public static void main(String[] args) {
        //3
        System.out.println(jumpingOnClouds(new int[]{0, 0, 0, 0, 1, 0}));
        //3
        System.out.println(jumpingOnClouds(new int[]{0, 0, 0, 1, 0, 0}));
        //4
        System.out.println(jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 0}));
    }

    static int jumpingOnClouds(int[] c) {
        int jumps = 0;

        int cloudIndex = 0;
        while (cloudIndex < c.length - 2) {
            cloudIndex += (c[cloudIndex + 2] % 2 == 0) ? 2 : 1;
            jumps++;
        }

        return cloudIndex != c.length - 1 ? ++jumps : jumps;
    }
}
