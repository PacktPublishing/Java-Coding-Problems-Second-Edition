package modern.challenge;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Pumpkin pumpkin = new Pumpkin("Pumpkin", 2000);
        Melon melon = new Melon("Melon", 2400);        
        Muskmelon muskmelon = new Muskmelon("Muskmelon", 1500);
        Cantaloupe cantaloupe = new Cantaloupe("Cantaloupe", 5000);
        HoneyDew honeyDew = new HoneyDew("HoneyDew", 4500);
        Persian persian = new Persian("Persian", 1230);

        byte[] pumpkinSer = Converters.objectToBytes(pumpkin);
        byte[] melonSer = Converters.objectToBytes(melon);
        byte[] muskmelonSer = Converters.objectToBytes(muskmelon);
        byte[] cantaloupeSer = Converters.objectToBytes(cantaloupe);        
        byte[] honeyDewSer = Converters.objectToBytes(honeyDew);
        byte[] persianSer = Converters.objectToBytes(persian);
        
        System.out.println("Serialization (pumpkin): " + Arrays.toString(pumpkinSer));
        System.out.println("Serialization (melon): " + Arrays.toString(melonSer));
        System.out.println("Serialization (muskmelon): " + Arrays.toString(muskmelonSer));
        System.out.println("Serialization (cantaloupe): " + Arrays.toString(cantaloupeSer));        
        System.out.println("Serialization (honeyDew): " + Arrays.toString(honeyDewSer));
        System.out.println("Serialization (persian): " + Arrays.toString(persianSer));

        System.out.println();

        // pass the filters since Melon is Melon and is not Muskmelon
        Melon melonDeser = (Melon) Converters.bytesToObject(
                melonSer, Filters.allowMelonFilter(), Filters.rejectMuskmelonFilter());
        System.out.println("Deserialization (melon): " + melonDeser);
        
        // Pumpkin pumpkinDeser = (Pumpkin) Converters.bytesToObject(
        //        pumpkinSer, Filters.allowMelonFilter(), Filters.rejectMuskmelonFilter());
        // System.out.println("Deserialization (pumpkin): " + pumpkinDeser);
        
        // Muskmelon muskmelonDeser = (Muskmelon) Converters.bytesToObject(
        //      muskmelonSer, Filters.allowMelonFilter(), Filters.rejectMuskmelonFilter());
        // System.out.println("Deserialization (muskmelon): " + muskmelonDeser);

        // pass the filters since Cantaloupe is Melon and is not Muskmelons
        Cantaloupe cantaloupeDeser = (Cantaloupe) Converters.bytesToObject(
                cantaloupeSer, Filters.allowMelonFilter(), Filters.rejectMuskmelonFilter());
        System.out.println("Deserialization (cantaloupe): " + cantaloupeDeser);
        
        // HoneyDew honeyDewDeser = (HoneyDew) Converters.bytesToObject(
        //        honeyDewSer, Filters.allowMelonFilter(), Filters.rejectMuskmelonFilter());
        // System.out.println("Deserialization (honeyDew): " + honeyDewDeser);
        
        // Persian persianDeser = (Persian) Converters.bytesToObject(
        //        persianSer, Filters.allowMelonFilter(), Filters.rejectMuskmelonFilter());
        // System.out.println("Deserialization (honeyDew): " + persianDeser);
    }
}