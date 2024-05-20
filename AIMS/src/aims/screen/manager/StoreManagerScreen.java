package aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import aims.store.*;
import aims.media.*;

public class StoreManagerScreen extends JFrame{
    private final Store store;

    public StoreManagerScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(),BorderLayout.NORTH);
        JPanel centerPanel = createCenter();
        cp.add(centerPanel, BorderLayout.CENTER);
        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }
    
    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        menu.add(new JMenuItem("View store"));

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBookMenuItem = new JMenuItem("Add Book");
        addBookMenuItem.addActionListener(e -> new AddBookToStoreScreen(store));
        smUpdateStore.add(addBookMenuItem);

        JMenuItem addCDMenuItem = new JMenuItem("Add CD");
        addCDMenuItem.addActionListener(e -> new AddCDToStoreScreen(store));
        smUpdateStore.add(addCDMenuItem);

        JMenuItem addDVDMenuItem = new JMenuItem("Add DVD");
        addDVDMenuItem.addActionListener(e -> new AddDVDToStoreScreen(store));
        smUpdateStore.add(addDVDMenuItem);

        menu.add(smUpdateStore);
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout (header, BoxLayout .X_AXIS));
        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font. PLAIN, 50));
        title.setForeground (Color.CYAN);
        header.add(Box.createRigidArea (new Dimension (10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea (new Dimension (10, 10)));
        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for(int i = 0; i < 9; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }
        return center;
    }

    public void check(){
        store.print();
    }
    public static void main (String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(15, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(14, "Star Wars", "Science Fiction", 24.95f, 87, "George Lucas");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(23, "Inception", "Science Fiction", 18.99f, 148,
                "Christopher Nolan");
        Book book3 = new Book(12, "Harry Potter3", "Fantasy", 11.7f);
        Book book2 = new Book(34, "Harry Potter2", "Fantasy", 11.6f);
        Book book1 = new Book(44, "Harry Potter1", "Fantasy", 11.5f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc(15, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        DigitalVideoDisc dvd5 = new DigitalVideoDisc(14, "Star Wars", "Science Fiction", 24.95f, 87, "George Lucas");
        DigitalVideoDisc dvd6 = new DigitalVideoDisc(23, "Inception", "Science Fiction", 18.99f, 148,
                "Christopher Nolan");

        Media[] newMedia = { dvd3, dvd2, dvd1, book3, book2, book1 , dvd4, dvd5, dvd6};

        Store store = new Store();
        for (Media m : newMedia) {
            store.addMedia(m);
        }

        new StoreManagerScreen(store);
    }
}