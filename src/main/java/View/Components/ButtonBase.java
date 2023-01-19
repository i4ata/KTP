package View.Components;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public abstract class ButtonBase extends JButton {
    public Color borderColor = Color.WHITE;
    public Color defaultBackgroundColor = Color.decode("#80D0F4");
    public Color hoverBackgroundColor = Color.WHITE;
    public Color pressedBackgroundColor = Color.LIGHT_GRAY;
    public final Color textColor = Color.BLACK;

    public Border outerBorder;
    public Border defaultBorder;
    public Border hoverBorder;
    public Border pressedBorder;

    public final Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);
    public final Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);

    public ButtonBase(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
    }

    public abstract void init();

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(pressedBackgroundColor);
            setBorder(pressedBorder);
        } else if (getModel().isRollover()) {
            g.setColor(hoverBackgroundColor);
            setBorder(hoverBorder);
            setCursor(handCursor);
        } else {
            g.setColor(defaultBackgroundColor);
            setBorder(defaultBorder);
            setCursor(defaultCursor);
        }
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

}
