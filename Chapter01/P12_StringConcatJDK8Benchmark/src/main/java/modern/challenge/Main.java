package modern.challenge;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Fork(value = 1, warmups = 0)
@Measurement(iterations = 90, time = 1)
@State(Scope.Benchmark)
public class Main {
    
    private static String str1;
    private static String str2;
    private static String str3;
    private static String str4;
    
    private static List<String> strs;

    @Setup
    public static void setup() {
        
        str1 = "hello";
        str2 = "my";
        str3 = "dear";
        str4 = "friend";                
        
        strs = Arrays.asList("hello", "my", "dear", "friend");                
    }
    
    @Benchmark
    public static String concatViaPlus() {

        return str1 + str2 + str3 + str4;
    }

    @Benchmark
    public static String concatViaStringBuilder() {

        StringBuilder sb = new StringBuilder();

        sb.append(str1)
                .append(str2)
                .append(str3)
                .append(str4);

        return sb.toString();
    }

    @Benchmark
    public static String concatListViaPlus() {

        String result = "";
        for (String str : strs) {
            result = result + str;
        }

        return result;
    }

    @Benchmark
    public static String concatListViaStringBuilder() {

        StringBuilder result = new StringBuilder();

        for (String str : strs) {
            result.append(str);
        }

        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(args);                
    }
}
