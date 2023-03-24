package modern.challenge;

import java.io.IOException;
import java.io.ObjectInputFilter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Set a filter factory
       MelonFilterFactory filterFactory = new MelonFilterFactory();
       ObjectInputFilter.Config.setSerialFilterFactory(filterFactory);        
     
       ObjectInputFilter.Config.setSerialFilter(Filters.allowFilter());       
      
        Pumpkin pumpkin = new Pumpkin("Pumpkin", 2000);
        Melon melon = new Melon("Melon", 2400);
        Muskmelons muskmelons = new Muskmelons("Muskmelons", 1500);
        Cantaloupe cantaloupe = new Cantaloupe("Cantaloupe", 5000);
        HoneyDew honeyDew = new HoneyDew("HoneyDew", 4500);
        Persian persian = new Persian("Persian", 1230);

        byte[] pumpkinSer = Converters.objectToBytes(pumpkin);
        byte[] melonSer = Converters.objectToBytes(melon);
        byte[] muskmelonsSer = Converters.objectToBytes(muskmelons);
        byte[] cantaloupeSer = Converters.objectToBytes(cantaloupe);
        byte[] honeyDewSer = Converters.objectToBytes(honeyDew);
        byte[] persianSer = Converters.objectToBytes(persian);

        System.out.println("Serialization (pumpkin): " + Arrays.toString(pumpkinSer));
        System.out.println("Serialization (melon): " + Arrays.toString(melonSer));
        System.out.println("Serialization (muskmelons): " + Arrays.toString(muskmelonsSer));
        System.out.println("Serialization (cantaloupe): " + Arrays.toString(cantaloupeSer));
        System.out.println("Serialization (honeyDew): " + Arrays.toString(honeyDewSer));
        System.out.println("Serialization (persian): " + Arrays.toString(persianSer));

        System.out.println();
        
        // Pumpkin pumpkinDeser = (Pumpkin) Converters.bytesToObject(pumpkinSer, Filters.rejectFilter());
        // System.out.println("Deserialization (pumpkin): " + pumpkinDeser);
        
        Melon melonDeser = (Melon) Converters.bytesToObject(melonSer, Filters.rejectFilter());
        System.out.println("Deserialization (melon): " + melonDeser);     
        
        // Muskmelons muskmelonsDeser = (Muskmelons) Converters.bytesToObject(muskmelonsSer, Filters.rejectFilter());        
        // System.out.println("Deserialization (muskmelons): " + muskmelonsDeser);
                
        Cantaloupe cantaloupeDeser = (Cantaloupe) Converters.bytesToObject(cantaloupeSer, Filters.rejectFilter());
        System.out.println("Deserialization (cantaloupe): " + cantaloupeDeser);

        // HoneyDew honeyDewDeser = (HoneyDew) Converters.bytesToObject(honeyDewSer, Filters.rejectFilter());
        // System.out.println("Deserialization (honeyDew): " + honeyDewDeser);
        
        // Persian persianDeser = (Persian) Converters.bytesToObject(persianSer, Filters.rejectFilter());
        // System.out.println("Deserialization (honeyDew): " + persianDeser);
    }
}