package modern.challenge;

@SuppressWarnings("unchecked")
public class Main {

    public static void main(String[] args) {

       FruitRecord<MelonRecord> fruit = 
               new FruitRecord<>(new MelonRecord("Hami", 1000), "China");
       
       EngineRecord<String, Integer, String> engine = new EngineRecord("TV1", 661, "Water cooled");
       
       ContainerRecord<String> innerContainer = new ContainerRecord("Inner container");
       ContainerRecord<ContainerRecord<String>> container = new ContainerRecord(innerContainer);
       
       if (fruit instanceof FruitRecord<MelonRecord>(MelonRecord melon, String country)) {
          System.out.println(melon + " from " + country);
       }
       
       if (fruit instanceof FruitRecord<MelonRecord>(var melon, var country)) {
          System.out.println(melon + " from " + country);
       }                                  
       
       if (fruit instanceof FruitRecord(var melon, var country)) {
          System.out.println(melon + " from " + country);
       }
              
       if (engine instanceof EngineRecord<String, Integer, String>(var type, var power, var cooling)) {
           System.out.println(type + " - " + power + " - " + cooling);
       }
       
       if (engine instanceof EngineRecord(var type, var power, var cooling)) {
           System.out.println(type + " - " + power + " - " + cooling);
       }
       
       if (container instanceof ContainerRecord<ContainerRecord<String>>(ContainerRecord(var c))) {
           System.out.println(c);
       }
       
       if (container instanceof ContainerRecord(ContainerRecord(var c))) {
           System.out.println(c);
       }
       
       if (container instanceof ContainerRecord<ContainerRecord<String>>(var c)) {
           System.out.println(c);
       }              
          
       switch (fruit) {
           case FruitRecord<MelonRecord>(MelonRecord melon, String country) : 
               System.out.println(melon + " from " + country); break;
           default : break;           
       };
       
       switch (fruit) {
           case FruitRecord<MelonRecord>(var melon, var country) : 
               System.out.println(melon + " from " + country); break;
           default : break;           
       };
       
       switch (fruit) {
           case FruitRecord(var melon, var country) : 
               System.out.println(melon + " from " + country); break;
           default : break;           
       };
       
       switch (engine) {
           case EngineRecord<String, Integer, String>(var type, var power, var cooling) : 
               System.out.println(type + " - " + power + " - " + cooling);
           default : break;           
       };
       
       switch (engine) {
           case EngineRecord(var type, var power, var cooling) : 
               System.out.println(type + " - " + power + " - " + cooling);
           default : break;           
       };
              
       switch (container) {
           case ContainerRecord<ContainerRecord<String>>(ContainerRecord(var c)) : 
               System.out.println(c);
           default : break;           
       };              
       
       switch (container) {
           case ContainerRecord(ContainerRecord(var c)) : 
               System.out.println(c);
           default : break;           
       };
       
       switch (container) {
           case ContainerRecord<ContainerRecord<String>>(var c) : 
               System.out.println(c);
           default : break;           
       };
    }
}