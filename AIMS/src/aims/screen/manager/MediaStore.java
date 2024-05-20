package aims.screen.manager;

import aims.media.*;
import javax.swing.*;
import java.awt.*;

public class MediaStore extends JPanel {

    public MediaStore (Media media) {
        this.setLayout(new BoxLayout(this, BoxLayout. Y_AXIS));
        JLabel title = new JLabel (media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font. PLAIN, 15));
        title.setAlignmentX (CENTER_ALIGNMENT);
        JLabel cost = new JLabel(" "+media.getCost()+" $");
        cost.setAlignmentX (CENTER_ALIGNMENT);
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout (FlowLayout.CENTER));
        if(media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(e -> media.playMedia());
            container.add(playButton);
        }
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        this.setBorder (BorderFactory.createLineBorder (Color.BLACK));
    }
}
