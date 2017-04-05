package bounce;

import java.util.LinkedList;

import static java.lang.Thread.sleep;

public class BounceApp {

    private LinkedList<Bouncable> bouncers = new LinkedList<Bouncable>();
    private Displayer dm;
    public BounceApp() {
        dm = DisplayManager.getInstance();
        bouncers.add(new BouncableCreator());
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    loop();
                    try {
                        sleep(15);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    dm.repaint();
                    try {
                        sleep(15);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();
    }
    public void loop() {
        while (true) {
            for (Bouncable b : bouncers) {
                b.move();
                b.draw();
            }
        }
    }
    public static void main(String ... args) {
        new BounceApp().loop();
    }
}
