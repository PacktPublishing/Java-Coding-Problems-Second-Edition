package modern.challenge;

import java.util.ArrayDeque;
import java.util.Queue;

public class KdTree {

    private Node root;
    private Node found;
    private double foundDistance;
    private int visited;

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

        double theDistance(Node node) {

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

        Node targetNode = newNode(coords);

        visited = 0;
        foundDistance = 0;
        found = null;

        nearest(root, targetNode, 0);

        return found.coords.clone();
    }

    private void nearest(Node root, Node targetNode, int index) {

        if (root == null) {
            return;
        }

        visited++;
        double theDistance = root.theDistance(targetNode);

        if (found == null || theDistance < foundDistance) {
            foundDistance = theDistance;
            found = root;
        }

        if (foundDistance == 0) {
            return;
        }

        double rootTargetDistance = root.get(index) - targetNode.get(index);
        index = (index + 1) % 2;

        nearest(rootTargetDistance > 0 ? root.left : root.right, targetNode, index);

        if (rootTargetDistance * rootTargetDistance >= foundDistance) {
            return;
        }

        nearest(rootTargetDistance > 0 ? root.right : root.left, targetNode, index);
    }

    public double distance() {
        return Math.sqrt(foundDistance);
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
