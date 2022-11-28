package View.Components;

import javax.swing.*;
import java.awt.*;

public class Text extends JLabel {
    public Text(String text, int size) {
        super(text);
        setBackground(Color.DARK_GRAY);
        setForeground(Color.WHITE);
    }
}