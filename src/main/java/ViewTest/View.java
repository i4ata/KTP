package ViewTest;

import Controller.Controller;
import KnowledgeBase.KB;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class View extends JFrame implements PropertyChangeListener {

    JLabel question;
    JButton startButton;
    JPanel buttonPanel = new JPanel();

    public View() {
        init();
    }

    private void init() {
        setTitle("KB");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        question = new JLabel("Welcome");
        add(question, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        remove(buttonPanel);
        String newQuestion = (String) evt.getNewValue();
        List<String> answers = (List<String>) evt.getOldValue();
        System.out.println(newQuestion);
        if(answers == null) { // leaf node
            question.setText(newQuestion);
            return;
        }
        System.out.println(answers);
        buttonPanel = new JPanel();
        for (String answer : answers) {
            JButton b = new JButton(answer);
            b.addActionListener(startButton.getActionListeners()[0]);
            b.setActionCommand(answer);
            buttonPanel.add(b);
        }
        add(buttonPanel, BorderLayout.SOUTH);
        invalidate();
        validate();
        repaint();
        question.setText(newQuestion);
    }

    public void setup(KB model) {
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
