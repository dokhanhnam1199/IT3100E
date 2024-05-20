package aims.media;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.*;

public class DigitalVideoDisc extends Disc implements Playable{
    
    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    }
    
    public String toString() {
        return "DVD- " + this.getId() + " - " + this.getTitle() + " - " + this.getCategory() + " - "+this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + "$";
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + getTitle() + "by" + getDirector());
        System.out.println("DVD length: " + getLength());
    }

    @Override
    public void playMedia(){
        // Create a JDialog
        JDialog playDialog = new JDialog();
        playDialog.setTitle("Playing DVD: " + getTitle());
        playDialog.setSize(400, 300);
        playDialog.setLocationRelativeTo(null);
        playDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Create a JTextArea to display the CD and track information
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // Capture the CD and track information
        StringBuilder info = new StringBuilder();
        info.append("Playing DVD: ").append(getTitle()).append(" by ").append(getDirector()).append("\n");
        info.append("DVD length: ").append(getLength()).append("\n\n");

        textArea.setText(info.toString());

        // Add the JTextArea to a JScrollPane (for better handling of large text)
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Add the JScrollPane to the JDialog
        playDialog.add(scrollPane, BorderLayout.CENTER);

        // Make the JDialog visible
        playDialog.setVisible(true);
    }
}
