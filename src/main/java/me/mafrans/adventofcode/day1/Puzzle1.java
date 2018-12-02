package me.mafrans.adventofcode.day1;

import me.mafrans.adventofcode.general.MaUtil;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Puzzle1 {
    public static void main(String[] args) throws IOException {
        String stringInput = MaUtil.readResource("day1-input.txt", Charset.defaultCharset());
        String[] inputArray = stringInput.split("\\r?\\n");

        int frequency = 0;
        for(String value : inputArray) {
            if(value.startsWith("+")) {
                frequency += Integer.parseInt(value.substring(1));
            }
            else if(value.startsWith("-")) {
                frequency -= Integer.parseInt(value.substring(1));
            }
        }

        System.out.println("Frequency: " + frequency);
    }
}
