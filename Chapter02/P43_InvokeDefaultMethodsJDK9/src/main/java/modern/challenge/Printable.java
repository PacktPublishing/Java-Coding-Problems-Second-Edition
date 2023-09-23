package modern.challenge;

public interface Printable {
    
    default void setup() {
        System.out.println("Printable: Setup the printer");        
    }
    
    default void print(String doc) {        
        System.out.println("Printable: Printing the document: " + doc);        
    }
}
