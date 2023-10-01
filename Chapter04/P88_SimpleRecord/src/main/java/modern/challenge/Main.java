package modern.challenge;

public class Main {

    public static void main(String[] args) {

        Melon melon1 = new Melon("Cantaloupe", 2600);
        MelonRecord melon2 = new MelonRecord("Cantaloupe", 2600);
        MelonRecord melon3 = new MelonRecord("Cantaloupe", 2600);
        
        System.out.println(melon1);
        System.out.println(melon1.getType());
        System.out.println(melon1.getWeight());
        
        System.out.println();
        
        System.out.println(melon2.type());
        System.out.println(melon2.weight());
        System.out.println(melon2.equals(melon3));
    }
}
