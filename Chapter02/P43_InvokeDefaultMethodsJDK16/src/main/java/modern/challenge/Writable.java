package modern.challenge;

public interface Writable {
    
    default void setup() {
        System.out.println("Writable: Setup the editor");        
    }
    
    default void write(String doc) {        
        System.out.println("Writable: Writing in document: " + doc);        
    }
}
