package hust.soict.cs.aims.cart;

import hust.soict.cs.aims.disc.DigitalVideoDisc;

public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    // Phương thức thêm một đĩa DVD đơn lẻ
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("Đĩa \"" + disc.getTitle() + "\" đã được thêm.");
        } else {
            System.out.println("Giỏ hàng đã gần đầy!");
        }
    }
    
    // Nạp chồng: Thêm một danh sách đĩa bằng mảng
    public void addDigitalVideoDisc(DigitalVideoDisc[] discList) {
        for (DigitalVideoDisc disc : discList) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered] = disc;
                qtyOrdered++;
                System.out.println("Danh sách đĩa đã được thêm.");
            } else {
                System.out.println("Giỏ hàng đã gần đầy.");
                break;
            }
        }
    }
    
    /* // Nạp chồng: Thêm bằng varargs (bị xung đột với mảng nên tạm khóa)
    public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
        if (dvdList.length + qtyOrdered > MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full. Cannot add this list of DVDs!");
            return;
        }
        for (int i = 0; i < dvdList.length; i++) {
            itemsOrdered[qtyOrdered] = dvdList[i];
            qtyOrdered++;
        }
        System.out.println("The list of DVDs has been added.");
    } 
    */

    // Nạp chồng: Thêm chính xác 2 đĩa
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered + 2 > MAX_NUMBERS_ORDERED) {
            System.out.println("Không thể thêm 2 DVD vì giỏ hàng đầy!");
            return;
        }

        itemsOrdered[qtyOrdered++] = dvd1;
        System.out.println("Đĩa \"" + dvd1.getTitle() + "\" đã được thêm.");
        itemsOrdered[qtyOrdered++] = dvd2;
        System.out.println("Đĩa \"" + dvd2.getTitle() + "\" đã được thêm.");
    }

    // Phương thức xóa đĩa
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        int idx;
        for (idx = 0; idx < qtyOrdered; idx++) {
            if (disc == itemsOrdered[idx]) {
                break;
            }
        }

        if (idx == qtyOrdered) {
            System.out.println("Không tìm thấy đĩa \"" + disc.getTitle() + "\" trong giỏ hàng.");
            return;
        }

        for (int i = idx; i < qtyOrdered - 1; i++) {
            itemsOrdered[i] = itemsOrdered[i + 1];
        }
        qtyOrdered--;
        System.out.println("Đĩa \"" + disc.getTitle() + "\" đã được xóa.");
    }

    // Phương thức tính tổng chi phí
    public float totalCost() {
        float sum = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            sum += itemsOrdered[i].getCost();
        }
        return sum;
    }

    // Tìm kiếm theo ID
    public void searchById(int id) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                System.out.println("Đã tìm thấy: " + itemsOrdered[i].toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy kết quả nào cho ID: " + id);
        }
    }

    // Tìm kiếm theo Tiêu đề
    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                System.out.println("Đã tìm thấy: " + itemsOrdered[i].toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy kết quả nào cho tiêu đề: " + title);
        }
    }
    
    // In nội dung giỏ hàng theo định dạng
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Các mục đã đặt hàng:");

        System.out.printf("%-5s%-25s%10s\n", "STT", "Tiêu đề", "Giá ($)");
        System.out.println("--------------------------------------------------");

        for (int i = 0; i < qtyOrdered; i++) {
            System.out.printf("%-5d%-25s%10.2f\n", i + 1, itemsOrdered[i].getTitle(), itemsOrdered[i].getCost());
        }

        System.out.println("--------------------------------------------------");
        System.out.printf("%-30s%10.2f\n", "Tổng chi phí:", totalCost());
        System.out.println("**************************************************\n");
    }
}