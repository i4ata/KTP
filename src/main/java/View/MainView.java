package View;

import Controller.Controller;
import Model.KnowledgeSystem;

import javax.swing.*;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;

/**
 * Main view. This class provides the main JPanel in which all the different views will be displayed.
 */
public class MainView implements PropertyChangeListener{
    private final JPanel mainPanel = new JPanel();

    private final HashMap<String, BaseView> views = new HashMap<>() {{
        put("start", new StartView());
        put("question", new QuestionView());
        put("output", new OutputView());
    }};

    private final HashMap<String, JComponent> viewComponents = new HashMap<>();

    /**
     * Constructor for the main view, which controls visibility of other views
     * @param controller controller
     */
    public MainView(Controller controller) {
        mainPanel.setBackground(Color.decode("#20A0D8"));
        for (Map.Entry<String, BaseView> viewPair : views.entrySet()) {
            String viewName = viewPair.getKey();
            BaseView view = viewPair.getValue();
            JComponent viewComponent = view.getMainComponent();

            view.setController(controller);
            view.init();
            viewComponents.put(viewName, viewComponent);
            mainPanel.add(viewComponent);
        }

        hideAllViews();
        viewComponents.get("start").setVisible(true);
    }

    /**
     * Gets the main JPanel where every view is displayed
     * @return The main JPanel visible in the JFrame
     */
    public JComponent getMainComponent() {
        return mainPanel;
    }

    /**
     * Hides all the views that are added to the viewComponents Hashmap
     */
    private void hideAllViews() {
        for (JComponent comp: viewComponents.values()) {
            comp.setVisible(false);
        }
    }

    /**
     * Adds the MainView as a listener for changes in the model.
     * @param model Model class of the game
     */
    public void setup (KnowledgeSystem model){
        model.addPropertyChangeListener(this);
    }

    /**
     * This makes updates in the mainView by showing and hiding views.
     * It also updates components in the views. Updates come from the knowledgesystem class.
     * @param evt A PropertyChangeEvent object describing the event source
     *          and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        hideAllViews();
        switch (evt.getPropertyName()) {
            case ("showStartView") -> viewComponents.get("start").setVisible(true);
            case("showQuestionView") -> {
                views.get("question").update(evt.getNewValue());
                viewComponents.get("question").setVisible(true);
            }
            case("showOutputView") -> {
                views.get("output").update(evt.getNewValue());
                viewComponents.get("output").setVisible(true);
            }
        }
    }
}
