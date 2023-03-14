package modern.challenge;

public class Main {

    public static void main(String[] args) {
              
        SkipList list = new SkipList();
        
        list.insert(4);
        list.insert(3);
        list.insert(2);
        list.insert(1);
        list.insert(8);
        list.insert(5);
        list.insert(9);
        list.insert(10);
        list.insert(11);
        list.insert(34);
        
        list.printList();
        System.out.println();
        System.out.println("Contains 11: " + list.contains(11));
        
        list.insert(7);
        list.printList();
        System.out.println();
                
        list.delete(9);        
        list.printList();
        System.out.println();
        
        list.delete(34);        
        list.printList();
        System.out.println();
        
        list.delete(5);        
        list.printList();
        System.out.println();
        
        list.delete(10);        
        list.printList();
        System.out.println();
        
        list.delete(8);        
        list.printList();
        System.out.println();
        
        list.delete(1);        
        list.printList();
        System.out.println();
        
        System.out.println("Found 2: " + list.contains(2));
        System.out.println();
        list.delete(2);        
        list.printList();
        System.out.println();
        System.out.println("Found 2: " + list.contains(2));
        System.out.println();
        
        list.delete(4);        
        list.printList();
        System.out.println();
        
        list.delete(11);        
        list.printList();
        System.out.println();
        
        list.delete(3);        
        list.printList();
        System.out.println();
    }
}