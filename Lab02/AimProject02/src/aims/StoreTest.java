package aims;

public class StoreTest {
    public static void main(String[] args) {
       
        Store myStore = new Store();

       
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
                "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
                "Science Fiction", "George Lucas", 87, 24.95f);

        
        myStore.addDVD(dvd1);
        myStore.addDVD(dvd2);

        System.out.println("\n--- SAU KHI THEM ---");
        myStore.printStore(); 

       
        myStore.removeDVD(dvd1);

        System.out.println("\n--- SAU KHI XOA ---");
        myStore.printStore(); 
    }
}