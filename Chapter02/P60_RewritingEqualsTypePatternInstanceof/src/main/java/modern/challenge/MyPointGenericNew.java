package modern.challenge;

import java.util.Objects;

public final class MyPointGenericNew<E> {
    
    private final E x;
    private final E y;
    private final E z;

    public MyPointGenericNew(E x, E y, E z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.x);
        hash = 83 * hash + Objects.hashCode(this.y);
        hash = 83 * hash + Objects.hashCode(this.z);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) {
            return true;
        }
        
        return obj instanceof MyPointGenericNew<?> other 
                && this.x == other.x && this.y == other.y && this.z == other.z;          
    }       
}