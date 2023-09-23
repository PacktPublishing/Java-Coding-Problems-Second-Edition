package modern.challenge;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Usb {

    public static String saveOld(Object o) throws IOException {

        if (o instanceof File) {
            File file = (File) o;
            return "Saving a file of size: " + String.format("%,d bytes", file.length());
        }                
        
        if (o instanceof Path) {
            Path path = (Path) o;
            return "Saving a file of size: " + String.format("%,d bytes", Files.size(path));
        }
        
        if (o instanceof String) {
            String str = (String) o;
            return "Saving a string of size: " + String.format("%,d bytes", str.length());
        }

        return "I cannot save the given object";
    }
    
    public static String save(Object o) throws IOException {

        if (o instanceof File file) {
            return "Saving a file of size: " + String.format("%,d bytes", file.length());
        }
        
        if (o instanceof String str) {
            return "Saving a string of size: " + String.format("%,d bytes", str.length());
        }
        
        if (o instanceof Path path) {
            return "Saving a file of size: " + String.format("%,d bytes", Files.size(path));
        }

        return "I cannot save the given object";
    }

    public static void main(String[] args) throws IOException {
        
        System.out.println(saveOld(Paths.get("pom.xml")));
        System.out.println(saveOld(new File("pom.xml")));
        System.out.println(saveOld("This is a plain string"));
        
        System.out.println();
        
        System.out.println(save(Paths.get("pom.xml")));
        System.out.println(save(new File("pom.xml")));
        System.out.println(save("This is a plain string"));
        
        System.out.println();
        
        // JDK 20 -> expression type cannot be a subtype of pattern type (upcasting is allowed)
        // JDK 21 -> this works
        if ("foo" instanceof String str) {System.out.println(str);}
        if ("foo" instanceof CharSequence sequence) {System.out.println(sequence);}
        
    }
}