package View.Components;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * @author Micky Labreche
 * This class defines the dialog buttons visible in the dialog view.
 * They don't have a white border, and have a different font.
 */
public class ButtonDialog extends ButtonBase {
    public ButtonDialog(String text) {
        super(text);
        init();
    }

    /**
     * @author Micky Labreche
     * This defines the borders around the dialog options.
     */
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
