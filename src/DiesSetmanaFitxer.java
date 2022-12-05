import java.io.*;
import java.util.*;

public class DiesSetmanaFitxer {
    public static void main(String[] args) throws IOException {
        try {
            FileReader fr = new FileReader("Dies");
            int data = fr.read();
            while (data != -1) {
                System.out.println(data);
                data = fr.read();
                fr.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
