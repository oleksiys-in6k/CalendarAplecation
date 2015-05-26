
import java.io.IOException;
import java.util.Calendar;

class CalendarApplication {
    public static ICalendarRender iCalendarRender;

    public static final String OUT_PARAMETER = "--out";
    public static final String HTML_PARAMETER = "HTML";
    public static final String TEXT_PARAMETER = "TEXT";
    public static final int ARGS_NUM_OF_OUT = 0;
    public static final int ARGS_NUM_OF_YEAR = 1;
    public static final int ARGS_NUM_OF_MONTH = 2;
public static final int ARGS_NUM_OF_OUT_TEXT = 3;
    public static AbstractMonthCalendarRenderer renderer;


    public static void main(String args[]) throws IOException {




       // LinkedHashMap treeMap = workingWithDirectory.getHashMap();
//        System.out.println(treeMap);
//
//        createNewFilesAndDirectory();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        if (args.length > ARGS_NUM_OF_OUT && args[ARGS_NUM_OF_OUT].equals(OUT_PARAMETER)) {
            args[ARGS_NUM_OF_OUT_TEXT] = args[ARGS_NUM_OF_OUT_TEXT].toUpperCase();
            if (args[ARGS_NUM_OF_OUT_TEXT].equals(HTML_PARAMETER))
                renderer = new HTMLCalendarRender();
            if (args[ARGS_NUM_OF_OUT_TEXT].equals(TEXT_PARAMETER))
                renderer = new ConsoleCalendarRender();
            if (renderer == null) {
                System.out.println("Error: enter correct --out argumnet");
                System.exit(0);
            }

            WorkingWithDirectory workingWithDirectory = new WorkingWithDirectory();

//            MonthCalendar monthCalendar = new MonthCalendar(calendar);
//            System.out.println(renderer.render(monthCalendar));

        } else
            System.out.println("Please enter right arguments: YYYY MMM --out [HTML][TEXT]");
    }
}
