package com.creatingCalendar;

import com.fillMonthCalendar.MonthCalendar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class InputConfigReader {

    public List<MonthCalendar> getMOnthsFromConfig() throws FileNotFoundException {
        List<MonthCalendar> result = new LinkedList<MonthCalendar>();

        Scanner in = new Scanner(new File("config.txt"));


        while (in.hasNextLine()) {
            Calendar calendar  = Calendar.getInstance();
            int year = 0;
            LinkedList <MonthCalendar> listOfMonth = new LinkedList<>();

            if (in.hasNextInt()) {
                year = calendar.get(Calendar.YEAR);
            }
            if (!in.hasNextInt()) {
                String s = in.nextLine().trim();
                listOfMonth.addAll(Arrays.asList(s.split(" ")));
                result.addAll(new Year(year, listOfMonth));
        }

        Collections.sort(result);

            //ToDo Here

        return result;
    }


//    public List<MonthCalendar> creatingListOfAllMonths() throws FileNotFoundException {
//        InputConfigReader config = new InputConfigReader();
//        List<Year> years = config.getYearsFromConfig();
//
//        List<MonthCalendar> allMonths = new ArrayList<>();
//
//        for (Year year : years) {
//            allMonths.addAll(year.getMonths());
//        }
//        return allMonths;
//    }
//}

}
