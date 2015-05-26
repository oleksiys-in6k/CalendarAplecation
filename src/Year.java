import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.*;

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

            sortingMonthes(sMonthes);
        }
    }

    private void sortingMonthes(ArrayList<String> sMonthes) {
        ArrayList <Integer> listOfMonthsIndex = new ArrayList();
        for ( int  i= 0 ; i < sMonthes.size(); i++)
            listOfMonthsIndex.add(new SwitchesOfMonth().getMonthIndexByName(sMonthes.get(i)));

        Collections.sort(listOfMonthsIndex);
        sMonthes.clear();

        for (int i = 0;  i < listOfMonthsIndex.size(); i++) {
            sMonthes.add(new SwitchesOfMonth().getMonthNameByIndex(listOfMonthsIndex.get(i)));
        }
        System.out.println(listOfMonthsIndex);
        System.out.println(sMonthes);
    }

    private void inputExistingMonth(ArrayList<String> sMonthes) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.DAY_OF_MONTH, 1);

        for (String sMonthe : sMonthes) {
            c.set(Calendar.MONTH, new SwitchesOfMonth().getMonthIndexByName(sMonthe));
            monthes.add(new MonthCalendarFile(c));
        }
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
