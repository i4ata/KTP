package View.Components;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * @author Micky Labreche
 * This defines the base for the custom buttons in the game.
 */
public abstract class ButtonBase extends JButton {
    public Color borderColor = Color.WHITE;
    public Color defaultBackgroundColor = Color.BLACK;
    public Color hoverBackgroundColor = Color.DARK_GRAY;
    public Color pressedBackgroundColor = Color.LIGHT_GRAY;
    public final Color textColor = Color.WHITE;

    public Border outerBorder;
    public Border defaultBorder;
    public Border hoverBorder;
    public Border pressedBorder;

    public final Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);
    public final Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);

    /**
     * @author Micky Labreche
     * The constructor for the button which passes the displayed text to the superclass and disables some settings
     * that influence the appearance.
     * @param text The text that is displayed on the button.
     */
    public ButtonBase(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
    }

    /**
     * @author Micky Labreche
     * Defines the abstract method init
     */
    public abstract void init();

    /**
     * @author Micky Labreche
     * Overrides the standard paint method that is used to display the component.
     * It defines which colors should be displayed when hovering over or clicking on a button.
     * It also changes the pointer icon.
     * @param g the <code>Graphics</code> object to protect
     */
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
