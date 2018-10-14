package git.crud;

import git.crud.model.Model;

public class Main {

    public static void main(String[] args) {
        Model md = new Model();
        md.requestFileName();
        md.createFile();
        md.readFile();
    }
}
