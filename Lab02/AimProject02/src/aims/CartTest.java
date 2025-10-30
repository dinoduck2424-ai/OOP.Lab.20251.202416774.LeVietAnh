package aims; 

public class CartTest {

    public static void main(String[] args) {
        
        
        Cart cart = new Cart();

    
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
                "Animation", "Roger Allers", 87, 19.95f);
        
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
                "Science Fiction", "George Lucas", 87, 24.95f);
        
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
                "Animation", "John Musker", 90, 18.99f);

      
        System.out.println("--- BAT DAU KIEM TRA NAP CHONG ---");

        
        cart.addDigitalVideoDisc(dvd1, dvd2);
        
       
        cart.addDigitalVideoDisc(dvd3);
        
        System.out.println("--- KET THUC KIEM TRA NAP CHONG ---");
        
        
        System.out.println("\n--- KIEM TRA PRINT ---");
        cart.print();
        
       
        System.out.println("\n--- KIEM TRA SEARCH BY ID ---");
       
        System.out.println("Tim kiem ID 1:");
        cart.searchByID(1);
        
        System.out.println("\nTim kiem ID 10 (Không tồn tại):");
        cart.searchByID(10);
        
       
        System.out.println("\n--- KIEM TRA SEARCH BY TITLE ---");
        System.out.println("Tim kiem 'Lion':");
        
        cart.searchByTitle("Lion"); 
        
        System.out.println("\nTim kiem 'Matrix' (Khong ton tai):");
        cart.searchByTitle("Matrix");
    }
}