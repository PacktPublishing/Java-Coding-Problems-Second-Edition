package modern.challenge;

public class Main {

    public static void main(String[] args) {

        PairHeap heap = new PairHeap();
        heap.insert(5);
        heap.insert(1);
        heap.insert(7);
        heap.insert(9);

        System.out.println("Initial heap:");
        heap.inOrder();

        heap.decreaseKey(9, 2);
        System.out.println("\nAfter decreasing 9 to 2:");
        heap.inOrder();

        heap.decreaseKey(5, 4);
        System.out.println("\nAfter decreasing 5 to 4:");
        heap.inOrder();
        
        int min = heap.findMin();
        System.out.println("\nMin: " + min);
        
        int del = heap.extractMin();
        System.out.println("\nDeleted: " + del);
        System.out.println("\nNew min: " + heap.findMin());
        System.out.println("\nAfter deletion:");        
        heap.inOrder();
        
        boolean is4 = heap.isKey(4);
        System.out.println("\nIs 4: " + is4);     
        
        System.out.println("\nEmpty (before call doEmpty()): " + heap.isEmpty());
        System.out.println("\nSize (before call doEmpty()): " + heap.size());
        heap.doEmpty();
        System.out.println("\nEmpty (after call doEmpty()): " + heap.isEmpty());
        System.out.println("\nSize (after call doEmpty()): " + heap.size());
        
    }
}
