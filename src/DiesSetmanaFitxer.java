import java.io.*;
import java.util.*;

public class DiesSetmanaFitxer {
    public static void main(String[] args) throws IOException {
        try {
            FileReader fr = new FileReader("src/Dies.txt");
            int data;
            while ((data=fr.read()) != -1) {
                System.out.println((char)data);
            }
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
