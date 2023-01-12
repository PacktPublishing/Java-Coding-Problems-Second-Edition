package modern.challenge;

public class Main {

    public static void main(String[] args) {
        
        String str = "I love Java!";
        String txt = """
                     I love Java!""";
        
        System.out.println("Is 'str' (string literal) equal to 'txt' (text block) via '==': " 
                + (str == txt));
        System.out.println("Is 'str' (string literal) equal to 'txt' (text block) via 'equals': " 
                + str.equals(txt));
        
        System.out.println();
        
        String tom = "Tom";
        String jerry = """
                       Jerry""";
        
        System.out.println(tom + " and " + jerry);
        System.out.println();
        
        System.out.println(tom.toUpperCase() + " AND " + jerry.toUpperCase());        
    }
}