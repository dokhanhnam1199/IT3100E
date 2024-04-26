package aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private List<Track> tracks;

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist, List<Track> tracks) {
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
        sb.append(" - tracks=[");
        for (Track track : tracks) {
            sb.append(track.toString());
            sb.append(", ");
        }
        sb.append("]");
        if (!tracks.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
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
}
