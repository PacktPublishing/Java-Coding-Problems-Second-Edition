package modern.challenge;

public class MyPoint {
    
    private final int x;
    private final int y;
    private final int z;

    public MyPoint(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "MyPoint{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }        
}
