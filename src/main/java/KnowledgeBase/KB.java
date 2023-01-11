package KnowledgeBase;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KB {

    private Question root = null;

    PropertyChangeListener listener;

    List<String> medicineCollection = List.of("Herbitussin", "Bronchostop", "Bronchostop Duo", "Goldie sept", "Propolis", "Strepsils",
            "Strepsils intensive", "Hexoraleten", "Hexoral", "Efizol", "Trahizan", "Homeogene 9", "See a doctor");
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
//        Left Part under 1-3 Coughing:
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

//        Middle Part under 1-3 Coughing:
        Question node13 = new Question("What is your preferred form of medicine?", Map.of("Tablets", leaves.get("Herbitussin"), "Spray", leaves.get("Propolis")));
        Question node14 = new Question("Are you allergic to thyme?", Map.of("No", node13, "Yes", leaves.get("Propolis")));
        Question node15 = new Question("Are you allergic to bees?", Map.of("No", node14, "Yes", leaves.get("Herbitussin")));
        Question node16 = new Question("What is your preferred form of medicine?", Map.of("Tablets", leaves.get("Bronchostop"), "Spray", leaves.get("Propolis")));
        Question node17 = new Question("Are you allergic to thyme?", Map.of("No", node16, "Yes", leaves.get("Propolis")));
        Question node18 = new Question("Are you allergic to bees?", Map.of("No", node17, "Yes", leaves.get("Bronchostop")));
        Question node19 = new Question("Are you diabetic?", Map.of("No", node15, "Yes", node18));
        Question node20 = new Question("Do you have a cough?", Map.of("No", node19, "Yes", node18));

//        Right Part under 1-3 Coughing:
        Question node21 = new Question("What is your preferred form of medicine?", Map.of("Tablets", leaves.get("Herbitussin"), "Spray", leaves.get("Propolis")));
        Question node22 = new Question("Are you allergic to thyme?", Map.of("No", node21, "Yes", leaves.get("Propolis")));
        Question node23 = new Question("Are you allergic to bees?", Map.of("No", node22, "Yes", leaves.get("Herbitussin")));
        Question node24 = new Question("Are you allergic to bees?", Map.of("No", leaves.get("Propolis"), "Yes", leaves.get("See a doctor")));
        Question node25 = new Question("Are you diabetic?", Map.of("No", node23, "Yes", node24));
        Question node26 = new Question("Do you have a cough?", Map.of("No", node25, "Yes", node24));

//        1-3 Level of discomfort
        Question node27 = new Question("Do you associate the pain with extensive use of vocal cords?", Map.of("No", node12, "Yes", leaves.get("Goldie sept")));
        Question node28 = new Question("Does your daily life involve operating heavy machinery?", Map.of("No", node20, "Yes", node26));
        Question node29 = new Question("Does your daily life involve dirty/cold/dry conditioned air?", Map.of("No", node27, "Yes", node28));
        Question node30 = new Question("Is the weather regularly cold in your daily life?", Map.of("No", node12, "Yes", node29));
        Question node31 = new Question("Have you been coughing for more than 5 days?", Map.of("No", node30, "Yes", leaves.get("See a doctor")));
        Question node32 = new Question("Are you pregnant?", Map.of("No", node31, "Yes", leaves.get("Herbitussin")));

//        Left Part under 4-8 Diabetic:
        Question node33 = new Question("What is your preferred form of medicine?", Map.of("Spray", leaves.get("Strepsils intensive"), "Tablets", leaves.get("Hexoraleten")));
        Question node34 = new Question("What is your preferred form of medicine?", Map.of("Spray", leaves.get("Hexoral"), "Tablets", leaves.get("Hexoraleten")));
        Question node35 = new Question("Do you have a fever?", Map.of("No", node33, "Yes", node34));
        Question node36 = new Question("Does your daily live involve heavy machinery?", Map.of("No", node35, "Yes", node34));

//        Right Part under 4-8 Diabetic:
        Question node37 = new Question("What is your preferred form of medicine?", Map.of("Spray", leaves.get("Strepsils intensive"), "Tablets", leaves.get("Hexoraleten")));
        Question node38 = new Question("What is your preferred form of medicine?", Map.of("Spray", leaves.get("Hexoral"), "Tablets", leaves.get("Hexoraleten")));
        Question node39 = new Question("Do you have a fever?", Map.of("No", node37, "Yes", node38));
        Question node40 = new Question("Does your daily live involve heavy machinery?", Map.of("No", node39, "Yes", node38));

//        4-8 Level of discomfort:
        Question node41 = new Question("Are you diabetic?", Map.of("No", node36, "Yes", node40));
        Question node42 = new Question("Do you have a cough?", Map.of("No", node41, "Yes", leaves.get("See a doctor")));
        Question node43 = new Question("Do you smoke?", Map.of("No", node42, "Yes", leaves.get("See a doctor")));
        Question node44 = new Question("Are you pregnant", Map.of("No", node43, "Yes", leaves.get("Strepsils")));

//        9-10 Level of discomfort:
        Question node45 = new Question("Is your daily live associated with extensive use of your vocal cords?", Map.of("No", leaves.get("Efizol"), "Yes", leaves.get("Trahizan")));
        Question node46 = new Question("Does your daily live involve operating heavy machinery?", Map.of("No", node45, "Yes", leaves.get("Efizol")));
        Question node47 = new Question("Does your daily live incolve dirty, dry, cold, or conditioned air?", Map.of("No", node46, "Yes", leaves.get("Trahizan")));
        Question node48 = new Question("Are your symptoms associated with cold?", Map.of("No", node46, "Yes", node47));
        Question node49 = new Question("Do you have a fever?", Map.of("No", node48, "Yes", leaves.get("See a doctor")));
        Question node50 = new Question("Do you have a cough?", Map.of("No", node49, "Yes", leaves.get("See a doctor")));
        Question node51 = new Question("Do you smoke regularly?", Map.of("No", node50, "Yes", leaves.get("See a doctor")));
        Question node52 = new Question("Are you diabetic?", Map.of("No", node51, "Yes", leaves.get("See a doctor")));
        Question node53 = new Question("Are you pregnant?", Map.of("No", node52, "Yes", leaves.get("See a doctor")));


        Question tmpHead = new Question("What is your level of discomfort from 1-10?", Map.of("1-3", node32, "4-8", node44, "9-10", node53));
        root = tmpHead; //replace node12 with the highest node of the tree when you done. ok
    }

    private Map<String, Question> getLeaves() {
        Map<String, Question> leaves = new HashMap<>();
        for (String medicine : medicineCollection) {
            leaves.put(medicine, new Question(medicine, null));
        }
        return leaves;
    }

    public void makeChoice(String answer) {
        if(!root.getMap().containsKey(answer)) {
            throw new IllegalArgumentException("Not one of the possible answers");
        }
        root = root.getMap().get(answer);
        notifyListeners();
    }

    public void notifyListeners() {
        System.out.println("Listeners notified!");
        List<String> keys = root.getMap() == null ? null : new ArrayList<>(root.getMap().keySet());
        listener.propertyChange(new PropertyChangeEvent(this, "question", keys, root.getText()));
    }
}
