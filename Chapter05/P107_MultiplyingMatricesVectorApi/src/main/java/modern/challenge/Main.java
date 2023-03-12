package modern.challenge;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import jdk.incubator.vector.FloatVector;
import jdk.incubator.vector.VectorSpecies;

public class Main {

    private static final VectorSpecies<Float> VS = FloatVector.SPECIES_PREFERRED;

    public static float[] mulMatrix(float[] x, float[] y, int size) {

        final int upperBound = VS.loopBound(size);
        float[] z = new float[size * size];

        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                float elem = x[i * size + k];
                FloatVector eVector = FloatVector.broadcast(VS, elem);
                for (int j = 0; j < upperBound; j += VS.length()) {
                    FloatVector yVector = FloatVector.fromArray(VS, y, k * size + j);
                    FloatVector zVector = FloatVector.fromArray(VS, z, i * size + j);
                    zVector = eVector.fma(yVector, zVector);
                    zVector.intoArray(z, i * size + j);
                }
            }
        }

        return z;
    }

    private static final VectorSpecies<Float> VS_512 = FloatVector.SPECIES_512;

    public static float[] mulMatrixAVX512(float[] x, float[] y, int size) {

        float[] z = new float[size * size];
        final int blockWidth = size >= 256 ? 512 : 256;
        final int blockHeight = size >= 512 ? 8 : size >= 256 ? 16 : 32;

        for (int rowOffset = 0; rowOffset < size; rowOffset += blockHeight) {
            for (int columnOffset = 0; columnOffset < size; columnOffset += blockWidth) {
                for (int i = 0; i < size; i++) {
                    for (int j = columnOffset; j < columnOffset + blockWidth && j < size; j += VS_512.length()) {
                        FloatVector sum = FloatVector.fromArray(VS_512, z, i * size + j);
                        for (int k = rowOffset; k < rowOffset + blockHeight && k < size; k++) {
                            FloatVector multiplier = FloatVector.broadcast(VS_512, x[i * size + k]);
                            sum = multiplier.fma(FloatVector.fromArray(VS_512, y, k * size + j), sum);
                        }
                        sum.intoArray(z, i * size + j);
                    }
                }
            }
        }

        return z;
    }

    public static void main(String[] args) {

        // EXAMPLE 1   
        //                 | 1 2 5 4 |   | 3 4 1 8 |   | 62  74  82  69  |
        //                 | 5 4 3 7 |   | 7 4 9 9 |   | 93  110 111 134 |
        //   x * y = z,    | 2 2 6 2 | * | 5 6 7 3 | = | 60  68  76  66  |
        //                 | 4 1 2 5 |   | 5 8 7 7 |   | 54  72  62  82  |
        
        float[] x = new float[]{1, 2, 5, 4, 5, 4, 3, 7, 2, 2, 6, 2, 4, 1, 2, 5};
        float[] y = new float[]{3, 4, 1, 8, 7, 4, 9, 9, 5, 6, 7, 3, 5, 8, 7, 7};

        float[] z = mulMatrix(x, y, 4);

        System.out.println(Arrays.toString(z));

        // EXAMPLE 2
        System.out.println("\nPlease, be patient, this will take a while ...");

        float[] x65536 = new float[256 * 256];
        float[] y65536 = new float[256 * 256];
        for (int i = 0; i < 256 * 256; i++) {
            x65536[i] = ThreadLocalRandom.current().nextFloat();
            y65536[i] = ThreadLocalRandom.current().nextFloat();
        }

        float[] z65536 = mulMatrixAVX512(x65536, y65536, 256);

        System.out.println(Arrays.toString(z65536));
    }
}