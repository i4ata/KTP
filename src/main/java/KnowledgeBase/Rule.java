package KnowledgeBase;

public class Rule {
    private Question question;
    private Rule[] nexts;

    public Rule(Question question, Rule[] nexts) {
        this.question = question;
        this.nexts = nexts;
    }

    public void execute() {}

}
