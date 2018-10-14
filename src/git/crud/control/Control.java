package git.crud.control;

import git.crud.model.Model;
import git.crud.view.Cmd;

import java.util.Scanner;

public class Control {
    private Model model;
    private Cmd view;

    public Control(Model parModel, Cmd parView) {
        model = parModel;
        view = parView;
    }

    public void controls() {
        boolean ar = true;
        Scanner skan = new Scanner(System.in);
        int a;
        while (ar) {
            view.showMeniu();
            a = skan.nextInt();
            switch (a) {
                case 0:
                    ar = false;
                    break;
                case 1:
                    model.requestFileName();
                    break;
                case 2:
                    model.createFile();
                    break;
                case 3:
                    model.readFile();
                    break;
                case 4:
                    model.updateFile();
                    break;
                case 5:
                    model.deleteFile();
                    break;
            }
        }
    }
}
