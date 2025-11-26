package hust.soict.cs.aims;

import hust.soict.cs.aims.cart.Cart;
import hust.soict.cs.aims.disc.DigitalVideoDisc;

public class Aims {

    public static void main(String[] args) {

        //Create a new Cart
        Cart anOrder = new Cart();

        //Create new DVD objects
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                "The Lion King", "Animation", "Roger Allers", 87, 19.95f);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
                "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc(
                "Aladdin", "Animation", "George Lucas", 18.99f);

        //Add DVDs to the cart
        System.out.println("Adding DVDs to the cart...\n");
        anOrder.addDigitalVideoDisc(dvd1, dvd2);
        anOrder.addDigitalVideoDisc(dvd3);

        //Display total cost
        System.out.printf("\nTotal Cost is: %.2f\n\n", anOrder.totalCost());

        //Display current cart
        anOrder.print();

        //Remove DVD that does not exist
        System.out.println("Trying to remove a DVD that does not exist:");
        DigitalVideoDisc notFound = new DigitalVideoDisc("Mr. Bean", "Comedy", 20.55f);
        anOrder.removeDigitalVideoDisc(notFound);

        //Remove an existing DVD
        System.out.println("\nRemoving an existing DVD (Star Wars):");
        anOrder.removeDigitalVideoDisc(dvd2);

        //Display updated cart
        System.out.println();
        anOrder.print();
    }
}
