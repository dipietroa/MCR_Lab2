package bounce;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by Adrian on 05.04.2017.
 */
public class FilledCircle extends FilledBouncableCreator {
    public FilledCircle(){
        super(Color.blue);
        shape = new Ellipse2D.Double(initPos.x, initPos.y, size, size);
    }
}
