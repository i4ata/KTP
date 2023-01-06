import Controller.Controller;
import Model.KnowledgeSystem;
import View.MainView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    private static void loadFont(String path) {
        try (InputStream input = Main.class.getResourceAsStream(path)) {
            if (input == null) {
                throw new IOException("The font could not be found");
            }

            Font arcade = Font.createFont(Font.TRUETYPE_FONT, input);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(arcade);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }

    private static void createAndShowGUI(KnowledgeSystem model, Controller controller) {
        JFrame frame = new JFrame("Main Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loadFont("fonts/tnr.ttf");

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
