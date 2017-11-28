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
            final int previousValue = array[i - 1];
            int currentValue = array[i];
            final int nextValue = array[i + 1];

            if (previousValue > currentValue) {
                swap(array, previousValue, currentValue, i - 1, i);
                //current value is updated by the first swap
                currentValue = array[i];
            }


            if (currentValue < nextValue) {
                swap(array, currentValue, nextValue, i, i + 1);
            }
        }
    }

    private void swap(int[] array, int fromValue, int toValue, int fromIndex, int toIndex) {
        array[fromIndex] = toValue;
        array[toIndex] = fromValue;
    }
}
