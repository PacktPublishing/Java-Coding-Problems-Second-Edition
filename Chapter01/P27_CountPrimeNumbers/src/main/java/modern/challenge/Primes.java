package modern.challenge;

import java.util.BitSet;

public final class Primes {

    private Primes() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int count(int v) {

        if (v <= 2) {
            return 0;
        }      

        BitSet bs = new BitSet();

        v = v - 1;
        int sq = (int) Math.sqrt(v);
        int cnt = v;
        
        for (int i = 2; i <= sq; i++) {
            
            if (!bs.get(i)) {
                for (int j = 2; (i * j) <= v; j++) {
                    
                    if (!bs.get(i * j)) {
                        cnt--;
                        bs.set(i * j);
                    }
                }
            }
        }

        return cnt - 1;
    }
}
