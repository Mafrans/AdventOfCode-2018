package me.mafrans.adventofcode.day2;

import me.mafrans.adventofcode.general.MaUtil;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Puzzle1 {
    public static void main(String[] args) throws IOException {
        String stringInput = MaUtil.readResource("day2-input.txt", Charset.defaultCharset());
        String[] inputArray = stringInput.split("\\r?\\n");
        Map<String, Map<Character, Integer>> boxMaps = new HashMap<>();

        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for(String input : inputArray) {
            Map<Character, Integer> map = new HashMap<>();
            if(boxMaps.containsKey(input)) {
                map = boxMaps.get(input);
            }

            for (int i = 0; i < alphabet.length(); i++) {
                char letter = alphabet.charAt(i);

                for(int n = 0; n < input.length(); n++) {
                    char inputLetter = input.charAt(n);
                    int c = 0;

                    if(map.containsKey(letter)) {
                        c = map.get(letter);
                    }

                    if(inputLetter == letter) {
                        c++;
                    }
                    map.put(letter, c);
                }
            }

            boxMaps.put(input, map);
        }

        int twos = 0;
        int threes = 0;
        for(String input : boxMaps.keySet()) {
            Map<Character, Integer> map = boxMaps.get(input);
            boolean canTwo = true;
            boolean canThree = true;

            int tempTwos = 0;
            int tempThrees = 0;
            for(int i : map.values()) {
                if(canTwo && i == 2) {
                    tempTwos++;
                    canTwo = false;
                }
                if(canThree && i == 3) {
                    tempThrees++;
                    canThree = false;
                }
            }
            twos += tempTwos;
            threes += tempThrees;
        }

        System.out.println("Twos: " + twos);
        System.out.println("Threes: " + threes);
        System.out.println("Checksum: " + (twos * threes));
    }
}
