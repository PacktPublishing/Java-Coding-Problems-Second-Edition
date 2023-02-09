package modern.challenge;

public class Main {

    public static void main(String[] args) {
        
        MelonRecord melon = new MelonRecord("Cantaloupe", 2600);
        
        System.out.println(melon);
        System.out.println(melon.weight() + " g");
        melon.exterminatePest();
    }
}
