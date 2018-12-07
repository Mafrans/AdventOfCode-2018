package me.mafrans.adventofcode.day6;

import me.mafrans.adventofcode.general.MaUtil;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class Puzzle1 {
    public static void main(String[] args) throws IOException {
        String stringInput = MaUtil.readResource("day6-input.txt", Charset.defaultCharset());
        String[] inputArray = stringInput.split("\\r?\\n");

        int xSize = 0;
        int ySize = 0;
        for (String input : inputArray) {
            int x = Integer.parseInt(input.replace(" ", "").split(",")[0]);
            int y = Integer.parseInt(input.replace(" ", "").split(",")[1]);

            if (x > xSize) {
                xSize = x;
            }
            if (y > ySize) {
                ySize = y;
            }
        }


        int[][] coords = new int[xSize + 1][ySize + 1];
        Map<Integer, int[]> bases = new HashMap<>();
        int i = 0;
        for (String input : inputArray) {
            int x = Integer.parseInt(input.replace(" ", "").split(",")[0]);
            int y = Integer.parseInt(input.replace(" ", "").split(",")[1]);



            coords[x][y] = i;
            bases.put(i+1, new int[] {x, y});
            i++;
        }

        for(int x = 0; x < coords.length; x++) {
            for(int y = 0; y < coords[x].length; y++) {

                int shortestDistance = 0;
                int shortestId = 0;
                for(int id : bases.keySet()) {
                    int distance = bases.get(id)[0];
                }

            }
        }

        System.out.println(visualize(coords));
    }

    public static String visualize(int[][] coords) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder out = new StringBuilder();
        for(int x = 0; x < coords.length; x++) {
            for(int y = 0; y < coords[x].length; y++) {
                out.append(coords[x][y] == 0 ? "." : String.valueOf(alphabet.charAt(coords[x][y]%25)).toUpperCase());
            }
            out.append("\n");
        }
        return out.toString();
    }
}
