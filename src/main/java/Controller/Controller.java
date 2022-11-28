package Controller;

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
            case "interface" -> model.changeToInterface();
            case "start" -> model.start();
        }
    }
}
