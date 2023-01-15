package View;

import Model.Question;
import View.Components.ButtonWhite;
import View.Components.Text;

import javax.swing.*;
import java.awt.*;

public class QuestionView extends BaseView{
    private final JComponent mainComponent;
    private JLabel question;
    private JPanel grid;

    public QuestionView() {
        this.mainComponent = this.getMainComponent();
    }

    @Override
    public void init() {
        question = new Text("", 40);

        grid = new JPanel();
        grid.setLayout(new GridLayout(1,2, 15, 15));
        grid.setPreferredSize(new Dimension(870, 250));
        grid.setBackground(Color.DARK_GRAY);

        mainComponent.setLayout(new BoxLayout(mainComponent, BoxLayout.PAGE_AXIS));
        question.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainComponent.setPreferredSize(new Dimension(750, 980));
        mainComponent.setBackground(Color.DARK_GRAY);
        mainComponent.setLayout(new BoxLayout(mainComponent, BoxLayout.PAGE_AXIS));
        mainComponent.add(Box.createRigidArea(new Dimension(0,100)));
        mainComponent.add(question);
        mainComponent.add(Box.createRigidArea(new Dimension(0,550)));
        mainComponent.add(grid);
    }

    /**
     * @author Micky Labreche
     * This takes an object and updates the correct part of the view based on the object type.
     * @param object The input object that contains the update information.
     */
    @Override
    public void update(Object object) {
        updateOptions((Question) object);
    }


    public void updateOptions(Question q) {
        String title = "<html>"+q.getQuestion()+"</html>";
        question.setText(title);

        grid.removeAll();
        String[] options = q.getOptions();
        for (int i = 0; i < options.length; i++) {
            String option = "<html>" + options[i] + "</html>";
            ButtonWhite optionButton = new ButtonWhite(option);
            optionButton.setActionCommand("question:"+options[i]);
            optionButton.addActionListener(controller);
            grid.add(optionButton);
        }
    }
}
