package LAB_01;
import javax.swing.JOptionPane;

public class Calc {
    public static void main(String[] args) {
        try {
            String strnum1 = JOptionPane.showInputDialog("Input first number:");
            String strnum2 = JOptionPane.showInputDialog("Input second number:");

            double num1 = Double.parseDouble(strnum1);
            double num2 = Double.parseDouble(strnum2);

            if (num2 == 0) {
                JOptionPane.showMessageDialog(null, "The divisor can't be zero");
                return;
            }

            JOptionPane.showMessageDialog(null,
                    num1 + " + " + num2 + " = " + (num1 + num2) + "\n" +
                    num1 + " - " + num2 + " = " + (num1 - num2) + "\n" +
                    num1 + " * " + num2 + " = " + (num1 * num2) + "\n" +
                    num1 + " / " + num2 + " = " + (num1 / num2));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid number input!");
        }
    }
}
