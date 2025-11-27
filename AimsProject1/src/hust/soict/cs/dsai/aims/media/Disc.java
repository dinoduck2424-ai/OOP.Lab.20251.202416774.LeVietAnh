package hust.soict.cs.dsai.aims.media;

public class Disc extends Media {

    protected String director;
    protected int length;

    // Constructor
    public Disc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

    // Getters
    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    // toString for polymorphism
    @Override
    public String toString() {
        return title + " - " + category + " - " + director + " - " + length + ": " + cost + " $";
    }
}
