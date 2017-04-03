package bounce;

import java.awt.*;
import java.awt.event.KeyAdapter;

/**
 * Created by Adrian on 03.04.2017.
 */
public interface Displayer {
    int getWidth();
    int getHeight();
    Graphics2D getGraphics();
    void repaint();
    void setTitle(String s);
    void addKeyListener(KeyAdapter ka);
}
