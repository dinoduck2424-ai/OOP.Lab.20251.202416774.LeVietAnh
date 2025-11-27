package hust.soict.cs.aims;

import hust.soict.cs.aims.cart.Cart;
import hust.soict.cs.aims.store.Store;
import hust.soict.cs.dsai.aims.media.*;

import java.util.Scanner;

public class Aims {

    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        seedStore();   // dữ liệu mẫu để test nhanh
        showMainMenu();
    }

    // ================= MẪU DỮ LIỆU =================
    private static void seedStore() {
        store.addMedia(new DigitalVideoDisc(1, "The Matrix", "Action", "Wachowski", 136, 10.0f));
        store.addMedia(new DigitalVideoDisc(2, "Inception", "Sci-Fi", "Nolan", 148, 12.0f));

        Book b = new Book(3, "Clean Code", "Programming", 28.5f);
        b.addAuthor("Robert C. Martin");
        store.addMedia(b);

        CompactDisc cd = new CompactDisc(4, "Greatest Hits", "Pop", "Producer X", "Artist Y", 15.0f);
        cd.addTrack(new Track("Song A", 3));
        cd.addTrack(new Track("Song B", 4));
        store.addMedia(cd);
    }

    // ================= MENU CHÍNH =================
    public static void showMainMenu() {
        while (true) {
            System.out.println("\n===== AIMS MAIN MENU =====");
            System.out.println("1. View store");
            System.out.println("2. View cart");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int choice = readInt();

            if (choice == 0) {
                System.out.println("Exiting AIMS.");
                return;
            }
            if (choice == 1) viewStore();
            if (choice == 2) viewCart();
        }
    }

    // ================= STORE MENU =================
    private static void viewStore() {
        while (true) {
            System.out.println("\n===== STORE =====");
            store.displayStore();

            System.out.println("\n1. See media details");
            System.out.println("2. Add media to cart");
            System.out.println("3. Play a media");
            System.out.println("0. Back");
            System.out.print("Choose: ");

            int c = readInt();
            if (c == 0) return;

            sc.nextLine(); // clear newline
            System.out.print("Enter title: ");
            String title = sc.nextLine().trim();
            Media m = store.findByTitle(title);

            if (m == null) {
                System.out.println("Media not found.");
                continue;
            }

            if (c == 1) showMediaDetails(m);
            if (c == 2) cart.addMedia(m);
            if (c == 3) {
                if (m instanceof Playable)
                    ((Playable) m).play();
                else
                    System.out.println("This media cannot be played.");
            }
        }
    }

    private static void showMediaDetails(Media m) {
        System.out.println("\n----- DETAILS -----");
        System.out.println(m.toString());

        if (m instanceof CompactDisc) {
            System.out.println("Tracks:");
            for (Track t : ((CompactDisc) m).getTracks()) {
                System.out.println(" - " + t.getTitle() + " (" + t.getLength() + ")");
            }
        }
    }

    // ================= CART MENU =================
    private static void viewCart() {
        while (true) {
            System.out.println("\n===== CART =====");
            cart.printCart();

            System.out.println("\n1. Remove media");
            System.out.println("2. Play media");
            System.out.println("3. Sort by title then cost");
            System.out.println("4. Sort by cost then title");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.print("Choose: ");

            int c = readInt();
            if (c == 0) return;

            if (c == 5) {
                System.out.println("Order placed!");
                cart.clear();
                return;
            }

            sc.nextLine(); // clear buffer
            System.out.print("Enter title: ");
            String title = sc.nextLine().trim();

            Media m = cart.searchByTitle(title);
            if (m == null) {
                System.out.println("Media not found in cart.");
                continue;
            }

            if (c == 1) cart.removeMedia(m);
            if (c == 2) {
                if (m instanceof Playable)
                    ((Playable) m).play();
                else
                    System.out.println("This media cannot be played.");
            }
            if (c == 3) cart.sortByTitleCost();
            if (c == 4) cart.sortByCostTitle();
        }
    }

    // ================= SAFE INPUT =================
    private static int readInt() {
        while (!sc.hasNextInt()) {
            System.out.print("Invalid! Enter again: ");
            sc.next();
        }
        return sc.nextInt();
    }
}
