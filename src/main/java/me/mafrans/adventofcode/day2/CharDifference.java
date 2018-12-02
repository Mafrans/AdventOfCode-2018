package me.mafrans.adventofcode.day2;

public class CharDifference {
    private char char1;
    private char char2;
    private int position;

    public CharDifference(char char1, char char2, int position) {
        this.char1 = char1;
        this.char2 = char2;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public char getChar1() {
        return char1;
    }

    public void setChar1(char char1) {
        this.char1 = char1;
    }

    public char getChar2() {
        return char2;
    }

    public void setChar2(char char2) {
        this.char2 = char2;
    }
}
