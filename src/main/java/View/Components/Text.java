package View.Components;

import javax.swing.*;
import java.awt.*;

/**
 * @author Micky Labreche
 * The text class defines the standard font and text color for all the text in the game.
 */
public class Text extends JLabel {
    public Text(String text, int size) {
        super(text);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
    }
}