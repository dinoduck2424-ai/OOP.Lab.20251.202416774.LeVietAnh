package hust.soict.cs.aims.disc;

public class DigitalVideoDisc {

    //Attributes
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    
    //Classifier member
    private static int nbDigitalVideoDiscs = 0;

    //Instance member
    private int id;

    //Constructors
    public DigitalVideoDisc(String title) {
        this.title = title;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }
    //Setters
    public void setTitle(String title) {
    this.title = title;
    }

    //Find out if the corresponding disk is a match given the title
    public boolean isMatch(String title) {
        return this.title.equalsIgnoreCase(title);
    }

    //Override
    public String toString() {
        return "DVD - " + this.title + " - " + this.category + " - " + this.director
            + " - " + this.length + ": " + this.cost + " $";
    }

    //Methods
    public void play() {
        if (length <= 0) {
            System.out.println("This DVD cannot be played!");
        } else {
            System.out.println("Playing DVD: " + title);
            System.out.println("DVD length: " + length);
        }
    }

    public void displayDiscInfo() {
        System.out.println("----- DVD Info -----");
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Category: " + category);
        System.out.println("Director: " + director);
        System.out.println("Length: " + length);
        System.out.println("Cost: " + cost);
        System.out.println("--------------------");
    }
}
