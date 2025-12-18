package hust.soict.cs.dsai.aims.screen;

import hust.soict.cs.dsai.aims.media.Media;
import hust.soict.cs.dsai.aims.media.Playable;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class MediaStore extends JPanel {

    private Media media;

    public MediaStore(Media media, Consumer<Media> addToCartHandler) {
        this.media = media;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setPreferredSize(new Dimension(180, 160));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font("Arial", Font.BOLD, 14));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel cost = new JLabel(media.getCost() + " $");
        cost.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton addBtn = new JButton("Add to cart");
        addBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        addBtn.addActionListener(e -> addToCartHandler.accept(media));

        this.add(Box.createVerticalStrut(10));
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalStrut(10));
        this.add(addBtn);

        if (media instanceof Playable) {
            JButton playBtn = new JButton("Play");
            playBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
            playBtn.addActionListener(e -> ((Playable) media).play());

            this.add(Box.createVerticalStrut(5));
            this.add(playBtn);
        }
    }
}
