package aims.cart;
import aims.media.*;
import java.util.ArrayList;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        if(!itemsOrdered.contains(media)){
            itemsOrdered.add(media);
            System.out.println(media.getTitle() + " has been added.");
        }
        else {
            System.out.println("The item is already in the cart.");
        }
    }

    public void removeMedia(Media media) {
        if(itemsOrdered.remove(media)){
            System.out.println(media.getTitle() + " has been removed.");
        } else {
            System.out.println(media.getTitle() + " was not found in the cart.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void print(){
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        int i = 1;
        for (Media media : itemsOrdered) {
            System.out.println((i++) + ". " + media.toString());
        }
        System.out.println("Total cost is: "+totalCost());
        System.out.println("**************************************************");
    }

    public Media searchByTitle(String title){
        for (Media media : itemsOrdered) {
            if(media.isMatch(title)){
                System.out.println(media.toString());
                return media;
            }
        }
        System.out.println("the media was not found in the cart.");
        return null;
    }

    public Media searchById(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println(media.toString());
                return media;
            }
        }
        System.out.println("the media was not found in the cart.");
        return null;
    }
}
