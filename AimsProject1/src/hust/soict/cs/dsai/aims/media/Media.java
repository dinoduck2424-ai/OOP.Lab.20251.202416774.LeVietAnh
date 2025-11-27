package hust.soict.cs.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {

    protected int id;
    protected String title;
    protected String category;
    protected float cost;


    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Media))
            return false;

        Media other = (Media) obj;

        if (this.title == null || other.title == null)
            return false;

        return this.title.equalsIgnoreCase(other.title);
    }


    @Override
    public String toString() {
        return title + " - " + category + ": " + cost + " $";
    }


    public static final Comparator<Media> COMPARE_BY_TITLE_COST =
        Comparator.comparing(Media::getTitle, String.CASE_INSENSITIVE_ORDER)
                  .thenComparing(Comparator.comparing(Media::getCost).reversed());

    // Sort by cost desc → title asc
    public static final Comparator<Media> COMPARE_BY_COST_TITLE =
        Comparator.comparing(Media::getCost).reversed()
                  .thenComparing(Media::getTitle, String.CASE_INSENSITIVE_ORDER);
}
