package modern.challenge;

import java.io.Serializable;
import java.util.Objects;

public class Melon implements Serializable {

    private final String type;
    private final int weight;

    public Melon(String type, int weight) {
        
        Objects.requireNonNull(type, "The melon's type cannot be null");
        
        if (weight < 1000 || weight > 10000) { 
            throw new IllegalArgumentException(
                    "The melon's weight must be between 1000 and 10000 grams");
        }  
        
        this.type = type;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.type);
        hash = 47 * hash + this.weight;
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
        
        final Melon other = (Melon) obj;
        if (this.weight != other.weight) {
            return false;
        }
        
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "Melon{" + "type=" + type + ", weight=" + weight + '}';
    }   
}
