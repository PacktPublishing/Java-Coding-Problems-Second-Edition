package modern.challenge;

public interface Draft extends Writable {
    
    @Override
    default void write(String draft) {        
        System.out.println("Draft: Writing in draft: " + draft);        
    }
}
