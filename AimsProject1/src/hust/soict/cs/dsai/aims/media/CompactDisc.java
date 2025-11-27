package hust.soict.cs.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {

    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    // Constructor: note order matches Disc(int id, String title, String category, String director, int length, float cost)
    public CompactDisc(int id, String title, String category, String director, String artist, float cost) {
        super(id, title, category, director, 0, cost); // length = 0 (will be computed from tracks)
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (track == null) return;
        if (!tracks.contains(track)) {
            tracks.add(track);
        } else {
            System.out.println("Track already exists: " + track.getTitle());
        }
    }

    public void removeTrack(Track track) {
        if (track == null) return;
        if (tracks.remove(track)) {
            // removed
        } else {
            System.out.println("Track not found: " + (track.getTitle() == null ? "" : track.getTitle()));
        }
    }

    // length of CD is sum of track lengths
    @Override
    public int getLength() {
        int total = 0;
        for (Track t : tracks) {
            total += t.getLength();
        }
        return total;
    }

    // expose tracks so Aims can list them
    public ArrayList<Track> getTracks() {
        return this.tracks;
    }

    @Override
    public void play() {
        int totalLen = getLength();
        if (totalLen <= 0) {
            System.out.println("CD cannot be played!");
            return;
        }
        System.out.println("Playing CD: " + getTitle());
        System.out.println("Artist: " + artist);
        System.out.println("Total length: " + totalLen);

        for (Track t : tracks) {
            t.play();
        }
    }

    @Override
    public String toString() {
        return "CD - " + getTitle() + " - " + getCategory() + " - " + getDirector()
                + " - Artist: " + artist + " - " + getLength() + ": " + getCost() + " $";
    }
}
