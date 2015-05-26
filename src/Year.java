import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;

public class Year {

    int year;
    ArrayList<MonthCalendarFile> monthes = new ArrayList<MonthCalendarFile>();


    public Year(int year, ArrayList<String> sMonthes) {
        this.year = year;
        fillMonthes(sMonthes);
    }

    private void fillMonthes(ArrayList<String> sMonthes) {
        if (sMonthes.size() == 0)
            inputAllMonthes();

        else {
            inputExistingMonth(sMonthes);
        }
    }

    private void inputExistingMonth(ArrayList<String> sMonthes) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.DAY_OF_MONTH, 1);

        for (String month : sMonthes) {
            c.set(Calendar.MONTH, getCorrectMonth(month));
            monthes.add(new MonthCalendarFile(c));
        }
    }

    private int getCorrectMonth(String s) {

        switch (s.toLowerCase()) {
            case "january": return Calendar.JANUARY;
            case "february": return Calendar.FEBRUARY;
            case "march": return Calendar.MARCH;
            case "april": return Calendar.APRIL;
            case "may": return Calendar.MARCH;
            case "june": return Calendar.JUNE;
            case "july": return Calendar.JULY;
            case "august": return Calendar.AUGUST;
            case "september": return Calendar.SEPTEMBER;
            case "october": return Calendar.OCTOBER;
            case "november": return Calendar.NOVEMBER;
            case "december": return Calendar.DECEMBER;
        }
        return -1;
    }

    private void inputAllMonthes() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.DAY_OF_MONTH, 1);

        for (int monthNumber = 0; monthNumber < 12; monthNumber++  ) {
            c.set(Calendar.MONTH, monthNumber);
            monthes.add(new MonthCalendarFile(c));
        }
    }

    public void writeToFile() throws FileNotFoundException {
        for(MonthCalendarFile mcf : monthes) {

            mcf.writeToFile();
        }
    }
}