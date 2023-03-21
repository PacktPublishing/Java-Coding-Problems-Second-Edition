package modern.challenge;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Melon melon = new Melon("Gac", 2500);

        String melonSer = Converters.objectToXML(melon);
        System.out.println("Serialization: " + melonSer);

        System.out.println();

        Melon melonDeser = (Melon) Converters.XMLToObject(melonSer);
        System.out.println("Deserialization: " + melonDeser);
    }
}
