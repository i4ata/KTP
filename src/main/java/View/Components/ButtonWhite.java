package View.Components;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ButtonWhite extends ButtonBase {
    public ButtonWhite(String text) {
        super(text);
        init();
    }

    public void init() {
        outerBorder = new LineBorder(borderColor, 5, true);
        defaultBorder = getCompoundBorder(defaultBackgroundColor);
        hoverBorder = getCompoundBorder(hoverBackgroundColor);
        pressedBorder = getCompoundBorder(pressedBackgroundColor);

        setForeground(textColor);
        setBorder(defaultBorder);
        setFont(new Font("ArcadeClassic", Font.BOLD, 40));
    }

    private Border getCompoundBorder(Color color) {
        return BorderFactory.createCompoundBorder(outerBorder,
                BorderFactory.createLineBorder(color, 20));
    }

    public void setFontSize(int size) {
        this.setFont(new Font("ArcadeClassic", Font.BOLD, size));
    }

    public void disableButton() {
        setText("");
        setIcon(null);
        hoverBackgroundColor = Color.BLACK;
        pressedBackgroundColor = Color.BLACK;
        borderColor = Color.BLACK;
        init();
    }

}
