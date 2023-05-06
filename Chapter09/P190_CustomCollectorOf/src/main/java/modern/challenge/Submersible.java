package modern.challenge;

import java.util.Objects;

public class Submersible implements Vehicle {
    
    private final String type;
    private final double maxdepth;

    public Submersible(String type, double maxdepth) {
        this.type = type;
        this.maxdepth = maxdepth;
    }

    public String getType() {
        return type;
    }

    public double getMaxdepth() {
        return maxdepth;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.type);
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.maxdepth) ^ (Double.doubleToLongBits(this.maxdepth) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Submersible other = (Submersible) obj;
        if (Double.doubleToLongBits(this.maxdepth) != Double.doubleToLongBits(other.maxdepth)) {
            return false;
        }
        return Objects.equals(this.type, other.type);
    }

    @Override
    public String toString() {
        return "Submersible{" + "type=" + type + ", maxdepth=" + maxdepth + '}';
    }        
}