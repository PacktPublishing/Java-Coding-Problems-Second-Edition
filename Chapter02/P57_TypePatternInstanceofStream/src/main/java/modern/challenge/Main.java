package modern.challenge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

interface Engine {}

class HypersonicEngine implements Engine {} // not implemented
class HighSpeedEngine implements Engine {}  // not implemented

class RegularEngine implements Engine {

    private final int maxSpeed;
    private final boolean electric;

    public RegularEngine(int maxSpeed, boolean electric) {
        this.maxSpeed = maxSpeed;
        this.electric = electric;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public boolean isElectric() {
        return electric;
    }

    @Override
    public String toString() {
        return "RegularEngine{" + "maxSpeed=" + maxSpeed + ", electric=" + electric + '}';
    }           
}

public class Main {

    private static List<Engine> filterRegularEngines(List<Engine> engines, int testSpeed) {

        for (Iterator<Engine> i = engines.iterator(); i.hasNext();) {
            final Engine e = i.next();
            if (e instanceof RegularEngine) {
                final RegularEngine popularEngine = (RegularEngine) e;
                if (popularEngine.isElectric()) {
                    if (!hasEnoughAutonomy(popularEngine, testSpeed)) {
                        i.remove();
                    }
                }
            }
        }

        return engines;
    }

    private static List<Engine> filterRegularEnginesStream(List<Engine> engines, int testSpeed) {

        engines.removeIf(e -> e instanceof RegularEngine engine 
                && engine.isElectric()
                && !hasEnoughAutonomy(engine, testSpeed));
        
        return engines;
    }

    private static boolean hasEnoughAutonomy(Engine engine, int testSpeed) {
        return Math.random() > 0.5;
    }

    public static void main(String[] args) {

        List<Engine> engines = new ArrayList<>();

        engines.add(new RegularEngine(210, true));
        engines.add(new RegularEngine(190, true));
        engines.add(new RegularEngine(200, false));
        engines.add(new RegularEngine(150, false));
        engines.add(new RegularEngine(150, true));
        engines.add(new RegularEngine(210, false));

        System.out.println("Inital list: " + engines);
        System.out.println();
        // System.out.println("After filter: " + filterRegularEngines(engines, 180));
        System.out.println("After filter (stream): " + filterRegularEnginesStream(engines, 180));
    }
}
