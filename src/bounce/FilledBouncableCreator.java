package bounce;

import java.awt.*;

/**
 * Classe gérant l'affichage d'une forme pleine
 * @author Di Pietro Adrian
 * @author Cotza Andrea
 * \date 27.03.2017
 */
public abstract class FilledBouncableCreator extends BouncableCreator {
    /**
     * Appelle le constructeur de la classe parent
     * @param color
     */
    public FilledBouncableCreator(Color color){
        super(color);
    }

    /**
     * Classe anonyme retournant un Renderable avec méthode display
     * définie
     * @return
     */
    @Override
    public Renderable getRenderer(){
        /**
         * Dessine une forme pleine
         */
        return new Renderable(){
            @Override
            public void display(Graphics2D g, Bouncable b) {

                g.setColor(color);
                g.fill(b.getShape());
                g.draw(b.getShape());
            }
        };
    }
}
