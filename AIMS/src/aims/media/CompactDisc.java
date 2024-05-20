package aims.media;

import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.*;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks;

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist, ArrayList<Track> tracks) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
        this.tracks = new ArrayList<>(tracks);
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println(track.getTitle() + " has been added.");
        }
        else {
            System.out.println("The track already exists.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.remove(track)) {
            System.out.println(track.getTitle() + " has been removed.");
        } else {
            System.out.println(track.getTitle() + " was not found.");
        }
    }

    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CD");
        sb.append(" - ").append(getId());
        sb.append(" - ").append(getTitle());
        sb.append(" - ").append(getCategory());
        sb.append(" - ").append(getLength());
        sb.append(" - ").append(getDirector());
        sb.append(" - ").append(artist);
        sb.append(": ").append(getCost()).append('$');
        if (tracks != null && !tracks.isEmpty()) {
            sb.append(" - tracks=[");
            for (Track track : tracks) {
                sb.append(track.toString());
                sb.append(", ");
            }
            sb.append("]");
        }
        sb.append(": ").append(getCost()).append('$');
        return sb.toString();
    }

    @Override
    public void play() {
        System.out.println("Playing CD: " + getTitle() + " by " + artist);
        System.out.println("CD length: " + getLength());

        for (Track track : tracks) {
            track.play();
        }
    }

    @Override
    public void playMedia(){
        // Create a JDialog
        JDialog playDialog = new JDialog();
        playDialog.setTitle("Playing CD: " + getTitle());
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
        info.append("Playing CD: ").append(getTitle()).append(" by ").append(artist).append("\n");
        info.append("CD length: ").append(getLength()).append("\n\n");

        for (Track track : tracks) {
            info.append(track.toString()).append("\n");
        }

        textArea.setText(info.toString());

        // Add the JTextArea to a JScrollPane (for better handling of large text)
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Add the JScrollPane to the JDialog
        playDialog.add(scrollPane, BorderLayout.CENTER);

        // Make the JDialog visible
        playDialog.setVisible(true);
    }
}
