package View;

import Controller.Controller;
import Model.KnowledgeSystem;

import javax.swing.*;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;

public class MainView implements PropertyChangeListener{
    private final JPanel mainPanel = new JPanel();

    private final HashMap<String, BaseView> views = new HashMap<>() {{
        put("start", new StartView());
        put("question", new QuestionView());
        put("output", new OutputView());
    }};

    private final HashMap<String, JComponent> viewComponents = new HashMap<>();

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

    public JComponent getMainComponent() {
        return mainPanel;
    }

    private void hideAllViews() {
        for (JComponent comp: viewComponents.values()) {
            comp.setVisible(false);
        }
    }

    public void setup (KnowledgeSystem model){
        model.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        hideAllViews();
        switch (evt.getPropertyName()) {
            case ("showStartView") -> {
                viewComponents.get("start").setVisible(true);
            }
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
