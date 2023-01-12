package modern.challenge;

public class Main {

    public static void main(String[] args) {

        int dividend = 162;
        int divisor = 42;
        
        System.out.println("Floor modulus:");
        int fd = Math.floorDiv(dividend, divisor);        
        int fmodJDK8_1 = dividend - (fd * divisor);
        
        int fmodJDK8_2 = Math.floorMod(dividend, divisor);        
        
        System.out.println("Modulus: " + (dividend % divisor) 
                + " Floor modulus: " + fmodJDK8_1 + " = " + fmodJDK8_2);
        
        System.out.println();
                
        System.out.println("Ceil modulus:");        
        int cd = Math.ceilDiv(dividend, divisor);
        int cmodJDK18_1 = dividend - (cd * divisor);
        
        int cmodJDK18_2 = Math.ceilMod(dividend, divisor);
        System.out.println("Modulus: " + (dividend % divisor) 
                + " Ceil modululs: " + cmodJDK18_1 + " = " + cmodJDK18_2);                
    }
}