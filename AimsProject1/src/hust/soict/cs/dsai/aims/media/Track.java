package hust.soict.cs.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Track)) return false;
        Track other = (Track) o;
        if (this.length != other.length) return false;
        if (this.title == null) return other.title == null;
        return this.title.equals(other.title);
    }


    public String toString() {
        return String.format("Track[title=%s,length=%d]", title, length);
    }


    public void play() {
        if (this.length <= 0) {
            System.out.println("ERROR: Cannot play track \"" + this.title + "\" (length <= 0).");
            return;
        }
        System.out.println("Playing track: " + this.title);
        System.out.println("Track length: " + this.length);
    }
}
