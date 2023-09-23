package modern.challenge;

public class Person {
    
    // public String getAddress() { return ""; }
    // public String getAddress(Person this) { return ""; } // These two methods are semantically the same
    
    public String getAddress(Person this, String prevAddr) { return ""; } // These two methods are semantically the same
    
    public String getAddress(@ValidAddress Person this) { return ""; }
}


