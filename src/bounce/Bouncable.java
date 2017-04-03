package bounce;

import java.awt.*;

/**
 * Created by Adrian on 03.04.2017.
 */
public interface Bouncable {
    void draw();
    void move();
    Renderable getRenderer();
    Color getColor();
    Shape getShape();
}
