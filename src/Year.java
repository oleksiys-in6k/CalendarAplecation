import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.*;

public class Year implements Comparable {

    int year;
    LinkedList<MonthCalendarFile> months = new LinkedList<MonthCalendarFile>();

    int linkPrew;
    int linkNext;

    public Year(int year, LinkedList<String> sMonthes) {
        this.year = year;
        fillMonths(sMonthes);
    }

    private void fillMonths(LinkedList<String> sMonthes) {
        if (sMonthes.size() == 0)
            inputAllMonths();
        else {
            sortingMonths(sMonthes);
            inputExistingMonth(sMonthes);
        }
    }

    private void sortingMonths(LinkedList<String> sMonthes) {
        LinkedList <Integer> listOfMonthsIndex = new LinkedList();
        for ( int  i= 0 ; i < sMonthes.size(); i++)
            listOfMonthsIndex.add(new SwitchesOfMonth().getMonthIndexByName(sMonthes.get(i)));

        Collections.sort(listOfMonthsIndex);
        sMonthes.clear();

        for (int i = 0;  i < listOfMonthsIndex.size(); i++) {
            String currMonth = new SwitchesOfMonth().getMonthNameByIndex(listOfMonthsIndex.get(i));
            sMonthes.add(currMonth);

        }
    }

    private void inputExistingMonth(LinkedList<String> sMonthes) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.DAY_OF_MONTH, 1);

        for (String sMonthe : sMonthes) {
            c.set(Calendar.MONTH, new SwitchesOfMonth().getMonthIndexByName(sMonthe));
            months.add(new MonthCalendarFile(c));
        }
    }

    private void inputAllMonths() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.DAY_OF_MONTH, 1);

        for (int monthNumber = 0; monthNumber < 12; monthNumber++  ) {
            c.set(Calendar.MONTH, monthNumber);
            months.add(new MonthCalendarFile(c));
        }
    }

    public LinkedList<MonthCalendarFile> getMonths() {
        return months;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(year, ((Year) o).year);
    }
}
