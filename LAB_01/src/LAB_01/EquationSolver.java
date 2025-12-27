package LAB_01;
import javax.swing.JOptionPane;

public class EquationSolver {
    public static void main(String[] args) {
        String[] options = {"Linear", "System", "Quadratic"};
        int choice = JOptionPane.showOptionDialog(null,
                "Choose equation type",
                "Solver",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);

        if (choice == 0) {
            double a = Double.parseDouble(JOptionPane.showInputDialog("a = "));
            double b = Double.parseDouble(JOptionPane.showInputDialog("b = "));
            if (a == 0)
                JOptionPane.showMessageDialog(null, b == 0 ? "No solution" : "x = " + (-b / a));
            else
                JOptionPane.showMessageDialog(null, "x = " + (-b / a));
        }

        if (choice == 2) {
            double a = Double.parseDouble(JOptionPane.showInputDialog("a = "));
            double b = Double.parseDouble(JOptionPane.showInputDialog("b = "));
            double c = Double.parseDouble(JOptionPane.showInputDialog("c = "));
            if (a == 0) {
                JOptionPane.showMessageDialog(null,
                        b == 0 ? "No solution" : "x = " + (-c / b));
            } else {
                double delta = b * b - 4 * a * c;
                if (delta < 0) JOptionPane.showMessageDialog(null, "No real solution");
                else if (delta == 0)
                    JOptionPane.showMessageDialog(null, "x = " + (-b / (2 * a)));
                else
                    JOptionPane.showMessageDialog(null,
                            "x1 = " + (-b + Math.sqrt(delta)) / (2 * a) +
                            ", x2 = " + (-b - Math.sqrt(delta)) / (2 * a));
            }
        }
    }
}
