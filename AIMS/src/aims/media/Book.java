package aims.media;
import java.util.ArrayList;

public class Book  extends Media{
    private ArrayList<String> authors;

    public Book(int id, String title, String category, float cost){
        super(id, title, category, cost);
    }

    public Book(int id, String title, String category, float cost, ArrayList<String> authors){
        super(id, title, category, cost);
        this.authors = new ArrayList<>(authors);
    }

    public void addAuthor(String author) {
        if (!authors.contains(author)) {
            authors.add(author);
            System.out.println(author+" has been added.");
        }
    }

    public void removeAuthor(String author) {
        if(authors.remove(author)){
            System.out.println(author + " has been removed.");
        }
        else {
            System.out.println(author + " was not found.");
        }
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BOOK");
        sb.append(" - ").append(getId());
        sb.append(" - ").append(getTitle());
        sb.append(" - ").append(getCategory());
        sb.append(": ").append(getCost()).append('$');
        sb.append(" - tracks=[");
        for (String author : authors) {
            sb.append(author);
            sb.append(", ");
        }
        sb.append("]");
        if (!authors.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }
}
