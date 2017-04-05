package bounce;

import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Thread.sleep;

public class BounceApp {

    private LinkedList<Bouncable> bouncers = new LinkedList<Bouncable>();
    private Displayer dm;
    public BounceApp() {
        dm = DisplayManager.getInstance();
        bouncers.add(new FilledSquare());
        bouncers.add(new EmptySquare());
        bouncers.add(new FilledSquare());
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
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    dm.getGraphics().clearRect(0, 0, dm.getWidth(), dm.getHeight());
                    dm.repaint();
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();*/
        // Lance la boucle d'exécution
        /*Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                loop();
            }
        }, 0, 1000 / 100);*/
    }
    public void loop() {
        dm.getGraphics().clearRect(0, 0, dm.getWidth(), dm.getHeight());
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
