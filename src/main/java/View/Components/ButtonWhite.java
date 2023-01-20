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

    @Override
    protected void init() {
        outerBorder = new LineBorder(borderColor, 5, true);
        defaultBorder = getCompoundBorder(defaultBackgroundColor);
        hoverBorder = getCompoundBorder(hoverBackgroundColor);
        pressedBorder = getCompoundBorder(pressedBackgroundColor);

        setForeground(textColor);
        setBorder(defaultBorder);
        setFont(new Font("ArcadeClassic", Font.BOLD, 20));
    }

    private Border getCompoundBorder(Color color) {
        return BorderFactory.createCompoundBorder(outerBorder,
                BorderFactory.createLineBorder(color, 20));
    }
}
