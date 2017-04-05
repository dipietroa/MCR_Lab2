package bounce;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Random;

/**
 * Created by Adrian on 05.04.2017.
 */
public class MovementManager {

    private double vectx;
    private double vecty;

    public MovementManager(){
        Random x = new Random();
        vectx = x.nextDouble() * (3 - (-3)) + (-3);
        vecty = x.nextDouble() * (3 - (-3)) + (-3);
    }

    private double verifyBoundL(double limitL, double pos, double vect, Shape sToMove){
        if(pos + vect < limitL)
            return Math.abs(vect);
        return vect;
    }

    private double verifyBoundH(double limitH, double pos, double vect, double size, Shape sToMove){
        if(pos + vect + size > limitH)
            return Math.abs(vect) * -1;
        return vect;
    }

    public Shape moveShapeCheckingForCollision(Shape sToMove){
        AffineTransform mover = new AffineTransform();
        vectx = verifyBoundL(0, sToMove.getBounds2D().getX(), vectx, sToMove);
        vecty= verifyBoundL(30, sToMove.getBounds2D().getY(), vecty, sToMove);
        vectx = verifyBoundH(DisplayManager.getInstance().getWidth(), sToMove.getBounds2D().getX(),
                            vectx, sToMove.getBounds2D().getWidth(), sToMove);
        vecty = verifyBoundH(DisplayManager.getInstance().getHeight(), sToMove.getBounds2D().getY(),
                            vecty, sToMove.getBounds2D().getHeight(), sToMove);

        mover.translate(vectx,vecty);
        return mover.createTransformedShape(sToMove);
    }
}
