package com.github.algorithms.hackerrank.stacksandqueues.largestrectangle;

import java.util.ArrayList;
import java.util.List;

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
        List<Rectangle> rectangles = new ArrayList<>();
        int largestRectangle = 0;

        for (int i = 0; i < h.length; i++) {
            Rectangle rectangle = new Rectangle(h[i]);
            rectangles.add(rectangle);

            scanLeftNeighbours(rectangles);
            scanRightNeighbours(h, i, rectangle);

            if (rectangle.size() > largestRectangle) {
                largestRectangle = rectangle.size();
            }
        }

        return largestRectangle;
    }

    private static void scanLeftNeighbours(List<Rectangle> rectangles) {
        int position = rectangles.size() - 1;
        Rectangle rectangle = rectangles.get(position);

        while (--position >= 0
                && isValidNeighbour(rectangles.get(position).height(), rectangle.height())) {
            rectangle.increaseSize();
        }
    }

    private static void scanRightNeighbours(int[] heights, int position, Rectangle rectangle) {
        while (++position < heights.length
                && isValidNeighbour(heights[position], rectangle.height())) {
            rectangle.increaseSize();
        }
    }

    private static boolean isValidNeighbour(int neighbourHeight, int height) {
        return neighbourHeight >= height;
    }
}
