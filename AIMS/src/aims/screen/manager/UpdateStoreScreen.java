package aims.screen.manager;

import javax.swing.*;
import java.awt.*;

public class UpdateStoreScreen extends JFrame {
    public UpdateStoreScreen() {
        setTitle("Update Store");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu updateStoreMenu = new JMenu("Update Store");

        JMenuItem addBookMenuItem = new JMenuItem("Add Book");
        //addBookMenuItem.addActionListener(e -> new AddBookToStoreScreen().setVisible(true));
        updateStoreMenu.add(addBookMenuItem);

        JMenuItem addCDMenuItem = new JMenuItem("Add CD");
        //addCDMenuItem.addActionListener(e -> new AddCompactDiscToStoreScreen().setVisible(true));
        updateStoreMenu.add(addCDMenuItem);

        JMenuItem addDVDMenuItem = new JMenuItem("Add DVD");
        //addDVDMenuItem.addActionListener(e -> new AddDigitalVideoDiscToStoreScreen().setVisible(true));
        updateStoreMenu.add(addDVDMenuItem);

        JMenuItem viewStoreMenuItem = new JMenuItem("View Store");
        //viewStoreMenuItem.addActionListener(e -> new ViewStoreScreen().setVisible(true));
        updateStoreMenu.add(viewStoreMenuItem);

        menuBar.add(updateStoreMenu);
        setJMenuBar(menuBar);

        // Main panel content (for future enhancements, can be left empty for now)
        JPanel mainPanel = new JPanel();
        mainPanel.add(new JLabel("Select an option from the 'Update Store' menu."));
        add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UpdateStoreScreen().setVisible(true);
    }
}
