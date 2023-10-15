package modern.challenge;

import static c.lib.math.math_h.modf;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

public class Main {   

    public static void main(String[] args) {

        double x = 89.76655;
        
        try (Arena arena = Arena.openConfined()) {

            MemorySegment segmentIntptr = arena.allocate(ValueLayout.JAVA_DOUBLE);

            double fractional = modf(x, segmentIntptr);
            System.out.println("Fractional part: " + fractional
                    + " Integer part: " + segmentIntptr.get(ValueLayout.JAVA_DOUBLE, 0));
        }
    }
}
