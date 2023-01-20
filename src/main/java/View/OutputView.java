package View;

import View.Components.Text;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

/**
 * This class defines the output view, which is displayed when the system has made a decision.
 */
public class OutputView extends BaseView{
    private final JComponent mainComponent;
    private final Text exitText = new Text("Recommended medicine:", 28);
    private final Text medicineText = new Text("0", 100);

    /**
     * This method sets the mainComponent to the standard empty JPanel on initialization.
     */
    public OutputView() {
        this.mainComponent = this.getMainComponent();
    }

    /**
     * This puts all the visible components in the view.
     */
    @Override
    public void init() {
        exitText.setAlignmentX(Component.CENTER_ALIGNMENT);

        medicineText.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainComponent.setLayout(new BoxLayout(mainComponent, BoxLayout.PAGE_AXIS));
        mainComponent.setBackground(Color.decode("#20A0D8"));
        mainComponent.add(Box.createRigidArea(new Dimension(0,250)));
        mainComponent.add(Box.createVerticalGlue());
        mainComponent.add(exitText);
        mainComponent.add(Box.createRigidArea(new Dimension(0,200)));
        mainComponent.add(Box.createVerticalGlue());
        mainComponent.add(medicineText);
    }

    /**
     * This takes an object and updates the correct part of the view based on the object type.
     * @param object The input object that contains the update information.
     */
    @Override
    public void update (Object object) {
        updateOutput((Set<String>) object);
    }

    /**
     * Updates the medicineText string with the corresponding medicine based on the asked questions.
     * @param medicines that is/are displayed.
     */
    public void updateOutput(Set<String> medicines) {
        medicineText.setText(medicines.toString().replace("[", "").replace("]",""));
    }
}
