package com.github.algorithms.hackerrank.stacksandqueues;

import java.util.ArrayDeque;
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
        //each deque will keep as first element the height and as the last element the rectangle size
        List<ArrayDeque<Integer>> rectangles = new ArrayList<>();
        int rectanglesIndex = -1;

        int largestRectangle = 0;

        for (int i = 0; i < h.length; i++) {
            int height = h[i];

            ArrayDeque<Integer> rectangle = initRectangle(height);
            rectangles.add(rectangle);
            rectanglesIndex++;

            scanLeftNeighbours(rectangles, rectanglesIndex);
            scanRightNeighbours(h, i, rectangle);

            Integer rectangleSize = rectangleSize(rectangle);
            if (rectangleSize > largestRectangle) {
                largestRectangle = rectangleSize;
            }
        }

        return largestRectangle;
    }

    private static ArrayDeque<Integer> initRectangle(int height) {
        ArrayDeque<Integer> rectangle = new ArrayDeque<>();
        rectangle.add(height);
        return rectangle;
    }

    private static void scanLeftNeighbours(List<ArrayDeque<Integer>> rectangles, int startIndex) {
        ArrayDeque<Integer> rectangle = rectangles.get(startIndex);
        int height = rectangle.getFirst();

        for (int i = startIndex - 1; i >= 0; i--) {
            Integer neighbourHeight = rectangles.get(i).getFirst();
            if (!isValidNeighbour(neighbourHeight, height)) {
                break;
            }

            rebuildRectangleSizeAtTop(rectangle, height);
        }
    }

    private static void scanRightNeighbours(int[] heights, int startIndex, ArrayDeque<Integer> rectangle) {
        Integer height = rectangle.getFirst();

        for (int i = startIndex + 1; i < heights.length; i++) {
            if (!isValidNeighbour(heights[i], height)) {
                break;
            }

            rebuildRectangleSizeAtTop(rectangle, height);
        }
    }

    private static Integer rectangleSize(ArrayDeque<Integer> deque) {
        return deque.getLast();
    }

    private static void rebuildRectangleSizeAtTop(ArrayDeque<Integer> deque, int height) {
        deque.add(rectangleSize(deque) + height);
    }

    private static boolean isValidNeighbour(int neighbourHeight, int height) {
        return neighbourHeight >= height;
    }
}
