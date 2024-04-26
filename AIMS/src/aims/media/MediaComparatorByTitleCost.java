package aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
        @Override
        public int compare(Media m1, Media m2) {
                int titleCompare = m1.getTitle().compareTo(m2.getTitle());
                if (titleCompare != 0) {
                        return titleCompare;
                } else {
                        // If titles are the same, compare cost in descending order
                        return Double.compare(m2.getCost(), m1.getCost());
                }
        }
}
