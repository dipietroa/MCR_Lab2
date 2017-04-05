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
public class DisplayManager implements Displayer {

    private static final long serialVersionUID = 1L;

    private static DisplayManager INSTANCE;
    private JFrame jf;
    private JPanel panel;
    private Image img;

    private DisplayManager() {
        jf = new JFrame();
        panel = new JPanel();

        panel.setBackground(Color.WHITE);
        jf.setContentPane(panel);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(400,400);
        jf.setVisible(true);

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
        return (Graphics2D) img.getGraphics();
    }


    public void addKeyListener(KeyAdapter ka){

    }

    public int getHeight(){
        return panel.getHeight();
    }

    public int getWidth(){
        return panel.getWidth();
    }

    public void setTitle(String title){

    }

    public void repaint() {
        panel.getGraphics().drawImage(img, 0, 0,panel);
    }
}
