package View;

import Controller.Controller;
import Model.KnowledgeSystem;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;

public class MainView implements PropertyChangeListener {
    private final JPanel mainPanel = new JPanel();

    private final HashMap<String, BaseView> views = new HashMap<>() {{
        put("start", new StartView());
        put("interface", new InterfaceView());
    }};

    private final HashMap<String, JComponent> viewComponents = new HashMap<>();

    public MainView(Controller controller) {
        mainPanel.setBackground(Color.DARK_GRAY);
        mainPanel.setBackground(Color.BLACK);
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
            case ("showInterface") -> {
                viewComponents.get("interface").setVisible(true);
            }
        }
    }
}
