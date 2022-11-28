import Controller.Controller;
import Model.KnowledgeSystem;
import View.MainView;

import javax.swing.*;

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
        System.out.println("Expert name: Persi Pencheva");
        System.out.println("Field of expertise: Pharmacy (lifelong experience in Bulgaria)");
        SwingUtilities.invokeLater(() -> {
            KnowledgeSystem model = new KnowledgeSystem();
            Controller controller = new Controller(model);
            createAndShowGUI(model, controller);
        });
    }
}
