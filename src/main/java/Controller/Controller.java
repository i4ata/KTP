package Controller;

import KnowledgeBase.KB;
import KnowledgeBase.Question;
import Model.KnowledgeSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller implements ActionListener {
    KB model;

    public Controller(KB model) {
        this.model = model;
    }

    //Choose a random child to move to upon pressing the button
    public void actionPerformed(ActionEvent e) {
        List<String> keysAsArray = new ArrayList<>(model.getCurrentQuestion().getMap().keySet());
        String choice = keysAsArray.get(new Random().nextInt(keysAsArray.size()));
        System.out.println("You chose: " + choice + "\n");
        model.makeChoice(choice);
    }
}
