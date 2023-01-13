package Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashSet;
import java.util.Set;

public class Model {
    private Set<String> medicines = FileReaderCSV.readMedicineCollection().keySet();
    private Set<Question> questions = extractQuestions();
    private Question currentQuestion = new Question(1);
    public Question getCurrentQuestion() {
        return currentQuestion;
    }
    private PropertyChangeListener listener;
    public void setListener(PropertyChangeListener listener) {
        this.listener = listener;
    }
    public Set<String> getMedicines() {
        return medicines;
    }
    public Set<Question> getQuestions() {
        return questions;
    }
    private Set<Question> extractQuestions() {
        Set<Question> questions = new HashSet<>();
        for(int idx = 1; idx <= FileReaderCSV.readQuestions().size(); ++idx) {
            questions.add(new Question(idx));
        }
        return questions;
    }

    public void AskQuestions(String choice) {
        System.out.println("\n\n\n");
        System.out.println("Questions amount:" + questions.size());
        for(Question q : questions) {
            System.out.println(q.getIndex() + "    " + q.getQuestion() + "  "  + getScore(q));
        }
        System.out.println("\n\n\n");
        System.out.println(medicines.size());
        System.out.println("Current set:" + medicines);

        System.out.println("Question:" + currentQuestion.getQuestion());

        System.out.println(choice);

        Set<String> toRemove = choice.equals(currentQuestion.getOptions()[1]) ? currentQuestion.getYes() : currentQuestion.getNo();

        questions.remove(currentQuestion);

        medicines.removeAll(toRemove);

        for(Question q : questions) {
            q.getNo().removeAll(toRemove);
            q.getYes().removeAll(toRemove);
        }

        questions.removeIf(element -> getScore(element) == 0);

        System.out.println("Removing: " + toRemove);

        currentQuestion = getBestQuestion();

        notifyListeners();
    }

    private Question getBestQuestion() {
        Question best = null;
        int best_score = 0;

        for(Question q: questions) {
            int score = getScore(q);

            if(score > best_score) {
                best_score = score;
                best = q;
            }
        }

        return best;
    }

    private int getScore(Question q) {
        Set<String> intersectionYes = new HashSet<>(medicines);
        intersectionYes.retainAll(q.getYes());

        Set<String> intersectionNo = new HashSet<>(medicines);
        intersectionNo.retainAll(q.getNo());

        int score = Math.max(intersectionYes.size(), intersectionNo.size());

        if(score == medicines.size() || score == 0) {
            return 0;
        }

        return score;
    }

    public void notifyListeners() {
        if (medicines.size() > 1 && !questions.isEmpty())
        {
            listener.propertyChange(new PropertyChangeEvent(this, "question", null, currentQuestion));
        } else {
            listener.propertyChange(new PropertyChangeEvent(this, "output", null, medicines));
        }
    }
}
