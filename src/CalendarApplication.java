
import java.io.IOException;
import java.util.*;

class CalendarApplication {


    public static void main(String args[]) throws IOException {

        InputConfigReader config = new InputConfigReader();
        List<Year> years = config.getYearsFromConfig();

        List<MonthCalendarFile> list = new ArrayList<>();

        for (Year year : years) {
            list.addAll(year.getMonths());
        }

        ListIterator<MonthCalendarFile> it =  list.listIterator();
        while (it.hasNext()) {
            MonthCalendarFile previous = null, next = null;

            if (it.hasPrevious()) {
                previous = list.get(it.previousIndex());
            }

            MonthCalendarFile calendarFile = it.next();

            if (it.hasNext()) {
                next = list.get(it.nextIndex());
            }

            calendarFile.writeToFile(previous, next);
        }
   }
}
