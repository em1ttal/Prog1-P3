package Conjunts;

import java.util.*;
import java.io.*;

public class ConjuntsFitxer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Name of file: ");
        String file_name = sc.nextLine();
        //Puede ser que hay que quitar esa linia, dependiendo que como el IDE lee ficheros
        file_name = "src/Conjunts/" + file_name;
        int n;
        try {
            File file = new File(file_name);
            Scanner file_reader = new Scanner(file);
            n = Integer.parseInt(file_reader.nextLine());
            int[] a = new int[n];
            int[] b = new int[n];
            String aux = file_reader.nextLine();
            String[] aux_nums = aux.split(" ");
            for (int i = 0; i < aux_nums.length; i++)
                a[i] = Integer.parseInt(aux_nums[i]);
            aux = file_reader.nextLine();
            aux_nums = aux.split(" ");
            for (int i = 0; i < aux_nums.length; i++)
                b[i] = Integer.parseInt(aux_nums[i]);
            if(conjuntsIguals(a,b,n))
                System.out.println("Si");
            else
                System.out.println("No");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");;
        } catch (NumberFormatException e) {
            System.out.println("Incorrect type read");
        }
    }

    static boolean conjuntsIguals(int[] a, int[] b, int n) {
        int max_a = Integer.MIN_VALUE;
        int max_b = Integer.MIN_VALUE;
        /*
          Encuentra el numero minimo en cada array
          Primer(): a[0], b[0]
          Siguente(): a[i+1], b[i+1]
          Final(): a[last], b[last]
          Recorregut
         */
        for (int i = 0; i < n; i++) {
            max_a = Math.max(max_a,a[i]);
            max_b = Math.max(max_b,b[i]);
        }
        int new_size = Math.max(max_a,max_b)+1;
        int[] a_reps = new int[new_size];
        int[] b_reps = new int[new_size];
        /*
          En dos nuevos arrays, suma la veces que aparece un numero
          Primer(): a[0], b[0]
          Siguente(): a[i+1], b[i+1]
          Final(): a[last], b[last]
          Recorregut
         */
        for (int i = 0; i < n; i++) {
            a_reps[a[i]]++;
            b_reps[b[i]]++;
        }
        /*
          Si en los dos arrays, hay un numero que aparece pero en el otro no, no son los mismos
          Primer(): a_reps[0], b_reps[0]
          Siguente(): a_reps[i+1], b_reps[i+1]
          Final(): a_reps[last], b_reps[last]
          Final_Possible(): a[] = 0, b[] > 0 OR a[] > 0, b[] = 0
          Recorregut
         */
        for (int i = 0; i < new_size; i++) {
            if ((a_reps[i] == 0 && b_reps[i] > 0) || (a_reps[i] > 0 && b_reps[i] == 0))
                return false;
        }
        return true;
    }
}
