package View;

import View.Components.ButtonWhite;
import View.Components.Text;

import javax.swing.*;
import java.awt.*;

public class StartView extends BaseView{
    private final JComponent mainComponent;
    private final Text title = new Text("<html><span style='color:#f5e342'>KnowledgeSystem</span></html>", 80);
    private final Text description = new Text("", 15);

    /**
     * @author Rengert van Dolderen
     * This sets the mainComponent to the standard empty JPanel on initialization.
     */
    public StartView() {
        this.mainComponent = this.getMainComponent();
    }

    /**
     * @author Rengert van Dolderen
     * This puts all the visible components in the view.
     */
    @Override
    public void init() {
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        String intro = "<html>Pharmacy Knowledge System</html>";

        description.setText(intro);
        description.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel grid = new JPanel();
        grid.setBackground(Color.BLACK);
        grid.setLayout(new GridLayout(1,1, 15, 15));
        grid.setPreferredSize(new Dimension(870, 300));

        ButtonWhite startOption = new ButtonWhite("<html>Start New</html>");
        startOption.setActionCommand("interface:");
        startOption.addActionListener(controller);
        grid.add(startOption);


        mainComponent.setBackground(Color.BLACK);
        mainComponent.setLayout(new BoxLayout(mainComponent, BoxLayout.PAGE_AXIS));
        mainComponent.add(Box.createRigidArea(new Dimension(0,200)));
        mainComponent.add(title);
        mainComponent.add(Box.createRigidArea(new Dimension(0,50)));
        mainComponent.add(description);
        mainComponent.add(Box.createRigidArea(new Dimension(0,50)));
        mainComponent.add(grid);
    }

    @Override
    public void update(Object object) {}
}