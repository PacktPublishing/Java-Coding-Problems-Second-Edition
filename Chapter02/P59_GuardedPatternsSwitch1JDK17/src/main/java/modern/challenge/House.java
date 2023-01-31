package modern.challenge;

class Heater {}
class Stove extends Heater {}
class Chimney extends Heater {

    private final boolean electric;

    public Chimney(boolean electric) {
        this.electric = electric;
    }

    public boolean isElectric() {
        return electric;
    }
}

public class House {

    private static String turnOnTheHeat(Heater heater) {

        return switch (heater) {
            case Stove stove -> "Make a fire in the stove";
            case Chimney chimney && chimney.isElectric() -> "Plug in the chimney";
            case Chimney chimney -> "Make a fire in the chimney";
            default -> "No heater available!";
        };
    }

    public static void main(String[] args) {
        System.out.println(turnOnTheHeat(new Stove()));
        System.out.println(turnOnTheHeat(new Chimney(true)));
    }
}