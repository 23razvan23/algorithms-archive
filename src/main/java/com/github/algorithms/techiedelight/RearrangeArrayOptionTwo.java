package com.github.algorithms.techiedelight;


public class RearrangeArrayOptionTwo implements IRearrangeArray {

    /**
     * Start from the second element and increase index by 2.
     * At each step, check if the current array element is less than the previous and the next one, and swap the elements.
     *
     * @param array The array to be rearranged.
     */
    public void rearrangeArray(int[] array) {
        for (int i = 1; i < array.length - 1; i = i + 2) {
            if (array[i - 1] > array[i]) {
                swap(array, i - 1, i);
            }
            if (array[i] < array[i + 1]) {
                swap(array, i, i + 1);
            }
        }
    }

    private void swap(int[] array, int fromIndex, int toIndex) {
        int temp = array[fromIndex];
        array[fromIndex] = array[toIndex];
        array[toIndex] = temp;
    }
}
