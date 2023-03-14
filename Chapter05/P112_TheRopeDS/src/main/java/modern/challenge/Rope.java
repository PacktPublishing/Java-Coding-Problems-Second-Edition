package modern.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Rope {

    public static char indexAt(Node node, int index) {

        if (node == null) {
            throw new IllegalArgumentException("The given node cannot be null");
        }

        int len = getLength(node) - 1;

        if (index < 0 || index > len) {
            throw new IndexOutOfBoundsException("The given index cannot be negative or greater than " + len);
        }

        if (index > node.weight - 1) {
            return indexAt(node.right, index - node.weight);
        } else if (node.left != null) {
            return indexAt(node.left, index);
        } else {            
            return node.str.charAt(index);
        }
    }

    private static int getLength(Node node) {

        if (node.str != null) {
            return node.weight;
        } else {
            return getLength(node.left) + (node.right == null ? 0 : getLength(node.right));
        }
    }

    public static Node concat(Node node1, Node node2) {

        if (node1 == null || node2 == null) {
            throw new IllegalArgumentException("The given nodes cannot be null");
        }

        return new Node(node1, node2, getLength(node1));
    }

    public static List<Node> split(Node node, int index) {

        if (node == null) {
            throw new IllegalArgumentException("The given node cannot be null");
        }

        int len = getLength(node) - 1;

        if (index < 0 || index > len) {
            throw new IndexOutOfBoundsException("The given index cannot be negative or greater than " + len);
        }

        List<Node> ropesInit = new ArrayList<>();
        ropesInit.add(node);

        int position = index;

        while (true) {
            Node previous = ropesInit.get(ropesInit.size() - 1);

            if (previous == null) {
                return Arrays.asList(node);
            }

            if (position > previous.weight - 1) {
                position = position - previous.weight;
                ropesInit.add(previous.right);
            } else if (previous.left != null) {
                ropesInit.add(previous.left);
            } else {
                break;
            }
        }

        if (position > 0) {
            Node parentNode = ropesInit.get(ropesInit.size() - 1);

            Node nodeLeft = new Node(parentNode.str.substring(0, position));
            Node nodeRight = new Node(parentNode.str.substring(position));

            parentNode.str = null;
            parentNode.weight = position;
            parentNode.left = nodeLeft;
            parentNode.right = nodeRight;

            ropesInit.add(nodeRight);
        }

        List<Node> ropesConcat = new ArrayList<>();

        boolean goback = false;
        Node previousNode = ropesInit.get(ropesInit.size() - 1);
        while (!ropesInit.isEmpty()) {

            Node nextNode = ropesInit.remove(ropesInit.size() - 1);
            Node cutNode = null;
            if (goback) {
                if (nextNode.left == previousNode && nextNode.right != null) {
                    cutNode = nextNode.right;
                }
            } else if (nextNode.right == previousNode) {
                cutNode = previousNode;
                goback = true;
            }

            previousNode = nextNode;

            if (cutNode != null) {
                ropesConcat.add(cutNode);
                nextNode.right = null;

                for (int i = ropesInit.size() - 1; i >= 0; i--) {

                    if (ropesInit.get(i).left == nextNode) {
                        ropesInit.get(i).weight -= cutNode.weight;
                    }

                    nextNode = ropesInit.get(i);
                }
            }

        }

        List<Node> ropesResult = new ArrayList<>();
        ropesResult.add(node);

        Iterator<Node> iterator = ropesConcat.iterator();
        if (iterator.hasNext()) {

            Node concat = iterator.next();
            while (iterator.hasNext()) {
                concat = Rope.concat(concat, iterator.next());
            }

            ropesResult.add(concat);
        }

        return ropesResult;
    }

    public static Node insert(Node node, int index, String str) {

        if (node == null) {
            throw new IllegalArgumentException("The given node cannot be null");
        }

        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("The given string cannot be null or empty");
        }

        int len = getLength(node) - 1;

        if (index < 0 || index > len) {
            throw new IndexOutOfBoundsException("The given index cannot be negative or greater than " + len);
        }

        List<Node> splitRopes = Rope.split(node, index);
        Node insertNode = new Node(null, null, str.length(), str);
        Node resultNode;

        if (splitRopes.size() == 1) {
            if (index == 0) {
                resultNode = Rope.concat(insertNode, splitRopes.get(0));
            } else {
                resultNode = Rope.concat(splitRopes.get(0), insertNode);
            }
        } else {                          
            resultNode = Rope.concat(splitRopes.get(0), insertNode);
            resultNode = Rope.concat(resultNode, splitRopes.get(1));
        }

        return resultNode;
    }

    public static Node delete(Node node, int start, int end) {

        if (node == null) {
            throw new IllegalArgumentException("The given node cannot be null");
        }

        int len = getLength(node) - 1;

        if (start < 0 || start > len) {
            throw new IndexOutOfBoundsException("The given start cannot be negative or greater than " + len);
        }
        
        if (end < 0 || end > len) {
            throw new IndexOutOfBoundsException("The end index cannot be negative or greater than " + len);
        }
        
        if (start >= end) {
            throw new IndexOutOfBoundsException("The given start cannot >= than the given end");
        }

        Node beforeNode = null;
        Node afterNode;

        List<Node> splitRopes1 = Rope.split(node, start);

        if (splitRopes1.size() == 1) {
            afterNode = splitRopes1.get(0);
        } else {
            beforeNode = splitRopes1.get(0);
            afterNode = splitRopes1.get(1);
        }

        List<Node> splitRopes2 = Rope.split(afterNode, end - start);
        if (splitRopes2.size() == 1) {
            return beforeNode;
        }

        return beforeNode == null ? splitRopes2.get(1) : Rope.concat(beforeNode, splitRopes2.get(1));
    }

    public static class Node {

        private Node left;
        private Node right;

        private int weight;
        private String str;

        public Node(String str) {
            this(null, null, str.length(), str);
        }

        public Node(Node left, Node right, int weight) {
            this(left, right, weight, null);
        }

        public Node(Node left, Node right, int weight, String str) {
            this.left = left;
            this.right = right;
            this.str = str;
            this.weight = weight;
        }

        public String buildStr() {

            StringBuilder treeString = new StringBuilder();
            buildStr(this, treeString);

            return treeString.toString();
        }
    
        private static void buildStr(Node node, StringBuilder treeString) {                       

            if (node.str != null) {
                treeString.append(node.str);
            } else {
                buildStr(node.left, treeString);
                if (node.right != null) {
                    buildStr(node.right, treeString);
                }
            }
        }

        @Override
        public boolean equals(Object obj) {

            if (obj == this) {
                return true;
            }

            if (obj instanceof Node that) {
                return Objects.equals(str, that.str) && Objects.equals(left, that.left) && Objects
                        .equals(right, that.right) && Objects.equals(weight, that.weight);
            }

            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, right, weight, str);
        }

        @Override
        public String toString() {

            StringBuilder treeString = new StringBuilder();
            treeRope(this, treeString, 0);

            return treeString.toString();
        }

        private static void treeRope(Node node, StringBuilder treeString, int deep) {

            if (node == null) {
                treeString.append("null");
                return;
            }

            String padding = "    ".repeat(deep);
            treeString.append("{\n");
            treeString.append(padding).append("  weight: ").append(node.weight).append(", \n");

            treeString.append(padding).append("  left: ");
            treeRope(node.left, treeString, deep + 1);
            treeString.append(", \n");

            treeString.append(padding).append("  right: ");
            treeRope(node.right, treeString, deep + 1);
            treeString.append(", \n");
            treeString.append(padding).append("  str: ").append(node.str);
        }
    }
}
