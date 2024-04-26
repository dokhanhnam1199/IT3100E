package aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
    
    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    }
    
    public String toString() {
        return "DVD- " + this.getId() + " - " + this.getTitle() + " - " + this.getCategory() + " - "+this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + "$";
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength());
    }
}
