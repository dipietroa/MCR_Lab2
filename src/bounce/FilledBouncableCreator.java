package bounce;

import java.awt.*;

/**
 * Created by Adrian on 05.04.2017.
 */
public abstract class FilledBouncableCreator extends BouncableCreator {
    public FilledBouncableCreator(Color color){
        super(color);
    }

    @Override
    public Renderable getRenderer(){
        return new Renderable(){
            @Override
            public void display(Graphics2D g, Bouncable b) {

                g.setColor(color);
                g.fill(b.getShape());
                g.draw(b.getShape());
            }
        };
    }
}
