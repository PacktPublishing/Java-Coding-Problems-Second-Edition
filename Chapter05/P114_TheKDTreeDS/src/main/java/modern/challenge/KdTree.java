package modern.challenge;

import java.util.ArrayDeque;
import java.util.Queue;

public class KdTree {

    private Node root;
    private Node suitable;
    private double suitableDistance;
    private int marked;

    private final class Node {

        private final double[] coords;

        private Node left;
        private Node right;

        public Node(double[] coords) {
            this.coords = coords;
        }

        double get(int index) {
            return coords[index];
        }

        double thisDistance(Node node) {

            double distTotal = 0;
            for (int i = 0; i < coords.length; ++i) {
                double dist = coords[i] - node.coords[i];
                distTotal += dist * dist;
            }

            return distTotal;
        }

        @Override
        public String toString() {

            StringBuilder sb = new StringBuilder("(");
            for (int i = 0; i < coords.length; ++i) {

                if (i > 0) {
                    sb.append(", ");
                }

                sb.append(coords[i]);
            }

            sb.append(')');

            return sb.toString();
        }
    }

    public void insert(double[] coords) {
        root = insert(root, coords, 0);
    }

    private Node insert(Node root, double[] coords, int depth) {

        if (root == null) {
            return newNode(coords);
        }

        int cd = depth % 2;
        if (coords[cd] < root.coords[cd]) {
            root.left
                    = insert(root.left, coords, depth + 1);
        } else {
            root.right
                    = insert(root.right, coords, depth + 1);
        }

        return root;
    }

    public double[] findNearest(double[] coords) {

        if (root == null) {
            throw new IllegalStateException("The tree is empty (cannot find the root)");
        }

        Node dest = newNode(coords);

        marked = 0;
        suitableDistance = 0;
        suitable = null;

        nearest(root, dest, 0);

        return suitable.coords.clone();
    }

    private void nearest(Node root, Node dest, int index) {

        if (root == null) {
            return;
        }

        marked++;
        double thisDistance = root.thisDistance(dest);

        if (suitable == null || thisDistance < suitableDistance) {
            suitableDistance = thisDistance;
            suitable = root;
        }

        if (suitableDistance == 0) {
            return;
        }

        double rootDestDistance = root.get(index) - dest.get(index);
        index = (index + 1) % 2;

        nearest(rootDestDistance > 0 ? root.left : root.right, dest, index);

        if (rootDestDistance * rootDestDistance >= suitableDistance) {
            return;
        }

        nearest(rootDestDistance > 0 ? root.right : root.left, dest, index);
    }

    public double distance() {
        return Math.sqrt(suitableDistance);
    }

    public void printLevelOrder() {

        Queue<Node> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            Node current = queue.poll();

            System.out.print(" " + current);

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    private Node newNode(double[] coords) {
        return new Node(coords);
    }
}
