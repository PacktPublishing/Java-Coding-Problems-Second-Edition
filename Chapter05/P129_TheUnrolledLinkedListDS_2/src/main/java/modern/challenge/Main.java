package modern.challenge;

public class Main {

    public static void main(String[] args) {

        UnrolledLinkedList list = new UnrolledLinkedList(4);
        
        list.insert(3);
        list.insert(4);
        list.insert(51);
        list.insert(11);
        list.insert(12);
        list.insert(22);
        list.insert(56);
        list.insert(6);
        list.insert(7);
        list.insert(9);
                
        System.out.println("Initial list: " + list.toString());
    }
}
