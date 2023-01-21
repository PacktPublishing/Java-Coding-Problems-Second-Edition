package modern.challenge;

public class Main {    

    public static void main(String[] args) {

        FunPuzzle fp = new FunPuzzle("head");
        Puzzle p = fp;  // Compiler throws an unchecked warning (raw type)
        p.setPiece(5);  // ClassCastException
    }
}
