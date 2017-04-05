package bounce;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import static java.lang.Thread.sleep;

/**
 * Classe principale
 * @author Di Pietro Adrian
 * @author Cotza Andrea
 * \date 27.03.2017
 */
public class BounceApp {

    private LinkedList<Bouncable> bouncers = new LinkedList<Bouncable>();
    private Displayer dm;

    /**
     * Génère un nombre nb de chaque forme pleine
     * @param nb
     */
    private synchronized void generateCollectionFilledBouncers(int nb){
        for (int i = 0; i < nb; i++) {
            bouncers.add(new FilledCircle());
            bouncers.add(new FilledSquare());
        }
    }

    /**
     * Génère un nombre nb de chaque forme vide
     * @param nb
     */
    private synchronized void generateCollectionEmptyBouncers(int nb){
        for (int i = 0; i < nb; i++) {
            bouncers.add(new EmptyCircle());
            bouncers.add(new EmptySquare());
        }
    }

    /**
     * Efface tous les bouncable
     */
    private synchronized void clear(){
        bouncers.clear();
    }

    /**
     * Ajoute une écoute d'entrée clavier au DisplayManager
     */
    private void setKeyListeners(){
        dm.addKeyListener(new KeyAdapter() {
            /**
             * Structure de contrôle permettant d'associer des caractères
             * représantant les touches du clavier aux évènements souhaités
             * @param e évènement clavier enregistré
             */
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if(e.getKeyChar() == 'e')
                    clear();
                if(e.getKeyChar() == 'b')
                    generateCollectionEmptyBouncers(10);
                if(e.getKeyChar() == 'f')
                    generateCollectionFilledBouncers(10);
                if(e.getKeyChar() == 'q')
                    System.exit(0);
            }
        });
    }

    /**
     * Constructeur de l'application:
     * demande une instance DisplayManager
     * génère une première collection de formes
     * démarre l'écoute clavier
     * lance une thread exécutant le refresh et régulant le frame rate
     *
     */
    public BounceApp() {
        dm = DisplayManager.getInstance();
        this.generateCollectionFilledBouncers(5);
        this.setKeyListeners();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    loop();
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();
    }

    /**
     * rempli le précédent affichage (pour effacer)
     * déplace tous les bouncers puis les dessine
     * affichage de la nouvelle image obtenue.
     */
    public void loop() {
        //setBackground ne fonctionne pas (toujours fond noir) à corriger
        dm.getGraphics().setBackground(Color.white);
        dm.getGraphics().fillRect(0, 0, dm.getWidth(), dm.getHeight());
        synchronized (this){
            for (Bouncable b : bouncers) {
                b.move();
                b.draw();
            }
        }
        dm.repaint();
    }

    /**
     * Démarre l'application
     * @param args
     */
    public static void main(String ... args) {
        new BounceApp();
    }
}
