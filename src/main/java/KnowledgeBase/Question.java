package KnowledgeBase;

import java.util.Map;

public class Question {
    private String text;
    private Map<String, Question> map;

    public Question(String text, Map<String, Question> map) {
        this.text = text;
        this.map = map;
    }

    public String getText() {
        return text;
    }

    public Map<String, Question> getMap() {
        return map;
    }
}
