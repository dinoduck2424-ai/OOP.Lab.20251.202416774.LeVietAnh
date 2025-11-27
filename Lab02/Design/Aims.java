package hust.soict.cs.aims;

import hust.soict.cs.aims.cart.Cart;
import hust.soict.cs.aims.disc.DigitalVideoDisc;

public class Aims {

    public static void main(String[] args) {

        // Khởi tạo một giỏ hàng mới
        Cart anOrder = new Cart();

        // Tạo các đối tượng DVD mới
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                "The Lion King", "Animation", "Roger Allers", 87, 19.95f);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
                "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc(
                "Aladdin", "Animation", "George Lucas", 18.99f);

        // Thêm các đĩa DVD vào giỏ hàng
        System.out.println("Đang thêm DVD vào giỏ hàng...\n");
        anOrder.addDigitalVideoDisc(dvd1, dvd2);
        anOrder.addDigitalVideoDisc(dvd3);

        // Hiển thị tổng chi phí
        System.out.printf("\nTổng chi phí là: %.2f\n\n", anOrder.totalCost());

        // Hiển thị giỏ hàng hiện tại
        anOrder.print();

        // Thử xóa một DVD không có trong giỏ
        System.out.println("Đang thử xóa một DVD không tồn tại:");
        DigitalVideoDisc notFound = new DigitalVideoDisc("Mr. Bean", "Comedy", 20.55f);
        anOrder.removeDigitalVideoDisc(notFound);

        // Xóa một DVD đang có trong giỏ
        System.out.println("\nĐang xóa DVD (Star Wars):");
        anOrder.removeDigitalVideoDisc(dvd2);

        // Hiển thị giỏ hàng sau khi cập nhật
        System.out.println();
        anOrder.print();
    }
}