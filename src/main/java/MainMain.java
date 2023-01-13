import Model.Model;
import View.MainView;

public class MainMain {
    public static void main(String[] args) {
        Model model = new Model();
        MainView view = new MainView();
        view.setup(model);
    }
}
