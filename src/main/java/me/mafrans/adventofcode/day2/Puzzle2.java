package me.mafrans.adventofcode.day2;

import me.mafrans.adventofcode.general.MaUtil;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Puzzle2 {
    public static void main(String[] args) throws IOException {
        String stringInput = MaUtil.readResource("day2-input.txt", Charset.defaultCharset());
        String[] inputArray = stringInput.split("\\r?\\n");

        String finalInput = null;
        CharDifference finalDifference = null;
        for(String input : inputArray) {

            boolean first = true;
            for(String input2 : inputArray) {
                if(first) {
                    first = false;
                    continue;
                }

                List<CharDifference> differences = new ArrayList<>();

                for(int i = 0; i < input.length(); i++) {
                    char letter1 = input.charAt(i);
                    char letter2 = input2.charAt(i);

                    if(letter1 != letter2) {
                        CharDifference charDifference = new CharDifference(letter1, letter2, i);
                        differences.add(charDifference);
                    }
                }

                if(differences.size() == 1) {
                    finalInput = input;
                    finalDifference = differences.get(0);
                }
            }
        }

        System.out.println("Final Input: " + finalInput);
        System.out.println("Final Difference: " + finalDifference.getChar1() + "/" + finalDifference.getChar2() + " at " + finalDifference.getPosition());

    }
}
