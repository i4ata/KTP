package View.Components;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ButtonDialog extends ButtonBase {
    public ButtonDialog(String text) {
        super(text);
        init();
    }

    public void init() {
        int thickness = 12;
        defaultBorder = new LineBorder(defaultBackgroundColor, thickness);
        hoverBorder = new LineBorder(hoverBackgroundColor, thickness);
        pressedBorder = new LineBorder(pressedBackgroundColor, thickness);
        setHorizontalAlignment(SwingConstants.LEFT);

        setForeground(textColor);
        setBorder(defaultBorder);
        setFont(new Font("Kongtext Regular", Font.BOLD, 20));
    }
}
