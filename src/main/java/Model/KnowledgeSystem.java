package Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;

public class KnowledgeSystem {

    transient Collection<PropertyChangeListener> listeners = new ArrayList<>();

    public KnowledgeSystem() {

    }

    private void buildKnowledgeSystem() {

    }

    public void changeToInterface() {
        notifyListeners("showInterface", true);
    }

    private void notifyListeners(String name, Object newValue){
        PropertyChangeEvent payload = new PropertyChangeEvent(this, name, null, newValue);
        for (PropertyChangeListener listener : listeners){
            listener.propertyChange(payload);
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        listeners.add(listener);
    }

    public void start(){
        buildKnowledgeSystem();
        changeToInterface();
    }
}
