
import java.util.Calendar;
import java.util.Date;

public class WeekDay {
    WeekDayType type;
    Calendar calendar;

    public WeekDay(Calendar date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date.getTime());

        this.type = WeekDayType.values()[date.get(Calendar.DAY_OF_WEEK) - 1 ];
        this.calendar = c;
    }

    public WeekDayType getType() {
        return type;
    }

    public int getDayInMonth(){
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public Calendar getCalendar() {
        return calendar;
    }
}
