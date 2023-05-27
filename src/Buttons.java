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

    static StringBuilder num = new StringBuilder();


    Buttons(JPanel panel, InputOutputFrame ioframe)
    {
        this.panel = panel;
        this.ioframe = ioframe;


        buttons.add(new JButton("0")); // 0
        buttons.add(new JButton("1")); // 1
        buttons.add(new JButton("2")); // 2
        buttons.add(new JButton("3")); // 3
        buttons.add(new JButton("4")); // 4
        buttons.add(new JButton("5")); // 5
        buttons.add(new JButton("6")); // 6
        buttons.add(new JButton("7")); // 7
        buttons.add(new JButton("8")); // 8
        buttons.add(new JButton("9")); // 9

        buttons.add(new JButton("+")); // 10
        buttons.add(new JButton("-")); // 11
        buttons.add(new JButton("*")); // 12
        buttons.add(new JButton("/")); // 13
        buttons.add(new JButton("DELETE")); // 14
        buttons.add(new JButton("n^k"));    // 15
        buttons.add(new JButton("sqrt"));   // 16
        buttons.add(new JButton("n!"));     // 17
        buttons.add(new JButton("="));      // 18

        buttons.get(0).setBounds(80, 154, 70, 50);
        buttons.get(1).setBounds(10,2,70,50);
        buttons.get(2).setBounds(80,2,70,50);
        buttons.get(3).setBounds(150, 2, 70,50);
        buttons.get(4).setBounds(10, 54, 70, 50);
        buttons.get(5).setBounds(80, 54, 70, 50);
        buttons.get(6).setBounds(150, 54, 70, 50);
        buttons.get(7).setBounds(10, 104, 70, 50);
        buttons.get(8).setBounds(80, 104, 70, 50);
        buttons.get(9).setBounds(150, 104, 70, 50);

        buttons.get(10).setBounds(220, 204, 78, 50); // 244
        buttons.get(11).setBounds(220, 154, 78, 50); // 184
        buttons.get(13).setBounds(220, 54, 78, 50); // 64
        buttons.get(12).setBounds(220, 104, 78, 50); // 124

        buttons.get(14).setBounds(220, 2, 78, 50);

        buttons.get(15).setBounds(80, 204,70,50);
        buttons.get(16).setBounds(150,204,70,50);
        buttons.get(17).setBounds(10, 204,70,50);

        buttons.get(18).setBounds(220,254,78,50);

        for (int i = 0; i < buttons.size(); i++)
        {
            buttons.get(i).addActionListener(this);

            panel.add(buttons.get(i));
        }


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
