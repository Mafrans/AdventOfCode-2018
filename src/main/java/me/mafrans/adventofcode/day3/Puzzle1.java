package me.mafrans.adventofcode.day3;

import me.mafrans.adventofcode.general.MaUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Puzzle1 {
    public static void main(String[] args) throws IOException {
        String stringInput = MaUtil.readResource("day3-input.txt", Charset.defaultCharset());
        String[] inputArray = stringInput.split("\\r?\\n");


        int[][] coords = new int[1000][1000];
        for(String input : inputArray) {
            String[] parsedInput = input.replace(" ", "").replace("#", "").split("[@:]");
            Claim claim = new Claim(parsedInput[0], parsedInput[1].split(",")[0], parsedInput[1].split(",")[1], parsedInput[2].split("x")[0], parsedInput[2].split("x")[1]);

            int totalHeight = claim.getTopMargin() + claim.getHeight();
            int totalWidth = claim.getLeftMargin() + claim.getWidth();
            for(int x = 0; x < 1000; x++) {
                for (int y = 0; y < 1000; y++) {
                    if (x+1 > claim.getLeftMargin() && x+1 <= totalWidth && y+1 > claim.getTopMargin() && y+1 <= totalHeight) {
                        coords[x][y]++;
                    }
                }
            }
        }

        int amount = 0;

        for(int x = 0; x < 1000; x++) {
            for(int y = 0; y < 1000; y++) {
                if(coords[x][y] > 1) {
                    amount++;
                }
            }
        }

        //System.out.println(coords[0].length);
        //System.out.println("Coords: " + visualize(coords));
        System.out.println("Amount of Overlapping Tiles: " + amount);
    }

    private static String visualize(Claim claim) {
        int totalHeight = claim.getTopMargin() + claim.getHeight();
        int totalWidth = claim.getLeftMargin() + claim.getWidth();

        StringBuilder out = new StringBuilder();
        for(int y = 0; y < 1000; y++) {
            for(int x = 0; x < 1000; x++) {
                if(y < claim.getTopMargin() || x < claim.getLeftMargin() || y > totalHeight || x > totalWidth) {
                    out.append(".");
                }
                else {
                    out.append("#");
                }
            }
            out.append("\n");
        }

        return out.toString();
    }

    private static String visualize(int[][] coords) throws IOException {
        StringBuilder out = new StringBuilder();
        for(int y = 0; y < 1000; y++) {
            for(int x = 0; x < 1000; x++) {
                out.append(coords[x][y]);
                //System.out.println(x + ", " + y);
            }
            out.append("\n");
        }

        File file = new File("test.txt");
        FileUtils.writeStringToFile(file, out.toString());

        return out.toString();
    }
}
