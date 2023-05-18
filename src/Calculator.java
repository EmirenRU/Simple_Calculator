import javax.swing.*;
import java.awt.*;

public class Calculator
{
    static JFrame frame = new JFrame("Calculator");
    static JPanel panelInputOutput = new JPanel(null);
    static JPanel panelButtons = new JPanel(null);
    Buttons buttons;
    InputOutputFrame ioframe;


    Calculator()
    {
            initCalculator();
    }

    final private void initCalculator()
    {
        frame.setBackground(new Color(58,58,58,255));
        frame.setSize(320, 532);

        panelInputOutput.setBounds(0,0,320,175);
        panelButtons.setBounds(0,175,320,310);
        panelButtons.setBackground(new Color(58,58,58));
        panelInputOutput.setBackground(new Color(65,65,65));

        ioframe = new InputOutputFrame(panelInputOutput);
        buttons = new Buttons(panelButtons, ioframe);









        frame.setResizable(false);
        frame.add(panelButtons);
        frame.add(panelInputOutput);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    // w=60 h=36
    // w=320 h=532
    // h = 309
    // h = 225







}
