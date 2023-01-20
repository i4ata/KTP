package View;

import View.Components.ButtonWhite;
import View.Components.Text;

import javax.swing.*;
import java.awt.*;

public class StartView extends BaseView{
    private final JComponent mainComponent;
    private final Text gameTitle = new Text("<html><span style='color:#f5e342'>Medicine Prescription<br>Knowledge System</span></html>", 80);
    private final Text gameDescription = new Text("", 15);

    /**
     * This sets the mainComponent to the standard empty JPanel on initialization.
     */
    public StartView() {
        this.mainComponent = this.getMainComponent();
    }

    /**
     * This puts all the visible components in the view.
     */
    @Override
    public void init() {
        gameTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        String intro = "<html>A. Angelov, I. Rusinov, R.J. van Dolderen <br><br>" +
                "This knowledge system is a decision-making tool to help pharmacy<br>" +
                "staff make more informed and accurate decisions when prescribing<br>" +
                "medicine.</html>";

        gameDescription.setText(intro);
        gameDescription.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel grid = new JPanel();
        grid.setBackground(Color.decode("#20A0D8"));
        grid.setLayout(new GridLayout(1,1, 15, 15));
        grid.setPreferredSize(new Dimension(870, 200));

        ButtonWhite startOption = new ButtonWhite("<html>Start</html>");
        startOption.setActionCommand("next:");
        startOption.addActionListener(controller);
        grid.add(startOption);

        mainComponent.setBackground(Color.decode("#20A0D8"));
        mainComponent.setLayout(new BoxLayout(mainComponent, BoxLayout.PAGE_AXIS));
        mainComponent.add(Box.createRigidArea(new Dimension(0,200)));
        mainComponent.add(gameTitle);
        mainComponent.add(Box.createRigidArea(new Dimension(0,50)));
        mainComponent.add(gameDescription);
        mainComponent.add(Box.createRigidArea(new Dimension(0,50)));
        mainComponent.add(grid);
    }

    /**
     * This takes an object and updates the correct part of the view based on the object type.
     * @param object The input object that contains the update information.
     */
    @Override
    public void update(Object object) {}
}