package modern.challenge;

public class Main {

    static {        
        System.loadLibrary("math");
    }
    
    private native long sumTwoInt(int x, int y);

    public static void main(String[] args) {
        long result = new Main().sumTwoInt(3, 9);
        
        System.out.println("Result: " + result);
    }    
}
