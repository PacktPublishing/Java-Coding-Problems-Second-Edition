package modern.challenge;

import jdk.incubator.vector.FloatVector;
import jdk.incubator.vector.VectorMask;
import jdk.incubator.vector.VectorOperators;
import jdk.incubator.vector.VectorSpecies;

public class Main {

    private static final VectorSpecies<Float> VS = FloatVector.SPECIES_PREFERRED;

    public static float vectorFma(float[] x, float[] y) {

        int upperBound = VS.loopBound(x.length);
        FloatVector sum = FloatVector.zero(VS);
        int i = 0;
        for (; i < upperBound; i += VS.length()) {

            FloatVector xVector = FloatVector.fromArray(VS, x, i);
            FloatVector yVector = FloatVector.fromArray(VS, y, i);
            sum = xVector.fma(yVector, sum); //  sum = xVector.mul(yVector).add(sum)
        }

        if (i <= (x.length - 1)) {
            VectorMask<Float> mask = VS.indexInRange(i, x.length);

            FloatVector xVector = FloatVector.fromArray(VS, x, i, mask);
            FloatVector yVector = FloatVector.fromArray(VS, y, i, mask);
            sum = xVector.fma(yVector, sum);
        }

        float result = sum.reduceLanes(VectorOperators.ADD);

        return result;
    }

    public static void main(String[] args) {

        float[] x = new float[]{1f, 2f, 3f, 5f, 1f, 8f};
        float[] y = new float[]{4f, 5f, 2f, 8f, 5f, 4f};

        float result = vectorFma(x, y);

        System.out.println("Fma result: " + result);
    }
}