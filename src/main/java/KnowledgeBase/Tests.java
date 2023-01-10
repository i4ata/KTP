package KnowledgeBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tests {
    public static void main(String[] args) {
        KB kb = new KB();
        Question q = kb.getFirst();
        while(q.getMap() != null) {
            System.out.println(q.getText());
            System.out.println(q.getMap().keySet());

            //choose random answer
            List<String> keysAsArray = new ArrayList<>(q.getMap().keySet());
            String choice = keysAsArray.get(new Random().nextInt(keysAsArray.size()));
            System.out.println("You chose: " + choice + "\n");

            //get on the corresponding child
            q = q.getMap().get(choice);
        }
        System.out.println(q.getText());
    }
}
