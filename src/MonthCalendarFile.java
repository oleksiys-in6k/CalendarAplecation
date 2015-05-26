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
                +  new SwitchesOfMonth().getMonthNameByIndex((c.get(Calendar.MONTH)))
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

}
