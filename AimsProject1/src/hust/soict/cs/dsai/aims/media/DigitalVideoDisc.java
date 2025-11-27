package hust.soict.cs.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {

    // Constructor
    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, director, length, cost);
    }

    // Implement Playable
    @Override
    public void play() {
        if (getLength() <= 0) {
            System.out.println("This DVD cannot be played!");
            return;
        }
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength());
    }

    // toString override
    @Override
    public String toString() {
        return "DVD - " + title + " - " + category + " - " + director
                + " - " + length + ": " + cost + " $";
    }
}
