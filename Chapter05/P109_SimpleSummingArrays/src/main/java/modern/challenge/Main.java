package modern.challenge;

import jdk.incubator.vector.IntVector;

public class Main {
   
    public static void main(String[] args) {
        
        int[] x = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int[] y = new int[]{4, 5, 2, 5, 1, 3, 8, 7};

        IntVector xVector = IntVector.fromArray(IntVector.SPECIES_256, x, 0);
        IntVector yVector = IntVector.fromArray(IntVector.SPECIES_256, y, 0);

        IntVector zVector = xVector.add(yVector);

        System.out.println(zVector); // [5, 7, 5, 9, 6, 9, 15, 15]
    }
}
