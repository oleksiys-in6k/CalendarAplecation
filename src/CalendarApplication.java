
import java.io.FileNotFoundException;

import java.util.*;

class CalendarApplication {

    public void writeEachMonthInOwnFile(List<MonthCalendarFile> allMonths) throws FileNotFoundException {
        ListIterator<MonthCalendarFile> it = allMonths.listIterator();
        while(it.hasNext())

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

    public List<MonthCalendarFile> creatingListOfAllMonths() throws FileNotFoundException {
        InputConfigReader config = new InputConfigReader();
        List<Year> years = config.getYearsFromConfig();

        List<MonthCalendarFile> allMonths = new ArrayList<>();

        for (Year year : years) {
            allMonths.addAll(year.getMonths());
        }
        return allMonths;
    }


}
