package com.springReader;

import com.creatingCalendar.Year;
import com.fillMonthCalendar.MonthCalendar;
import com.run.IMonthReader;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by LEX on 29.05.2015.
 */
public class TodayInput implements IMonthReader {


    @Override
    public List<MonthCalendar> getYears() {

        List<Year> result = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,1);

        MonthCalendar monthCalendar = new MonthCalendar(calendar);
        List <MonthCalendar> list = new ArrayList <> ();
        list.add(monthCalendar);

        return list;
    }
}

