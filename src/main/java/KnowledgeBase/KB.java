package KnowledgeBase;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KB {

    private Question root = null;

    PropertyChangeListener listener;

    List<String> medicineCollection = List.of("Herbitussin", "Bronchostop Duo", "Goldie sept", "Propolis", "Strepsils",
            "Strepsils intensive", "Hexoraleten", "Hexoral", "Efizol", "Trahizan", "Homeogene 9");
    public KB() {
        init();
    }

    public Question getCurrentQuestion() {
        return root;
    }

    public void setListener(PropertyChangeListener listener) {
        this.listener = listener;
    }

    private void init() {
        Map<String, Question> leaves = getLeaves();
        Question node1 = new Question("What is your preferred form of medicine?", Map.of("Tablets", leaves.get("Herbitussin"), "Spray", leaves.get("Propolis")));
        Question node2 = new Question("Are you allergic to thyme?", Map.of("No", node1, "Yes", leaves.get("Propolis")));
        Question node3 = new Question("What is your preferred form of medicine?", Map.of("Tablets", leaves.get("Herbitussin"), "Spray", leaves.get("Goldie sept")));
        Question node4 = new Question("Are you allergic to thyme?", Map.of("No", node3, "Yes", leaves.get("Goldie sept")));
        Question node5 = new Question("Are you allergic to bees?", Map.of("No", node2, "Yes", node4));
        Question node6 = new Question("What is your preferred form of medicine?", Map.of("Tablets", leaves.get("Bronchostop Duo"), "Spray", leaves.get("Propolis")));
        Question node7 = new Question("Are you allergic to thyme?", Map.of("No", node6, "Yes", leaves.get("Propolis")));
        Question node8 = new Question("What is your preferred form of medicine?", Map.of("Tablets", leaves.get("Bronchostop Duo"), "Spray", leaves.get("Goldie sept")));
        Question node9 = new Question("Are you allergic to thyme?", Map.of("No", node8, "Yes", leaves.get("Goldie sept")));
        Question node10 = new Question("Are you allergic to bees?", Map.of("No", node7, "Yes", node9));
        Question node11 = new Question("Do you have diabetes?", Map.of("No", node5, "Yes", node10));
        Question node12 = new Question("Do you have a cough?", Map.of("No", node11, "Yes", node10));

        root = node12;
    }

    private Map<String, Question> getLeaves() {
        Map<String, Question> leaves = new HashMap<>();
        for (String medicine : medicineCollection) {
            leaves.put(medicine, new Question(medicine, null));
        }
        return leaves;
    }

    public void makeChoice(String answer) {
        root = root.getMap().get(answer);
        notifyListeners();
    }

    private void notifyListeners() {
        System.out.println("Listeners notified!");
        listener.propertyChange(new PropertyChangeEvent(this, "text", null, root.getText()));
        if(root.getMap() != null) {
            listener.propertyChange(new PropertyChangeEvent(this, "answers", null, root.getMap().keySet()));
        }
    }
}
