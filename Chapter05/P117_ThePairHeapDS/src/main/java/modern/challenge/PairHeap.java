package modern.challenge;

public class PairHeap {

    private Node root;
    private Node[] tree = new Node[5];

    private int size;

    private final class Node {

        private int key;

        private Node leftChild;
        private Node nextSibling;
        private Node prev;

        public Node(int key) {
            this.key = key;
        }
    }

    public void insert(int key) {

        Node newNode = new Node(key);

        if (root == null) {
            root = newNode;
        } else {
            root = compareAndLink(root, newNode);
        }

        size++;
    }

    private Node compareAndLink(Node xNode, Node yNode) {

        if (yNode == null) {
            return xNode;
        }

        if (xNode == null) {
            return yNode;
        }

        if (yNode.key < xNode.key) {
            yNode.prev = xNode.prev;
            xNode.prev = yNode;
            xNode.nextSibling = yNode.leftChild;

            if (xNode.nextSibling != null) {
                xNode.nextSibling.prev = xNode;
            }

            yNode.leftChild = xNode;

            return yNode;
        } else {
            yNode.prev = xNode;
            xNode.nextSibling = yNode.nextSibling;

            if (xNode.nextSibling != null) {
                xNode.nextSibling.prev = xNode;
            }

            yNode.nextSibling = xNode.leftChild;

            if (yNode.nextSibling != null) {
                yNode.nextSibling.prev = yNode;
            }

            xNode.leftChild = yNode;

            return xNode;
        }
    }

    public void decreaseKey(int key, int newKey) {

        Node found = findByKey(key);

        if (found.key < newKey) {
            throw new IllegalArgumentException();
        }

        found.key = newKey;
        if (found != root) {
            if (found.nextSibling != null) {
                found.nextSibling.prev = found.prev;
            }

            if (found.prev.leftChild == found) {
                found.prev.leftChild = found.nextSibling;
            } else {
                found.prev.nextSibling = found.nextSibling;
            }

            found.nextSibling = null;
            root = compareAndLink(root, found);
        }
    }

    private Node toFind = null;

    public boolean isKey(int key) {

        toFind = null;
        return findByKey(key, root) != null;
    }

    private Node findByKey(int key) {

        toFind = null;
        return findByKey(key, root);
    }

    private Node findByKey(int key, Node node) {

        if (toFind != null || node == null) {
            return toFind;
        }

        Node temp = node;
        do {
            if (key == temp.key) {
                toFind = temp;
            } else {
                Node tempChild = temp.leftChild;
                findByKey(key, tempChild);
                temp = temp.nextSibling;
            }
        } while (temp != node && toFind == null);

        return toFind;
    }

    public int extractMin() {

        if (isEmpty()) {
            throw new UnsupportedOperationException("Cannot delete because the heap is empty");
        }

        int key = findMin();
        root.key = Integer.MIN_VALUE;

        if (root.leftChild == null) {
            root = null;
        } else {
            root = combineSiblings(root.leftChild);
        }

        size--;

        return key;
    }

    private Node combineSiblings(Node nodeSibling) {

        if (nodeSibling.nextSibling == null) {
            return nodeSibling;
        }

        int numSiblings = 0;

        for (; nodeSibling != null; numSiblings++) {

            tree = doubleIfFull(tree, numSiblings);
            tree[numSiblings] = nodeSibling;

            nodeSibling.prev.nextSibling = null;
            nodeSibling = nodeSibling.nextSibling;
        }

        tree = doubleIfFull(tree, numSiblings);
        tree[numSiblings] = null;

        int i = 0;
        for (; i + 1 < numSiblings; i += 2) {
            tree[i] = compareAndLink(tree[i], tree[i + 1]);
        }

        int j = i - 2;
        if (j == numSiblings - 3) {
            tree[j] = compareAndLink(tree[j], tree[j + 2]);
        }

        for (; j >= 2; j -= 2) {
            tree[j - 2] = compareAndLink(tree[j - 2], tree[j]);
        }

        return tree[0];
    }

    private Node[] doubleIfFull(Node[] tree, int index) {

        if (index == tree.length) {
            Node[] treeArray = tree;

            tree = new Node[index * 2];
            System.arraycopy(treeArray, 0, tree, 0, index);
        }

        return tree;
    }

    public int findMin() {
        return root != null ? root.key : Integer.MIN_VALUE;
    }
    
    /* Challenge yourself to implement the merge operation based on this pseudo-code */
    /*
    function merge(h1, h2)
     if h1 == Empty
      return h2
            else if h2 == Empty
      return h1
            else if h1.root < h2.root
      return new Heap(h1.root, h2 :: h1.tree)
     else
      return new Heap(h2.root, h1 :: h2.tree)
     */

    public boolean isEmpty() {
        return root == null || size <= 0;
    }

    public int size() {
        return size;
    }

    public void doEmpty() {
        root = null;
        size = 0;
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {

        if (node != null) {
            inOrder(node.leftChild);
            System.out.print(node.key + " ");
            inOrder(node.nextSibling);
        }
    }
}