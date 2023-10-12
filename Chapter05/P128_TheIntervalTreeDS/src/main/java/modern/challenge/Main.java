package modern.challenge;

public class Main {

    public static void main(String[] args) {

        IntervalTree tree = new IntervalTree();

        tree.insert(new IntervalTree.Interval(4, 7));
        tree.insert(new IntervalTree.Interval(1, 10));
        tree.insert(new IntervalTree.Interval(7, 23));
        tree.insert(new IntervalTree.Interval(6, 8));
        tree.insert(new IntervalTree.Interval(9, 13));
        tree.insert(new IntervalTree.Interval(2, 24));
        
        System.out.println("Initial interval tree: ");
        tree.print(IntervalTree.TraversalOrder.LEVEL);
        System.out.println();
                
        System.out.println("\nSearch all intervals that overlaps the [23, 25] interval: ");
        System.out.println(tree.searchAll(new IntervalTree.Interval(23, 25)));       

        System.out.println("\nDelete the [7, 23] interval: ");
        tree.delete(new IntervalTree.Interval(7, 23));
        tree.print(IntervalTree.TraversalOrder.LEVEL);
        System.out.println();
        
        System.out.println("\nCheck that interval [11, 13] exists: ");
        System.out.println(tree.contains(new IntervalTree.Interval(11, 13)));
        
        IntervalTree.Interval found = tree.search(new IntervalTree.Interval(23, 25));
        System.out.println("\nSearch interval [23, 25]: " + found);
        
        System.out.println("\nInterval tree height: " + tree.height());
    }
}