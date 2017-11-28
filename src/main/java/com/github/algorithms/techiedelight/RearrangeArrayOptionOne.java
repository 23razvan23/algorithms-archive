package com.github.algorithms.techiedelight;


import java.util.Arrays;

public class RearrangeArrayOptionOne implements IRearrangeArray {

    /**
     * Start from the first element and increase index by 1.
     * At each step, depending on the parity of the position (0 based - 0 is odd):
     * - odd : if current array element is greater than the previous one, swap the elements
     * - even: if current array element is less than the next one, swap the elements
     *
     * @param array The array to be rearranged.
     */
    public void rearrangeArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (needToSwapNeighbours(array, i)) {
                swapNeighbours(array, i);
            }
        }
    }

    private boolean needToSwapNeighbours(int[] array, int index) {
        return (index % 2 == 0) ? array[index] > array[index + 1] : array[index] < array[index + 1];
    }

    private void swapNeighbours(int[] array, int index) {
        int temp = array[index];
        array[index] = array[index + 1];
        array[index + 1] = temp;
    }
}
