package com.github.algorithms.topcoder;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TennisRalliesTest {
    private TennisRallies victim;

    @Before
    public void setup() {
        victim = new TennisRallies();
    }

    @Test
    public void testMinimumShotsLengthAndNoForbiddenShots() {
        assertEquals(2, victim.howMany(1, new String[]{}, 1));
    }

    @Test
    public void testMinimumShotsLengthAndCrossForbiddenShot() {
        assertEquals(1, victim.howMany(1, new String[]{"c"}, 1));
    }

    @Test
    public void testMinimumShotsLengthAndDownTheLineForbiddenShot() {
        assertEquals(1, victim.howMany(1, new String[]{"d"}, 1));
    }

    @Test
    public void testAllShotsForbidden() {
        assertEquals(0, victim.howMany(18, new String[]{"c", "d"}, 1));
    }

    @Test
    public void testMaximumShotsLengthAndNoForbiddenShots() {
        assertEquals(262144, victim.howMany(18, new String[]{}, 1));
    }

    @Test
    public void testMaximumShotsLengthAndCrossForbiddenShots() {
        assertEquals(262122, victim.howMany(18, new String[]{"c", "cc", "ccc", "cccc", "ccccc", "cccccc", "ccccccc", "cccccccc", "ccccccccc", "cccccccccc"}, 100));
    }
}
