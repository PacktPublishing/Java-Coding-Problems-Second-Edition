package modern.challenge;

import org.joou.ULong;
import static org.joou.Unsigned.ulong;

public class Main {

    public static void main(String[] args) {                
        
        long x = 234253490223L;
        long y = -565951223449L;

        long resultSigned = Math.multiplyHigh(x, y);
        System.out.println("Result (signed): " + resultSigned);

        long resultUnsigned = Math.unsignedMultiplyHigh(x, y);
        System.out.println("Result (unsigned): " + resultUnsigned);

        // using jOOU
        ULong ux = ulong(234253490223L);
        ULong uy = ulong(-565951223449L);

        System.out.println();
        System.out.println("Unsigned x: " + ux + " long value: " + ux.longValue());
        System.out.println("Unsigned y: " + uy + " long value: " + uy.longValue());
        System.out.println();

        long uResultSigned = Math.multiplyHigh(ux.longValue(), uy.longValue());
        System.out.println("jOOU Result (signed): " + uResultSigned);

        long uResultUnsigned = Math.unsignedMultiplyHigh(ux.longValue(), uy.longValue());
        System.out.println("jOOU Result (unsigned): " + uResultUnsigned);
    }
}
