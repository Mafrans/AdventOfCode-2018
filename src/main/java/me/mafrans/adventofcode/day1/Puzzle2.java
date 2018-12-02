package me.mafrans.adventofcode.day1;

import me.mafrans.adventofcode.general.MaUtil;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Puzzle2 {
    public static void main(String[] args) throws IOException {
        String stringInput = MaUtil.readResource("day1-input.txt", Charset.defaultCharset());
        String[] inputArray = stringInput.split("\\r?\\n");
        List<Integer> knownFrequencies = new ArrayList<Integer>();
        System.out.println("Working, this will take a while...");

        int frequency = 0;
        int firstKnown = 0;
        knownFrequencies.add(frequency);
        outer:
        while (true) {
            for (String value : inputArray) {
                if (value.startsWith("+")) {
                    frequency += Integer.parseInt(value.substring(1));
                } else if (value.startsWith("-")) {
                    frequency -= Integer.parseInt(value.substring(1));
                }

                if (knownFrequencies.contains(frequency)) {
                    firstKnown = frequency;
                    break outer;
                }

                knownFrequencies.add(frequency);
            }
        }
        System.out.println("\nFirst Already Known Frequency: " + firstKnown);
    }
}
