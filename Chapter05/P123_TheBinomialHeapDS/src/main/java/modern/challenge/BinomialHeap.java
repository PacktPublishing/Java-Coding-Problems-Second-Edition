package modern.challenge;

import java.util.ArrayList;
import java.util.List;

public class BinomialHeap {

    private Node head;

    private final class Node {

        private int key;
        private int degree;
        private Node parent;
        private Node child;
        private Node sibling;

        public Node() {
            key = Integer.MIN_VALUE;
        }

        public Node(int key) {
            this.key = key;
        }

        private void print(StringBuilder sb) {

            Node currentNode = this;

            while (currentNode != null) {

                if (currentNode.key != Integer.MIN_VALUE) {
                    sb.append(" ");
                    sb.append(currentNode.key);
                    sb.append(" ");
                }

                if (currentNode.child != null) {
                    sb.append("[ ");
                    currentNode.child.print(sb);
                    sb.append(" ]");
                }

                currentNode = currentNode.sibling;
            }
        }
    }

    public BinomialHeap() {
        head = null;
    }

    private BinomialHeap(Node head) {
        this.head = head;
    }

    public void insert(int key) {
        Node node = new Node(key);
        BinomialHeap newHeap = new BinomialHeap(node);

        head = unionHeap(newHeap);
    }

    public int findMin() {

        if (head == null) {
            return Integer.MIN_VALUE;
        } else {
            Node min = head;
            Node nextNode = min.sibling;

            while (nextNode != null) {
                if (nextNode.key < min.key) {
                    min = nextNode;
                }
                nextNode = nextNode.sibling;
            }

            return min.key;
        }
    }

    public void decreaseKey(int key, int newKey) {

        Node found = findByKey(key);
        if (found != null) {
            decreaseKey(found, newKey);
        }
    }

    private void decreaseKey(Node node, int newKey) {

        node.key = newKey;
        goUp(node, false);
    }

    public void delete(int key) {

        Node found = findByKey(key);
        if (found != null) {
            delete(found);
        }
    }

    private void delete(Node node) {

        node = goUp(node, true);

        if (head == node) {
            deleteTreeRoot(node, null);
        } else {
            Node previousNode = head;
            while (previousNode.sibling.key != node.key) {
                previousNode = previousNode.sibling;
            }
            deleteTreeRoot(node, previousNode);
        }
    }

    private Node goUp(Node node, boolean goToRoot) {

        Node parent = node.parent;
        while (parent != null && (goToRoot || node.key < parent.key)) {

            int t = node.key;
            node.key = parent.key;
            parent.key = t;

            node = parent;
            parent = parent.parent;
        }

        return node;
    }

    public int extractMin() {

        if (head == null) {
            return Integer.MIN_VALUE;
        }

        Node min = head;
        Node minPrev = null;
        Node nextNode = min.sibling;
        Node nextNodePrev = min;

        while (nextNode != null) {
            if (nextNode.key < min.key) {
                min = nextNode;
                minPrev = nextNodePrev;
            }

            nextNodePrev = nextNode;
            nextNode = nextNode.sibling;
        }

        deleteTreeRoot(min, minPrev);

        return min.key;
    }

    private void deleteTreeRoot(Node root, Node previousNode) {

        if (root == head) {
            head = root.sibling;
        } else {
            previousNode.sibling = root.sibling;
        }

        Node unionHeap = null;
        Node child = root.child;
        while (child != null) {
            Node nextNode = child.sibling;
            child.sibling = unionHeap;
            child.parent = null;
            unionHeap = child;
            child = nextNode;
        }

        BinomialHeap toUnionHeap = new BinomialHeap(unionHeap);

        head = unionHeap(toUnionHeap);
    }

    private Node findByKey(int key) {

        List<Node> nodes = new ArrayList<>();

        nodes.add(head);
        while (!nodes.isEmpty()) {
            Node currentNode = nodes.get(0);
            nodes.remove(0);
            if (currentNode.key == key) {
                return currentNode;
            }
            if (currentNode.sibling != null) {
                nodes.add(currentNode.sibling);
            }
            if (currentNode.child != null) {
                nodes.add(currentNode.child);
            }
        }

        return null;
    }

    private void linkNodes(Node minNodeTree, Node other) {

        other.parent = minNodeTree;
        other.sibling = minNodeTree.child;
        minNodeTree.child = other;
        minNodeTree.degree++;
    }

    public BinomialHeap union(BinomialHeap heap) {

        Node node = unionHeap(heap);
        BinomialHeap bh = new BinomialHeap(node);

        return bh;
    }

    private Node unionHeap(BinomialHeap heap) {

        Node mergeHeap = merge(this, heap);       

        head = null;
        heap.head = null;

        if (mergeHeap == null) {
            return null;
        }

        Node previousNode = null;
        Node currentNode = mergeHeap;
        Node nextNode = mergeHeap.sibling;

        while (nextNode != null) {
            if (currentNode.degree != nextNode.degree || (nextNode.sibling != null
                    && nextNode.sibling.degree == currentNode.degree)) {
                previousNode = currentNode;
                currentNode = nextNode;
            } else {
                if (currentNode.key < nextNode.key) {
                    currentNode.sibling = nextNode.sibling;
                    linkNodes(currentNode, nextNode);
                } else {
                    if (previousNode == null) {
                        mergeHeap = nextNode;
                    } else {
                        previousNode.sibling = nextNode;
                    }

                    linkNodes(nextNode, currentNode);
                    currentNode = nextNode;
                }
            }

            nextNode = currentNode.sibling;
        }

        return mergeHeap;
    }

    private Node merge(BinomialHeap h1, BinomialHeap h2) {

        if (h1.head == null) {
            return h2.head;
        } else if (h2.head == null) {
            return h1.head;
        } else {
            Node headIt;
            Node h1Next = h1.head;
            Node h2Next = h2.head;

            if (h1.head.degree <= h2.head.degree) {
                headIt = h1.head;
                h1Next = h1Next.sibling;
            } else {
                headIt = h2.head;
                h2Next = h2Next.sibling;
            }

            Node tail = headIt;

            while (h1Next != null && h2Next != null) {
                if (h1Next.degree <= h2Next.degree) {
                    tail.sibling = h1Next;
                    h1Next = h1Next.sibling;
                } else {
                    tail.sibling = h2Next;
                    h2Next = h2Next.sibling;
                }

                tail = tail.sibling;
            }

            if (h1Next != null) {
                tail.sibling = h1Next;
            } else {
                tail.sibling = h2Next;
            }

            return headIt;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
    }

    public void print() {

        StringBuilder sb = new StringBuilder();
        if (head != null) {
            head.print(sb);
        }

        System.out.println(sb.toString());
    }
}
