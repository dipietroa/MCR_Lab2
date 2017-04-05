package bounce;

import javax.swing.*;
import java.awt.*;
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

        panel = new JPanel() {

            private static final long serialVersionUID = 1L;

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
            }

        };

        panel.setBackground(Color.WHITE);
        this.getContentPane().add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0,0, 500, 500);
        this.setVisible(true);

        img = panel.createImage(500, 500);
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

    /*public void repaint() {
        panel.getGraphics().drawImage(img, 0, 0, null);
        img.getGraphics().clearRect(0,0,panel.getWidth(),panel.getHeight());
    }*/
}
