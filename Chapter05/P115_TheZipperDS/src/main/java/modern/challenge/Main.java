package modern.challenge;

import modern.challenge.zipper.Cursor;
import modern.challenge.zipper.Zipper;
import modern.challenge.tree.Node;

public class Main {

    public static void main(String[] args) {

        //       A
        //     / | \ 
        //    B  C  D---            
        //  / | \    \  \
        // E  F  G    H  I (I will be inserted)            
        Node tree
                = new Node("A",
                        new Node("B",
                                new Node("E"),
                                new Node("F"),
                                new Node("G")),
                        new Node("C"),
                        new Node("D",
                                new Node("H")));

        Cursor<Node> root = Zipper.createZipper(tree);
        
        System.out.println("Print the zip tree");
        System.out.println("-------------------------------------------------");        
        root.childrenIterator().forEachRemaining(System.out::println);
        System.out.println("\nCurrent node is first: " + root.isFirst());
        System.out.println();

        System.out.println("Navigating from node A to node G");
        System.out.println("-------------------------------------------------");
        
        Cursor<Node> gNode = root.down().down(1).right(); // this should be 'G'
        System.out.println("Current node: " + gNode.unwrap().getName());
        System.out.println("Current node is leaf: " + gNode.isLeaf());
        System.out.println();
                
        System.out.println("Insert node I as child of node D and sibling of node H (first, navigate from node G to H):");
        System.out.println("-------------------------------------------------");        
        Cursor<Node> hNode = gNode.up().rightMost().down();
        System.out.println("Current node: " + hNode.unwrap().getName());
        System.out.println("Current node is leaf: " + hNode.isLeaf());
        System.out.println("Insert the I node ...");         
        Cursor<Node> hNewNode = hNode.insertRight(new Node("I"));
        hNewNode.up().childrenIterator().forEachRemaining(System.out::println); // now, D should have a two children, H and I
        System.out.println();
        
        System.out.println("Remove the B node (first, navigate from node H to B):");
        System.out.println("-------------------------------------------------");        
        Cursor<Node> bNode = hNewNode.up().leftMost();
        System.out.println("Current node: " + bNode.unwrap().getName());
        System.out.println("Current node is leaf: " + bNode.isLeaf());
        System.out.println("Current node is first: " + bNode.isFirst());
        Cursor<Node> parentNode = bNode.remove();
        System.out.println();
       
        System.out.println("Back to tree (changes are reflected in the tree)");
        System.out.println("-------------------------------------------------");        
        Node backToTree = Zipper.unwrapZipper(parentNode);        
        System.out.println(backToTree);
    }
}
