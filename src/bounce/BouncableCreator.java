package bounce;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
 * Created by Adrian on 05.04.2017.
 */
public abstract class BouncableCreator implements Bouncable {
    protected int size;
    protected MovementManager mvm;
    protected Color color;
    protected Shape shape;
    Point initPos = new Point();


    public BouncableCreator(Color color){
        initPos.x = 30;
        initPos.y = 30;
        this.color = color;
        Random r = new Random();
        size = 30;
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

    public abstract Renderable getRenderer();

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
