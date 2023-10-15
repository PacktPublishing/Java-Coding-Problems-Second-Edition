package modern.challenge;

import java.util.List;
import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {

        List<Integer> integers = List.of(3, 2, 5, 6, 7, 8);

        List<Integer> evenDoubledClassic = integers.stream()
                .filter(i -> i % 2 == 0)
                .map(i -> i * 2)
                .collect(toList());
        System.out.println(evenDoubledClassic);

        List<Integer> evenDoubledMM1 = integers.stream()
                .<Integer>mapMulti((i, consumer) -> {
                    if (i % 2 == 0) {
                        consumer.accept(i * 2);
                    }
                })
                .collect(toList());
        System.out.println(evenDoubledMM1);

        List<Integer> evenDoubledMM2 = integers.stream()
                .mapMultiToInt((i, consumer) -> {
                    if (i % 2 == 0) {
                        consumer.accept(i * 2);
                    }
                })
                .mapToObj(i -> i) // or, .boxed()
                .collect(toList());
        System.out.println(evenDoubledMM2);

        int evenDoubledAndSumMM = integers.stream()
                .mapMultiToInt((i, consumer) -> {
                    if (i % 2 == 0) {
                        consumer.accept(i * 2);
                    }
                })
                .sum();

        System.out.println(evenDoubledAndSumMM);
    }
}