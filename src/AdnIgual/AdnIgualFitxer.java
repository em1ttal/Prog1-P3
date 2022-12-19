package AdnIgual;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdnIgualFitxer {
    public static void main(String[] args) {
        String file_name = "src/AdnIgual/Adn.txt";
        try {
            File file = new File(file_name);
            Scanner file_reader = new Scanner(file);
            String[] sequence1 = file_reader.nextLine().split(" ");
            String[] sequence2 = file_reader.nextLine().split(" ");
            if (adnIguals(sequence1,sequence2))
                System.out.println("Iguals");
            else
                System.out.println("No iguals");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (NumberFormatException e) {
            System.out.println("Incorrect type read");
        }
    }

    static boolean adnIguals(String[] adn1, String[] adn2) {
        if (adn1.length != adn2.length)
            return false;
        int n = adn1.length;
        for (int i = 0; i < n; i++) {
            boolean equal = true;
            for (int j = 0; j < n && equal; j++) {
                if (!adn1[j].equals(adn2[(i+j)%n]))
                    equal = false;
            }
            if (equal)
                return true;
        }
        return false;
    }
}
