package bounce;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
 * Created by Adrian on 05.04.2017.
 */
public class BouncableCreator implements Bouncable {
    protected int size;
    protected MovementManager mvm;
    protected Color color;
    protected Shape shape;
    private double vectx;
    private double vecty;


    public BouncableCreator(){
        Random r = new Random();
        shape = new Rectangle(100, 100, 20, 20);
        //shape = new Ellipse2D.Double(100,100,20,20);
        mvm = new MovementManager();
        //this.size = ;
        //this.movement = movement;
        //this.color = color;
    }

    public Shape getShape(){
        return shape;
    }

    @Override
    public void move() {
        shape = mvm.moveShapeCheckingForCollision(shape);
    }

    public void draw(){
        this.getRenderer().display(DisplayManager.getInstance().getGraphics(), this);
    }

    public Renderable getRenderer(){
        return new Renderable(){
            @Override
            public void display(Graphics2D g, Bouncable b) {

                g.setColor(Color.BLUE);
                g.setStroke(new BasicStroke(2));
                g.fill(b.getShape());
                g.draw(b.getShape());
            }
        };
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
