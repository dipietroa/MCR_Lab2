package bounce;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
 * Created by Adrian on 05.04.2017.
 */
public class BouncableCreator implements Bouncable {
    protected Point center = new Point();
    protected int size;
    protected Movement movement;
    protected Color color;
    protected Shape shape;

    public BouncableCreator(int csize){
        Random r = new Random(csize);
        shape = new Rectangle(100, 100, 20, 20);
        shape = new Ellipse2D.Double(100,100,20,20);
        this.center.x = r.nextInt();
        this.center.y = r.nextInt();
        //this.size = ;
        //this.movement = movement;
        //this.color = color;
    }

    public Shape getShape(){
        return shape;
    }

    @Override
    public void move() {
        /*center.x += movement.getX();
        center.y += movement.getY();*/
    }

    public void draw(){
        this.getRenderer().display(DisplayManager.getInstance().getGraphics(), this);
    }

    public Renderable getRenderer(){
        return new Renderable(){
            @Override
            public void display(Graphics2D g, Bouncable b) {

                g.setColor(Color.BLUE);
                //g.setStroke(new BasicStroke(2));
                g.draw(b.getShape());
            }
        };
    }
    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
