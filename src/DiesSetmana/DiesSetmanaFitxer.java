package DiesSetmana;

import java.io.*;
import java.util.*;

public class DiesSetmanaFitxer {
    public enum Day {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }

    public static void main(String[] args) {
        String file_name = "src/DiesSetmana/Dies.txt";
        int num_days;
        try {
            File file = new File(file_name);
            Scanner file_reader = new Scanner(file);
            num_days = file_reader.nextInt();
            for (int i = 0; i < num_days; i++)
                System.out.println(nomDiesSetmana(file_reader.nextInt()));
            file_reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (NumberFormatException e) {
            System.out.println("Incorrect type in file");
        }
    }

    static String nomDiesSetmana(int n) {
        return Day.values()[n-1].toString();
    }
}
