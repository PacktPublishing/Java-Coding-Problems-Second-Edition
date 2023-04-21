package modern.challenge;

import modern.challenge.Main.BinaryTree.Leaf;
import modern.challenge.Main.BinaryTree.Node;

public class Main {

    sealed interface BinaryTree {

        record Leaf() implements BinaryTree {}
        record Node(int value, BinaryTree left, BinaryTree right) implements BinaryTree {}       
    }
    
    static int sumNode(BinaryTree t) {

        return switch (t) {
            
            case Leaf nl -> 0;
            case Node nv -> nv.value() + sumNode(nv.left()) + sumNode(nv.right());
        };
    }

    public static void main(String[] args) {

        BinaryTree leaf = new Leaf();
        BinaryTree s1 = new Node(5, leaf, leaf);
        BinaryTree s2 = new Node(10, leaf, leaf);
        BinaryTree s = new Node(4, s1, s2);

        int sum = sumNode(s);

        System.out.println("Sum: " + sum);
    }
}