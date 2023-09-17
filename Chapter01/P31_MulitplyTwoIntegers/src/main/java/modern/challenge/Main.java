package modern.challenge;

public class Main {

    public static void main(String[] args) {

        int p = 5;
        int q = -4;
        
        int r1 = Numbers.multiplyV1(p, q);
        int r2 = Numbers.multiplyV2(p, q);
        
        System.out.println("V1: " + p + " * " + q + " = " + r1);        
        System.out.println("V2: " + p + " * " + q + " = " + r2);        
    }
}
