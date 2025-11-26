package hust.soict.cs.aims.cart;

import hust.soict.cs.aims.disc.DigitalVideoDisc;

public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    //Thêm 1 đĩa đơn lẻ
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
        } else {
            System.out.println("The cart is almost full!");
        }
    }
    //Thêm danh sách nhiều đĩa bằng list
    public void addDigitalVideoDisc(DigitalVideoDisc[] discList) {
        for (DigitalVideoDisc disc : discList) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered] = disc;
                qtyOrdered++;
                System.out.println("The list of disc have been added");
            } else {
                System.out.println("The cart is almost full");
                break;
            }
        }
    }
    //Thêm danh sách nhiều đĩa (varargs)
    /*public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
        if (dvdList.length + qtyOrdered > MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full. Cannot add this list of DVDs!");
            return;
        }
        for (int i = 0; i < dvdList.length; i++) {
            itemsOrdered[qtyOrdered] = dvdList[i];
            qtyOrdered++;
        }
        System.out.println("The list of DVDs has been added.");
    } */

    //Thêm đúng 2 đĩa
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered + 2 > MAX_NUMBERS_ORDERED) {
            System.out.println("Cannot add two DVDs because the cart is full!");
            return;
        }

        itemsOrdered[qtyOrdered++] = dvd1;
        System.out.println("The disc \"" + dvd1.getTitle() + "\" has been added.");
        itemsOrdered[qtyOrdered++] = dvd2;
        System.out.println("The disc \"" + dvd2.getTitle() + "\" has been added.");
    }

    //Xóa đĩa
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        int idx;
        for (idx = 0; idx < qtyOrdered; idx++) {
            if (disc == itemsOrdered[idx]) {
                break;
            }
        }

        if (idx == qtyOrdered) {
            System.out.println("Cannot find disc \"" + disc.getTitle() + "\" in the current cart.");
            return;
        }

        for (int i = idx; i < qtyOrdered - 1; i++) {
            itemsOrdered[i] = itemsOrdered[i + 1];
        }
        qtyOrdered--;
        System.out.println("The disc \"" + disc.getTitle() + "\" has been removed.");
    }

    //Tính tổng
    public float totalCost() {
        float sum = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            sum += itemsOrdered[i].getCost();
        }
        return sum;
    }

    //Search by ID
    public void searchById(int id) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                System.out.println("Found: " + itemsOrdered[i].toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No match found for ID: " + id);
        }
    }

    // Search by Title
    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                System.out.println("Found: " + itemsOrdered[i].toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No match found for title: " + title);
        }
    }
    
    //Hiển thị giỏ hàng đúng format
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        System.out.printf("%-5s%-25s%10s\n", "No.", "Title", "Cost ($)");
        System.out.println("--------------------------------------------------");

        for (int i = 0; i < qtyOrdered; i++) {
            System.out.printf("%-5d%-25s%10.2f\n", i + 1, itemsOrdered[i].getTitle(), itemsOrdered[i].getCost());
        }

        System.out.println("--------------------------------------------------");
        System.out.printf("%-30s%10.2f\n", "Total cost:", totalCost());
        System.out.println("**************************************************\n");
    }
}
