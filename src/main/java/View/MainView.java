package View;

import Controller.Controller;
import Model.KnowledgeSystem;
import Model.Question;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The main view of the system.
 */
public class MainView extends JFrame implements PropertyChangeListener {

    JLabel question;
    JButton startButton;
    JPanel buttonPanel = new JPanel();

    /**
     * Initialize the view with a welcoming screen.
     */
    public MainView() {
        init();
    }

    private void init() {
        setTitle("KnowledgeSystem");
        setSize(1200,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        question = new JLabel("Welcome", SwingConstants.CENTER);
        add(question, BorderLayout.CENTER);
        setVisible(true);
    }

    /**
     * Update the view based on changes in the model.
     * Display the next question and the possible options.
     * If there are no more questions to be asked, display the conclusion of the knowledge system.
     * @param evt A PropertyChangeEvent object describing the event source
     *          and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        remove(buttonPanel);

        if (evt.getPropertyName().equals("question")) {
            displayQuestions((Question) evt.getNewValue());
        } else {
            invalidate();
            validate();
            repaint();
            question.setText(evt.getNewValue().toString());
        }
    }

    private void displayQuestions(Question currentQuestion) {

        String text = currentQuestion.getQuestion();
        String op1 = currentQuestion.getOptions()[0];
        String op2 = currentQuestion.getOptions()[1];

        System.out.println(text);
        System.out.println(op1 + " " + op2);
        buttonPanel = new JPanel();

        JButton b1 = new JButton(op1);
        b1.addActionListener(startButton.getActionListeners()[0]);
        b1.setActionCommand(op1);

        JButton b2 = new JButton(op2);
        b2.addActionListener(startButton.getActionListeners()[0]);
        b2.setActionCommand(op2);


        buttonPanel.add(b1);
        buttonPanel.add(b2);

        add(buttonPanel, BorderLayout.SOUTH);
        invalidate();
        validate();
        repaint();
        question.setText(text);
    }

    /**
     * Link the view and the model by passing the view as a listener of the model.
     * Initialize the controller for the buttons in the view.
     * @param model
     */
    public void setup(KnowledgeSystem model) {
        startButton = new JButton("Next");
        startButton.addActionListener(new Controller(model));
        startButton.setActionCommand("Next");
        buttonPanel.add(startButton);
        add(buttonPanel, BorderLayout.SOUTH);

        model.setListener(this);

        invalidate();
        validate();
        repaint();
    }
}
