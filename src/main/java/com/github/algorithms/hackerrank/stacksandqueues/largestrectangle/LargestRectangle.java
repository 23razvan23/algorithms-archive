package com.github.algorithms.hackerrank.stacksandqueues.largestrectangle;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import static com.github.algorithms.hackerrank.stacksandqueues.largestrectangle.Direction.LEFT;
import static com.github.algorithms.hackerrank.stacksandqueues.largestrectangle.Direction.RIGHT;

public class LargestRectangle {

    public static void main(String[] args) {
        //9
        System.out.println(largestRectangle(new int[]{1, 2, 3, 4, 5}));

        //20
        System.out.println(largestRectangle(new int[]{5, 6, 11, 4, 5}));

        //26152
        System.out.println(largestRectangle(new int[]{8979, 4570, 6436, 5083, 7780, 3269, 5400, 7579, 2324, 2116}));
    }

    static long largestRectangle(int[] h) {
        int largestRectangle = 0;

        for (int i = 0; i < h.length; i++) {
            Rectangle rectangle = new Rectangle(h[i]);

            scanNeighbours(LEFT, h, new AtomicInteger(i), rectangle);
            scanNeighbours(RIGHT, h, new AtomicInteger(i), rectangle);

            if (rectangle.size() > largestRectangle) {
                largestRectangle = rectangle.size();
            }
        }

        return largestRectangle;
    }

    private static void scanNeighbours(Direction direction, int[] heights, final AtomicInteger position, Rectangle rectangle) {
        Predicate<Direction> directionPredicate = d ->
                LEFT == direction ? position.decrementAndGet() >= 0
                        : RIGHT == direction && position.incrementAndGet() < heights.length;

        while (directionPredicate.test(direction)
                && isValidNeighbour(heights[position.intValue()], rectangle.height())) {
            rectangle.increaseSize();
        }
    }

    private static boolean isValidNeighbour(int neighbourHeight, int height) {
        return neighbourHeight >= height;
    }
}
