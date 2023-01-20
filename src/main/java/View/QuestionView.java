package View;

import Model.Question;
import View.Components.ButtonWhite;
import View.Components.Text;

import javax.swing.*;
import java.awt.*;

/**
 * This class defines the view that is displayed when the questions are being asked.
 */
public class QuestionView extends BaseView{
    private final JComponent mainComponent;
    private JLabel question;
    private JPanel grid;

    /**
     * The constructor sets the mainComponent to the standard empty JPanel on initialization.
     */
    public QuestionView() {
        this.mainComponent = this.getMainComponent();
    }

    /**
     * This method puts all the visible components in the view.
     */
    @Override
    public void init() {
        question = new Text("", 40);
        question.setAlignmentX(Component.CENTER_ALIGNMENT);
        question.setHorizontalAlignment(0);

        grid = new JPanel();
        grid.setLayout(new GridLayout(1,2, 15, 15));
        grid.setPreferredSize(new Dimension(870, 250));
        grid.setBackground(Color.decode("#20A0D8"));

        mainComponent.setLayout(new BoxLayout(mainComponent, BoxLayout.PAGE_AXIS));

        mainComponent.setPreferredSize(new Dimension(750, 680));
        mainComponent.setBackground(Color.decode("#20A0D8"));
        mainComponent.setLayout(new BoxLayout(mainComponent, BoxLayout.PAGE_AXIS));
        mainComponent.add(Box.createRigidArea(new Dimension(0,350)));
        mainComponent.add(question);
        mainComponent.add(Box.createRigidArea(new Dimension(0,150)));
        mainComponent.add(grid);
    }

    /**
     * This method takes an object and updates the correct part of the view based on the object type.
     * @param object The input object that contains the update information.
     */
    @Override
    public void update(Object object) {
        updateOptions((Question) object);
    }

    /**
     * This method fills the buttons with the option strings corresponding to the current question.
     * @param q question whose options are displayed
     */
    public void updateOptions(Question q) {
        String title = "<html>"+q.getQuestion()+"</html>";
        question.setText(title);

        grid.removeAll();
        String[] options = q.getOptions();
        for (String s : options) {
            String option = "<html>" + s + "</html>";
            ButtonWhite optionButton = new ButtonWhite(option);
            optionButton.setActionCommand("question:" + s);
            optionButton.addActionListener(controller);
            grid.add(optionButton);
        }
    }
}
