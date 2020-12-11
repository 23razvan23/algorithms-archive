package com.github.algorithms.hackerrank.challenges;

import java.io.*;

public class CountingValleys {
    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        int level = 0;
        boolean wasBelowSeaLevel = false;
        int valleys = 0;

        for (int step = 0; step < steps; step++) {
            if (isUpStep(path, step)) {
                level++;
            } else if (isDownStep(path, step)) {
                level--;
            }

            if (level < 0) {
                wasBelowSeaLevel = true;
            } else if (level > 0) {
                wasBelowSeaLevel = false;
            } else {
                if (wasBelowSeaLevel) {
                    valleys++;
                }
            }
        }

        return valleys;
    }

    private static boolean isDownStep(String path, int step) {
        return isStepType(path, step, 'D');
    }

    private static boolean isUpStep(String path, int step) {
        return isStepType(path, step, 'U');
    }

    private static boolean isStepType(String path, int step, char stepType) {
        return path.charAt(step) == stepType;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = CountingValleys.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
