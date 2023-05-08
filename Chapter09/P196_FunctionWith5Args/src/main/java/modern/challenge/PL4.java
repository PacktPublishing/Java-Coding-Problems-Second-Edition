package modern.challenge;

public class PL4 {
    
    private final double a;
    private final double b;
    private final double c;
    private final double d;
    private final double x;

    public PL4(double a, double b, double c, double d, double x) {        
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.x = x;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    public double getX() {
        return x;
    }            
    
    public double compute() {
        return d + ((a - d) / (1 + (Math.pow(x / c, b))));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.a) ^ (Double.doubleToLongBits(this.a) >>> 32));
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.b) ^ (Double.doubleToLongBits(this.b) >>> 32));
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.c) ^ (Double.doubleToLongBits(this.c) >>> 32));
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.d) ^ (Double.doubleToLongBits(this.d) >>> 32));
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
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
        final PL4 other = (PL4) obj;
        if (Double.doubleToLongBits(this.a) != Double.doubleToLongBits(other.a)) {
            return false;
        }
        if (Double.doubleToLongBits(this.b) != Double.doubleToLongBits(other.b)) {
            return false;
        }
        if (Double.doubleToLongBits(this.c) != Double.doubleToLongBits(other.c)) {
            return false;
        }
        if (Double.doubleToLongBits(this.d) != Double.doubleToLongBits(other.d)) {
            return false;
        }
        return Double.doubleToLongBits(this.x) == Double.doubleToLongBits(other.x);
    }

    @Override
    public String toString() {
        return "PL4{" + "a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + ", x=" + x + '}';
    }        
}