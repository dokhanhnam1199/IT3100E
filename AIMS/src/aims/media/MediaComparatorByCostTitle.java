package aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        int costCompare = Double.compare(m2.getCost(), m1.getCost());
        if (costCompare != 0) {
            return costCompare;
        } else {
            // If costs are the same, compare titles
            return m1.getTitle().compareTo(m2.getTitle());
        }
    }
}