
public class ConsoleCalendarRender extends AbstractMonthCalendarRenderer {

    private static final String RED = "\u001B[31m";
    private static final String BLACK = "\u001B[0m";
    private static final String TAB = "\t";
    private static final String ENTER = "\n";

    @Override
    public String getOpenDayToken(WeekDayType dayDayType) {
        return TAB;
    }

    @Override
    public String getCloseDayToken() {
        return TAB;
    }

    @Override
    public String getOpenWeekToken() {
        return "";
    }

    @Override
    public String getCloseWeekToken() {
        return ENTER;
    }

    @Override
    public String getOpenMonthToken() {
        return "";
    }

    @Override
    public String getCloseMonthToken() {
        return "";
    }

    @Override
    public String getOpenTitleToken() {
        return TAB ;
    }

    @Override
    public String getCloseTitleToken() {
        return TAB;
    }

}
