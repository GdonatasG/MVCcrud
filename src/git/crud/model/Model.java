package git.crud.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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

    public void updateFile() {
        File file = new File(fileName);
        if (file.exists()) {
            try {
                String tekstas;
                Scanner skan = new Scanner(System.in);
                FileWriter writer = new FileWriter(file, true);
                System.out.println("Iveskite teksta is spauskite enter, ivedus zodi pabaiga procesas bus nutrauktas");
                do {
                    tekstas = skan.nextLine();
                    if (!tekstas.toLowerCase().equals("pabaiga")) {
                        writer.write(tekstas + "\n");
                    }
                } while (!tekstas.toLowerCase().equals("pabaiga"));
                writer.close();
            } catch (IOException e) {
                System.out.println("Toks failas neegzistuoja!");
            }
        }
    }

    public void deleteFile() {
        File file = new File(fileName);
        if (file.exists()) {
            System.out.println("Ar tikrai norite istrinti faila " + fileName + " ? T/N");
            Scanner skan = new Scanner(System.in);
            String ar = skan.nextLine();
            if (ar.toLowerCase().equals("t")) {
                file.delete();
                System.out.println("Failas " + fileName + " sekmingai pasalintas.");
            }
        }
    }
}
