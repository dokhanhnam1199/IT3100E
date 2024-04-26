package aims.store;
import aims.media.*;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println(media.getTitle() + " has been added.");
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println(media.getTitle() + " has been removed.");
            return;
        } else {
            System.out.println(media.getTitle() + " was not found in the cart.");
        }
    }

    public void print() {
        System.out.println("***********************STORE***********************");
        System.out.println("Ordered Items:");
        int i = 1;
        for (Media media : itemsInStore) {
            System.out.println((i++) + ". " + media.toString());
        }
        System.out.println("**************************************************");
    }

    public Media searchByTitle(String title){
        for(Media m : itemsInStore){
            if(m.getTitle() == title) return m; 
        }
        return null;
    }
}
