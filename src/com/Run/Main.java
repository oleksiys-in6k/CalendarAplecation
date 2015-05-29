package com.Run;

import com.creatingCalendar.MonthCalendarFile;
import com.render.CalendarRender;
import com.render.ConsoleCalendarRender;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.FileNotFoundException;
import java.util.List;


public class Main {


    public static void main(String[] args) throws FileNotFoundException {
//        BeanFactory beanFactory = new FileSystemXmlApplicationContext("src/com/spring-config.xml");
//        com.Run.CalendarApplication calendarApplication = (com.Run.CalendarApplication) beanFactory.getBean("applicationContext.xml");
//        calendarApplication.execute();



        CalendarApplication calendarApplication = new CalendarApplication();
        calendarApplication.execute();
        List<MonthCalendarFile> allMonths = calendarApplication.creatingListOfAllMonths();
//        calendarApplication.writeEachMonthInOwnFile(allMonths);
//        calendarApplication.writeEachMonthInConsole(allMonths);

//        CalendarRender calendarRender = new ConsoleCalendarRender();
//        calendarApplication.setCalendarRender(calendarRender);
//        System.out.println(calendarRender);
//        System.out.println(allMonths.toString());

    }

}
