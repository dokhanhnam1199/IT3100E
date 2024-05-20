package aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import aims.store.Store;
import aims.media.CompactDisc;
import aims.media.Track;

public class AddCDToStoreScreen extends JFrame {
    private ArrayList<Track> tracks;

    public AddCDToStoreScreen(Store store) {
        this.tracks = new ArrayList<>();
        setTitle("Add CD");
        setSize(400, 600);
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
        panel.add(new JLabel("Artist:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        JTextField artistField = new JTextField(20);
        panel.add(artistField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(new JLabel("Track Title:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        JTextField trackTitleField = new JTextField(20);
        panel.add(trackTitleField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(new JLabel("Track Length:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        JTextField trackLengthField = new JTextField(20);
        panel.add(trackLengthField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        JButton addTrackButton = new JButton("Add Track");
        addTrackButton.addActionListener(e -> {
            try {
                String trackTitle = trackTitleField.getText();
                int trackLength = Integer.parseInt(trackLengthField.getText());
                tracks.add(new Track(trackTitle, trackLength));
                trackTitleField.setText("");
                trackLengthField.setText("");
                JOptionPane.showMessageDialog(this, "Track added successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number for Track Length.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(addTrackButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        JButton addButton = new JButton("Add CD");
        addButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String title = titleField.getText();
                String category = categoryField.getText();
                float cost = Float.parseFloat(costField.getText());
                int length = Integer.parseInt(lengthField.getText());
                String director = directorField.getText();
                String artist = artistField.getText();
                CompactDisc newCD = new CompactDisc(id, title, category, cost, length, director, artist, tracks);
                store.addMedia(newCD);
                JOptionPane.showMessageDialog(this, "CD added successfully!");
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Invalid input. Please enter valid numbers for ID, Cost, Length, and Track Length.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(addButton, gbc);

        add(panel);
        setVisible(true);
    }
}