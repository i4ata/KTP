import Controller.Controller;
import Model.KnowledgeSystem;
import View.MainView;

import javax.swing.*;

/**
 * Run the MVC.
 */
public class Main {

    private static void createAndShowGUI(KnowledgeSystem model, Controller controller) {
        JFrame frame = new JFrame("Main Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MainView mainView = new MainView(controller);
        mainView.setup(model);

        frame.getContentPane().add(mainView.getMainComponent());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            KnowledgeSystem model = new KnowledgeSystem();
            Controller controller = new Controller(model);
            createAndShowGUI(model, controller);
        });
    }
}


