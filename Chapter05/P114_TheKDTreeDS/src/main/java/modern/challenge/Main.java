package modern.challenge;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        double[][] coords = {
            {3, 5}, {1, 4}, {5, 4}, {2, 3}, {4, 2}, {3, 2}, {5, 2}, {2, 1}, {2, 4}, {2, 5}
        };
System.out.println(Arrays.toString(coords[0]));
        KdTree kd = new KdTree();

        for (double[] coord : coords) {
            System.out.println("Insert: " + Arrays.toString(coord));
            kd.insert(coord);
        }

        System.out.println("\nNearest (4, 4): " 
                + Arrays.toString(kd.findNearest(new double[]{4, 4})));

        System.out.println("\nTree (level order):");
        kd.printLevelOrder();
    }
}
