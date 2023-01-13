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
    
//    public void AskQuestions() {
//        System.out.println("\n\n\n\n\n\n\n\n\n");
//        while(!medicines.isEmpty() || !questions.isEmpty()) {
//            Question bestQuestion = getBestQuestion();
//
//            Set<String> answer = new Random().nextBoolean() ? bestQuestion.getYes() : bestQuestion.getNo();
//
//            questions.remove(bestQuestion);
//
//            medicines.removeAll(answer);
//
//            for(Question q : questions) {
//                q.getNo().removeAll(answer);
//                q.getYes().removeAll(answer);
//            }
//
//            questions.removeIf(element -> getScore(element) == 0);
//            if (medicines.size() == 1) {
//                break;
//            }
//        }
//    }

    public void AskQuestions(String choice) {
        System.out.println("\n\n\n");
        System.out.println("Questions amount:" + questions.size());
        questions.forEach(Question::print);
        for(Question q : questions)
        {
            System.out.println(q.getIndex() + "    " + q.getQuestion() + "  "  + getScore(q));
        }
        System.out.println("\n\n\n");
        System.out.println(medicines.size());
        System.out.println("Current set:" + medicines);

        System.out.println("Question:" + currentQuestion.getQuestion());

        System.out.println(choice);

        Set<String> answer = choice.equals(currentQuestion.getOptions()[0]) ? currentQuestion.getYes() : currentQuestion.getNo();

        questions.remove(currentQuestion);

        medicines.removeAll(answer);

        for(Question q : questions) {
            q.getNo().removeAll(answer);
            q.getYes().removeAll(answer);
        }

        questions.removeIf(element -> getScore(element) == 0);

        System.out.println("Removing:" + currentQuestion.getQuestion());
        System.out.println("Removing:");
        System.out.println(answer);

        currentQuestion = getBestQuestion();

        notifyListeners();
    }

    public Question getBestQuestion() {
        Question best = new Question(1);
        int best_score = getScore(best);

        for(Question q: questions) {
            int score = getScore(q);

            if(score > best_score) {
                best_score = score;
                best = q;
            } else if(score == best_score && best.getIndex() < q.getIndex()) {
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

        //int score = intersectionNo.size() + intersectionYes.size();
        int score = Math.min(intersectionYes.size(), intersectionNo.size());

        if(score == 2*medicines.size() || score == 0) {
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
