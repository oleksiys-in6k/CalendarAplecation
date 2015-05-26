import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Calendar;

public class MonthCalendarFile {
    public static ICalendarRender iCalendarRender;

    private static final String HTMLEXTENSION = ".index";
    private Calendar calendar = Calendar.getInstance();
    private MonthCalendar monthCalendar;
    private File file;

    public MonthCalendarFile(Calendar calendar) {
        this.calendar.setTime(calendar.getTime());
        this.monthCalendar = new MonthCalendar(calendar);
        this.file = new File(getPathToFile(calendar));

        deleteOutputDirectory( new File("output"));

    }

    private void deleteOutputDirectory(File directory) {
        if (directory.isDirectory()) {
            String[] children = directory.list();
            for (int i=0; i<children.length; i++) {
                File susItem = new File(directory, children[i]);
                deleteOutputDirectory(susItem);
            }
            directory.delete();
        } else directory.delete();
    }

    private String getPathToFile(Calendar c) {
        return "output"
                + File.separator
                + c.get(calendar.YEAR)
                +  File.separator
                +  setCorrectMonth(c.get(Calendar.MONTH))
                + HTMLEXTENSION;
    }

    public void writeToFile() throws FileNotFoundException {
        File directory = new File(file.getParent() + "/");
        if (directory.exists() == false) {
            directory.mkdirs();
        }

        PrintWriter writer = new PrintWriter(file);
        iCalendarRender = new HTMLCalendarRender();
        writer.println(iCalendarRender.render(monthCalendar));
        writer.close();
    }

    private String setCorrectMonth(int c) {
        switch (c) {
            case Calendar.JANUARY:  return "janyary";
            case Calendar.FEBRUARY: return "february";
            case Calendar.MARCH:    return "march";
            case Calendar.APRIL:    return "april";
            case Calendar.MAY:      return "may";
            case Calendar.JUNE:     return "june";
            case Calendar.JULY:     return "july";
            case Calendar.AUGUST:   return "august";
            case Calendar.SEPTEMBER:return "september";
            case Calendar.OCTOBER:  return "october";
            case Calendar.NOVEMBER: return "november";
            case Calendar.DECEMBER: return "december";
        }
        return null;
    }
}
