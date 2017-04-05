package bounce;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Classe représentant un cercle plein
 * @author Di Pietro Adrian
 * @author Cotza Andrea
 * \date 27.03.2017
 */
public class FilledCircle extends FilledBouncableCreator {
    /**
     * Définit la couleur et la forme (position taille)
     */
    public FilledCircle(){
        super(Color.blue);
        shape = new Ellipse2D.Double(initPos.x, initPos.y, size, size);
    }
}
