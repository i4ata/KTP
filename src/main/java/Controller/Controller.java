package Controller;

import Model.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    Model model;

    public Controller(Model model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Next")) {
            model.notifyListeners();
        } else {
            model.AskQuestions(e.getActionCommand());
        }
    }
}
