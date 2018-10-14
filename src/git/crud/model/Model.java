package git.crud.model;

import java.util.Scanner;

public class Model {
    private String fileName;

    public void requestFileName() {
        System.out.println("Iveskite failo pavadinima");
        Scanner skan = new Scanner(System.in);
        fileName = skan.nextLine();
        System.out.println(fileName);
    }
}
