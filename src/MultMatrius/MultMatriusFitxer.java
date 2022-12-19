package MultMatrius;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MultMatriusFitxer {
    public static void main(String[] args) {
        String file_name = "src/MultMatrius/Matrius.txt";
        try {
            File file = new File(file_name);
            Scanner file_reader = new Scanner(file);
            String aux = file_reader.nextLine();
            String[] num_holder = aux.split(" ");
            int n = Integer.parseInt(num_holder[0]), m = Integer.parseInt(num_holder[1]), k = Integer.parseInt(num_holder[2]);
            int[][] matrix1 = new int[n][m];
            int[][] matrix2 = new int[m][k];
            /*
              Lee las filas del matriz
              Primer(): Sepera la primera fila a un array de strings despues de leerlo
              Siguente(): Sepera fila++ a un array de strings despues de leerlo
              Final(): Sepera la ultima fila a un array de strings despues de leerlo
              Recorregut
             */
            for (int i = 0; i < n; i++) {
                aux = file_reader.nextLine();
                num_holder = aux.split(" ");
                /*
                  Rellena la matriz
                  Primer(): Primera columna de primer fila
                  Siguente(): Columna++ de fila
                  Final(): Ultima columna
                  Recorregut
                 */
                for (int j = 0; j < m; j++)
                    matrix1[i][j] = Integer.parseInt(num_holder[j]);
            }
            /*
              Lee las filas del matriz
              Primer(): Sepera la primera fila a un array de strings despues de leerlo
              Siguente(): Sepera fila++ a un array de strings despues de leerlo
              Final(): Sepera la ultima fila a un array de strings despues de leerlo
              Recorregut
             */
            for (int i = 0; i < m; i++) {
                aux = file_reader.nextLine();
                num_holder = aux.split(" ");
                /*
                  Rellena la matriz
                  Primer(): Primera columna de primer fila
                  Siguente(): Columna++ de fila
                  Final(): Ultima columna
                  Recorregut
                 */
                for (int j = 0; j < k; j++)
                    matrix2[i][j] = Integer.parseInt(num_holder[j]);
            }
            int[][] mult = multiplica(n,m,k,matrix1,matrix2);
            System.out.println("La matriu resultant A * B es:");
            /*
              Imprime la matriz
              Primer(): Primera fila de matriz
              Siguente(): Fila++ de matriz
              Final(): Ultima fila
              Recorregut
             */
            for (int i = 0; i < n; i++)
                System.out.println(Arrays.toString(mult[i]));
            file_reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (NumberFormatException e) {
            System.out.println("Incorrect type read");
        }
    }

    static int[][] multiplica(int n, int m, int k, int[][] A, int[][] B) {
        int[][] multiplied = new int[n][k];
        /*
          Iterate through rows of matrix A
          First(): Row 1
          Next(): Row 2
          Last(): Last row
          Reccoregut
         */
        for (int i = 0; i < n; i++) {
            /*
              Iterates through columns of matrix B
              First(): Column 1
              Next(): Column 2
              Last(): Last column
              Reccoregut
             */
            for (int j = 0; j < k; j++) {
                /*
                  Iterate through rows of matrix B / columns of matrix A
                  First(): Row 1 & Column 1
                  Next(): Row 2 & Column 2
                  Last(): Last row & Last column
                  Reccoregut
                 */
                for (int l = 0; l < m; l++)
                    multiplied[i][j] += A[i][l] * B[l][j];
            }
        }
        return multiplied;
    }
}
