package me.mafrans.adventofcode.day4;

public class Guard {
    public int id;
    public int minutesSlept;
    public int[] timesSlept;

    public Guard() {
        id = 0;
        minutesSlept = 0;
        timesSlept = new int[60];
    }
}
