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

                millorsEstudiants(names,grades,aux_name,aux_grade,num_top);

                total_students++;
                if (file_reader.hasNext())
                    file_reader.nextLine();
            }
            file_reader.close();
            if (num_top > total_students)
                System.out.println("EXCEPTION: More students wanted then students available");
            else {
                FileWriter file_to_write = new FileWriter(file_name_write);
                file_to_write.write("Els " + num_top + " estudiants amb millor nota:\n");
                for (int i = 0; i < num_top; i++)
                    file_to_write.write(names[i] + " " + grades[i] + "\n");
                file_to_write.close();
                System.out.println("Datos escrito al fichero " + file_name_write);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (NumberFormatException e) {
            System.out.println("Incorrect type read");
        } catch (IOException e) {
            System.out.println("File not created");
        }
    }

    static void millorsEstudiants(String[] names, float[] grades, String new_name, float new_grade, int size) {
        boolean not_replaced = true;
        for (int i = 0; i < size && not_replaced; i++) {
            if (new_grade > grades[i]) {
                String aux_name = new_name, aux2_name;
                float aux_grade = new_grade, aux2_grade;
                for (int j = i; j < size; j++) {
                    aux2_name = names[j]; aux2_grade = grades[j];
                    names[j] = aux_name; grades[j] = aux_grade;
                    aux_name = aux2_name; aux_grade = aux2_grade;
                }
                not_replaced = false;
            }
        }

    }
}
