package bounce;

import java.awt.*;

/**
 * Classe représentant un carré plein
 * @author Di Pietro Adrian
 * @author Cotza Andrea
 * \date 27.03.2017
 */
public class FilledSquare extends FilledBouncableCreator{
    /**
     * Définit la couleur et la forme (position taille)
     */
    public FilledSquare(){
        super(Color.yellow);
        shape = new Rectangle(initPos.x,initPos.y,size,size);
    }
}
