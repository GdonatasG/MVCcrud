package git.crud.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Model {
    private String fileName;

    public void requestFileName() {
        System.out.println("Iveskite failo pavadinima");
        Scanner skan = new Scanner(System.in);
        fileName = skan.nextLine();
    }

    public void createFile() {
        File file = new File(fileName);
        if (!file.exists()) {
            Scanner skan = new Scanner(System.in);
            System.out.println("Tokio failo nera. Ar noretumete ji sukurti? T/N");
            String ar = skan.nextLine();
            if (ar.toLowerCase().equals("t")) {
                try {
                    file.createNewFile();
                    System.out.println("Failas " + fileName + " sekmingai sukurtas!");
                } catch (IOException e) {
                    System.out.println("Ivyko klaida!");
                }
            }
        } else {
            System.out.println("Toks failas jau egzistuoja!");
        }
    }

    public void readFile() {
        File file = new File(fileName);
        if (file.exists()) {
            try {
                Scanner skan = new Scanner(file);
                while (skan.hasNextLine()) {
                    System.out.println(skan.nextLine());
                }
                skan.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
