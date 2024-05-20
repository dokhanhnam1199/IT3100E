package aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import aims.store.Store;
import aims.media.DigitalVideoDisc;

public class AddDVDToStoreScreen extends JFrame {

    public AddDVDToStoreScreen(Store store) {
        setTitle("Add DVD");
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
        JTextField idField = new JTextField(20);
        panel.add(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Title:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        JTextField titleField = new JTextField(20);
        panel.add(titleField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Category:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        JTextField categoryField = new JTextField(20);
        panel.add(categoryField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Cost:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        JTextField costField = new JTextField(20);
        panel.add(costField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Length:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        JTextField lengthField = new JTextField(20);
        panel.add(lengthField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Director:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        JTextField directorField = new JTextField(20);
        panel.add(directorField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String title = titleField.getText();
                String category = categoryField.getText();
                float cost = Float.parseFloat(costField.getText());
                int length = Integer.parseInt(lengthField.getText());
                String director = directorField.getText();
                DigitalVideoDisc newDVD = new DigitalVideoDisc(id, title, category, cost, length, director);
                store.addMedia(newDVD);
                JOptionPane.showMessageDialog(this, "DVD added successfully!");
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers for ID, Cost, and Length.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(addButton, gbc);

        add(panel);
        setVisible(true);
    }
}