package com.springReader;

import com.Run.IMonthReader;
import com.creatingCalendar.Year;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by LEX on 29.05.2015.
 */
public class ConsoleInput implements IMonthReader {
    @Override
    public List<Year> getYears() {
        List<Year> result = new ArrayList<Year>();
        int year, month;
        Scanner in = new Scanner(System.in);
        System.out.print("Input Year: ");
        year = Integer.valueOf(in.next());
        System.out.print("Input Month: ");
        month = Integer.valueOf(in.next()) - 1;
        in.close();
//        result.add(year, (Year) month);

        return result;
    }
}
