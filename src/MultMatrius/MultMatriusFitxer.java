package MultMatrius;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
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
            String[] dims = aux.split(" ");
            int n = Integer.parseInt(dims[0]), m = Integer.parseInt(dims[1]), k = Integer.parseInt(dims[2]);
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
