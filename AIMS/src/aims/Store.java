package aims;

public class Store {
    private DigitalVideoDisc[] itemsInStore;

    public Store() {
        itemsInStore = new DigitalVideoDisc[1000];
    }

    public void addDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < itemsInStore.length; i++) {
            if (itemsInStore[i] == null) {
                itemsInStore[i] = dvd;
                System.out.println(dvd.getTitle() + " has been added to the store.");
                return;
            }
        }
        System.out.println("The store is full. Cannot add.");
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < itemsInStore.length; i++) {
            if (itemsInStore[i] != null && itemsInStore[i].equals(dvd)) {
                itemsInStore[i] = null;
                System.out.println(dvd.getTitle() + " has been removed from the store.");
                return;
            }
        }
        System.out.println("The DVD was not found in the store.");
    }
}
