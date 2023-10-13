package modern.challenge;

// import java.io.Serializable;
import java.util.Objects;

public class Melon { //implements Serializable { // this is optional

    private String type;
    private float weight;

    // this is needed for XMLEncoder and XmlMapper
    public Melon() {} 
    
    public Melon(String type, float weight) {
        this.type = type;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public float getWeight() {
        return weight;
    }

    // setters are needed by the XMLEncoder
    public void setType(String type) {
        this.type = type;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }        

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.type);
        hash = 97 * hash + Float.floatToIntBits(this.weight);
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
