//package com.springReader;
//
//import com.fillMonthCalendar.MonthCalendar;
//import com.run.IMonthReader;
//import com.creatingCalendar.InputConfigReader;
//import com.creatingCalendar.MonthCalendarFile;
//import com.creatingCalendar.Year;
//
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class ConfigFile implements IMonthReader {
//
//    public List<MonthCalendarFile> creatingListOfAllMonths() throws FileNotFoundException {
//        InputConfigReader config = new InputConfigReader();
//        List<Year> years = config.getYearsFromConfig();
//
//        List<MonthCalendarFile> allMonths = new ArrayList<>();
//
//        for (Year year : years) {
//            allMonths.addAll(year.getMonths());
//        }
//        return allMonths;
//    }
//
//    @Override
//    public List<MonthCalendar> getYears() {
//        return null;
//    }
//}
