package View;

import View.Components.Text;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

/**
 * @author Rengert van Dolderen
 * This view is visible after exiting the store. Your score is displayed with a corresponding message.
 */
public class OutputView extends BaseView{
    private final JComponent mainComponent;
    private final Text exitText = new Text("Prescribed medicine:", 28);
    private final Text medicineText = new Text("0", 100);

    public OutputView() {
        this.mainComponent = this.getMainComponent();
    }

    @Override
    public void init() {
        exitText.setAlignmentX(Component.CENTER_ALIGNMENT);

        medicineText.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainComponent.setLayout(new BoxLayout(mainComponent, BoxLayout.PAGE_AXIS));
        mainComponent.setBackground(Color.DARK_GRAY);
        mainComponent.add(Box.createRigidArea(new Dimension(0,100)));
        mainComponent.add(Box.createVerticalGlue());
        mainComponent.add(exitText);
        mainComponent.add(Box.createRigidArea(new Dimension(0,200)));
        mainComponent.add(Box.createVerticalGlue());
        mainComponent.add(medicineText);
    }

    @Override
    public void update (Object object) {
        updateOutput((Set<String>) object);
    }

    public void updateOutput(Set<String> medicines) {
        medicineText.setText(medicines.toString().replace("[", "").replace("]",""));
    }
}
