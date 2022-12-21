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
            file_reader.nextLine();
            /*
              Mientras quedan numeros a leer, lo lee y imprime el dia correspondiente
              Primer(): Primer numero
              Siguente(): numero++
              Final(): Ultimo numero
              Recorregut
             */
            for (int i = 0; i < num_days; i++)
                System.out.println(nomDiesSetmana(file_reader.nextInt()));
            file_reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (NumberFormatException e) {
            System.out.println("Incorrect type in file");
        }
    }

    /**
     * Encuentra el dia que corresponde con el valor
     * @param n Valor del dia
     * @return Dia escrito o error si el valor es fuera del rango
     */
    static String nomDiesSetmana(int n) {
        if (n > 7 || n < 1)
            return (n + " is out of range");
        return Day.values()[n-1].toString();

    }
}
