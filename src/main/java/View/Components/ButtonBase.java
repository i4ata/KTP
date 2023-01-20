package View.Components;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * This class defines the base for the custom buttons in the view.
 */
public abstract class ButtonBase extends JButton {
    protected Color borderColor = Color.WHITE;
    protected Color defaultBackgroundColor = Color.decode("#80D0F4");
    protected Color hoverBackgroundColor = Color.WHITE;
    protected Color pressedBackgroundColor = Color.LIGHT_GRAY;
    protected final Color textColor = Color.BLACK;

    protected Border outerBorder;
    protected Border defaultBorder;
    protected Border hoverBorder;
    protected Border pressedBorder;

    protected final Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);
    protected final Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);

    /**
     * The constructor for the button which passes the displayed text to the superclass and disables some settings
     * that influence the appearance.
     * @param text The text that is displayed on the button.
     */
    public ButtonBase(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
    }

    protected abstract void init();

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
