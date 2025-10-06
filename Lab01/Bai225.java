import javax.swing.JOptionPane;

public class Calculator {
    public static void main(String[] args) {
        // Sử dụng try-catch để xử lý lỗi nhập liệu không phải là số
        try {
            // 1. Nhập liệu và kiểm tra null (khi người dùng nhấn Cancel)
            String strNum1 = JOptionPane.showInputDialog("Enter the first number (Num1):");
            if (strNum1 == null) return; // Kết thúc nếu Cancel

            String strNum2 = JOptionPane.showInputDialog("Enter the second number (Num2):");
            if (strNum2 == null) return; // Kết thúc nếu Cancel

            // 2. Chuyển đổi và tính toán
            double num1 = Double.parseDouble(strNum1);
            double num2 = Double.parseDouble(strNum2);

            double sum = num1 + num2;
            double difference = num1 - num2;
            double product = num1 * num2;
            
            // 3. Xây dựng chuỗi kết quả một cách gọn gàng
            StringBuilder resultBuilder = new StringBuilder();
            resultBuilder.append(String.format("Sum (Num1 + Num2): %.2f\n", sum));
            resultBuilder.append(String.format("Difference (Num1 - Num2): %.2f\n", difference));
            resultBuilder.append(String.format("Product (Num1 * Num2): %.2f\n", product));

            // 4. Xử lý phép chia
            if (num2 != 0) {
                double quotient = num1 / num2;
                resultBuilder.append(String.format("Quotient (Num1 / Num2): %.2f", quotient));
            } else {
                resultBuilder.append("Quotient (Num1 / Num2): Undefined (Cannot divide by zero)");
            }

            // 5. Hiển thị kết quả
            JOptionPane.showMessageDialog(null, resultBuilder.toString(), "Calculation Results", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException e) {
            // Thông báo lỗi nếu người dùng nhập ký tự không phải số
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numerical values.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Dù có lỗi hay không, luôn thoát chương trình
            System.exit(0);
        }
    }
}
