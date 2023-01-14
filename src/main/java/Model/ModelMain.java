package Model;

import java.util.Random;
import java.util.Set;

/**
 * A class to run only the model.
 */
public class ModelMain {

    /**
     * Run the model alone by giving a random answer on each question.
     * @param args
     */
    public static void main(String[] args) {
        KnowledgeSystem model = new KnowledgeSystem();
        model.setListener(evt -> {});

        Set<Question> questions = model.getQuestions();
        Set<String> medicines = model.getMedicines();

        while(!questions.isEmpty() && !medicines.isEmpty()) {
            model.AskQuestions(model.getCurrentQuestion().getOptions()[new Random().nextInt(2)]);
            if(medicines.size() == 1) {
                System.out.println("Done!");
                System.out.println(medicines);
                break;
            }
        }
    }
}
