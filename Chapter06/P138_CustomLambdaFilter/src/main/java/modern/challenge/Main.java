package modern.challenge;

import java.io.IOException;
import java.io.ObjectInputFilter.Status;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        /* create a custom lambda filter and set it for all the streams of this application */
        /*
        ObjectInputFilter.Config
                .setSerialFilter(f -> ((f.serialClass() != null)
                // or, filter.serialClass().getName().equals("modern.challenge.Melon")
                && f.serialClass().getPackage().getName().equals("modern.challenge")
                && f.serialClass().getSimpleName().equals("Melon"))
                ? Status.REJECTED : Status.UNDECIDED);
        */

        Melon melon = new Melon("Gac", 2500);

        byte[] melonSer = Converters.objectToBytes(melon);
        System.out.println("Serialization: " + Arrays.toString(melonSer));

        System.out.println();

        Melon melonDeser = (Melon) Converters.bytesToObject(melonSer, 
                f -> ((f.serialClass() != null)
                    // or, filter.serialClass().getName().equals("modern.challenge.Melon")
                    && f.serialClass().getPackage().getName().equals("modern.challenge")
                    && f.serialClass().getSimpleName().equals("Melon"))
                    ? Status.REJECTED : Status.UNDECIDED);
        System.out.println("Deserialization: " + melonDeser);
    }
}
