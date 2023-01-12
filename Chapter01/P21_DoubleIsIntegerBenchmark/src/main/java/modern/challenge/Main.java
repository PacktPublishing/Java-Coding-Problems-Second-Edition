package modern.challenge;

import com.google.common.math.DoubleMath;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Fork(value = 1, warmups = 0)
@Measurement(iterations = 10, time = 1)
@State(Scope.Benchmark)
public class Main {

    @Param({"23.11", "23"})
    private double v;

    @Benchmark
    public boolean isDoubleIntegerV1() {

        return v == (int) v;
    }

    @Benchmark
    public boolean isDoubleIntegerV2() {

        return v % 1 == 0;
    }

    @Benchmark
    public boolean isDoubleIntegerV3() {

        return ((Math.floor(v) == v) && Double.isFinite(v));
    }

    @Benchmark
    public boolean isDoubleIntegerV4() {

        return (Math.floor(v) == Math.ceil(v) && Double.isFinite(v));
    }

    @Benchmark
    public boolean isDoubleIntegerV5() {

        return ((Math.rint(v) == v) && Double.isFinite(v));
    }

    @Benchmark
    public boolean isDoubleIntegerV6() {

        return DoubleMath.isMathematicalInteger(v);
    }

    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(args);
    }
}