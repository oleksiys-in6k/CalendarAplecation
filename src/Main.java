import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        CalendarApplication calendarApplication = new CalendarApplication();
        List<MonthCalendarFile> allMonths = calendarApplication.creatingListOfAllMonths();
        calendarApplication.writeEachMonthInOwnFile(allMonths);




    }
}
