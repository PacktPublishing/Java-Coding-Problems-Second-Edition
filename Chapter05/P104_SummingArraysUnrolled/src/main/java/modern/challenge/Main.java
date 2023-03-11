package modern.challenge;

import java.util.Arrays;
import jdk.incubator.vector.IntVector;
import jdk.incubator.vector.VectorSpecies;

public class Main {

    private static final VectorSpecies<Integer> VS256 = IntVector.SPECIES_256;

    public static void sumUnrolled(int x[], int y[], int z[]) {

        int width = VS256.length();
        int i = 0;
        for (; i <= (x.length - width * 4); i += width * 4) {

            IntVector s1 = IntVector.fromArray(VS256, x, i)
                    .add(IntVector.fromArray(VS256, y, i));
            IntVector s2 = IntVector.fromArray(VS256, x, i + width)
                    .add(IntVector.fromArray(VS256, y, i + width));
            IntVector s3 = IntVector.fromArray(VS256, x, i + width * 2)
                    .add(IntVector.fromArray(VS256, y, i + width * 2));
            IntVector s4 = IntVector.fromArray(VS256, x, i + width * 3)
                    .add(IntVector.fromArray(VS256, y, i + width * 3));

            s1.intoArray(z, i);
            s2.intoArray(z, i + width);
            s3.intoArray(z, i + width * 2);
            s4.intoArray(z, i + width * 3);
        }

        for (; i < x.length; i++) {
            z[i] = x[i] + y[i];
        }
    }

    public static void main(String[] args) {

        int[] x = new int[]{3, 6, 5, 5, 1, 2, 3, 4, 5, 6, 7, 8, 3, 6, 5, 5, 1, 2, 3, 4, 5, 6, 7, 8, 3, 6, 5, 5, 1, 2, 3, 4, 3, 4};
        int[] y = new int[]{4, 5, 2, 5, 1, 3, 8, 7, 1, 6, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 3, 6, 5, 5, 1, 2, 3, 4, 5, 6, 7, 8, 2, 8};
        int[] z = new int[x.length];

        sumUnrolled(x, y, z);
        System.out.println("Result: " + Arrays.toString(z));
    }
}
