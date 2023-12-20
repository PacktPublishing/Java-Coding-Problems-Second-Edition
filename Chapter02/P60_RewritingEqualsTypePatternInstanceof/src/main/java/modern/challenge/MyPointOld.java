package modern.challenge;

public final class MyPointOld {
    
    private final int x;
    private final int y;
    private final int z;

    public MyPointOld(int x, int y, int z) {
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
        
        if (!(obj instanceof MyPointOld)) {
		return false;
        }
        
        final MyPointOld other = (MyPointOld) obj;
        
        return (this.x == other.x && this.y == other.y && this.z == other.z);            
    }       
}