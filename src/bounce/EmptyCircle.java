package bounce;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Classe représentant un cercle vide
 * @author Di Pietro Adrian
 * @author Cotza Andrea
 * \date 27.03.2017
 */
public class EmptyCircle extends EmptyBouncableCreator {
    /**
     * Définit la couleur, la taille des bords et la forme (position taille)
     */
    public EmptyCircle(){
        super(Color.green, 2);
        shape = new Ellipse2D.Double(initPos.x, initPos.y, size, size);
    }
}
