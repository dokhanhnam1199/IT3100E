package aims.store;
import aims.media.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        // Create a new store
        Store myStore = new Store();

        // Create some DVDs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(15, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");

        DigitalVideoDisc dvd2 = new DigitalVideoDisc(14, "Star Wars", "Science Fiction", 24.95f, 87, "George Lucas");
        
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(23, "Inception", "Science Fiction", 18.99f, 148, "Christopher Nolan");
    
        // Add DVDs to the store
        myStore.addMedia(dvd1);
        myStore.addMedia(dvd2);
        myStore.addMedia(dvd3);

        // Remove a DVD from the store
        myStore.removeMedia(dvd2);

    }
}
