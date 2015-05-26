
import java.io.IOException;
import java.util.ArrayList;

class CalendarApplication {


    public static void main(String args[]) throws IOException {

        InputConfigReader config = new InputConfigReader();
        ArrayList<Year> years = config.getYearsFromConfig();

        for (Year year : years) {
            year.writeToFile();
        }
   }
}
