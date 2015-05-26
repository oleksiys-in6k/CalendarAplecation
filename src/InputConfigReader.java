import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;


public class InputConfigReader {

    public ArrayList<Year> getYearsFromConfig () throws FileNotFoundException {
        ArrayList<Year> result;
        result = new ArrayList<Year>();

        File fileConfig = new File("config.txt");

        Scanner in = new Scanner(fileConfig);


        while (in.hasNextLine()) {
            int year = 0;
            ArrayList<String> list = new ArrayList<>();

            if (in.hasNextInt()) {
                year = in.nextInt();
            }
            if (!in.hasNextInt())
             {
                String s =  in.nextLine().trim();
                list.addAll(Arrays.asList(s.split(" ")));
            }
            result.add(new Year(year, list));
        }

        return result;
    }

}
