package modern.challenge;

import java.util.Arrays;
import jdk.incubator.vector.IntVector;
import jdk.incubator.vector.VectorMask;
import jdk.incubator.vector.VectorSpecies;

public class Main {

    private static final VectorSpecies<Integer> VS256 = IntVector.SPECIES_256;

    public static void sum(int x[], int y[], int z[]) {

        int upperBound = VS256.loopBound(x.length);
        for (int i = 0; i < upperBound; i += VS256.length()) {

            IntVector xVector = IntVector.fromArray(VS256, x, i);
            IntVector yVector = IntVector.fromArray(VS256, y, i);
            IntVector zVector = xVector.add(yVector);

            zVector.intoArray(z, i);
        }
    }

    public static void sumMask(int x[], int y[], int z[]) {

        int upperBound = VS256.loopBound(x.length);
        int i = 0;
        for (; i < upperBound; i += VS256.length()) {

            IntVector xVector = IntVector.fromArray(VS256, x, i);
            IntVector yVector = IntVector.fromArray(VS256, y, i);
            IntVector zVector = xVector.add(yVector);

            zVector.intoArray(z, i);
        }

        if (i <= (x.length - 1)) {            
            VectorMask<Integer> mask = VS256.indexInRange(i, x.length);

            IntVector zVector = IntVector.fromArray(VS256, x, i, mask)
                    .add(IntVector.fromArray(VS256, y, i, mask));

            zVector.intoArray(z, i, mask);
        }
    }

    public static void sumPlus(int x[], int y[], int z[]) {

        int upperBound = VS256.loopBound(x.length);
        int i = 0;
        for (; i < upperBound; i += VS256.length()) {

            IntVector xVector = IntVector.fromArray(VS256, x, i);
            IntVector yVector = IntVector.fromArray(VS256, y, i);
            IntVector zVector = xVector.add(yVector);

            zVector.intoArray(z, i);
        }

        for (; i < x.length; i++) {
            z[i] = x[i] + y[i];
        }
    }

    public static void main(String[] args) {

        int[] x = new int[]{3, 6, 5, 5, 1, 2, 3, 4, 5, 6, 7, 8, 3, 6, 5, 5, 1, 2, 3, 4, 5, 6, 7, 8, 3, 6, 5, 5, 1, 2, 3, 4, 3, 4};
        int[] y = new int[]{4, 5, 2, 5, 1, 3, 8, 7, 1, 6, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 3, 6, 5, 5, 1, 2, 3, 4, 5, 6, 7, 8, 2, 8};

        int[] z = new int[x.length];
        sum(x, y, z);
        System.out.println("Result: " + Arrays.toString(z));

        z = new int[x.length];
        sumMask(x, y, z);
        System.out.println("Result: " + Arrays.toString(z));

        z = new int[x.length];
        sumPlus(x, y, z);
        System.out.println("Result: " + Arrays.toString(z));
    }
}
