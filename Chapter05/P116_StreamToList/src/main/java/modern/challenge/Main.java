package modern.challenge;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        // JDK 8
        List<File> roots8 = Stream.of(File.listRoots()).collect(Collectors.toList());

        // JDK 10
        List<File> roots10 = Stream.of(File.listRoots()).collect(Collectors.toUnmodifiableList());

        // JDK 16
        List<File> roots16 = Stream.of(File.listRoots()).toList();

        MelonMarket mm1 = new MelonMarket(
                List.of(
                        new MelonRecord("Gac", 1600),
                        new MelonRecord("Hami", 2000),
                        new MelonRecord("Cantaloupe", 3000)
                )
        );

        MelonMarket mm2 = new MelonMarket(
                List.of(
                        new MelonRecord("Muskmelon", 6000),
                        new MelonRecord("Honeydew", 2000)
                )
        );

        List<MelonMarket> mm = List.of(mm1, mm2);

        // JDK 8
        List<MelonRecord> melons8 = mm.stream()
                .flatMap(m -> m.melons().stream())
                .collect(Collectors.toList());
        
        // JDK 10
        List<MelonRecord> melons10 = mm.stream()
                .flatMap(m -> m.melons().stream())
                .collect(Collectors.toUnmodifiableList());
        
        // JDK 16        
        List<MelonRecord> melons16 = mm.stream()
                .flatMap(m -> m.melons().stream())
                .toList();                
    }
}