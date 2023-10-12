package modern.challenge;

public class Main {

    public static void main(String[] args) {

        UnrolledLinkedList list = new UnrolledLinkedList();
        list.insert(new int[]{3, 4, 51});
        list.insert(new int[]{11, 12, 22, 56});
        list.insert(new int[]{6, 7});
        list.insert(new int[]{9});

        System.out.println("Initial list: " + list.toString());

        int val22 = list.get(5);
        System.out.println("\n Element at index 5: " + val22);

        list.delete(5);
        System.out.println("\n After deleting the element at index 5: " + list.toString());

        list.delete(8);
        System.out.println("\n After deleting the element at index 8: " + list.toString());
    }
}
