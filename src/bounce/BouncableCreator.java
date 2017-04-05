package bounce;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
 * Classe abstraite représentant un Bouncable
 * @author Di Pietro Adrian
 * @author Cotza Andrea
 * \date 27.03.2017
 */
public abstract class BouncableCreator implements Bouncable {
    private int MIN_SIZE = 10;
    private int MAX_SIZE = 40;
    protected int size;
    protected MovementManager mvm;
    protected Color color;
    protected Shape shape;
    protected Point initPos = new Point();

    /**
     * Constructeur
     * @param color couleur de la forme
     */
    public BouncableCreator(Color color){
        initPos.x = DisplayManager.getInstance().getWidth()/2;
        initPos.y = DisplayManager.getInstance().getHeight()/2;
        this.color = color;
        Random r = new Random();
        size = MIN_SIZE + r.nextInt(MAX_SIZE - MIN_SIZE + 1);
        mvm = new MovementManager();
    }

    /**
     * Retourne la forme
     * @return
     */
    @Override
    public Shape getShape(){
        return shape;
    }

    /**
     * Déplace la forme en faisant appel au MovementManager
     */
    @Override
    public void move() {
        shape = mvm.moveShapeCheckingForCollision(shape);
    }

    /**
     * Dessine la forme en utilisant la méthode display du Renderable
     */
    @Override
    public void draw(){
        this.getRenderer().display(DisplayManager.getInstance().getGraphics(), this);
    }

    /**
     * Retourne le Renderable
     * @return
     */
    @Override
    public abstract Renderable getRenderer();

    /**
     * Retourne la couleur de la forme
     * @return
     */
    @Override
    public Color getColor() {
        return color;
    }
}
