package hust.soict.cs.aims.store;

import hust.soict.cs.aims.disc.DigitalVideoDisc;

public class Store {
    public static final int MAX_NUMBERS_IN_STORE = 100;  // Số lượng DVD tối đa trong cửa hàng
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBERS_IN_STORE];
    private int curInStore = 0;  // Số lượng DVD hiện tại

    // Thêm DVD vào cửa hàng
    public void addDVD(DigitalVideoDisc disc) {
        if (curInStore < MAX_NUMBERS_IN_STORE) {
            itemsInStore[curInStore] = disc;
            curInStore++;
            System.out.println("Đĩa \"" + disc.getTitle() + "\" đã được thêm vào cửa hàng.");
        } else {
            System.out.println("Cửa hàng đã đầy. Không thể thêm DVD.");
        }
    }

    // Xóa DVD khỏi cửa hàng
    public void removeDVD(DigitalVideoDisc disc) {
        int idx;
        for (idx = 0; idx < curInStore; idx++) {
            if (disc == itemsInStore[idx]) {
                break;
            }
        }

        if (idx == curInStore) {
            System.out.println("Đĩa \"" + disc.getTitle() + "\" không tìm thấy trong cửa hàng.");
            return;
        }

        for (int i = idx; i < curInStore - 1; i++) {
            itemsInStore[i] = itemsInStore[i + 1];
        }
        curInStore--;
        System.out.println("Đĩa \"" + disc.getTitle() + "\" đã được xóa khỏi cửa hàng.");
    }

    // Hiển thị tất cả DVD trong cửa hàng
    public void print() {
        System.out.println("***********************STORE***********************");
        for (int i = 0; i < curInStore; i++) {
            System.out.println((i + 1) + ". " + itemsInStore[i].toString());
        }
        System.out.println("***************************************************");
    }
}