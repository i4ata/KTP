//package View;
//
//import View.Components.ButtonWhite;
//import View.Components.Text;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class InterfaceView extends BaseView{
//    private final JComponent mainComponent;
//    private final Text description = new Text("", 15);
//
//    public InterfaceView() {
//        this.mainComponent = this.getMainComponent();
//    }
//
//    @Override
//    public void init() {
//
//        String intro = "<html>Hi</html>";
//
//        description.setText(intro);
//        description.setAlignmentX(Component.CENTER_ALIGNMENT);
//
//        mainComponent.setBackground(Color.DARK_GRAY);
//        mainComponent.setLayout(new BoxLayout(mainComponent, BoxLayout.PAGE_AXIS));
//    }
//
//    @Override
//    public void update(Object object) {}
//}

package View;

import KnowledgeBase.KB;
import KnowledgeBase.Question;
import View.Components.ButtonWhite;
import View.Components.Text;

import javax.swing.*;
import java.awt.*;

public class InterfaceView extends BaseView
{
    private JComponent mainComponent;

    public InterfaceView() {
        this.mainComponent = this.getMainComponent();
    }

    @Override
    public void init() {
//        Text chooseClass = new Text("Choose a class", 40);
//        chooseClass.setAlignmentX(Component.CENTER_ALIGNMENT);
//
//        JPanel grid = new JPanel();
//        grid.setBackground(Color.BLACK);
//        grid.setLayout(new GridLayout(1,3, 15, 15));
//        grid.setPreferredSize(new Dimension(870, 450));
//
//        for (int i = 0; i < optionAmount; i++) {
//            ButtonWhite classOption = new ButtonWhite(buttonNames[i]);
//            classOption.setActionCommand("chooseClass:"+i);
//            classOption.addActionListener(controller);
//            grid.add(classOption);
//        }
//
//        grid.setBackground(Color.BLACK);
//        mainComponent.setBackground(Color.BLACK);
//        mainComponent.setLayout(new BoxLayout(mainComponent, BoxLayout.PAGE_AXIS));
//        mainComponent.add(Box.createRigidArea(new Dimension(0,100)));
//        mainComponent.add(chooseClass);
//        mainComponent.add(Box.createRigidArea(new Dimension(0,50)));
//        mainComponent.add(grid);
    }

    @Override
    public void update(Object object)
    {
        if (object instanceof Question)
        {
            Question question = (Question) object;
            mainComponent = getMainComponent();
            Text chooseClass = new Text(question.getText(), 40);
            chooseClass.setAlignmentX(Component.CENTER_ALIGNMENT);

            JPanel grid = new JPanel();
            grid.setBackground(Color.BLACK);
            grid.setLayout(new GridLayout(1,3, 15, 15));
            grid.setPreferredSize(new Dimension(870, 450));

            for (String entry : question.getMap().keySet()) { //sup
                ButtonWhite classOption = new ButtonWhite(entry);
                classOption.setActionCommand("chooseClass:"+entry);
                classOption.addActionListener(controller);
                grid.add(classOption);
            }

            grid.setBackground(Color.BLACK);
            mainComponent.setBackground(Color.BLACK);
            mainComponent.setLayout(new BoxLayout(mainComponent, BoxLayout.PAGE_AXIS));
            mainComponent.add(Box.createRigidArea(new Dimension(0,100)));
            mainComponent.add(chooseClass);
            mainComponent.add(Box.createRigidArea(new Dimension(0,50)));
            mainComponent.add(grid);
        }
    }
}