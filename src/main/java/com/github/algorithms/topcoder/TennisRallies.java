package com.github.algorithms.topcoder;

public class TennisRallies {
    private static final String CROSS_COURT_SHOT = "c";
    private static final String DOWN_THE_LINE_SHOT = "d";

    private int count;

    public int howMany(int numLength, String[] forbidden, int allowed) {
        generateRallies(numLength, forbidden, allowed, "");
        return count;
    }

    private void generateRallies(int rallyLength, String[] forbiddenShots, int allowed, String rally) {
        if (generateRally(rallyLength, forbiddenShots, allowed, rally)) {
            return;
        }

        int forbiddenCount = getForbiddenCount(forbiddenShots, rally);
        if (forbiddenCount < allowed){
            count++;
        }
    }

    private boolean generateRally(int length, String[] forbiddenShots, int allowed, String rally) {
        if (rally.length() < length) {
            generateRallies(length, forbiddenShots, allowed, rally + CROSS_COURT_SHOT);
            generateRallies(length, forbiddenShots, allowed, rally + DOWN_THE_LINE_SHOT);
            return true;
        }
        return false;
    }

    private int getForbiddenCount(String[] forbiddenShots, String rally) {
        int count = 0;

        for (String forbiddenShot : forbiddenShots) {
            int index = 0;
            while (rally.indexOf(forbiddenShot, index) != -1) {
                index = rally.indexOf(forbiddenShot, index) + 1;
                count++;
            }
        }
        return count;
    }
}
