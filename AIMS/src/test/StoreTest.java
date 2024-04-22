package test;

import aims.Store;
import aims.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        // Create a new store
        Store myStore = new Store();

        // Create some DVDs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        // Add DVDs to the store
        myStore.addDVD(dvd1);
        myStore.addDVD(dvd2);
        myStore.addDVD(dvd3);

        // Remove a DVD from the store
        myStore.removeDVD(dvd2);

    }
}
