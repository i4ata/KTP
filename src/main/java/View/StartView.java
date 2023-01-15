package View;

import View.Components.ButtonWhite;
import View.Components.Text;

import javax.swing.*;
import java.awt.*;

public class StartView extends BaseView{
    private final JComponent mainComponent;
    private final Text gameTitle = new Text("<html><span style='color:#f5e342'>Knowledge System</span></html>", 80);
    private final Text gameDescription = new Text("", 15);

    public StartView() {
        this.mainComponent = this.getMainComponent();
    }

    @Override
    public void init() {
        gameTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        String intro = "<html>A. Angelov, I. Rusinov, R.J. van Dolderen</html>";

        gameDescription.setText(intro);
        gameDescription.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel grid = new JPanel();
        grid.setBackground(Color.DARK_GRAY);
        grid.setLayout(new GridLayout(1,1, 15, 15));
        grid.setPreferredSize(new Dimension(870, 300));

        ButtonWhite startOption = new ButtonWhite("<html>Start</html>");
        startOption.setActionCommand("next:");
        startOption.addActionListener(controller);
        grid.add(startOption);

        mainComponent.setBackground(Color.DARK_GRAY);
        mainComponent.setLayout(new BoxLayout(mainComponent, BoxLayout.PAGE_AXIS));
        mainComponent.add(Box.createRigidArea(new Dimension(0,200)));
        mainComponent.add(gameTitle);
        mainComponent.add(Box.createRigidArea(new Dimension(0,50)));
        mainComponent.add(gameDescription);
        mainComponent.add(Box.createRigidArea(new Dimension(0,50)));
        mainComponent.add(grid);
    }

    @Override
    public void update(Object object) {}
}