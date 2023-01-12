package modern.challenge;

import dnl.utils.text.table.TextTable;
import java.util.Comparator;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Stream<RandomGeneratorFactory<RandomGenerator>> all = RandomGeneratorFactory.all();

        Object[][] data = all.sorted(Comparator.comparing(RandomGeneratorFactory::group))
                .map(f -> {
                    Object[] obj = new Object[]{
                        f.name(),
                        f.group(),
                        f.isArbitrarilyJumpable(),
                        f.isDeprecated(),
                        f.isHardware(),
                        f.isJumpable(),
                        f.isLeapable(),
                        f.isSplittable(),
                        f.isStatistical(),
                        f.isStochastic(),
                        f.isStreamable()
                    };
                    return obj;
                }).toArray(Object[][]::new);

        String[] columns = new String[]{"Name", "Group", "Ar. Jumpable",
            "Deprecated", "Hardware", "Jumpable", "Leapable", "Splittable",
            "Statistical", "Stochastic", "Streamable"};

        TextTable tt = new TextTable(columns, data);
        tt.printTable();
    }
}
