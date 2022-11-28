package View;

import View.Components.ButtonWhite;
import View.Components.Text;

import javax.swing.*;
import java.awt.*;

public class InterfaceView extends BaseView{
    private final JComponent mainComponent;
    private final Text description = new Text("", 15);

    public InterfaceView() {
        this.mainComponent = this.getMainComponent();
    }

    @Override
    public void init() {

        String intro = "<html>Hi</html>";

        description.setText(intro);
        description.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainComponent.setBackground(Color.DARK_GRAY);
        mainComponent.setLayout(new BoxLayout(mainComponent, BoxLayout.PAGE_AXIS));
    }

    @Override
    public void update(Object object) {}
}