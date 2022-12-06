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

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Name of file: ");
        String file_name = sc.nextLine();
        //Puede ser que hay que quitar esa linia, dependiendo que como el IDE lee ficheros
        file_name = "src/DiesSetmana/" + file_name;
        try {
            FileReader fr = new FileReader(file_name);
            int data = fr.read();
            int num_read = 0;
            while (data != -1) {
                if (num_read != 0 && data != 32)
                    printDay(Integer.parseInt(String.valueOf((char)data)));
                data = fr.read();
                num_read++;
            }
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (NumberFormatException e) {
            System.out.println("Incorrect type in file");
        }
    }

    static void printDay(int day) {
        switch (day) {
            case 1 -> System.out.print(Day.MONDAY + " ");
            case 2 -> System.out.print(Day.TUESDAY + " ");
            case 3 -> System.out.print(Day.WEDNESDAY + " ");
            case 4 -> System.out.print(Day.THURSDAY + " ");
            case 5 -> System.out.print(Day.FRIDAY + " ");
            case 6 -> System.out.print(Day.SATURDAY + " ");
            case 7 -> System.out.print(Day.SUNDAY + " ");
            default -> System.out.print("Invalid day ");
        }
    }
}
