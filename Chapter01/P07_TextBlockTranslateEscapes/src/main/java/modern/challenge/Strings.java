package modern.challenge;

public final class Strings {
    
    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }
    
    // we need to pass here the unescaped version of address
    public static void printAddressOnEnvelope(String address) {
        
        // the code needed to print the address on envelope
        
        System.out.println("The printed address looks as follows:\n");
        
        System.out.println(address);
    }
}
