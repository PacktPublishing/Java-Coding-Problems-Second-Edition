package modern.challenge;

import java.util.ArrayDeque;
import java.util.Queue;

class SplayTree {

    private Node root;
    private int count;

    private final class Node {

        private Node left;
        private Node right;
        private Node parent;
        private int data;

        public Node() {
            this(0, null, null, null);
        }

        public Node(int data) {
            this(data, null, null, null);
        }

        public Node(int data, Node left, Node right, Node parent) {
            this.left = left;
            this.right = right;
            this.parent = parent;
            this.data = data;
        }
    }

    public SplayTree() {
        root = null;
    }   

    public void insert(int data) {

        Node xNode = root;
        Node yNode = null;

        while (xNode != null) {
            yNode = xNode;
            if (data > yNode.data) {
                xNode = xNode.right;
            } else {
                xNode = xNode.left;
            }
        }

        xNode = new Node();
        xNode.data = data;
        xNode.parent = yNode;

        if (yNode == null) {
            root = xNode;
        } else if (data > yNode.data) {
            yNode.right = xNode;
        } else {
            yNode.left = xNode;
        }

        splay(xNode);

        count++;
    }
    
    public void insertAll(SplayTree other) {
        insertAll(other.root);        
    }
    
    private void insertAll(Node node) {
        if (node != null) {
            insertAll(node.left);
            insert(node.data);
            insertAll(node.right);
        }
    }
    
    private void splay(Node node) {

        while (node.parent != null) {

            Node parentNode = node.parent;
            Node grandpaNode = parentNode.parent;

            if (grandpaNode == null) {
                if (node == parentNode.left) {
                    leftChildToParent(node, parentNode);
                } else {
                    rightChildToParent(node, parentNode);
                }
            } else {
                if (node == parentNode.left) {
                    if (parentNode == grandpaNode.left) {
                        leftChildToParent(parentNode, grandpaNode);
                        leftChildToParent(node, parentNode);
                    } else {
                        leftChildToParent(node, node.parent);
                        rightChildToParent(node, node.parent);
                    }
                } else {
                    if (parentNode == grandpaNode.left) {
                        rightChildToParent(node, node.parent);
                        leftChildToParent(node, node.parent);
                    } else {
                        rightChildToParent(parentNode, grandpaNode);
                        rightChildToParent(node, parentNode);
                    }
                }
            }
        }

        root = node;
    }
    
    private void leftChildToParent(Node xNode, Node yNode) {

        if (xNode == null || yNode == null || yNode.left != xNode || xNode.parent != yNode) {
            throw new IllegalStateException("Something is not working properly while transforming the left child into parent");
        }
                
        if (yNode.parent != null) {
            if (yNode == yNode.parent.left) {
                yNode.parent.left = xNode;
            } else {
                yNode.parent.right = xNode;
            }
        }
        if (xNode.right != null) {
            xNode.right.parent = yNode;
        }

        xNode.parent = yNode.parent;
        yNode.parent = xNode;
        yNode.left = xNode.right;
        xNode.right = yNode;
    }

    private void rightChildToParent(Node xNode, Node yNode) {

        if ((xNode == null) || (yNode == null) || (yNode.right != xNode) || (xNode.parent != yNode)) {
            throw new IllegalStateException("Something is not working properly while transforming the right child into parent");
        }
                
        if (yNode.parent != null) {
            if (yNode == yNode.parent.left) {
                yNode.parent.left = xNode;
            } else {
                yNode.parent.right = xNode;
            }
        }

        if (xNode.left != null) {
            xNode.left.parent = yNode;
        }

        xNode.parent = yNode.parent;
        yNode.parent = xNode;
        yNode.right = xNode.left;
        xNode.left = yNode;
    }
    
    public boolean search(int data) {

        return searchNode(data) != null;
    }

    private Node searchNode(int data) {

        Node previousNode = null;
        Node rootNode = root;

        while (rootNode != null) {
            previousNode = rootNode;
            if (data > rootNode.data) {
                rootNode = rootNode.right;
            } else if (data < rootNode.data) {
                rootNode = rootNode.left;
            } else if (data == rootNode.data) {
                splay(rootNode);
                return rootNode;
            }
        }

        if (previousNode != null) {
            splay(previousNode);
            return null;
        }

        return null;
    }

    public void delete(int data) {

        Node node = searchNode(data);
        delete(node);
    }

    private void delete(Node node) {

        if (node == null) {
            return;
        }

        splay(node);

        if ((node.left != null) && (node.right != null)) {
            Node min = node.left;
            while (min.right != null) {
                min = min.right;
            }

            min.right = node.right;
            node.right.parent = min;
            node.left.parent = null;
            root = node.left;
        } else if (node.right != null) {
            node.right.parent = null;
            root = node.right;
        } else if (node.left != null) {
            node.left.parent = null;
            root = node.left;
        } else {
            root = null;
        }

        node.parent = null;
        node.left = null;
        node.right = null;
        node = null;

        count--;
    }        
    
    public boolean isEmpty() {
        return root == null;
    }
    
    public int count() {
        return count;
    }

    public void clear() {
        root = null;
        count = 0;
    }

    public enum TraversalOrder {
        PRE,
        IN,
        POST,
        LEVEL
    }

    public void print(TraversalOrder to) {

        if (isEmpty()) {
            System.out.println("empty");
            return;
        }

        switch (to) {
            // DFS
            case IN -> 
                printInOrder(root);        
            case PRE ->
                printPreOrder(root);
            case POST ->
                printPostOrder(root);
            // BFS
            case LEVEL ->
                printLevelOrder(root);              
        }
    }

    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(" " + node.data);
            printInOrder(node.right);
        }
    }

    private void printPreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.data);
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    private void printPostOrder(Node node) {
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(" " + node.data);
        }
    }

    private void printLevelOrder(Node node) {

        Queue<Node> queue = new ArrayDeque<>();

        queue.add(node);

        while (!queue.isEmpty()) {

            Node current = queue.poll();

            System.out.print(" " + current.data);

            if (current.left != null) {
                queue.add(current.left);
            }
            
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }
}