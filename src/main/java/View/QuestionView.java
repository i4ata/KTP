package View;

import Model.Question;
import View.Components.ButtonWhite;
import View.Components.Text;

import javax.swing.*;
import java.awt.*;

public class QuestionView extends BaseView{
    private final JComponent mainComponent;
    private JLabel storeOverview;
    private JPanel grid;

    /**
     * @author Micky Labreche
     * This sets the mainComponent to the standard empty JPanel on initialization.
     */
    public QuestionView() {
        this.mainComponent = this.getMainComponent();
    }

    /**
     * @author Micky Labreche
     * This puts all the visible components in the view.
     */
    @Override
    public void init() {
        storeOverview = new Text("", 40);

        grid = new JPanel();
        grid.setLayout(new GridLayout(1,2, 15, 15));
        grid.setPreferredSize(new Dimension(870, 250));
        grid.setBackground(Color.DARK_GRAY);

        mainComponent.setLayout(new BoxLayout(mainComponent, BoxLayout.PAGE_AXIS));
        storeOverview.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainComponent.setPreferredSize(new Dimension(750, 980));
        mainComponent.setBackground(Color.DARK_GRAY);
        mainComponent.setLayout(new BoxLayout(mainComponent, BoxLayout.PAGE_AXIS));
        mainComponent.add(Box.createRigidArea(new Dimension(0,100)));
        mainComponent.add(storeOverview);
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
        storeOverview.setText(title);

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
