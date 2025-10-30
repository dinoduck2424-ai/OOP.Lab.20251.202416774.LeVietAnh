package aims;

public class DigitalVideoDisc {

    private static int nbDigitalVideoDiscs = 0;

    private int id;
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;


    private void autoAssignId() {
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

  
    public DigitalVideoDisc(String title) {
        this.title = title;
        autoAssignId();
    }

  
    public DigitalVideoDisc(String category, String title, float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
        autoAssignId();
    }

   
    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
        autoAssignId();
    }

  
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        autoAssignId();
    }

  
    public void setTitle(String title) { this.title = title; }
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getDirector() { return director; }
    public int getLength() { return length; }
    public float getCost() { return cost; }

   
    @Override
    public String toString() {
    
        return "DVD - " + this.id + " - [" + this.title + "] - [" + this.category + "] - ["
                + this.director + "] - " + this.length + ": " + this.cost + " $";
    }

    public boolean isMatch(String title) {
        if (title == null || this.title == null) return false;
        return this.title.toLowerCase().contains(title.toLowerCase());
    }
}
