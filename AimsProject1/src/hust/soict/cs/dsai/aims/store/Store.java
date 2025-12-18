package hust.soict.cs.dsai.aims.store;

import hust.soict.cs.dsai.aims.media.Media;
import java.util.ArrayList;

public class Store {

    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) {
            System.out.println("Item already exists in store!");
            return;
        }
        itemsInStore.add(media);
        System.out.println("Added to store: " + media.getTitle());
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("Removed from store: " + media.getTitle());
        } else {
            System.out.println("Item not found.");
        }
    }

    public Media findByTitle(String title) {
        for (Media m : itemsInStore) {
            if (m.getTitle().equalsIgnoreCase(title)) return m;
        }
        return null;
    }

    public void displayStore() {
        System.out.println("===== STORE =====");
        if (itemsInStore.isEmpty()) {
            System.out.println("Store is empty.");
        }
        for (Media m : itemsInStore) {
            System.out.println(m.toString());
        }
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}
