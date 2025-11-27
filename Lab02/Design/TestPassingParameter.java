package hust.soict.cs.aims.disc;

public class TestPassingParameter {

    public static void main(String[] args) {
    	
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("Tiêu đề jungle dvd: " + jungleDVD.getTitle());
        System.out.println("Tiêu đề cinderella dvd: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("Tiêu đề jungle dvd sau khi đổi: " + jungleDVD.getTitle());
    }

    /* // Đoạn code gốc của bài lab, chạy không đúng như mong đợi (swap thất bại) 
    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    } 
    */

    // Đây là phương thức swap đã được sửa (hoán đổi nội dung)
    public static void swap(DigitalVideoDisc d1, DigitalVideoDisc d2) {
        String tmpTitle = d1.getTitle();
        d1.setTitle(d2.getTitle());
        d2.setTitle(tmpTitle);
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle); 
    }
}