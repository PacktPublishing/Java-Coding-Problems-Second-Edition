package modern.challenge;

public class Main {

    public static void main(String[] args) {
        
        FibonacciHeap heap = new FibonacciHeap();
        
        heap.insert(5);
        heap.insert(1);
        heap.insert(8);
        heap.insert(3);
        heap.insert(9);
        heap.insert(0);
        heap.insert(2);
        heap.insert(7);
        heap.insert(6);
        heap.insert(4);
        
        System.out.println("Initial heap: \n" + heap.heapString());
      
        heap.extractMin();
       
        System.out.println("Heap after extracting min (aka 0): \n" + heap.heapString());
        
        heap.decreaseKey(8, 0);
        
        System.out.println("Heap after decreasing key 8 to 0: \n" + heap.heapString());
        
        heap.delete(3);
        heap.delete(7);
        
        System.out.println("Heap after deleting the 3 and 7 keys: \n" + heap.heapString());
        
        heap.extractMin();
       
        System.out.println("Heap after extracting min (aka 0): \n" + heap.heapString());
        
        heap.insert(7);
        
        System.out.println("Heap after inserting the key 7: \n" + heap.heapString());
        
        System.out.println("\nCreating another heap ...\n");
        
        FibonacciHeap heapAux = new FibonacciHeap();
        
        heapAux.insert(15);
        heapAux.insert(11);
        heapAux.insert(18);
        heapAux.insert(13);
        heapAux.insert(19);
        
        System.out.println("Second initial heap: \n" + heapAux.heapString());
      
        heapAux.extractMin();
       
        System.out.println("Second heap after extracting min (aka 11): \n" + heapAux.heapString());
        
        heapAux.decreaseKey(18, 12);
        
        System.out.println("Heap after decreasing key 18 to 12: \n" + heapAux.heapString());
        
        FibonacciHeap heapResult = FibonacciHeap.merge(heap, heapAux);
        
        System.out.println("Third heap after merging 'heap' and 'heapAux': \n" + heapResult.heapString());
        
        System.out.println("\nThird heap status: \n");
        System.out.println("Min: " + heapResult.min());
        System.out.println("Empty: " + heapResult.isEmpty());
        System.out.println("Size: " + heapResult.size());
        
        heapResult.extractMin();
       
        System.out.println("\nThird heap after extracting min (aka 1): \n" + heapResult.heapString());
        
        boolean is100 = heapResult.isKey(100);
        boolean is12 = heapResult.isKey(12);
        
        System.out.println("\nThird heap contains the key 100: " + is100);
        System.out.println("\nThird heap contains the key 12: " + is12);
        
        heapResult.clear();
        
        System.out.println("\nThird heap after clear: \n" + heapResult.heapString());
        
        System.out.println("\nThird heap status: \n");
        System.out.println("Min: " + heapResult.min());
        System.out.println("Empty: " + heapResult.isEmpty());
        System.out.println("Size: " + heapResult.size());
    }
}
