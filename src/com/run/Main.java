package com.run;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.FileNotFoundException;


public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        BeanFactory beanFactory = new FileSystemXmlApplicationContext("src/com/spring-config.xml");
        CalendarApplication calendarApplication = (CalendarApplication) beanFactory.getBean("calendarApp");
        calendarApplication.execute();



//        CalendarApplication calendarApplication = new CalendarApplication();
//        calendarApplication.execute();
//        List<MonthCalendarFile> allMonths = calendarApplication.creatingListOfAllMonths();
//        calendarApplication.writeEachMonthInOwnFile(allMonths);
//        calendarApplication.writeEachMonthInConsole(allMonths);

//        CalendarRender calendarRender = new ConsoleCalendarRender();
//        calendarApplication.setCalendarRender(calendarRender);
//        System.out.println(calendarRender);
//        System.out.println(allMonths.toString());

    }

}
