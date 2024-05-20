package aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import aims.store.Store;
import aims.media.Book;

public class AddBookToStoreScreen extends JFrame {

    public AddBookToStoreScreen(Store store) {
        setTitle("Add Book");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("ID:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        JTextField idField = new JTextField();
        panel.add(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Title:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        JTextField titleField = new JTextField();
        panel.add(titleField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Category:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        JTextField categoryField = new JTextField();
        panel.add(categoryField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Cost:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        JTextField costField = new JTextField();
        panel.add(costField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Authors:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        JTextArea authorsArea = new JTextArea(3, 20);
        authorsArea.setLineWrap(true);
        authorsArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(authorsArea);
        panel.add(scrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String title = titleField.getText();
                String category = categoryField.getText();
                float cost = Float.parseFloat(costField.getText());
                ArrayList<String> authors = new ArrayList<>(Arrays.asList(authorsArea.getText().split("\\s*,\\s*")));
                Book newBook = new Book(id, title, category, cost, authors);
                store.addMedia(newBook);
                JOptionPane.showMessageDialog(this, "Book added successfully!");
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers for ID and Cost.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(addButton, gbc);

        add(panel);
        setVisible(true);
    }
}