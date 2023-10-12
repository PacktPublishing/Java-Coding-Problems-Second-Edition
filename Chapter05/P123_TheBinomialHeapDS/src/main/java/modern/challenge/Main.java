package modern.challenge;

public class Main {

    public static void main(String[] args) {

        BinomialHeap h1 = new BinomialHeap();
        h1.insert(11);
        h1.insert(8);
        h1.insert(24);
        h1.insert(13);
        h1.insert(22);
        h1.insert(40);
        h1.insert(31);

        System.out.println("H1: ");
        h1.print();

        BinomialHeap h2 = new BinomialHeap();
        h2.insert(18);
        h2.insert(3);
        h2.insert(37);
        h2.insert(5);
        h2.insert(7);
        h2.insert(9);
        h2.insert(40);
        h2.insert(29);
        h2.insert(24);
        h2.insert(45);
        h2.insert(55);

        System.out.println("H2: ");
        h2.print();

        BinomialHeap h3 = h1.union(h2);
        System.out.println("H3: ");
        h3.print();

        int extracted = h3.extractMin();

        System.out.println("\nExtract min: " + extracted);
        System.out.println("Heap after extract min: ");
        h3.print();

        h3.delete(31);
        System.out.println("\nHeap after deleting 31: ");
        h3.print();

        h3.decreaseKey(24, 2);
        System.out.println("\nHeap after decreasing 24 to 2: ");
        h3.print();
    }
}