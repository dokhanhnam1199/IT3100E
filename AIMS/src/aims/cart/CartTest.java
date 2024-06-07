package aims.cart;
import aims.media.DigitalVideoDisc;

import javax.naming.LimitExceededException;

public class CartTest {
    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();

        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(15, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        try {
            cart.addMedia(dvd1);
        } catch (LimitExceededException e) {
            throw new RuntimeException(e);
        }

        DigitalVideoDisc dvd2 = new DigitalVideoDisc(14, "Star Wars", "Science Fiction", 24.95f, 87, "George Lucas");
        try {
            cart.addMedia(dvd2);
        } catch (LimitExceededException e) {
            throw new RuntimeException(e);
        }

        DigitalVideoDisc dvd3 = new DigitalVideoDisc(23,"Inception", "Science Fiction", 18.99f, 148, "Christopher Nolan");
        try {
            cart.addMedia(dvd3);
        } catch (LimitExceededException e) {
            throw new RuntimeException(e);
        }

        // Test the print method
        cart.print();
        // Test search by title method
        cart.searchByTitle("The Lion King");
        cart.searchByTitle("2 girls 1 cup");
        cart.searchByID(1);
    }
}
