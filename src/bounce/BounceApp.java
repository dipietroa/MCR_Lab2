package bounce;

import java.util.LinkedList;

public class BounceApp {

    private LinkedList<Bouncable> bouncers;
    private Displayer dm;
    public BounceApp() {
        dm = DisplayManager.getInstance();
    }
    public void loop() {
        while (true) {
            for (Bouncable b : bouncers) {
                b.move();
                b.draw();
            }
            dm.repaint();
        }
    }
    public static void main(String ... args) {
        new BounceApp().loop();
    }
}
