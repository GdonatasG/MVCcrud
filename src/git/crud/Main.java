package git.crud;

import git.crud.control.Control;
import git.crud.model.Model;
import git.crud.view.Cmd;

public class Main {

    public static void main(String[] args) {
        Model model = new Model();
        Cmd view = new Cmd();
        Control control = new Control(model, view);
        control.controls();
    }
}
