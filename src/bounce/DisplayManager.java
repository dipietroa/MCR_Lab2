package bounce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyAdapter;
import java.util.List;

/**
 * Classe gérant l'interface graphique
 * @author Di Pietro Adrian
 * @author Cotza Andrea
 * \date 27.03.2017
 */
public class DisplayManager implements Displayer {

    private static final long serialVersionUID = 1L;

    private static DisplayManager INSTANCE;
    private JFrame jf;
    private JPanel panel;
    private Image img;

    /**
     * Constructeur - Instancie une frame, lui associe un panel
     * ce panel crée une image. Ajout d'un ComponentListener pour
     * recréer l'image à la redimension du panel
     */
    private DisplayManager() {
        jf = new JFrame();
        panel = new JPanel();
        panel.setBackground(Color.WHITE);

        jf.setContentPane(panel);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(400,400);
        jf.setVisible(true);
        jf.setTitle("Bounce by Di Pietro & Cotza");

        img = panel.createImage(panel.getWidth(), panel.getHeight());

        panel.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                img = panel.createImage(panel.getWidth(), panel.getHeight());
            }

            @Override
            public void componentMoved(ComponentEvent e) {}
            @Override
            public void componentShown(ComponentEvent e) {}
            @Override
            public void componentHidden(ComponentEvent e) {}
        });
    }

    /**
     * Fournit l'unique instance du DisplayManager si elle existe
     * la crée si non
     * @return
     */
    public static DisplayManager getInstance() {
        if (INSTANCE == null) {
            synchronized (DisplayManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DisplayManager();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Override nécessaire pour que ce soit les graphics
     * de l'image que nous renvoyons
     * @return
     */
    @Override
    public Graphics2D getGraphics() {
        return (Graphics2D) img.getGraphics();
    }

    /**
     * Ajout d'une écoute clavier
     * @param ka
     */
    public void addKeyListener(KeyAdapter ka){
        jf.addKeyListener(ka);
    }

    /**
     * Retourne la hauteur du panel
     * @return
     */
    public int getHeight(){
        return panel.getHeight();
    }

    /**
     * Retourne la largeur du panel
     * @return
     */
    public int getWidth(){
        return panel.getWidth();
    }

    /**
     * Définit le titre
     * @param title
     */
    public void setTitle(String title){
        jf.setTitle(title);
    }

    /**
     * Redéssine l'image
     */
    public void repaint() {
        panel.getGraphics().drawImage(img, 0, 0,panel);
    }
}
