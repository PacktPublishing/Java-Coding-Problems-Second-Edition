package modern.challenge;

import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.infra.Blackhole;

@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Fork(value = 1, warmups = 0)
public class Main {

    @Benchmark
    public void messageFormat(Blackhole blackhole) {

        String txt = MessageFormat.format(
                """
                Sweet {0} of {1} and of {2},
                delightful {3} of {4} wantonness,
                {5} in {6} and in beauty {7}
                and in {8} virtue {9} hold {10} dear ...
                """, "rose", "virtue", "gentleness", "lily", "youthful", "richest", "bounty", "clear", "every", "men", "most"
        );

        blackhole.consume(txt);
    }

    @Benchmark
    public void stringFormat(Blackhole blackhole) {

        String txt = String.format(
                """
                Sweet %s of %s and of %s,
                delightful %s of %s wantonness,
                %s in %s and in beauty %s
                and in %s virtue %s hold %s dear ...
                """, "rose", "virtue", "gentleness", "lily", "youthful", "richest", "bounty", "clear", "every", "men", "most"
        );

        blackhole.consume(txt);
    }

    @Benchmark
    public void stringFormatted(Blackhole blackhole) {

        String txt = """
                     Sweet %s of %s and of %s,
                     delightful %s of %s wantonness,
                     %s in %s and in beauty %s
                     and in %s virtue %s hold %s dear ...
                     """.formatted("rose", "virtue", "gentleness", "lily", "youthful", "richest", "bounty", "clear", "every", "men", "most");

        blackhole.consume(txt);
    }

    @Benchmark
    public void concatenation(Blackhole blackhole) {

        String txt = """
                     Sweet""" + " rose "
                + """
                     of""" + " virtue "
                + """
                     and of""" + " gentleness "
                + """                     
                     delightful""" + " lily "
                + """                     
                     of""" + " youthful "
                + """
                     wantonness,""" + " richest "
                + """
                     in""" + " bounty "
                + """
                     and in beauty""" + " clear "
                + """
                     and in""" + " every "
                + """
                     virtue""" + " men "
                + """
                     hold""" + " most "
                + """
                     dear ...""";

        blackhole.consume(txt);
    }

    @Benchmark
    public void stringBuilder(Blackhole blackhole) {

        StringBuilder sb = new StringBuilder();

        String txt = sb.append("""
                  Sweet""")
                .append(" rose ")
                .append("""
                        of""")
                .append(" virtue ")
                .append("""
                        and of""")
                .append(" gentleness ")
                .append("""
                        delightful""")
                .append(" lily ")
                .append("""
                        of""")
                .append(" youthful ")
                .append("""
                        wantonness,""")
                .append(" richest ")
                .append("""
                        in""")
                .append(" bounty ")
                .append("""
                        and in beauty""")
                .append(" clear ")
                .append("""
                        and in""")
                .append(" every ")
                .append("""
                        virtue""")
                .append(" men ")
                .append("""
                        hold""")
                .append(" most ")
                .append("""
                        dear ...""").toString();

        blackhole.consume(txt);
        blackhole.consume(sb);
    }

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}
