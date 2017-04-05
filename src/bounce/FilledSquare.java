package bounce;

import java.awt.*;

/**
 * Created by Adrian on 05.04.2017.
 */
public class FilledSquare extends FilledBouncableCreator{
    public FilledSquare(){
        super(Color.yellow);
        shape = new Rectangle(initPos.x,initPos.y,size,size);
    }
}
