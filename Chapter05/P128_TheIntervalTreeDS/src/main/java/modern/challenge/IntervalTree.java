package modern.challenge;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IntervalTree {

    private Node root;

    public static final class Interval {

        private final int min, max;

        public Interval(int min, int max) {
            this.min = min;
            this.max = max;
        }

        private boolean overlaps(Interval thiz) {

            if (thiz.max < this.min) {
                return false;
            }

            return this.max >= thiz.min;
        }

        private int compareTo(Interval thiz) {

            if (this.min < thiz.min) {
                return -1;
            } else if (this.min > thiz.min) {
                return 1;
            } else if (this.max < thiz.max) {
                return -1;
            } else if (this.max > thiz.max) {
                return 1;
            } else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return "[" + min + ", " + max + "]";
        }
    }

    private final class Node {

        private final Interval interval;
        private final Integer maxInterval;

        private Node left;
        private Node right;

        private int size;
        private int maxSubstree;

        Node(Interval interval, Integer maxInterval) {

            this.interval = interval;
            this.maxInterval = maxInterval;

            this.size = 1;
            this.maxSubstree = interval.max;
        }
    }

    public void insert(Interval interval) {
        root = insert(root, interval);
    }

    private Node insert(Node root, Interval interval) {

        if (root == null) {
            return new Node(interval, interval.max);
        }

        if (interval.min < root.interval.min) {
            root.left = insert(root.left, interval);
        } else {
            root.right = insert(root.right, interval);
        }

        if (root.maxSubstree < interval.max) {
            root.maxSubstree = interval.max;
        }

        return root;
    }

    public boolean contains(Interval interval) {

        return (get(root, interval) != null);
    }

    public Integer get(Interval interval) {

        return get(root, interval);
    }

    private Integer get(Node node, Interval interval) {

        if (node == null) {
            return null;
        }

        int result = interval.compareTo(node.interval);

        if (result < 0) {
            return get(node.left, interval);
        } else if (result > 0) {
            return get(node.right, interval);
        } else {
            return node.maxInterval;
        }
    }

    public Integer delete(Interval interval) {

        Integer maxInterval = get(interval);
        root = delete(root, interval);

        return maxInterval;
    }

    private Node delete(Node node, Interval interval) {

        if (node == null) {
            return null;
        }

        int result = interval.compareTo(node.interval);
        if (result < 0) {
            node.left = delete(node.left, interval);
        } else if (result > 0) {
            node.right = delete(node.right, interval);
        } else {
            node = joinLeftRight(node.left, node.right);
        }

        fixSizeMax(node);

        return node;
    }

    public Interval search(Interval interval) {
        return search(root, interval);
    }

    private Interval search(Node node, Interval interval) {

        while (node != null) {
            if (interval.overlaps(node.interval)) {
                return node.interval;
            } else if (node.left == null) {
                node = node.right;
            } else if (node.left.maxSubstree < interval.min) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        return null;
    }

    public List<Interval> searchAll(Interval interval) {

        List<Interval> intervals = new LinkedList<>();

        searchAll(root, interval, intervals);

        return intervals;
    }

    private boolean searchAll(Node node, Interval interval, List<Interval> intervals) {

        boolean search1 = false;
        boolean search2 = false;
        boolean search3 = false;

        if (node == null) {
            return false;
        }

        if (interval.overlaps(node.interval)) {
            intervals.add(node.interval);
            search1 = true;
        }

        if (node.left != null && node.left.maxSubstree >= interval.min) {
            search2 = searchAll(node.left, interval, intervals);
        }

        if (search2 || node.left == null || node.left.maxSubstree < interval.min) {
            search3 = searchAll(node.right, interval, intervals);
        }

        return search1 || search2 || search3;
    }

    public int size() {

        return size(root);
    }

    private int size(Node node) {

        if (node == null) {
            return 0;
        } else {
            return node.size;
        }
    }

    public int height() {

        return height(root);
    }

    private int height(Node node) {

        if (node == null) {
            return 0;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }

    private void fixSizeMax(Node node) {

        if (node == null) {
            return;
        }

        node.size = size(node.left) + size(node.right) + 1;
        node.maxSubstree = Math.max(node.interval.max, Math.max(max(node.left), max(node.right)));
    }

    private int max(Node node) {

        if (node == null) {
            return Integer.MIN_VALUE;
        }

        return node.maxSubstree;
    }

    private Node joinLeftRight(Node leftNode, Node rightNode) {

        if (leftNode == null) {
            return rightNode;
        }
        if (rightNode == null) {
            return leftNode;
        }

        if (Math.random() * (size(leftNode) + size(rightNode)) < size(leftNode)) {
            leftNode.right = joinLeftRight(leftNode.right, rightNode);

            fixSizeMax(leftNode);

            return leftNode;
        } else {
            rightNode.left = joinLeftRight(leftNode, rightNode.left);

            fixSizeMax(rightNode);

            return rightNode;
        }
    }

    public enum TraversalOrder {
        PRE,
        IN,
        POST,
        LEVEL
    }

    public void print(TraversalOrder to) {

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
            System.out.print(" " + node.interval);
            printInOrder(node.right);
        }
    }

    private void printPreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.interval);
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    private void printPostOrder(Node node) {
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(" " + node.interval);
        }
    }

    private void printLevelOrder(Node node) {

        Queue<Node> queue = new ArrayDeque<>();

        queue.add(node);

        while (!queue.isEmpty()) {

            Node current = queue.poll();

            System.out.print(" " + current.interval);

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }
}