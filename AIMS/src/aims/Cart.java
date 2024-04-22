package aims;
public class Cart {
    private DigitalVideoDisc[] discs;
    private int qtyOrdered;
    private static final int MAX_CAPACITY = 20;

    public Cart() {
        discs = new DigitalVideoDisc[MAX_CAPACITY];
        qtyOrdered = 0;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_CAPACITY) {
            discs[qtyOrdered++] = disc;
            System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
        } else {
            System.out.println("The cart is almost full.");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (discs[i].equals(disc)) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    discs[j] = discs[j + 1];
                }
                discs[--qtyOrdered] = null;
                System.out.println("The disc \"" + disc.getTitle() + "\" has been removed.");
                return;
            }
        }
        System.out.println("The disc \"" + disc.getTitle() + "\" was not found in the cart.");
    }

    public float totalCost() {
        float total = 0.00F;
        for (int i = 0; i < qtyOrdered; i++) {
            total += discs[i].getCost();
        }
        return total;
    }

    public void print(){
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println(i+1+". DVD - "+discs[i].getTitle()+" - "+discs[i].getCategory()+" - "+discs[i].getDirector()+" - "+discs[i].getLength()+": "+discs[i].getCost());
        }
        System.out.println("Total cost is: "+totalCost());
    }

    public void searchByTitle(java.lang.String title){
        for (int i = 0; i < qtyOrdered; i++) {
            if(discs[i].getTitle() == title){
                System.out.println("DVD - " + discs[i].getTitle() + " - " + discs[i].getCategory() + " - "
                        + discs[i].getDirector() + " - " + discs[i].getLength() + ": " + discs[i].getCost());
                return;
            }
        }
        System.out.println("The disc was not found in the cart.");
    }
}
