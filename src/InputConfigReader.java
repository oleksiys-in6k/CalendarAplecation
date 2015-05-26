import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class InputConfigReader {

    public List<Year> getYearsFromConfig() throws FileNotFoundException {
        List<Year> result = new LinkedList<Year>();

        File fileConfig = new File("config.txt");

        Scanner in = new Scanner(fileConfig);


        while (in.hasNextLine()) {
            int year = 0;
            LinkedList<String> list = new LinkedList<>();

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

        Collections.sort(result);

        return result;
    }

}
