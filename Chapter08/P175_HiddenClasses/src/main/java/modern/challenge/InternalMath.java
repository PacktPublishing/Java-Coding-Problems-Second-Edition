package modern.challenge;

import java.util.stream.IntStream;

public class InternalMath {
    
    public long sum(int[] nr) {
        return IntStream.of(nr).sum();
    }
}