package modern.challenge;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Usb {

    public static String save(Object o) throws IOException {

        // 'file' is created ONLY if 'instanceof' returns true
        if (o instanceof File file 
                // this is evaluated ONLY if 'file' was created                                
                && file.length() > 0 && file.length() < 1000) {
            return "Saving a file of size: " + String.format("%,d bytes", file.length());
        }                
       
        if (o instanceof Path path && Files.size(path) > 0 && Files.size(path) < 1000) {
            return "Saving a file of size: " + String.format("%,d bytes", Files.size(path));
        }
        
        if (!(o instanceof String str)) {
            // str is not available here
            return "I cannot save the given object";
        } else {
            return "Saving a string of size: " + String.format("%,d bytes", str.length());
        }        
    }        
    
    // works with early returns
    public static int getStringLength(Object o) {        
        if (!(o instanceof String str)) {
            return 0;
        }
        
        return str.length();
    }
    
    // no overlap risks, but DON'T DO THIS!
    private static String strNumber(Object o) {
        
        if (o instanceof Integer nr) {
            return String.valueOf(nr.intValue());
        } else if (o instanceof Long nr) {
            return String.valueOf(nr.longValue());
        } else {
            // nr is out of scope here
            return "Probably a float number";
        }
    }
       
    // DON'T DO THIS!
    private static final String str = "   I am a string with leading and trailing spaces     ";
    public static String convert(Object o) {
        if (o instanceof String str) { // local variable (binding variable) hides a field
            return str.strip(); // refers to binding variable, str
        } else {
            return str.strip(); // refers to field, str
        }        
    }
    
    // Reassigning binding variable is not possible in JDK 14/15, 
    // but it is starting with JDK 16+
    // HOWEVER, DON'T DO THIS!
    static String dummy = "";
    private static int getLength(Object o) {        
        if(o instanceof String str) {
            str = dummy; // reassigning binding variable
            
            return str.length(); // returns the length of 'dummy' not the passed 'str'
        }
        
        return 0;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(save(Paths.get("pom.xml")));
        System.out.println(save(new File("pom.xml")));
        System.out.println(save("This is a plain string"));
        
        System.out.println("The string 'text' has a length of: " + getLength("text"));
    }
}