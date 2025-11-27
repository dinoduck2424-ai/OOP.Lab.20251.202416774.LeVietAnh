package hust.soict.cs.dsai.aims.media;

public class TestPart1 {
    public static void main(String[] args) {
        Book b = new Book(1, "Lập trình Java", "Education", 29.99f);
        b.addAuthor("Nguyen Van A");
        b.addAuthor("Tran Thi B");
        b.addAuthor("Nguyen Van A"); // duplicate test
        System.out.println(b);

        b.removeAuthor("Tran Thi B");
        b.removeAuthor("No One"); // remove non-existing
        System.out.println(b);
    }
}
