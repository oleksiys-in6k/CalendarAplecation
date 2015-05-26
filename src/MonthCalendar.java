
import java.util.ArrayList;
import java.util.Calendar;

public class MonthCalendar {

    private ArrayList<Week> weeks = new ArrayList<Week>();

    Calendar calendar;

    public MonthCalendar(Calendar calendar) {

        this.calendar = calendar;

        Week week = new Week(calendar);
        weeks.add(week);

        do {
            week = week.createNextWeek();
            weeks.add(week);
        } while (week.isCurrentMonth(calendar));
    }

    public ArrayList<Week> getWeeks() {
        return weeks;
    }

}
