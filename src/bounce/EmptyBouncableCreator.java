package bounce;

import java.awt.*;

/**
 * Classe gérant l'affichage d'une forme vide
 * @author Di Pietro Adrian
 * @author Cotza Andrea
 * \date 27.03.2017
 */
public abstract class EmptyBouncableCreator extends BouncableCreator {
    protected int strokeSize;

    /**
     * Constructeur appelant celui de la classe parent et
     * définissant une taille pour les bords
     * @param color
     * @param strokeSize
     */
    public EmptyBouncableCreator(Color color, int strokeSize){
        super(color);
        this.strokeSize = strokeSize;
    }

    /**
     * Classe anonyme retournant un Renderable avec méthode display
     * définie
     * @return
     */
    @Override
    public Renderable getRenderer(){
        return new Renderable(){
            /**
             * Dessine une forme vide avec bords à taille définie
             * @param g
             * @param b
             */
            @Override
            public void display(Graphics2D g, Bouncable b) {

                g.setColor(color);
                g.setStroke(new BasicStroke(strokeSize));
                g.draw(b.getShape());
            }
        };
    }
}
