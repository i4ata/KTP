package View.Components;

import javax.swing.*;
import java.awt.*;

/**
 * The text class defines the standard font and text color for all the text in the game.
 */
public class Text extends JLabel {
    public Text(String text, int size) {
        super(text);
        setBackground(Color.decode("#20A0D8"));
        setForeground(Color.WHITE);
        setFont(new Font("Kongtext Regular", Font.BOLD, size));
    }
}
