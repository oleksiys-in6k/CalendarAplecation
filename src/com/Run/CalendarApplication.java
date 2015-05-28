package com.Run;

import com.creatingCalendar.InputConfigReader;
import com.creatingCalendar.MonthCalendarFile;
import com.creatingCalendar.Year;
import com.render.ConsoleCalendarRender;
import com.render.HTMLCalendarRender;
import com.render.ICalendarRender;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CalendarApplication {
    ICalendarRender iCalendarRender;

    public List<MonthCalendarFile> creatingListOfAllMonths() throws FileNotFoundException {
        InputConfigReader config = new InputConfigReader();
        List<Year> years = config.getYearsFromConfig();

        List<MonthCalendarFile> allMonths = new ArrayList<>();

        for (Year year : years) {
            allMonths.addAll(year.getMonths());
        }
        return allMonths;
    }

    public void writeEachMonthInConsole(List<MonthCalendarFile> allMonths) {
        ListIterator<MonthCalendarFile> it = allMonths.listIterator();
        while (it.hasNext()) {
            MonthCalendarFile previous = null, next = null;
            if (it.hasPrevious()) {
                previous = allMonths.get(it.previousIndex());
            }

            MonthCalendarFile calendarFile = it.next();

            if (it.hasNext()) {
                next = allMonths.get(it.nextIndex());
            }
            calendarFile.writeToConsole(previous, next);
        }
    }

    public void writeEachMonthInOwnFile(List<MonthCalendarFile> allMonths) throws FileNotFoundException {
        ListIterator<MonthCalendarFile> it = allMonths.listIterator();
        while (it.hasNext())

        {
            MonthCalendarFile previous = null, next = null;

            if (it.hasPrevious()) {
                previous = allMonths.get(it.previousIndex());
            }

            MonthCalendarFile calendarFile = it.next();

            if (it.hasNext()) {
                next = allMonths.get(it.nextIndex());
            }
            calendarFile.writeToFile(previous, next);
        }
    }

    public void setPrintToConsole(ConsoleCalendarRender printToConsole) {
        iCalendarRender.render()


    }

    public void setPrintToHTML(HTMLCalendarRender printToHTML) {
    }
}
