package modern.challenge;

public final class MyPointNew {
    
    private final int x;
    private final int y;
    private final int z;

    public MyPointNew(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + this.x;
        hash = 73 * hash + this.y;
        hash = 73 * hash + this.z;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) {
            return true;
        }
        
        return obj instanceof MyPointNew other 
                && this.x == other.x && this.y == other.y && this.z == other.z;            
    }
}