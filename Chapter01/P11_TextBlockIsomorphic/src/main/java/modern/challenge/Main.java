package modern.challenge;

public class Main {

    public static void main(String[] args) {

       String s1 = """
                   abbcdd                   
                     baaaad
                   ccddaa
                   """;
       
       String s2 = """  
                   qwwerr
                     wqqqqr
                   eerrqq
                   """;
        
       boolean result = Strings.isIsomorphic(s1, s2);
       
       System.out.println("Is ismoporphic ? " + result);
    }
}