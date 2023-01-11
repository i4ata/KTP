package Controller;

import KnowledgeBase.Question;
import Model.KnowledgeSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    KnowledgeSystem model;

    public Controller(KnowledgeSystem model) {
        this.model = model;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand().split(":")[0];

        switch (command) {
            case "interface" -> {
                String qs = e.getActionCommand().split(":")[1];
                model.changeToInterface(qs);
            }
            case "start" -> model.start();
        }
    }
}
