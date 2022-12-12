package MultMatrius;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MultMatriusFitxer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Name of file: ");
        String file_name = sc.nextLine();
        //Puede ser que hay que quitar esa linia, dependiendo que como el IDE lee ficheros
        file_name = "src/MultMatrius/" + file_name;
        try {
            File file = new File(file_name);
            Scanner file_reader = new Scanner(file);
            String aux = file_reader.nextLine();
            String[] num_holder = aux.split(" ");
            int n = Integer.parseInt(num_holder[0]), m = Integer.parseInt(num_holder[1]), k = Integer.parseInt(num_holder[2]);
            int[][] matrix1 = new int[n][m];
            int[][] matrix2 = new int[m][k];
            for (int i = 0; i < n; i++) {
                aux = file_reader.nextLine();
                num_holder = aux.split(" ");
                for (int j = 0; j < m; j++)
                    matrix1[i][j] = Integer.parseInt(num_holder[j]);
            }
            for (int i = 0; i < m; i++) {
                aux = file_reader.nextLine();
                num_holder = aux.split(" ");
                for (int j = 0; j < k; j++)
                    matrix2[i][j] = Integer.parseInt(num_holder[j]);
            }
            int[][] mult = multiplica(n,m,k,matrix1,matrix2);
            System.out.println("La matriu resultant A * B es:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < k; j++)
                    System.out.print(mult[i][j] + "  ");
                System.out.println();
            }
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
