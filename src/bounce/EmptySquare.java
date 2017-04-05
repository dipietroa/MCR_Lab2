package bounce;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Classe représentant un carré vide
 * @author Di Pietro Adrian
 * @author Cotza Andrea
 * \date 27.03.2017
 */
public class EmptySquare extends EmptyBouncableCreator {
    /**
     * Définit la couleur, la taille des bords et la forme (position taille)
     */
    public EmptySquare(){
        super(Color.red, 2);
        shape = new Rectangle(initPos.x,initPos.y,size,size);
    }
}
