package View;

import Controller.Controller;
import Model.Model;
import Model.Question;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Set;

public class MainView extends JFrame implements PropertyChangeListener {

    JLabel question;
    JButton startButton;
    JPanel buttonPanel = new JPanel();

    public MainView() {
        init();
    }

    private void init() {
        setTitle("KB");
        setSize(1200,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        question = new JLabel("Welcome", SwingConstants.CENTER);
        add(question, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        remove(buttonPanel);

        if (evt.getPropertyName().equals("question")) {
            displayQuestions((Question) evt.getNewValue());
        } else {
            invalidate();
            validate();
            repaint();
            question.setText(((Set<String>) evt.getNewValue()).toString());
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

    public void setup(Model model) {
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
