package com.springReader;
//
//import com.creatingCalendar.Year;
//import com.fillMonthCalendar.MonthCalendar;
//import com.run.IMonthReader;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
///**
// * Created by LEX on 29.05.2015.

import com.fillMonthCalendar.MonthCalendar;
import com.run.IMonthReader;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ConsoleInput implements IMonthReader {
    @Override
    public List<MonthCalendar> getYears() {
        List<MonthCalendar> result = new ArrayList<MonthCalendar>();

        result.add(new MonthCalendar(Calendar.getInstance()));

        return result;

    }
}
//        List<Year> result = new ArrayList<Year>();
//        int year, month;
//        Scanner in = new Scanner(System.in);
//        System.out.print("Input Year: ");
//        year = Integer.valueOf(in.next());
//        System.out.print("Input Month: ");
//        month = Integer.valueOf(in.next()) - 1;
//        in.close();
//        result.add(year, (Year) month);
//
//        return result;
   // }
//}
