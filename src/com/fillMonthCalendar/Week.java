package com.fillMonthCalendar;

import java.util.ArrayList;
import java.util.Calendar;

public class Week {
    public static final int DAYS_IN_WEEK = 7;

    ArrayList <WeekDay> weekDays = new ArrayList<WeekDay>();

    Calendar calendar;

    public Week(Calendar calendar) {
        Calendar c = Calendar.getInstance();
        c.setTime(calendar.getTime());
        this.calendar = c;
        populateWeekDays();
    }

    private void populateWeekDays() {
        Calendar c = Calendar.getInstance();
        c.setTime(calendar.getTime());

        int currentDayOfWeek = c.get(Calendar.DAY_OF_WEEK);

        c.add(Calendar.DAY_OF_YEAR, - (currentDayOfWeek - 1));

        for (int i = 0; i < DAYS_IN_WEEK; i++) {
            weekDays.add(new WeekDay(c));
            c.add(Calendar.DAY_OF_YEAR, 1 );
        }
    }

    public Week createNextWeek(){
        Calendar c = Calendar.getInstance();

        c.setTime(weekDays.get(6).getCalendar().getTime());
        c.add(Calendar.DAY_OF_YEAR, 1 );

        return new Week(c);
    }

    public boolean isCurrentMonth(Calendar calendar) {
        Calendar c = Calendar.getInstance();
        c.setTime(calendar.getTime());
        return weekDays.get(0).getCalendar().get(Calendar.MONTH) == weekDays.get(6).getCalendar().get(Calendar.MONTH);
    }

    public ArrayList <WeekDay> getDays() {
        return weekDays;
    }

}

