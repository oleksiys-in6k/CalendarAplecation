package com.fillMonthCalendar;

import java.util.Calendar;

public class WeekDay {
    WeekDayType type;
    Calendar calendar;

    public WeekDay(Calendar date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date.getTime());

        this.type = WeekDayType.values()[date.get(Calendar.DAY_OF_WEEK) - 1 ];
        this.calendar = c;
    }

    public boolean isLastDayOfWeek() {
        return getCalendar().get(Calendar.DAY_OF_MONTH) ==  getCalendar().getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public WeekDayType getType() {
        return type;
    }

    public int getDayInMonth(){
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public Calendar getCalendar() {
        return calendar;
    }
}
