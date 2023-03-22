package modern.challenge;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
            
        Melon melon = new Melon("Gac", 2500);
        Cantaloupe arancino = new Cantaloupe("Arancino", 5000);
        Muskmelons casaba = new Muskmelons("Casaba", 1500);
        Pumpkin pumpkin = new Pumpkin("Pumpkin", 2000);

        byte[] melonSer = Converters.objectToBytes(melon);
        byte[] arancinoSer = Converters.objectToBytes(arancino);
        byte[] casabaSer = Converters.objectToBytes(casaba);
        byte[] pumpkinSer = Converters.objectToBytes(pumpkin); // this is not a melon
        System.out.println("Serialization (melon): " + Arrays.toString(melonSer));
        System.out.println("Serialization (arancino): " + Arrays.toString(arancinoSer));
        System.out.println("Serialization (casaba): " + Arrays.toString(casabaSer));
        System.out.println("Serialization (pumpkin): " + Arrays.toString(casabaSer));

        System.out.println();

        // filter status: REJECTED since this is a Melon
        // Melon melonDeser = (Melon) Converters.bytesToObject(melonSer, Filters::classFilter);
        // System.out.println("Deserialization (melon): " + melonDeser);
        
        // filter status: REJECTED since this is a Melon
        // Cantaloupe arancinoDeser = (Cantaloupe) Converters.bytesToObject(arancinoSer, Filters::classFilter);
        // System.out.println("Deserialization (arancino): " + arancinoDeser);
        
        // filter status: REJECTED since this is a Melon
        // Muskmelons casabaDeser = (Muskmelons) Converters.bytesToObject(casabaSer, Filters::classFilter);
        // System.out.println("Deserialization (casaba): " + casabaDeser);
        
        Pumpkin pumpkinDeser = (Pumpkin) Converters.bytesToObject(pumpkinSer, Filters::classFilter);
        System.out.println("Deserialization (pumpkin): " + pumpkinDeser);
    }
}