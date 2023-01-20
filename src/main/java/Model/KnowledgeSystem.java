package Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Class that provides functionality for a working knowledge system.
 */
public class KnowledgeSystem {
    private final Set<String> medicines = FileReaderCSV.getMedicinesCSV().keySet();
    private final Set<Question> questions = extractQuestions();
    private Question currentQuestion = new Question(1);
    transient Collection<PropertyChangeListener> listeners = new ArrayList<>();

    /**
     * This function creates all Question objects with the information from the csv file.
     * @return questions
     */
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
    public void askQuestions(String choice) {
        Set<String> toRemove = choice.equals(currentQuestion.getOptions()[1]) ? currentQuestion.getYes() : currentQuestion.getNo();
        questions.remove(currentQuestion);
        medicines.removeAll(toRemove);
        for(Question q : questions) {
            q.getNo().removeAll(toRemove);
            q.getYes().removeAll(toRemove);
        }
        questions.removeIf(element -> getScore(element) == 0);

        currentQuestion = getBestQuestion();
        if (medicines.size() > 1 && !questions.isEmpty()) {
            changeToQuestions();
        } else {
            changeToOutput();
        }
    }

    /**
     * This function returns the Question object with the highest score received from the getScore function.
     * @return best
     */
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

    /**
     * getScore receives a Question object and computes a score based on the set of medicine under each outcome
     * compared to the current superset (medicines).
     * @param q
     * @return score
     */
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
     * Method used to change the view to the questions view.
     */
    public void changeToQuestions() {
        notifyListeners("showQuestionView", currentQuestion);
    }

    /**
     * Method used to change the view to the output view.
     */
    public void changeToOutput() {
        notifyListeners("showOutputView", medicines);
    }

    /**
     * changes a property in the view
     * @param name name of the to be changed property
     * @param newValue new value of the property to be changed
     */
    private void notifyListeners(String name, Object newValue){
        PropertyChangeEvent payload = new PropertyChangeEvent(this, name, null, newValue);
        for (PropertyChangeListener listener : listeners){
            listener.propertyChange(payload);
        }
    }

    /**
     * adds a PropertyChangeListener (the model) to the list of listeners
     * @param listener new PropertyChangeListener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener){
        listeners.add(listener);
    }

    /**
     * This method initializes the model process. It sets the currentQuestion to the first question in the csv
     * and changes the view to the questions view.
     */
    public void start() {
        currentQuestion = new Question(1);
        changeToQuestions();
    }
}
