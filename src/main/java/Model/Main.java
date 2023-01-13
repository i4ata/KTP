package Model;

import Model.Question;
import Model.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        //State currentState = State.StartScreen;
        System.out.println("Expert name: Persi Pencheva");
        System.out.println("Field of expertise: Pharmacy (lifelong experience in Bulgaria)");
        Model model = new Model();
        model.setListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {}
        });
        Set<Question> questions = model.getQuestions();
        Set<String> medicines = model.getMedicines();

        while(!questions.isEmpty() && !medicines.isEmpty()) {
            model.AskQuestions(model.getCurrentQuestion().getOptions()[new Random().nextInt(2)]);
            if(medicines.size() == 1) {
                System.out.println(medicines);
                break;
            }
        }
    }
}
