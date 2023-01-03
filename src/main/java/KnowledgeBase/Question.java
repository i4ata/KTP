package KnowledgeBase;

public class Question {
    private String text;
    private String[] possibleAnswers;

    public Question(String text, String[] possibleAnswers) {
        this.text = text;
        this.possibleAnswers = possibleAnswers;
    }

    public String getText() {
        return text;
    }

    public String[] getPossibleAnswers() {
        return possibleAnswers;
    }
}
