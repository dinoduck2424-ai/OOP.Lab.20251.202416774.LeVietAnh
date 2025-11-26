package hust.soict.cs.aims.disc;

public class DigitalVideoDisc {

    // Các thuộc tính (fields)
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    
    // Thành viên của lớp (static) - dùng để đếm
    private static int nbDigitalVideoDiscs = 0;

    // Thành viên của đối tượng (instance) - ID riêng
    private int id;

    // Các hàm tạo
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

    // Các phương thức Getter
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
    
    // Các phương thức Setter
    public void setTitle(String title) {
        this.title = title;
    }

    // Kiểm tra xem tiêu đề có khớp với từ khóa không
    public boolean isMatch(String title) {
        return this.title.equalsIgnoreCase(title);
    }

    // Ghi đè phương thức toString()
    public String toString() {
        return "DVD - " + this.title + " - " + this.category + " - " + this.director
            + " - " + this.length + ": " + this.cost + " $";
    }

    // Các phương thức khác
    public void play() {
        if (length <= 0) {
            System.out.println("DVD này không thể phát được!");
        } else {
            System.out.println("Đang phát DVD: " + title);
            System.out.println("Độ dài DVD: " + length);
        }
    }

    public void displayDiscInfo() {
        System.out.println("----- Thông tin DVD -----");
        System.out.println("ID: " + id);
        System.out.println("Tiêu đề: " + title);
        System.out.println("Thể loại: " + category);
        System.out.println("Đạo diễn: " + director);
        System.out.println("Độ dài: " + length);
        System.out.println("Giá: " + cost);
        System.out.println("--------------------");
    }
}