package modern.challenge;

public class Main {

    public static void main(String[] args) {

        double v1 = 65;
        double v2 = 169; // must be a perfect square
        
        double sqroot = Numbers.squareRootBabylonian(v1);
        long psqroot = Numbers.perfectSquareRootBabylonian(v2);
        
        System.out.println("Square root of " + v1 + " is: " + sqroot);
        System.out.println("Square root of " + v2 + " is: " + psqroot);
    }
}
