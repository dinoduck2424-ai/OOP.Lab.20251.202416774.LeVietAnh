package aims;

public class DigitalVideoDisc {
	 private int id;
	    private String title;
	    private String category;
	    private String director;
	    private int length; // in minutes
	    private float cost;

	   
	    public DigitalVideoDisc() { }

	   
	    public DigitalVideoDisc(String title) {
	        this.title = title;
	    }

	  
	    public DigitalVideoDisc(String category, String title, float cost) {
	        this.category = category;
	        this.title = title;
	        this.cost = cost;
	    }

	   
	    public DigitalVideoDisc(String director, String category, String title, float cost) {
	        this.director = director;
	        this.category = category;
	        this.title = title;
	        this.cost = cost;
	    }

	   
	    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
	        this.id = id;
	        this.title = title;
	        this.category = category;
	        this.director = director;
	        this.length = length;
	        this.cost = cost;
	    }

	    
	    public int getId() { return id; }
	    public String getTitle() { return title; }
	    public String getCategory() { return category; }
	    public String getDirector() { return director; }
	    public int getLength() { return length; }
	    public float getCost() { return cost; }

	   
	    public void play() {
	        if (length <= 0) {
	            System.out.println("Cannot play DVD '" + title + "': length is 0 or less.");
	        } else {
	            System.out.println("Playing demo of '" + title + "' (" + length + " mins)...");
	            // simulate playing
	        }
	    }

	    @Override
	    public String toString() {
	        return String.format("DVD[id=%d, title='%s', category='%s', director='%s', length=%d, cost=%.2f]",
	                id, title, category, director, length, cost);
	    }

}
