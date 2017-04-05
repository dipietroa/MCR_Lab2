package bounce;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by Adrian on 05.04.2017.
 */
public class EmptySquare extends EmptyBouncableCreator {
    public EmptySquare(){
        super(Color.red, 2);
        shape = new Rectangle(initPos.x,initPos.y,size,size);
    }
}
