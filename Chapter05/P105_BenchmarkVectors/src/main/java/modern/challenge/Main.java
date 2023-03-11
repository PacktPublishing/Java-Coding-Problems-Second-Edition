package modern.challenge;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import jdk.incubator.vector.IntVector;
import jdk.incubator.vector.VectorMask;
import jdk.incubator.vector.VectorSpecies;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode({Mode.AverageTime, Mode.Throughput})
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 1)
@State(Scope.Benchmark)
@Fork(value = 1, warmups = 0, jvmArgsPrepend = {"--add-modules=jdk.incubator.vector"})
public class Main {

    private static final VectorSpecies<Integer> VS = IntVector.SPECIES_PREFERRED;

    @Param("50000000")
    int length;

    int[] x;
    int[] y;
    int[] z;
    int[] w;
    int[] k;

    @Setup
    public void init() {

        x = new int[length];
        y = new int[length];
        z = new int[length];
        w = new int[length];
        k = new int[length];

        for (int i = 0; i < x.length; i++) {
            x[i] = ThreadLocalRandom.current().nextInt();
            y[i] = ThreadLocalRandom.current().nextInt();
            z[i] = ThreadLocalRandom.current().nextInt();
        }
    }

    @Benchmark
    public void computeWithMask(Blackhole blackhole) {

        int upperBound = VS.loopBound(x.length);
        int i = 0;
        for (; i < upperBound; i += VS.length()) {

            IntVector xVector = IntVector.fromArray(VS, x, i);
            IntVector yVector = IntVector.fromArray(VS, y, i);
            IntVector zVector = xVector.add(yVector);
            IntVector wVector = xVector.mul(zVector).mul(yVector);
            IntVector kVector = zVector.add((wVector).mul(yVector));

            kVector.intoArray(k, i);
        }

        if (i <= (x.length - 1)) {
            VectorMask<Integer> mask = VS.indexInRange(i, x.length);

            IntVector xVector = IntVector.fromArray(VS, x, i, mask);
            IntVector yVector = IntVector.fromArray(VS, y, i, mask);
            IntVector zVector = xVector.add(yVector);
            IntVector wVector = xVector.mul(zVector).mul(yVector);
            IntVector kVector = zVector.add((wVector).mul(yVector));

            kVector.intoArray(k, i, mask);
        }

        blackhole.consume(k);
    }

    @Benchmark
    public void computeNoMask(Blackhole blackhole) {

        int upperBound = VS.loopBound(x.length);

        int i = 0;
        for (; i < upperBound; i += VS.length()) {

            IntVector xVector = IntVector.fromArray(VS, x, i);
            IntVector yVector = IntVector.fromArray(VS, y, i);
            IntVector zVector = xVector.add(yVector);
            IntVector wVector = xVector.mul(zVector).mul(yVector);
            IntVector kVector = zVector.add((wVector).mul(yVector));

            kVector.intoArray(k, i);
        }

        for (; i < x.length; i++) {
            z[i] = x[i] + y[i];
            w[i] = x[i] * z[i] * y[i];
            k[i] = z[i] + w[i] * y[i];
        }

        blackhole.consume(k);
    }

    @Benchmark
    public void computeUnrolledNoMask(Blackhole blackhole) {

        int width = VS.length();
        int i = 0;

        for (; i <= (x.length - width * 4); i += width * 4) {

            IntVector zVector1 = IntVector.fromArray(VS, x, i)
                    .add(IntVector.fromArray(VS, y, i));
            IntVector zVector2 = IntVector.fromArray(VS, x, i + width)
                    .add(IntVector.fromArray(VS, y, i + width));
            IntVector zVector3 = IntVector.fromArray(VS, x, i + width * 2)
                    .add(IntVector.fromArray(VS, y, i + width * 2));
            IntVector zVector4 = IntVector.fromArray(VS, x, i + width * 3)
                    .add(IntVector.fromArray(VS, y, i + width * 3));

            IntVector wVector1 = IntVector.fromArray(VS, x, i).mul(zVector1).mul(IntVector.fromArray(VS, y, i));
            IntVector wVector2 = IntVector.fromArray(VS, x, i + width).mul(zVector2).mul(IntVector.fromArray(VS, y, i + width));
            IntVector wVector3 = IntVector.fromArray(VS, x, i + width * 2).mul(zVector3).mul(IntVector.fromArray(VS, y, i + width * 2));
            IntVector wVector4 = IntVector.fromArray(VS, x, i + width * 3).mul(zVector4).mul(IntVector.fromArray(VS, y, i + width * 3));

            IntVector kVector1 = zVector1.add((wVector1).mul(IntVector.fromArray(VS, y, i)));
            IntVector kVector2 = zVector2.add((wVector2).mul(IntVector.fromArray(VS, y, i + width)));
            IntVector kVector3 = zVector3.add((wVector3).mul(IntVector.fromArray(VS, y, i + width * 2)));
            IntVector kVector4 = zVector4.add((wVector4).mul(IntVector.fromArray(VS, y, i + width * 3)));

            kVector1.intoArray(k, i);
            kVector2.intoArray(k, i + width);
            kVector3.intoArray(k, i + width * 2);
            kVector4.intoArray(k, i + width * 3);
        }

        for (; i < x.length; i++) {
            z[i] = x[i] + y[i];
            w[i] = x[i] * z[i] * y[i];
            k[i] = z[i] + w[i] * y[i];
        }

        blackhole.consume(k);
    }

    @Benchmark
    public void computeArrays(Blackhole blackhole) {

        for (int i = 0; i < x.length; i++) {
            z[i] = x[i] + y[i];
            w[i] = x[i] * z[i] * y[i];
            k[i] = z[i] + w[i] * y[i];
        }

        blackhole.consume(k);
    }

    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(args);
    }
}
