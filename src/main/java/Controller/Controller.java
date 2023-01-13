package Controller;

import Model.Model;
import Model.Question;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    KB model;

    public Controller(KB model) {
        this.model = model;
    }

    //Choose a random child to move to upon pressing the button
    public void actionPerformed(ActionEvent e) {
        //List<String> keysAsArray = new ArrayList<>(model.getCurrentQuestion().getMap().keySet());
        //String choice = keysAsArray.get(new Random().nextInt(keysAsArray.size()));
        //System.out.println("You chose: " + choice + "\n");
        //model.makeChoice(choice);
        if(!e.getActionCommand().equals("Next")) {
            System.out.println("Selected: " + e.getActionCommand());
            model.makeChoice(e.getActionCommand());
        } else {
            model.notifyListeners();
        }
    }
}
