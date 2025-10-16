import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args) {
        // Hiển thị hộp thoại xác nhận (Confirm Dialog)
        int option = JOptionPane.showConfirmDialog(null,
            "Do you want to change to the first class ticket?");

        // Hiển thị hộp thoại thông báo kết quả (Message Dialog)
        // Dùng toán tử 3 ngôi (?:) để chuyển giá trị option sang chuỗi "Yes" hoặc "No"
        JOptionPane.showMessageDialog(null, "You've chosen: "
            + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));
            
        // Thoát chương trình
        System.exit(0);
    }
}