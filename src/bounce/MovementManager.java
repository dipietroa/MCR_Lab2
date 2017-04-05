package bounce;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Random;

/**
 * Classe gérant les mouvements et collisions d'une Shape
 * @author Di Pietro Adrian
 * @author Cotza Andrea
 * \date 27.03.2017
 */
public class MovementManager {

    private double vectx;
    private double vecty;
    private double RANGEMAX = 2;
    private double RANGEMIN = -2;

    /**
     * Constructeur, initialise un vecteur aléatoire
     */
    public MovementManager(){
        Random x = new Random();
        vectx = RANGEMIN + (RANGEMAX - RANGEMIN) * x.nextDouble();
        vecty = RANGEMIN + (RANGEMAX - RANGEMIN) * x.nextDouble();
    }

    /**
     * Vérifie les collisions inférieures
     * @param limitL borne
     * @param pos position forme
     * @param vect vecteur de déplacement de la forme
     * @param sToMove forme à déplacer
     * @return nouveau vecteur corrigé si collision si non le même
     */
    private double verifyBoundL(double limitL, double pos, double vect, Shape sToMove){
        if(pos + vect < limitL)
            return Math.abs(vect);
        return vect;
    }

    /**
     * Vérifie les collisions supérieures
     * @param limitH borne
     * @param pos position forme
     * @param vect vecteur de déplacement de la forme
     * @param size taille de la forme
     * @param sToMove forme à déplacer
     * @return nouveau vecteur corrigé si collision si non le même
     */
    private double verifyBoundH(double limitH, double pos, double vect, double size, Shape sToMove){
        if(pos + vect + size > limitH)
            return Math.abs(vect) * -1;
        return vect;
    }

    /**
     * Corrige les vecteurs de déplacement en cas de collision
     * puis effectue la translation et retourne la nouvelle forme
     * dans sa nouvelle position
     * @param sToMove forme à déplacer
     * @return nouvelle forme après déplacement (nouvelle position)
     */
    public Shape moveShapeCheckingForCollision(Shape sToMove){
        AffineTransform mover = new AffineTransform();
        vectx = verifyBoundL(0, sToMove.getBounds2D().getX(), vectx, sToMove);
        vecty= verifyBoundL(0, sToMove.getBounds2D().getY(), vecty, sToMove);
        vectx = verifyBoundH(DisplayManager.getInstance().getWidth(), sToMove.getBounds2D().getX(),
                            vectx, sToMove.getBounds2D().getWidth(), sToMove);
        vecty = verifyBoundH(DisplayManager.getInstance().getHeight(), sToMove.getBounds2D().getY(),
                            vecty, sToMove.getBounds2D().getHeight(), sToMove);

        mover.translate(vectx,vecty);
        return mover.createTransformedShape(sToMove);
    }
}
