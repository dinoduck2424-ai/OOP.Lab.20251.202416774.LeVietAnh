package hust.soict.cs.dsai.aims.media;

import java.util.ArrayList;

public class Book extends Media {

    private ArrayList<String> authors = new ArrayList<>();

    // Constructor
    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    // Add author
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        } else {
            System.out.println("Author already exists!");
        }
    }

    // Remove author
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        } else {
            System.out.println("Author not found!");
        }
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    // Polymorphic display
    @Override
    public String toString() {
        return "BOOK - " + title + " - " + category + " - " + authors + ": " + cost + " $";
    }
}
