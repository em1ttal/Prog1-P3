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
        String file_name = "src/DiesSetmana/Dies.txt";
        try {
            FileReader fr = new FileReader(file_name);
            int data = fr.read();
            int num_read = 0;
            /*
              Lee los numeros hasta que no hay mas
              Primer(): primera dia
              Siguente(): dia i+1
              Final(): ultimo dia
              Cerca: Porque el bucle esta buscando para que el valor = -1 que significa fin de fichero
             */
            while (data != -1) {
                if (num_read != 0 && data != 32)
                    System.out.println(nomDiesSetmana(Integer.parseInt(String.valueOf((char)data))));
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

    static String nomDiesSetmana(int n) {
        return Day.values()[n-1].toString();
    }
}
