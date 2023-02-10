package modern.challenge;

public class Main {

    public static void main(String[] args) {
        
        MelonRecord melon = new MelonRecord("Cantaloupe", 2600);
        
        System.out.println(melon);
        System.out.println(melon.weight() + " g = " + melon.weightToKg() + " Kg");        
        
        System.out.println();
        
        MelonRecord defaultMelon = MelonRecord.getDefaultMelon();
        System.out.println(defaultMelon);
        
        System.out.println();
        
        MelonRecord.Slicer slicer= new MelonRecord.Slicer();
        slicer.slice(melon, 10);
        slicer.slice(defaultMelon, 14);
    }
}
