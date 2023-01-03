package KnowledgeBase;

import java.util.HashMap;
import java.util.Map;

public class KB {
    private String[] medicineCollection = {
            "Herbitussin",
            "Bronchostop Duo",
            "..."
    };
    private Map<String, String> patient = new HashMap<>();
    private Rule first;

    public KB() {
        init();
    }

    public void start() {
        first.execute();
    }

    private void init() {
        Question lastQ = new Question("Would you like a homeopathic treatment?", new String[]{"Yes", "No"});
        String answer = "Yes";
        Rule lastR = new Rule(lastQ, null) {
            @Override
            public void execute() {
                if(answer.equals("Yes")) {
                    System.out.println("Homeogene 9");
                }
            }
        };

        Rule[] nexts = new Rule[]{lastR};
        first = new Rule(new Question("Let's do this!", new String[]{"Yes", "No"}), new Rule[]{lastR}) {
            @Override
            public void execute() {
                if(answer.equals("Yes")) {
                    nexts[0].execute();
                }
            }
        };
    }
}
