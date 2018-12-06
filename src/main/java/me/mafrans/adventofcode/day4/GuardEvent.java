package me.mafrans.adventofcode.day4;

import java.util.Date;

public class GuardEvent implements Comparable {
    static int FALLS_ASLEEP = 0;
    static int WAKES_UP = 1;
    public static int NEW_SHIFT = 2;

    private int event;
    private String eventString;
    private int guard;
    private Date date;

    public GuardEvent(int event, String eventString, int guard, Date date) {
        this.event = event;
        this.eventString = eventString;
        this.guard = guard;
        this.date = date;
    }

    GuardEvent() {}

    public String getEventString() {
        return eventString;
    }

    public void setEventString(String eventString) {
        this.eventString = eventString;
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    public int getGuard() {
        return guard;
    }

    public void setGuard(int guard) {
        this.guard = guard;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int compareTo(Object o) {
        return date.compareTo(((GuardEvent)o).getDate());
    }
}
