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
            FileReader fr = new FileReader(file_name);


        } catch (FileNotFoundException e) {
            System.out.println("File not found");;
        } catch (NumberFormatException e) {
            System.out.println("Incorrect type read");
        }
    }

    static boolean conjuntsIguals(int[] a, int[] b, int n) {
        int max_a = Integer.MIN_VALUE;
        int max_b = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max_a = Math.max(max_a,a[i]);
            max_b = Math.max(max_b,b[i]);
        }
        int new_size = Math.max(max_a,max_b)+1;
        int[] a_reps = new int[new_size];
        int[] b_reps = new int[new_size];
        for (int i = 0; i < n; i++) {
            a_reps[a[i]]++;
            b_reps[b[i]]++;
        }
        for (int i = 0; i < new_size; i++) {
            if ((a_reps[i] == 0 && b_reps[i] > 0) || (a_reps[i] > 0 && b_reps[i] == 0))
                return false;
        }
        return true;
    }
}
