package ViewTest;

import Controller.Controller;
import KnowledgeBase.KB;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View extends JFrame implements PropertyChangeListener {

    JLabel question;
    JButton button;

    public View() {
        init();
    }

    private void init() {
        setTitle("KB");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        question = new JLabel();
        add(question, BorderLayout.CENTER);
        button = new JButton("Next");
        add(button, BorderLayout.SOUTH);
        setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String newQuestion = (String) evt.getNewValue();
        System.out.println(newQuestion);
        question.setText(newQuestion);
    }

    public void setup(KB model) {
        question.setText(model.getCurrentQuestion().getText());
        button.addActionListener(new Controller(model));
        model.setListener(this);
    }
}
