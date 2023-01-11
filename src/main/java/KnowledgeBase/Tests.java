package KnowledgeBase;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tests {
//    public static void main(String[] args) {
//        KB kb = new KB();
//        Question q = kb.getCurrentQuestion();
//        while(q.getMap() != null) {
//            System.out.println(q.getText());
//            System.out.println(q.getMap().keySet());
//
//            //choose random answer
//            List<String> keysAsArray = new ArrayList<>(q.getMap().keySet());
//            String choice = keysAsArray.get(new Random().nextInt(keysAsArray.size()));
//            System.out.println("You chose: " + choice + "\n");
//
//            //get on the corresponding child
//            q = q.getMap().get(choice);
//        }
//        System.out.println(q.getText());
//    }
    public static void main(String[] args) {
        KB kb = new KB();
        kb.setListener(evt -> System.out.println(evt.getNewValue()));

        Question root = kb.getCurrentQuestion();
        System.out.println(root.getText());
        System.out.println(root.getMap().keySet());

        while(root.getMap() != null) {

            //choose random answer
            List<String> keysAsArray = new ArrayList<>(root.getMap().keySet());
            String choice = keysAsArray.get(new Random().nextInt(keysAsArray.size()));
            System.out.println("You chose: " + choice + "\n");

            //get on the corresponding child
            kb.makeChoice(choice);
            root = kb.getCurrentQuestion();
        }
    }
}
