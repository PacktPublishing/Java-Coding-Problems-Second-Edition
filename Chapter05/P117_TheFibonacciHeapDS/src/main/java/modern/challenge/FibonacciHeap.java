package modern.challenge;

import java.util.NoSuchElementException;

public class FibonacciHeap {

    private Node min;
    private int nrOfItems;

    private final class Node {

        private Node parent;
        private Node right;
        private Node left;
        private Node child;

        private int degree;
        private int key;

        private boolean mark;

        private Node(int key) {

            this.key = key;

            this.right = this;
            this.left = this;
        }

        private void cut(Node node, Node min) {

            node.left.right = node.right;
            node.right.left = node.left;

            degree--;

            if (degree == 0) {
                child = null;
            } else if (child == node) {
                child = node.right;
            }

            node.right = min;
            node.left = min.left;
            min.left = node;
            node.left.right = node;

            node.parent = null;

            node.mark = false;
        }

        private void cascadingCut(Node min) {

            Node parentNode = parent;

            if (parentNode != null) {
                if (mark) {
                    parentNode.cut(this, min);
                    parentNode.cascadingCut(min);
                } else {
                    mark = true;
                }
            }
        }

        private void link(Node parent) {

            left.right = right;
            right.left = left;

            this.parent = parent;
            if (parent.child == null) {
                parent.child = this;
                right = this;
                left = this;
            } else {
                left = parent.child;
                right = parent.child.right;
                parent.child.right = this;
                right.left = this;
            }

            parent.degree++;

            mark = false;
        }

        private void addToString(StringBuilder sb) {

            Node currentNode = this;

            do {
                sb.append(" ");
                sb.append(currentNode.key);
                sb.append(" ");

                if (currentNode.child != null) {
                    sb.append("[");
                    currentNode.child.addToString(sb);
                    sb.append(" ]");
                }

                currentNode = currentNode.right;
            } while (currentNode != this);
        }
    }

    public void insert(int key) {

        Node node = new Node(key);

        if (min != null) {
            node.right = min;
            node.left = min.left;
            min.left = node;
            node.left.right = node;

            if (node.key < min.key) {
                min = node;
            }
        } else {
            min = node;
        }

        nrOfItems++;
    }

    public int extractMin() {

        Node mNode = min;
        if (mNode == null) {
            return Integer.MIN_VALUE;
        }

        if (mNode.child != null) {

            mNode.child.parent = null;
            for (Node nNode = mNode.child.right; nNode != mNode.child; nNode = nNode.right) {
                nNode.parent = null;
            }

            Node minLeftNode = min.left;
            Node mChildLeftNode = mNode.child.left;

            min.left = mChildLeftNode;
            mChildLeftNode.right = min;
            mNode.child.left = minLeftNode;
            minLeftNode.right = mNode.child;
        }

        mNode.left.right = mNode.right;
        mNode.right.left = mNode.left;

        if (mNode == mNode.right) {
            min = null;
        } else {
            min = mNode.right;
            consolidate();
        }

        nrOfItems--;

        return mNode.key;
    }

    private void consolidate() {

        // this is equal to 45 so it can be replaced with a constant
        double phi = (1 + Math.sqrt(5)) / 2;
        int fn = (int) (Math.log(Integer.MAX_VALUE) / Math.log(phi)) + 1;

        Node[] aux = new Node[fn];

        Node startNode = min;
        Node wNode = min;

        do {
            Node xNode = wNode;
            Node nextWNode = wNode.right;
            int degree = xNode.degree;

            while (aux[degree] != null) {

                Node yNode = aux[degree];
                if (xNode.key > yNode.key) {

                    Node tempNode = yNode;
                    yNode = xNode;
                    xNode = tempNode;
                }

                if (yNode == startNode) {
                    startNode = startNode.right;
                }

                if (yNode == nextWNode) {
                    nextWNode = nextWNode.right;
                }

                yNode.link(xNode);

                aux[degree] = null;

                degree++;
            }

            aux[degree] = xNode;
            wNode = nextWNode;

        } while (wNode != startNode);

        min = startNode;

        for (Node node : aux) {
            if (node != null && node.key < min.key) {
                min = node;
            }
        }
    }

    public void decreaseKey(int key, int newKey) {

        Node found = findByKey(key);
        if (found == null) {
            throw new NoSuchElementException("There is no node with the given key");
        }

        decreaseKey(found, newKey);
    }

    private void decreaseKey(Node node, int newKey) {
        decreaseKey(node, newKey, false);
    }

    private void decreaseKey(Node node, int newKey, boolean delete) {

        node.key = newKey;
        Node parentNode = node.parent;

        if (parentNode != null && (delete || node.key < parentNode.key)) {
            parentNode.cut(node, min);
            parentNode.cascadingCut(min);
        }

        if (delete || node.key < min.key) {
            min = node;
        }
    }

    public void delete(int key) {

        Node found = findByKey(key);
        if (found == null) {
            throw new NoSuchElementException("There is no node with the given key: " + key);
        }

        decreaseKey(found, Integer.MIN_VALUE, true);

        extractMin();
    }

    private Node toFind = null;
    public boolean isKey(int key) {

        toFind = null;
        return findByKey(key, this.min) != null;
    }

    private Node findByKey(int key) {

        toFind = null;
        return findByKey(key, this.min);
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
                Node tempChild = temp.child;
                findByKey(key, tempChild);
                temp = temp.right;
            }
        } while (temp != node && toFind == null);

        return toFind;
    }
    
    public boolean isEmpty() {
        return min == null;
    }

    public int min() {
        return min == null ? Integer.MIN_VALUE : min.key;
    }

    public int size() {
        return nrOfItems;
    }

    public void clear() {
        min = null;
        nrOfItems = 0;
    }

    public static FibonacciHeap merge(FibonacciHeap heap1, FibonacciHeap heap2) {

        FibonacciHeap heap = new FibonacciHeap();

        if (heap1 != null && heap2 != null) {
            heap.min = heap1.min;

            if (heap.min != null) {
                if (heap2.min != null) {

                    heap.min.right.left = heap2.min.left;
                    heap2.min.left.right = heap.min.right;
                    heap.min.right = heap2.min;
                    heap2.min.left = heap.min;

                    if (heap2.min.key < heap1.min.key) {
                        heap.min = heap2.min;
                    }
                }
            } else {
                heap.min = heap2.min;
            }

            heap.nrOfItems = heap1.nrOfItems + heap2.nrOfItems;
        }

        return heap;
    }

    public String heapString() {

        StringBuilder sb = new StringBuilder();

        if (min != null) {
            sb.append("{");
            min.addToString(sb);
            sb.append("}");
        }

        return sb.toString();
    }
}