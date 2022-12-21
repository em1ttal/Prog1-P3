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

    /**
     * Misma secuencia?
     * @param adn1 Primera secuencia
     * @param adn2 Segunda secuencia
     * @return Son lo mismo o no
     */
    static boolean adnIguals(String[] adn1, String[] adn2) {
        if (adn1.length != adn2.length)
            return false;
        int n = adn1.length;
        /*
          Primer for encuentra donde empieza la secuencia
          First(): index 0
          Siguente(): index++
          Final(): ultimo index
          Recorregut
         */
        for (int i = 0; i < n; i++) {
            boolean equal = true;
            /*
              Segundo for compreuba si la secuenica esta seguido, si no intenta empezar del siguente index
              Primer(): Primera posicion en que la secuenica esta seguido
              Siguente(): Pos++
              Final(): Ultima posicion si la secuenica es lo mismo. O posicion en que n lo sigue
              Recorregut o Cerca: Valores no son lo mismo
             */
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
