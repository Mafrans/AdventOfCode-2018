package me.mafrans.adventofcode.day4;

import me.mafrans.adventofcode.general.MaUtil;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Puzzle1 {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
    public static void main(String[] args) throws IOException, ParseException {
        String stringInput = MaUtil.readResource("day4-input.txt", Charset.defaultCharset());
        String[] inputArray = stringInput.split("\\r?\\n");

        List<GuardEvent> events = new ArrayList<>();

        // Set Dates and events
        for(String input : inputArray) {
            String dateString = input.split("]")[0].substring(1);
            String eventString = input.split("]")[1].substring(1);
            int event = 0;

            switch (eventString) {
                case "wakes up":
                    event = GuardEvent.WAKES_UP;
                    break;
                case "falls asleep":
                    event = GuardEvent.FALLS_ASLEEP;
                    break;

                default:
                    event = GuardEvent.NEW_SHIFT;
                    break;
            }

            Date date = dateFormat.parse(dateString);

            GuardEvent guardEvent = new GuardEvent();
            guardEvent.setDate(date);
            guardEvent.setEvent(event);
            guardEvent.setEventString(eventString);

            events.add(guardEvent);
        }

        Collections.sort(events);

        // Set Guards
        List<Guard> guards = new ArrayList<>();
        int currentGuard = 0;
        GuardEvent lastEvent = null;
        for(GuardEvent guardEvent : events) {
            if(guardEvent.getEvent() == GuardEvent.NEW_SHIFT) {
                currentGuard = Integer.parseInt(guardEvent.getEventString().split(" ")[1].substring(1));
            }
            guardEvent.setGuard(currentGuard);


            Guard guard = new Guard();
            guard.id = currentGuard;
            for(Guard g : guards) {
                if(g.id == currentGuard) {
                    guard = g;
                }
            }

            if(lastEvent != null) {
                if(lastEvent.getEvent() == GuardEvent.FALLS_ASLEEP) {
                    int minutesSince = (int) (Math.abs(guardEvent.getDate().getTime() - lastEvent.getDate().getTime())/60000);
                    guard.minutesSlept += minutesSince;
                    for(int i = 0; i < minutesSince; i++) {
                        guard.timesSlept[lastEvent.getDate().getMinutes() + i]++;
                    }
                }
            }

            guards.add(guard);
            lastEvent = guardEvent;
        }

        Guard longestSleeper = new Guard();
        for(Guard guard : guards) {
            if(guard.minutesSlept > longestSleeper.minutesSlept) {
                longestSleeper = guard;
            }
        }

        int minuteMostSlept = 0;
        for(int m = 0; m < longestSleeper.timesSlept.length; m++) {
            if(longestSleeper.timesSlept[m] > longestSleeper.timesSlept[minuteMostSlept]) {
                minuteMostSlept = m;
            }
        }

        System.out.println("Longest Sleeper: " + longestSleeper.id + " slept for " + longestSleeper.minutesSlept + " minutes");
        System.out.println("Minute most Slept on: " + minuteMostSlept);
    }
}
