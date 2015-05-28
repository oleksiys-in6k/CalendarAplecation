package com.Run;

import com.creatingCalendar.MonthCalendarFile;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        BeanFactory beanFactory = new FileSystemXmlApplicationContext("/com/spring-config.xml");
//        CalendarApplication calendarApplication = (CalendarApplication) beanFactory.getBean("calendarApplication");
       // com.Run.CalendarApplication calendarApplication = (com.Run.CalendarApplication) beanFactory.getBean("applicationContext.xml");
//        com.Run.CalendarApplication.execute();


//        List<com.creatingCalendar.MonthCalendarFile> allMonths = (List<com.creatingCalendar.MonthCalendarFile>) context.getBean("printCalendarToHTML");
//        System.out.println(allMonths);

//        CalendarApplication calendarApplication = (CalendarApplication) context.getBean("printCalendarToHTML");
//        calendarApplication.executeCalendarApplication();

        //te.spellCheck();


        CalendarApplication calendarApplication = new CalendarApplication();
        List<MonthCalendarFile> allMonths = calendarApplication.creatingListOfAllMonths();
//        calendarApplication.writeEachMonthInOwnFile(allMonths);
        calendarApplication.writeEachMonthInConsole(allMonths);

    }

}
