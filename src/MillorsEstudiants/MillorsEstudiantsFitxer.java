package MillorsEstudiants;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MillorsEstudiantsFitxer {
    public static void main(String[] args) {
        String file_name_read = "src/MillorsEstudiants/Estudiants.txt";
        String file_name_write = "src/MillorsEstudiants/EstudiantsMillorNota.txt";
        int total_students = 0;
        int num_top;
        String[] names;
        float[] grades;
        try {
            File file = new File(file_name_read);
            Scanner file_reader = new Scanner(file);
            num_top = Integer.parseInt(file_reader.nextLine());
            names = new String[num_top];
            grades = new float[num_top];
            String aux_name;
            float aux_grade;
            while (file_reader.hasNext()) {
                aux_name = file_reader.next();
                aux_grade = file_reader.nextFloat();

                //TODO: If for changing grades

                total_students++;
                if (file_reader.hasNext())
                    file_reader.nextLine();
            }
            if (num_top > total_students)
                System.out.println("EXCEPTION: More students wanted then students available");
            else {
                FileWriter file_to_write = new FileWriter(file_name_write);
                file_to_write.write("Els " + num_top + " estudiants amb millor nota:\n");
                for (int i = 0; i < num_top; i++)
                    file_to_write.write(names[i] + " " + grades[i] + "\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (NumberFormatException e) {
            System.out.println("Incorrect type read");
        } catch (IOException e) {
            System.out.println("File not created");
        }
    }

    static int[] topIndices(float[] notes, int k) {
        int[] a = {3,5};
        return a;
    }
}
