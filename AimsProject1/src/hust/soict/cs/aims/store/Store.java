package hust.soict.cs.aims.store;

import hust.soict.cs.aims.disc.DigitalVideoDisc;

public class Store {
    public static final int MAX_NUMBERS_IN_STORE = 100;  //Max number of DVD
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBERS_IN_STORE];
    private int curInStore = 0;  //Number of current DVD

    //Add DVD to Store
    public void addDVD(DigitalVideoDisc disc) {
        if (curInStore < MAX_NUMBERS_IN_STORE) {
            itemsInStore[curInStore] = disc;
            curInStore++;
            System.out.println("The disc \"" + disc.getTitle() + "\" has been added to the store.");
        } else {
            System.out.println("The store is full. Cannot add more DVDs.");
        }
    }

    //Remove DVD to Store
    public void removeDVD(DigitalVideoDisc disc) {
        int idx;
        for (idx = 0; idx < curInStore; idx++) {
            if (disc == itemsInStore[idx]) {
                break;
            }
        }

        if (idx == curInStore) {
            System.out.println("The disc \"" + disc.getTitle() + "\" was not found in the store.");
            return;
        }

        for (int i = idx; i < curInStore - 1; i++) {
            itemsInStore[i] = itemsInStore[i + 1];
        }
        curInStore--;
        System.out.println("The disc \"" + disc.getTitle() + "\" has been removed from the store.");
    }

    //Show all DVD in Store
    public void print() {
        System.out.println("***********************STORE***********************");
        for (int i = 0; i < curInStore; i++) {
            System.out.println((i + 1) + ". " + itemsInStore[i].toString());
        }
        System.out.println("***************************************************");
    }
}
