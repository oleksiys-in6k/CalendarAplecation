import java.io.*;
import java.lang.reflect.Array;
import java.security.cert.Extension;
import java.util.*;

public class WorkingWithDirectory {
    private static final String BACKSLASH = "\\";
    private static final String SLASH = "/";
    private static final String HTMLEXTENSION = ".html";
    public static AbstractMonthCalendarRenderer renderer;



    Map <Integer, ArrayList<String>> map = new TreeMap <Integer, ArrayList<String>> ();

    public WorkingWithDirectory() throws IOException {
        File file = new File("output");

        deletingDirectoryOutput(file);
        creatingClearDirectoryOutput(file);

        File fileConfig = new File("config.txt");

        Scanner in = new Scanner(fileConfig);
        Scanner in2 = new Scanner(String.valueOf(in));
        int year = 0;

        while (in.hasNextLine()) {
            ArrayList <String> list = new ArrayList<String>();
                if (in.hasNextInt()) {
                    year = in.nextInt();
                }
                else {
                    //in.hasNext();
                    String s = in.nextLine();
                    String news = s.substring(1, s.length());
                    System.out.println(news);

                    list.addAll(Arrays.asList(news.split(" ")));

//                    list.add(Arrays.asList(s.toCharArray()));
//                    list.add(in.nextLine());
                }
            map.put(year, list);
            }
        System.out.println(map);


        createSomeCalendars();
    }

    private void creatingClearDirectoryOutput(File file) {
        file.mkdir();
    }

    private void deletingDirectoryOutput(File file) {
        if (file.exists())
        for (File myFile : file.listFiles())
            if ( myFile.isFile())
                myFile.delete();
    }

    public Map<Integer, ArrayList<String>> getap() {
        return map;
    }

    public void createSomeCalendars() throws IOException {
        Calendar calendar1 = Calendar.getInstance();
        Set keys = map.keySet();
        System.out.println(map);
        String pathToFiles = "";

        for (Object key: keys) {
            pathToFiles = "output" + SLASH + key;
            File file = new File(pathToFiles);
            file.mkdirs();
        }
        String fileName;

        for (Object key: keys) {

            fileName = "output" + SLASH + key + SLASH + map.get(key) + HTMLEXTENSION;
            System.out.println();

            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));      //fileww.mkdirs();

            MonthCalendar monthCalendar = new MonthCalendar(calendar1);
            System.out.println(renderer.render(monthCalendar));

            writer.close();
        }
    }

}
