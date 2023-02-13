package modern.challenge;

public class Main {

    public static void main(String[] args) {

       FruitRecord<MelonRecord> fruit = 
               new FruitRecord<>(new MelonRecord("Hami", 1000), "China");
       
       if (fruit instanceof FruitRecord<MelonRecord>(MelonRecord melon, String country)) {
          System.out.println(melon + " from " + country);
       }
       
       if (fruit instanceof FruitRecord<MelonRecord>(var melon, var country)) {
          System.out.println(melon + " from " + country);
       }
       
       switch(fruit) {
           case FruitRecord<MelonRecord>(MelonRecord melon, String country) : 
               System.out.println(melon + " from " + country); break;
           default : break;           
       };
       
       switch(fruit) {
           case FruitRecord<MelonRecord>(var melon, var country) : 
               System.out.println(melon + " from " + country); break;
           default : break;           
       };
    }
}
