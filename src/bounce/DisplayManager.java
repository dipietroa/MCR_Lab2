package bounce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyAdapter;
import java.util.List;

/**
 * Created by Adrian on 03.04.2017.
 */
public class DisplayManager extends JFrame implements Displayer {

    private static final long serialVersionUID = 1L;

    private static DisplayManager INSTANCE;
    private JPanel panel;
    private Image img;

    private DisplayManager() {

        panel = new JPanel();

        panel.setBackground(Color.WHITE);
        this.setContentPane(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,400);
        this.setVisible(true);

        img = panel.createImage(panel.getWidth(), panel.getHeight());

        panel.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                img = panel.createImage(panel.getWidth(), panel.getHeight());
            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }
        });
    }

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

    @Override
    public Graphics2D getGraphics() {
        return (Graphics2D) super.getGraphics();
    }


    public void addKeyListener(KeyAdapter ka){

    }

    public void repaint() {
        panel.getGraphics().drawImage(img, 0, 0, new Color(0,0,0),panel);
    }
}
