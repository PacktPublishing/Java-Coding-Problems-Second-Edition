package modern.challenge;

public class Main {

    public static void main(String[] args) {

        System.out.println("Tau: " + (2 * Math.PI));
        System.out.println("Tau: " + Math.PI);
               
        // A circle has a circumference of 21.33 cm. What is the radius of the circle?
        // C = 2πr → r = C/(2π);

        // using PI
         double rPi = 21.33 / (2 * Math.PI);
         System.out.println("Radius (via PI): " + rPi);
         
         double rTau = 21.33 / Math.TAU;
         System.out.println("Radius (via TAU): " + rTau);
    }
}
