package modern.challenge;

public class Main {
    
    /*
    public static Str shortener(Str str) {
        
        if (str instanceof Concat s) {
            if (s.first() instanceof Variable first 
                    && s.second() instanceof Literal second && second.text().isBlank()) {
                return first;
            } else if (s.first() instanceof Literal first 
                    && s.second() instanceof Variable second && first.text().isBlank()) {
                return second;
            }                
        }
        
        return str;
    }*/
    
    public static Str shortener(Str str) {
        
        return switch (str) {            
            case Concat(Variable(var name), Literal(var text)) when text.isBlank() -> new Variable(name);            
            case Concat(Literal(var text), Variable(var name)) when text.isBlank() -> new Variable(name);
            default -> str;
        };        
    }
    
    public static void main(String[] args) {     
    
        System.out.println(shortener(new Concat(new Variable("t"), new Literal("   "))));     
    }
}