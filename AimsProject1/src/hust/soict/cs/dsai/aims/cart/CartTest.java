package hust.soict.cs.dsai.aims.cart;

import hust.soict.cs.dsai.aims.media.*;

public class CartTest {
    public static void main(String[] args) {

        Cart cart = new Cart();

        System.out.println("===== TEST ADD MEDIA =====");
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Sci-Fi", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladdin", "Animation", "Guy Ritchie", 90, 18.99f);

        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);
        cart.addMedia(dvd2);   // duplicate test

        System.out.println();
        cart.printCart();


        System.out.println("\n===== TEST SEARCH =====");
        Media found = cart.searchByTitle("star");
        if (found != null)
            System.out.println("Found media: " + found.getTitle());
        else
            System.out.println("Not found");

        found = cart.searchByTitle("king");
        if (found != null)
            System.out.println("Found media: " + found.getTitle());


        System.out.println("\n===== TEST REMOVE =====");
        cart.removeMedia(dvd2);
        cart.printCart();


        System.out.println("\n===== TEST SORTING =====");
        System.out.println("Sort by Title then Cost:");
        cart.sortByTitleCost();
        cart.printCart();

        System.out.println("\nSort by Cost then Title:");
        cart.sortByCostTitle();
        cart.printCart();


        System.out.println("\n===== TEST TOTAL COST =====");
        System.out.println("Total cost = " + cart.totalCost());
    }
}
