package aims;

public class Aims {
	 public static void main(String[] args) {
	        Cart cart = new Cart();

	        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Matrix", "Action", "Wachowski", 136, 10.0f);
	        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Interstellar", "Sci-Fi", "Nolan", 169, 12.5f);
	        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "The Matrix", "Action", "Wachowski", 136, 11.0f); // duplicate title higher cost
	        DigitalVideoDisc dvd4 = new DigitalVideoDisc(4, "Short Film", "Drama", "Someone", 0, 2.0f);

	        cart.addDigitalVideoDisc(dvd1);
	        cart.addDigitalVideoDisc(dvd2);
	        cart.addDigitalVideoDisc(dvd3);
	        cart.addDigitalVideoDisc(dvd4);

	        cart.printCart();

	        System.out.println("\n--- Play some DVDs ---");
	        dvd1.play();
	        dvd4.play(); 

	        System.out.println("\n--- Sort by title ---");
	        cart.sortByTitle();

	        System.out.println("\n--- Sort by cost ---");
	        cart.sortByCost();

	        System.out.println("\n--- Search in cart ---");
	        DigitalVideoDisc found = cart.searchById(2);
	        if (found != null) System.out.println("Found by id: " + found);
	        else System.out.println("Not found by id.");

	        System.out.println("\n--- Make a lucky free item and compute total ---");
	        float totalAfterLucky = cart.totalCostWithLuckyFree();
	        System.out.printf("Total after lucky free: %.2f\n", totalAfterLucky);

	        System.out.println("\n--- Update quantity (make two copies of Interstellar) ---");
	        cart.updateQuantity(dvd2, 2);
	        cart.printCart();

	        System.out.println("\n--- Remove an item ---");
	        cart.removeDigitalVideoDisc(dvd3);
	        cart.printCart();
	    }

}
