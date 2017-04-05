package bounce;

import java.awt.*;
import java.util.LinkedList;

import static java.lang.Thread.sleep;

public class BounceApp {

    private LinkedList<Bouncable> bouncers = new LinkedList<Bouncable>();
    private Displayer dm;
    public BounceApp() {
        dm = DisplayManager.getInstance();
        bouncers.add(new FilledSquare());
        bouncers.add(new FilledCircle());
        bouncers.add(new FilledSquare());
        bouncers.add(new FilledSquare());
        bouncers.add(new FilledSquare());
        bouncers.add(new FilledSquare());
        bouncers.add(new FilledCircle());
        bouncers.add(new FilledSquare());
        bouncers.add(new FilledSquare());
        bouncers.add(new FilledSquare());
        bouncers.add(new FilledSquare());
        bouncers.add(new FilledCircle());
        bouncers.add(new FilledSquare());
        bouncers.add(new FilledSquare());
        bouncers.add(new FilledSquare());
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
    public void loop() {
        dm.getGraphics().setBackground(Color.BLACK);
        dm.getGraphics().fillRect(0, 0, dm.getWidth(), dm.getHeight());
        for (Bouncable b : bouncers) {
            b.move();
            b.draw();
        }
        dm.repaint();
    }
    public static void main(String ... args) {
        new BounceApp();
    }
}
