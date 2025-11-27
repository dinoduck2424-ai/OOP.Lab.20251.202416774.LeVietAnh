package hust.soict.cs.aims.cart;

import hust.soict.cs.dsai.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Cart implementation for Lab04
 */
public class Cart {

    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media media) {
        if (media == null) {
            System.out.println("Cannot add null item to cart.");
            return;
        }
        if (itemsOrdered.contains(media)) {
            System.out.println("Item already exists in cart!");
            return;
        }
        itemsOrdered.add(media);
        System.out.println("Added: " + media.getTitle());
    }

    public void removeMedia(Media media) {
        if (media == null) {
            System.out.println("Cannot remove null item.");
            return;
        }
        if (itemsOrdered.remove(media)) {
            System.out.println("Removed: " + media.getTitle());
        } else {
            System.out.println("Item not found in cart.");
        }
    }

    /**
     * Search by title substring, case-insensitive.
     * Returns first match or null.
     */
    public Media searchByTitle(String title) {
        if (title == null) return null;
        String q = title.toLowerCase();
        for (Media m : itemsOrdered) {
            String t = m.getTitle();
            if (t != null && t.toLowerCase().contains(q)) return m;
        }
        return null;
    }

    public float totalCost() {
        float total = 0.0f;
        for (Media m : itemsOrdered) total += m.getCost();
        return total;
    }

    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Sorted cart by Title then Cost.");
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Sorted cart by Cost then Title.");
    }

    public void printCart() {
        System.out.println("===== CART =====");
        if (itemsOrdered.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            for (Media m : itemsOrdered) {
                System.out.println(m.toString());
            }
        }
        System.out.printf("Total cost: %.2f\n", totalCost());
    }

    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void clear() {
        itemsOrdered.clear();
    }
}
