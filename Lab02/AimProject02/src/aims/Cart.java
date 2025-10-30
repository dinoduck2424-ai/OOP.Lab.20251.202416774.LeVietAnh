package aims; 

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered;
    private int qtyOrdered;

    public Cart() {
        itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
        qtyOrdered = 0;
    }

   
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full. Cannot add disc: " + disc.getTitle());
            return;
        }
        itemsOrdered[qtyOrdered++] = disc;
        System.out.println("The disc has been added: " + disc.getTitle());
    }

   
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        if (dvdList == null) {
            System.out.println("Danh sách DVD bị rỗng.");
            return;
        }
        for (DigitalVideoDisc disc : dvdList) {
            this.addDigitalVideoDisc(disc); 
        }
    }

    
    public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
        if (dvdList == null) {
            System.out.println("Danh sách DVD bị rỗng.");
            return;
        }
        for (DigitalVideoDisc disc : dvdList) {
            this.addDigitalVideoDisc(disc);
        }
    }

    
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        this.addDigitalVideoDisc(dvd1);
        this.addDigitalVideoDisc(dvd2);
    }
    
 

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        int idx = -1;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == disc.getId()) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            System.out.println("Disc not found in cart: " + disc.getTitle());
            return;
        }
        // shift left
        for (int i = idx; i < qtyOrdered - 1; i++) {
            itemsOrdered[i] = itemsOrdered[i + 1];
        }
        itemsOrdered[--qtyOrdered] = null;
        System.out.println("Removed disc: " + disc.getTitle());
    }

    public float totalCost() {
        float sum = 0f;
        for (int i = 0; i < qtyOrdered; i++) {
            sum += itemsOrdered[i].getCost();
        }
        return sum;
    }

    public float totalCostWithLuckyFree() {
        if (qtyOrdered == 0) return 0f;
        Random r = new Random();
        int luckyIndex = r.nextInt(qtyOrdered);
        float sum = 0f;
        for (int i = 0; i < qtyOrdered; i++) {
            if (i == luckyIndex) continue;
            sum += itemsOrdered[i].getCost();
        }
        System.out.println("Lucky free item: " + itemsOrdered[luckyIndex].getTitle() + " (cost " + itemsOrdered[luckyIndex].getCost() + ")");
        return sum;
    }

   
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items (" + qtyOrdered + " items):");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i+1) + ". " + itemsOrdered[i].toString());
        }
        System.out.printf("Total cost: %.2f\n", totalCost());
        System.out.println("**************************************************");
    }

    
    public DigitalVideoDisc searchByID(int id) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                System.out.println("Found: " + itemsOrdered[i]);
                return itemsOrdered[i];
            }
        }
        System.out.println("Not found ID: " + id);
        return null;
    }

   
    public DigitalVideoDisc searchByTitle(String title) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found: " + itemsOrdered[i]);
                return itemsOrdered[i];
            }
        }
        System.out.println("Not found Title: " + title);
        return null;
    }

 

    public void sortByTitle() {
        DigitalVideoDisc[] copy = Arrays.copyOf(itemsOrdered, qtyOrdered);
        Arrays.sort(copy, new Comparator<DigitalVideoDisc>() {
            @Override
            public int compare(DigitalVideoDisc d1, DigitalVideoDisc d2) {
                int cmp = d1.getTitle().compareToIgnoreCase(d2.getTitle());
                if (cmp != 0) return cmp;
                return Float.compare(d2.getCost(), d1.getCost());
            }
        });
        System.out.println("Cart sorted by title:");
        for (DigitalVideoDisc d : copy) System.out.println(d);
    }

    public void sortByCost() {
        DigitalVideoDisc[] copy = Arrays.copyOf(itemsOrdered, qtyOrdered);
        Arrays.sort(copy, new Comparator<DigitalVideoDisc>() {
            @Override
            public int compare(DigitalVideoDisc d1, DigitalVideoDisc d2) {
                int cmp = Float.compare(d2.getCost(), d1.getCost()); 
                if (cmp != 0) return cmp;
                return d1.getTitle().compareToIgnoreCase(d2.getTitle());
            }
        });
        System.out.println("Cart sorted by cost:");
        for (DigitalVideoDisc d : copy) System.out.println(d);
    }

    public void updateQuantity(DigitalVideoDisc disc, int newQuantity) {
        
    }
}