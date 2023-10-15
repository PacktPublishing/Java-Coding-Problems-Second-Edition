package modern.challenge;

public final class Transistor implements ElectricComponent {
    
    private final float length;
    private final float width;
    private final float threshholdVoltage;

    public Transistor(float length, float width, float threshholdVoltage) {
        this.length = length;
        this.width = width;
        this.threshholdVoltage = threshholdVoltage;
    }

    public float getLength() {
        return length;
    }

    public float getWidth() {
        return width;
    }

    public float getThreshholdVoltage() {
        return threshholdVoltage;
    }            
}