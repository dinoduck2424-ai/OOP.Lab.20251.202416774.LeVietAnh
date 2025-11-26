package hust.soict.cs.aims.disc;

public class TestPassingParameter {

    public static void main(String[] args) {
    	
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    /* This code belongs to assignment and it isn't executed correctly 
    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    } */

    //This is my code after fixing method swap
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