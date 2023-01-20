package View.Components;

import javax.swing.*;
import java.awt.*;

/**
 * The text class defines the standard font and text color for all the text in the view.
 */
public class Text extends JLabel {

    /**
     * Constructor of a label with color white.
     * @param text to be displayed.
     * @param size font size of the text.
     */
    public Text(String text, int size) {
        super(text);
        setBackground(Color.decode("#20A0D8"));
        setForeground(Color.WHITE);
        setFont(new Font("Kongtext Regular", Font.BOLD, size));
    }
}
