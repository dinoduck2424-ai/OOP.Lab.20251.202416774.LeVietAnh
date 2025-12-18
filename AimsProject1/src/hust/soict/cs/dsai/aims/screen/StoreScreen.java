package hust.soict.cs.dsai.aims.screen;

import hust.soict.cs.dsai.aims.cart.Cart;
import hust.soict.cs.dsai.aims.media.*;
import hust.soict.cs.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class StoreScreen extends JFrame {

    private static final long serialVersionUID = 1L;

    private Store store;
    private Cart cart;

    public StoreScreen(Store store) {
        this.store = store;
        this.cart = new Cart();

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        /* ===== MENU BAR ===== */
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        JMenuItem viewCart = new JMenuItem("View Cart");
        viewCart.addActionListener(e -> new CartScreen(cart));
        menu.add(viewCart);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        /* ===== HEADER ===== */
        JLabel title = new JLabel("AIMS Store", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 26));
        cp.add(title, BorderLayout.NORTH);

        /* ===== CENTER: MEDIA GRID ===== */
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 3, 15, 15));

        for (Media m : store.getItemsInStore()) {
            MediaStore mediaPanel = new MediaStore(
                    m,
                    media -> {
                        cart.addMedia(media);
                        System.out.println(">> Cart size = "
                                + cart.getItemsOrdered().size());
                    }
            );
            centerPanel.add(mediaPanel);
        }

        JScrollPane scrollPane = new JScrollPane(centerPanel);
        cp.add(scrollPane, BorderLayout.CENTER);

        /* ===== FRAME CONFIG ===== */
        setTitle("AIMS Store");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /* ===== MAIN – TEST ===== */
    public static void main(String[] args) {

        Store store = new Store();

        store.addMedia(new Book(
                1, "Clean Code", "Programming", 29.99f));

        store.addMedia(new DigitalVideoDisc(
                2, "Inception", "Sci-Fi", "Nolan", 148, 19.99f));

        CompactDisc cd = new CompactDisc(
                3, "Greatest Hits", "Pop", "Producer X", "Artist Y", 15.99f);
        cd.addTrack(new Track("Song A", 3));
        cd.addTrack(new Track("Song B", 4));

        store.addMedia(cd);

        new StoreScreen(store);
    }
}
