package aims;

import aims.cart.*;
import aims.media.*;
import aims.store.*;
import java.util.Scanner;

public class Aims {
	static Store store = new Store();
    static Cart cart = new Cart();
	public static void main(String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(15, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(14, "Star Wars", "Science Fiction", 24.95f, 87, "George Lucas");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(23, "Inception", "Science Fiction", 18.99f, 148, "Christopher Nolan");
		Book book3 = new Book(12, "Harry Potter3", "Fantasy", 11.7f);
		Book book2 = new Book(34, "Harry Potter2", "Fantasy", 11.6f);
		Book book1 = new Book(44, "Harry Potter1", "Fantasy", 11.5f);
		
		Media[] newMedia = {dvd3, dvd2, dvd1, book3, book2, book1}; 

        for(Media m: newMedia){
            store.addMedia(m);
        }

		Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Exiting... Thank you for using AIMS.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        scanner.close();
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

	public static void viewStore(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            store.print();
            storeMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    mediaDetail();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    seeCurrentCart();
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
    
    public static void mediaDetail() {
        Scanner scanner = new Scanner(System.in);
        String title;
        int choice = -1;
        Media m;
        do {
            System.out.println("Enter title: ");
            title = scanner.nextLine();
            m = store.searchByTitle(title);
            if (m == null) System.out.println("Item is not found in store.");
        } while(m == null);

        do {
            mediaDetailsMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    cart.addMedia(m);
                    break;
                case 2:
                    m.play();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void playMedia() {
        Scanner scanner = new Scanner(System.in);
        String title;
        title = scanner.nextLine();
        Media m = store.searchByTitle(title);
        if(m != null) m.play();
    }
    
    public static void addMediaToCart(){
        Scanner scanner = new Scanner(System.in);
        String title;
        System.out.println("Enter title: ");
        title = scanner.nextLine();
        Media m = store.searchByTitle(title);
        cart.addMedia(m);
    }

    public static void updateStore() {
        Scanner scanner = new Scanner(System.in);
        String title;
        int choice;
        do {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add");
            System.out.println("2. Remove");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            System.out.println("Enter title: ");
            choice = scanner.nextInt();
            title = scanner.nextLine();
            Media m = store.searchByTitle(title);
            switch (choice) {
                case 1:
                    store.addMedia(m);
                    break;
                case 2:
                    store.removeMedia(m);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void seeCurrentCart(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            cart.print();
            cartMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    filterMedia();
                    break;
                case 2:
                    sortMedia();
                    break;
                case 3:
                    removeMedia();
                    break;
                case 4:
                    playMedia();
                    break;
                case 5:
                    System.out.println("order is created");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void filterMedia(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. By id");
            System.out.println("2. By title");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter id: ");
                    int id = scanner.nextInt();
                    cart.searchById(id);
                    break;
                case 2:
                    System.out.println("Enter title: ");
                    String title = scanner.nextLine();
                    cart.searchByTitle(title);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void sortMedia(){

    }

    public static void removeMedia(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter title: ");
        String title = scanner.nextLine();
        Media m = cart.searchByTitle(title);
        cart.removeMedia(m);
    }
}