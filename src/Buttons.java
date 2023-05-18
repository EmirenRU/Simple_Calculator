import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Buttons implements ActionListener, KeyListener
{
    // x,y,width,height, key
    static private ArrayList<JButton> buttons = new ArrayList<>();
    JPanel panel;
    InputOutputFrame ioframe;
    String operation;


    //nums
    private static JButton button0 = new JButton("0");
    private static JButton button1 = new JButton("1");
    private static JButton button2 = new JButton("2");
    private static JButton button3 = new JButton("3");
    private static JButton button4 = new JButton("4");
    private static JButton button5 = new JButton("5");
    private static JButton button6 = new JButton("6");
    private static JButton button7 = new JButton("7");
    private static JButton button8 = new JButton("8");
    private static JButton button9 = new JButton("9");

    // operations
    private static JButton buttonAdd = new JButton("+");
    private static JButton buttonSub = new JButton("-");
    private static JButton buttonDivide = new JButton("/");
    private static JButton buttonMultiply = new JButton("*");
    // Delete
    private static JButton buttonDel = new JButton("DELETE");
    // pow
    private static JButton buttonPow = new JButton("n^k");
    // sqrt
    private static JButton buttonSqrt = new JButton("sqrt");
    // Factorial
    private static JButton buttonFactorial = new JButton("n!");
    // =
    private static JButton buttonEquility = new JButton("=");

    static StringBuilder num = new StringBuilder();


    Buttons(JPanel panel, InputOutputFrame ioframe)
    {

        this.panel = panel;
        this.ioframe = ioframe;

        button1.setBounds(10,2,70,50);
        button2.setBounds(80,2,70,50);
        button3.setBounds(150, 2, 70,50);
        button4.setBounds(10, 54, 70, 50);
        button5.setBounds(80, 54, 70, 50);
        button6.setBounds(150, 54, 70, 50);
        button7.setBounds(10, 104, 70, 50);
        button8.setBounds(80, 104, 70, 50);
        button9.setBounds(150, 104, 70, 50);
        button0.setBounds(80, 154, 70, 50);

        buttonDel.setBounds(220, 2, 78, 50);

        buttonAdd.setBounds(220, 204, 78, 50); // 244
        buttonSub.setBounds(220, 154, 78, 50); // 184
        buttonDivide.setBounds(220, 54, 78, 50); // 64
        buttonMultiply.setBounds(220, 104, 78, 50); // 124

        buttonFactorial.setBounds(10, 204,70,50);
        buttonPow.setBounds(80, 204,70,50);
        buttonSqrt.setBounds(150,204,70,50);

        buttonEquility.setBounds(220,254,78,50);

        panel.add(button0);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);

        panel.add(buttonDel);
        panel.add(buttonAdd);
        panel.add(buttonSub);
        panel.add(buttonDivide);
        panel.add(buttonMultiply);
        panel.add(buttonFactorial);
        panel.add(buttonPow);
        panel.add(buttonSqrt);

        panel.add(buttonEquility);

        button0.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        buttonAdd.addActionListener(this);
        buttonSub.addActionListener(this);
        buttonDivide.addActionListener(this);
        buttonMultiply.addActionListener(this);

        buttonEquility.addActionListener(this);

        buttonSqrt.addActionListener(this);
        buttonPow.addActionListener(this);
        buttonFactorial.addActionListener(this);
        buttonDel.addActionListener(this);


    }

    private double getFactorial(double input)
    {
        double res = 1;
        for (int i = 1; i < input; i++)
        {
            res *= i;
        }
        return res;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        System.out.println(s);

        if (ioframe.getS1().equals("n^k"))
            ioframe.setS1("^");
        else if(s.equals("DELETE"))
        {
            ioframe.setS0("");
            ioframe.setS1("");
            ioframe.setS2("");
            ioframe.getOutput().setText("0");
        }
        else if (ioframe.getS1().equals("n!"))
            ioframe.setS1("!");




        // if the value is a number
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            // if operand is present then add to second no
            if (!ioframe.getS1().equals(""))
                ioframe.setS2(ioframe.getS2() + s);
            else
                ioframe.setS0(ioframe.getS0() + s);


            // set the value of text

            ioframe.getOutput().setText(ioframe.getS0() + ioframe.getS1() + ioframe.getS2());
        }
        else if (s.charAt(0) == 'C') {
            // clear the one letter
            ioframe.setS0("");
            ioframe.setS1("");
            ioframe.setS2("");

            // set the value of text
            ioframe.getOutput().setText(ioframe.getS0() + ioframe.getS1() + ioframe.getS2());
        }
        else if (s.charAt(0) == '=') {

            double te;
            String s0,s1, s2;
            s0 = ioframe.getS0();
            s1 = ioframe.getS1();
            s2 = ioframe.getS2();

            // store the value in 1st
            if (ioframe.getS1().equals("+"))
                te = (Double.parseDouble(s0) + Double.parseDouble(s2));
            else if (s1.equals("-"))
                te = (Double.parseDouble(s0) - Double.parseDouble(s2));
            else if (s1.equals("/"))
                te = (Double.parseDouble(s0) / Double.parseDouble(s2));
            else if (s1.equals("*"))
                te = (Double.parseDouble(s0) * Double.parseDouble(s2));
            else if (s1.equals("!"))
                te = (getFactorial(Double.parseDouble(s0)));
            else if (s1.equals("^")) {
                te = (Math.pow(Double.parseDouble(s0), Double.parseDouble(s2)));
                s1 = "^";
            }
            else if (s1.equals("sqrt"))
                te = (Math.sqrt(Double.parseDouble(s0)));
            else
                te = Double.parseDouble(s0);

            if (ioframe.getS1().equals("sqrt"))
                ioframe.getOutput().setText( ioframe.getS1() + "(" + ioframe.getS0() + ") = " + te);
            else if (ioframe.getS1().equals("DELETE"))
                ioframe.getOutput().setText("0");
            else if ( ioframe.getS1().equals("^"))
                ioframe.getOutput().setText( ioframe.getS0() + "^" + ioframe.getS2() + " = " + te);
            else if (ioframe.getS1().equals("!"))
                ioframe.getOutput().setText( ioframe.getS0() + "! = " + te);

            else
                // set the value of text
                ioframe.getOutput().setText(ioframe.getS0() + ioframe.getS1() + ioframe.getS2() + " = " + te);

            // convert it to string
            ioframe.setS0(Double.toString(te));

            ioframe.setS2("");
            ioframe.setS1("");

        }
        else {
            // if there was no operand
            if (ioframe.getS1().equals("") || ioframe.getS2().equals("")) {
                ioframe.setS1(s);
            }
            // else evaluate
            else {
                double te;

                String s0, s1, s2;
                s0 = ioframe.getS0();
                s1 = ioframe.getS1();
                s2 = ioframe.getS2();
                // store the value in 1st
                if (s1.equals("+"))
                    te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                else if (s1.equals("-"))
                    te = (Double.parseDouble(s0) - Double.parseDouble(s2));
                else if (s1.equals("/"))
                    te = (Double.parseDouble(s0) / Double.parseDouble(s2));
                else if (s1.equals("*"))
                    te = (Double.parseDouble(s0) * Double.parseDouble(s2));
                else if (s1.equals("^"))
                    te = (Math.pow(Double.parseDouble(s0), Double.parseDouble(s2)));
                else if (s1.equals("sqrt"))
                    te = (Math.sqrt(Double.parseDouble(s0)));
                else if (s1.equals("DELETE"))
                    te = 0;
                else if (s1.equals("!"))
                    te = (getFactorial(Double.parseDouble(s0)));
                else
                    te = Double.parseDouble(s0);

                // convert it to string
                ioframe.setS0(Double.toString(te));


                // place the operator
                ioframe.setS1(s);

                // make the operand blank
                ioframe.setS2("");

            }

            if (ioframe.getS1().equals("sqrt"))
                ioframe.getOutput().setText(ioframe.getS1() + "(" + ioframe.getS0() + ")");
            else if (ioframe.getS1().equals("DELETE")) {
                ioframe.getOutput().setText("0");
                ioframe.setS1("");
            }
            else if (ioframe.getS1().equals("!"))
                ioframe.getOutput().setText( ioframe.getS0() + "!");

            else
                // set the value of text
                ioframe.getOutput().setText(ioframe.getS0() + ioframe.getS1() + ioframe.getS2());

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
//
//    private static
//

}
