import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class InputOutputFrame
{

    // Вводим значения res;
    // =
    // Вводим значения inp
    // действия
    private static String s0,s1,s2;


    private static JTextField output = new JTextField();



    JPanel panel;

    InputOutputFrame(JPanel panel) {
        s0=s1=s2 = "";

        this.panel = panel;

        output.setBounds(0,0, 305, 175);
        output.setEditable(false);
        output.setFocusable(false);
        output.setHorizontalAlignment(output.RIGHT);
        output.setText("0");
        panel.add(output);
    }

    public String getS0() {
        return s0;
    }

    public void setS0(String s0) {
        this.s0 = s0;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public String getS2() {
        return s2;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }

    public JTextField getOutput() {
        return output;
    }

    public void setOutput(JTextField output) {
        this.output = output;
    }

    //    public void printOutput()
//    {
//        output.setText(Double.toString(result));
//    }
//
//
//    public void calculateAdd()
//    {
//        result = result + input;
//        output.setText( Double.toString(result) + " + " +  Double.toString(input) + " = " +  Double.toString( result ) );
//
//        input = 0.0;
//    }
//
//    public void calculateSub()
//    {
//        result = result - input;
//        output.setText( Double.toString(result) + " - " +  Double.toString(input) + " = " +  Double.toString( result ) );
//
//        input = 0.0;
//    }
//
//    public void calculateDiv()
//    {
//        result = result / input;
//        output.setText( Double.toString(result) + " / " +  Double.toString(input) + " = " +  Double.toString( result  ) );
//
//        input = 0.0;
//    }
//
//    public void calculateMul()
//    {
//        result = result * input;
//        output.setText( Double.toString(result) + " * " +  Double.toString(input) + " = " +  Double.toString( result  ) );
//        input = 0.0;
//    }
//
//    public void calculatePow()
//    {
//        double res = Math.pow(result, input);
//        output.setText( Double.toString(result) + " ^ " +  Double.toString(input) + " = " +  Double.toString( res ) );
//        result = res;
//        input = 0.0;
//    }
//

//
//    public void calculateSqrt()
//    {
//        result = Math.pow(result, 0.5);
//        output.setText( "sqrt("+ Double.toString(input) + ") = " +  Double.toString( result ) );
//        input = 0.0;
//    }
//
//
//    public JTextField getOutput() {
//        return output;
//    }
//
//    public void setOutput(JTextField output) {
//        this.output = output;
//    }
//
//    public double getResult() {
//        return result;
//    }
//
//    public void setResult(double result) {
//        this.result = result;
//    }
//
//    public double getInput() {
//        return input;
//    }
//
//    public void setInput(double number) {
//        this.input = number;
//    }


}
