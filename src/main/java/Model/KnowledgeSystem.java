package Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashSet;
import java.util.Set;

/**
 * Class that provides functionality for a working knowledge system.
 */
public class KnowledgeSystem {
    private Set<String> medicines = FileReaderCSV.getMedicinesCSV().keySet();
    private Set<Question> questions = extractQuestions();
    private Question currentQuestion = new Question(1);
    public Question getCurrentQuestion() {
        return currentQuestion;
    }
    private PropertyChangeListener listener;

    /**
     * Add a listener to the model. We set this listener to be the main view.
     * @param listener that updates the view upon changes in the model.
     */
    public void setListener(PropertyChangeListener listener) {
        this.listener = listener;
    }

    /**
     * Get a set of the current available medicine names.
     * @return the medicine names.
     */
    public Set<String> getMedicines() {
        return medicines;
    }

    /**
     * Get the set of the current available questions
     * @return the questions
     */
    public Set<Question> getQuestions() {
        return questions;
    }
    private Set<Question> extractQuestions() {
        Set<Question> questions = new HashSet<>();
        for(int idx = 1; idx <= FileReaderCSV.getQuestionsCSV().size(); ++idx) {
            questions.add(new Question(idx));
        }
        return questions;
    }

    /**
     * Function that answers the current question,
     * removes irrelevant questions based on the answer,
     * and removes medicines that contradict the answer.
     * Then, the function chooses the new best question.
     * @param choice the answer to the current question.
     */
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

    /**
     * Notify the listener about changes in the model.
     */
    public void notifyListeners() {
        if (medicines.size() > 1 && !questions.isEmpty()) {
            listener.propertyChange(new PropertyChangeEvent(this, "question", null, currentQuestion));
        } else {
            listener.propertyChange(new PropertyChangeEvent(this, "output", null, medicines));
        }
    }
}
