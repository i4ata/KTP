package Controller;

import Model.KnowledgeSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller class that is used to update the model
 * after the user's input in the view.
 */
public class Controller implements ActionListener {

    KnowledgeSystem model;

    /**
     * The model is passed to the controller.
     * @param model to be modified upon actions taken by the user
     */
    public Controller(KnowledgeSystem model) {
        this.model = model;
    }

    /**
     * The model is updated upon an action is taken.
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand().split(":")[0];

        switch (command) {
            case "next" -> model.start();
            case "question" -> model.askQuestions(e.getActionCommand().split(":")[1]);
        }
    }
}
