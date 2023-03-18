package modern.challenge;

class UnrolledLinkedList {

    private final int ns;

    private Node start;
    private Node end;
    private int size;

    private final class Node {

        private final int arr[];

        private Node next;
        private int items;

        public Node(int ns) {
            arr = new int[ns];
        }
    }

    public UnrolledLinkedList(int capacity) {
        ns = capacity + 1;
    }

    public void insert(int a) {

        size++;

        if (start == null) {
            start = new Node(ns);
            start.arr[0] = a;
            start.items++;
            end = start;

            return;
        }

        if (end.items + 1 < ns) {
            end.arr[end.items] = a;
            end.items++;
        } else {
            Node node = new Node(ns);
            int j = 0;
            for (int i = end.items / 2 + 1; i < end.items; i++) {
                node.arr[j++] = end.arr[i];
            }

            node.arr[j++] = a;
            node.items = j;
            end.items = end.items / 2 + 1;
            end.next = node;
            end = node;
        }
    }

    /* challenge yourself to implement here deletion based on the description from the book */
    
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("{");

        Node node = start;
        while (node != null) {
            sb.append("[");
            for (int i = 0; i < node.items; i++) {
                sb.append(node.arr[i]).append(" ");
            }
            sb.append("], ");
            node = node.next;
        }

        sb.replace(sb.length() - 2, sb.length() - 1, "}");

        return sb.toString();
    }
}
