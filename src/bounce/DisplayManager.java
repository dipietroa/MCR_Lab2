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

    private DisplayManager() {

        JPanel panel = new JPanel() {

            private static final long serialVersionUID = 1L;

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
            }

        };

        panel.setBackground(Color.WHITE);
        this.getContentPane().add(panel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(30, 30, 300, 300);
        this.setVisible(true);
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
        return (Graphics2D) INSTANCE.getGraphics();
    }

    public int getAvailableHeight() {
        return this.getContentPane().getHeight();
    }

    public int getAvailableWidth() {return this.getContentPane().getWidth();}

    public void addKeyListener(KeyAdapter ka){

    }
}
