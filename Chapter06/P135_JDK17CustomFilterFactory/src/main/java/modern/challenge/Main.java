package modern.challenge;

import java.io.IOException;
import java.io.ObjectInputFilter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Set a filter factory
       MelonFilterFactory filterFactory = new MelonFilterFactory();
       ObjectInputFilter.Config.setSerialFilterFactory(filterFactory);        
     
       ObjectInputFilter.Config.setSerialFilter(Filters.allowMelonFilter());       
      
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
        
        // Pumpkin pumpkinDeser = (Pumpkin) Converters.bytesToObject(pumpkinSer, Filters.rejectMuskmelonFilter());
        // System.out.println("Deserialization (pumpkin): " + pumpkinDeser);
        
        Melon melonDeser = (Melon) Converters.bytesToObject(melonSer, Filters.rejectMuskmelonFilter());
        System.out.println("Deserialization (melon): " + melonDeser);     
        
        // Muskmelon muskmelonDeser = (Muskmelon) Converters.bytesToObject(muskmelonSer, Filters.rejectMuskmelonFilter());        
        // System.out.println("Deserialization (muskmelon): " + muskmelonDeser);
                
        Cantaloupe cantaloupeDeser = (Cantaloupe) Converters.bytesToObject(cantaloupeSer, Filters.rejectMuskmelonFilter());
        System.out.println("Deserialization (cantaloupe): " + cantaloupeDeser);

        // HoneyDew honeyDewDeser = (HoneyDew) Converters.bytesToObject(honeyDewSer, Filters.rejectMuskmelonFilter());
        // System.out.println("Deserialization (honeyDew): " + honeyDewDeser);
        
        // Persian persianDeser = (Persian) Converters.bytesToObject(persianSer, Filters.rejectMuskmelonFilter());
        // System.out.println("Deserialization (honeyDew): " + persianDeser);
    }
}