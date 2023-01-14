import Model.KnowledgeSystem;
import View.MainView;

/**
 * Run the MVC.
 */
public class Main {
    public static void main(String[] args) {
        KnowledgeSystem model = new KnowledgeSystem();
        MainView view = new MainView();
        view.setup(model);
    }
}
