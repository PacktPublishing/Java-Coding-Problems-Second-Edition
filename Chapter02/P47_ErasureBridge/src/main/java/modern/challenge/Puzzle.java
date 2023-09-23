package modern.challenge;

public class Puzzle<E> {

    public E piece;

    public Puzzle(E piece) {
        this.piece = piece;
    }

    public void setPiece(E piece) {        
        this.piece = piece;
    }
}
