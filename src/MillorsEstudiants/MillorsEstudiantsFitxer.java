package MillorsEstudiants;

import java.io.*;
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
            /*
              Lee el fichero hasta el final
              Primero(): Primera linia del fichero
              Siguente(): Linia++
              Final(): Ultima linia
              Recorregut
             */
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
                /*
                  Escribe al fichero los mejores estudiantes y notas, numero determinado por fichero que se lee
                  Primero(): Primer estudiante
                  Siguente: estudiante++
                  Final(): Ultimo estudiante
                  Recoreegut
                 */
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

    /**
     * Actualiza el array de nombres y notas si el nuevo estudiante es uno de los con mejores nota
     * @param names Array de nombres con mejores nota
     * @param grades Array de notas con mejores nota
     * @param new_name Nombre de nuevo estudiante leido desde el fichero
     * @param new_grade Nota de nuevo estudiante leido desde el fichero
     * @param size Numero de estudiantes que queremos al final, tamaño del arrays
     */
    static void millorsEstudiants(String[] names, float[] grades, String new_name, float new_grade, int size) {
        boolean not_replaced = true;
        /*
          Encuentra la posicion del nuevo estudiante
          Primer(): primero de mejores
          Siguente(): pos++ de mejores
          Final(): nota no es mejor que los otros / nueva nota es mejor que posicion i
          Recoregut / Cerca: Mejor que posicion i
         */
        for (int i = 0; i < size && not_replaced; i++) {
            if (new_grade > grades[i]) {
                String aux_name = new_name, aux2_name;
                float aux_grade = new_grade, aux2_grade;
                /*
                  Actualiza los arrays para cambiar las posiciones
                  Primer(): Primer estudiante que baja en ranking
                  Siguente(): Estudiante++
                  Final(): Ultima posicion ha sido actualizado
                  Recorregut
                 */
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
