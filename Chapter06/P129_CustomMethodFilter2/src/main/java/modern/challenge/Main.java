package modern.challenge;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
            
        Pumpkin pumpkin = new Pumpkin("Pumpkin", 2000);
        Melon melon = new Melon("Gac", 2500);
        Cantaloupe cantaloupe = new Cantaloupe("Cantaloupe", 5000);
        Muskmelons muskmelons = new Muskmelons("Muskmelons", 1500);        

        byte[] pumpkinSer = Converters.objectToBytes(pumpkin); // this is not a melon
        byte[] melonSer = Converters.objectToBytes(melon);
        byte[] cantaloupeSer = Converters.objectToBytes(cantaloupe);
        byte[] muskmelonsSer = Converters.objectToBytes(muskmelons);
        
        System.out.println("Serialization (pumpkin): " + Arrays.toString(pumpkinSer));
        System.out.println("Serialization (melon): " + Arrays.toString(melonSer));
        System.out.println("Serialization (cantaloupe): " + Arrays.toString(cantaloupeSer));
        System.out.println("Serialization (muskmelons): " + Arrays.toString(muskmelonsSer));        

        System.out.println();

        Pumpkin pumpkinDeser = (Pumpkin) Converters.bytesToObject(pumpkinSer, Filters::classFilter);
        System.out.println("Deserialization (pumpkin): " + pumpkinDeser);
        
        // filter status: REJECTED since this is a Melon
        // Melon melonDeser = (Melon) Converters.bytesToObject(melonSer, Filters::classFilter);
        // System.out.println("Deserialization (melon): " + melonDeser);
        
        // filter status: REJECTED since this is a Melon
        // Cantaloupe cantaloupeDeser = (Cantaloupe) Converters.bytesToObject(cantaloupeSer, Filters::classFilter);
        // System.out.println("Deserialization (cantaloupe): " + cantaloupeDeser);
        
        // filter status: REJECTED since this is a Melon
        // Muskmelons muskmelonsDeser = (Muskmelons) Converters.bytesToObject(muskmelonsSer, Filters::classFilter);
        // System.out.println("Deserialization (muskmelons): " + muskmelonsDeser);                
    }
}