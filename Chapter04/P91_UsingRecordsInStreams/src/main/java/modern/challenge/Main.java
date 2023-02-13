package modern.challenge;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.summingDouble;
import static java.util.stream.Collectors.toList;
import java.util.stream.DoubleStream;

public class Main {
    
    public static void main(String[] args) {

        // EXAMPLE 1
        
        List<MelonRecord> melons = Arrays.asList(new MelonRecord("Crenshaw", 1200),
                new MelonRecord("Gac", 3000), new MelonRecord("Hemi", 2600),
                new MelonRecord("Hemi", 1600), new MelonRecord("Gac", 1200),
                new MelonRecord("Apollo", 2600), new MelonRecord("Horned", 1700),
                new MelonRecord("Gac", 3000), new MelonRecord("Hemi", 2600)
        );
        
        WeightsAndTotalRecord weightsAndTotal = melons.stream()
                .collect(Collectors.teeing(
                        summingDouble(MelonRecord::weight),
                        mapping(MelonRecord::weight, toList()),
                        WeightsAndTotalRecord::new
                ));
        
        System.out.println(weightsAndTotal);

        // EXAMPLE 2
                
        /*
        Map<Double, Long> elevations = DoubleStream.of(22, -10, 100, -5, 100, 123, 22, 230, -1, 250, 22)
                .filter(e -> e > 0)
                .map(e -> e * 0.393701)   
                .mapToObj(e -> (double) e)
                .collect(Collectors.groupingBy(Function.identity(), counting()));
        */
        
        record Elevation(double value) { Elevation(double value) { this.value = value * 0.393701; } }
        record ElevationCount(long count) {}
        Map<Elevation, ElevationCount> elevations = DoubleStream.of(22, -10, 100, -5, 100, 123, 22, 230, -1, 250, 22)
                .filter(e -> e > 0)                
                .mapToObj(Elevation::new)
                .collect(Collectors.groupingBy(Function.identity(), 
                         Collectors.collectingAndThen(counting(), ElevationCount::new)));
        
        System.out.println(elevations);
    }
}
