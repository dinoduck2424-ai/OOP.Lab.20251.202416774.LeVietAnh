package hust.soict.cs.dsai.aims.screen;

import hust.soict.cs.dsai.aims.cart.Cart;
import hust.soict.cs.dsai.aims.media.Media;
import hust.soict.cs.dsai.aims.media.Playable;

import javax.swing.*;
import java.awt.*;

public class CartScreen extends JFrame {

    private static final long serialVersionUID = 1L;

    private Cart cart;
    private JPanel centerPanel;
    private JLabel totalCostLabel;

    public CartScreen(Cart cart) {
        this.cart = cart;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        
        JLabel title = new JLabel("AIMS Cart", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 26));
        cp.add(title, BorderLayout.NORTH);

     
        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        refreshCart();

        JScrollPane scrollPane = new JScrollPane(centerPanel);
        cp.add(scrollPane, BorderLayout.CENTER);

        
        totalCostLabel = new JLabel();
        updateTotalCost();
        totalCostLabel.setFont(new Font("Arial", Font.BOLD, 16));
        totalCostLabel.setHorizontalAlignment(JLabel.CENTER);

        cp.add(totalCostLabel, BorderLayout.SOUTH);

       
        setTitle("Cart");
        setSize(600, 500);
        setVisible(true);
    }

   
    private void refreshCart() {
        centerPanel.removeAll();

        for (Media m : cart.getItemsOrdered()) {
            JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT));

            JLabel title = new JLabel(m.getTitle());
            title.setPreferredSize(new Dimension(200, 25));

            JLabel cost = new JLabel(m.getCost() + " $");
            cost.setPreferredSize(new Dimension(80, 25));

            JButton removeBtn = new JButton("Remove");
            removeBtn.addActionListener(e -> {
                cart.removeMedia(m);
                refreshCart();
                updateTotalCost();
            });

            row.add(title);
            row.add(cost);

            if (m instanceof Playable) {
                JButton playBtn = new JButton("Play");
                playBtn.addActionListener(e -> ((Playable) m).play());
                row.add(playBtn);
            }

            row.add(removeBtn);
            centerPanel.add(row);
        }

        centerPanel.revalidate();
        centerPanel.repaint();
    }

    private void updateTotalCost() {
        totalCostLabel.setText("Total cost: " + cart.totalCost() + " $");
    }
}
