package com.github.algorithms.techiedelight;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class RearrangeArrayTest {
    private IRearrangeArray victim1;
    private IRearrangeArray victim2;

    @Before
    public void setup() {
        victim1 = new RearrangeArrayOptionOne();
        victim2 = new RearrangeArrayOptionTwo();
    }

    @Test
    public void testRearrangeArrayEmptyVictim1() {
        testRearrangeArray(
                new int[]{},
                new int[]{},
                victim1
        );
    }

    @Test
    public void testRearrangeArrayEmptyVictim2() {
        testRearrangeArray(
                new int[]{},
                new int[]{},
                victim2
        );
    }

    @Test
    public void testRearrangeArrayElementsSortedVictim1() {
        testRearrangeArray(
                new int[]{1, 2, 3, 4, 5, 6, 7},
                new int[]{1, 3, 2, 5, 4, 7, 6},
                victim1
        );
    }

    @Test
    public void testRearrangeArrayElementsSortedVictim2() {
        testRearrangeArray(
                new int[]{1, 2, 3, 4, 5, 6, 7},
                new int[]{1, 3, 2, 5, 4, 7, 6},
                victim2
        );
    }

    @Test
    public void testRearrangeArrayElementsMixedVictim1() {
        testRearrangeArray(
                new int[]{9, 6, 8, 3, 7},
                new int[]{6, 9, 3, 8, 7},
                victim1
        );
    }

    @Test
    public void testRearrangeArrayElementsMixedVictim2() {
        testRearrangeArray(
                new int[]{9, 6, 8, 3, 7},
                new int[]{6, 9, 3, 8, 7},
                victim2
        );
    }

    @Test
    public void testRearrangeArrayElementsReverseOrderVictim1() {
        testRearrangeArray(
                new int[]{9, 8, 7, 6, 5, 4, 3},
                new int[]{8, 9, 6, 7, 4, 5, 3},
                victim1
        );
    }

    @Test
    public void testRearrangeArrayElementsReverseOrderVictim2() {
        testRearrangeArray(
                new int[]{9, 8, 7, 6, 5, 4, 3},
                new int[]{8, 9, 6, 7, 4, 5, 3},
                victim2
        );
    }

    private void testRearrangeArray(int[] inputArray, int[] expectedArray, IRearrangeArray victim) {
        victim.rearrangeArray(inputArray);
        assertTrue(Arrays.equals(expectedArray, inputArray));
    }

}
