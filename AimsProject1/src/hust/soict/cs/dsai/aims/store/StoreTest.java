package hust.soict.cs.dsai.aims.store;

import hust.soict.cs.dsai.aims.media.*;

public class StoreTest {
    public static void main(String[] args) {

        Store store = new Store();

        System.out.println("===== TEST ADD MEDIA =====");

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Matrix", "Action", "Wachowski", 136, 10.0f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Inception", "Sci-Fi", "Nolan", 148, 12.0f);

        Book book = new Book(3, "Design Patterns", "Programming", 30.0f);
        book.addAuthor("Erich Gamma");

        CompactDisc cd = new CompactDisc(4, "Greatest Hits", "Pop", "Prod X", "Artist Y", 15.0f);
        cd.addTrack(new Track("Track A", 3));
        cd.addTrack(new Track("Track B", 4));

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book);
        store.addMedia(cd);
        store.addMedia(dvd1);   // duplicate test

        System.out.println("\n===== DISPLAY STORE =====");
        store.displayStore();

        System.out.println("\n===== TEST FIND BY TITLE =====");
        Media m1 = store.findByTitle("matrix");
        if (m1 != null) System.out.println("Found: " + m1.getTitle());

        Media m2 = store.findByTitle("hits");
        if (m2 != null) System.out.println("Found: " + m2.getTitle());

        Media m3 = store.findByTitle("unknown");
        if (m3 == null) System.out.println("Media not found.");

        System.out.println("\n===== TEST REMOVE MEDIA =====");
        store.removeMedia(cd);
        store.displayStore();
    }
}
