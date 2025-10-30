
package aims; 

public class TestPassingParameter {

    public static void main(String[] args) {
      
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

       
        System.out.println("--- TRUOC KHI SWAP ---");
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
        
        swap(jungleDVD, cinderellaDVD); 
        
        System.out.println("\n--- SAU KHI SWAP ---");
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        System.out.println("\n--------------------------------\n");

      
        System.out.println("--- TRUOC KHI CHANGE TITLE ---");
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle()); 

        System.out.println("\n--- SAU KHI CHANGE TITLE ---");
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

   
    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title); 
        dvd = new DigitalVideoDisc(oldTitle); 
    }
}