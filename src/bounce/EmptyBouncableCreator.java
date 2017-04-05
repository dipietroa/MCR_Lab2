package bounce;

import java.awt.*;

/**
 * Created by Adrian on 05.04.2017.
 */
public abstract class EmptyBouncableCreator extends BouncableCreator {
    protected int strokeSize;

    public EmptyBouncableCreator(Color color, int strokeSize){
        super(color);
        this.strokeSize = strokeSize;
    }

    @Override
    public Renderable getRenderer(){
        return new Renderable(){
            @Override
            public void display(Graphics2D g, Bouncable b) {

                g.setColor(color);
                g.setStroke(new BasicStroke(strokeSize));
                g.draw(b.getShape());
            }
        };
    }
}
