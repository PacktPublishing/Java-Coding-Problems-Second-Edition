package modern.challenge;

public final class Resistor implements ElectricComponent {
    
    private final int resistance;
    private final float clazz;
    private final int voltage;
    private final int current;
    private final float power;

    public Resistor(int resistance, float clazz, int voltage, int current, float power) {
        this.resistance = resistance;
        this.clazz = clazz;
        this.voltage = voltage;
        this.current = current;
        this.power = power;
    }

    public int getResistance() {
        return resistance;
    }

    public float getClazz() {
        return clazz;
    }

    public int getVoltage() {
        return voltage;
    }

    public int getCurrent() {
        return current;
    }

    public float getPower() {
        return power;
    }        
}