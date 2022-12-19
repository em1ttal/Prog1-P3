package MillorsEstudiants;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MillorsEstudiantsFitxer {
    public static void main(String[] args) {
        String file_name = "src/MillorsEstudiants/Estudiants.txt";
        try {
            File file = new File(file_name);
            Scanner file_reader = new Scanner(file);
            int k = Integer.parseInt(file_reader.nextLine());

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (NumberFormatException e) {
            System.out.println("Incorrect type read");
        }
    }

    static int[] topIndices(float[] notes, int k) {
        int[] a = {3,5};
        return a;
    }
}
