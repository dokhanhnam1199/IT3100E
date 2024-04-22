package aims;
public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Breaking Bad", "Crime", "Vince Gilligan", 29.99f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Family Guy", "Animation",19.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        System.out.println("Total cost is: ");
        System.out.println(anOrder.totalCost());

    }
}
