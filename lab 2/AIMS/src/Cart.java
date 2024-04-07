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
            if (discs[i] == disc) {
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
}
