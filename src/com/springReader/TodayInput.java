package com.springReader;

import com.Run.IMonthReader;
import com.creatingCalendar.MonthCalendarFile;
import com.creatingCalendar.SwitchesOfMonth;
import com.creatingCalendar.Year;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by LEX on 29.05.2015.
 */
public class TodayInput implements IMonthReader {


    @Override
    public List<Year> getYears() {

        List<Year> result = new ArrayList<>();
        int year = 0;
        String month = null;
        int intmonth = 0;
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        MonthCalendarFile monthCalendarFile = new MonthCalendarFile(calendar);
        intmonth = calendar.get(Calendar.MONTH);

        List months = new ArrayList<>();
        month = SwitchesOfMonth.getMonthNameByIndex(intmonth);
        months.add(month);

        result.add(year, (Year) months);

        return result;
    }
}

