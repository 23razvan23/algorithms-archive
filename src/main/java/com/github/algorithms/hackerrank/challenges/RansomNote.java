package com.github.algorithms.hackerrank.challenges;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.util.Optional.ofNullable;
import static java.util.stream.Stream.of;

public class RansomNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        var magazineWordsMap = buildMagazineWordsOccurrencesMap(magazine);

        boolean allNoteWordsPresent = of(note)
                .allMatch(noteWord -> {
                    int noteWordCount = ofNullable(magazineWordsMap.get(noteWord)).orElse(0);
                    magazineWordsMap.put(noteWord, noteWordCount - 1);
                    return noteWordCount > 0;
                });

        if (allNoteWordsPresent) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static Map<String, Integer> buildMagazineWordsOccurrencesMap(String[] magazine) {
        var result = new HashMap<String, Integer>();

        of(magazine)
                .forEach(magazineWord -> result.compute(magazineWord,
                        (key, value) -> ofNullable(value).orElse(0) + 1));

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}

