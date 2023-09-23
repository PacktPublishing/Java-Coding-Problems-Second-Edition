
package modern.challenge;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Usb {

    public static String save(Object o) throws IOException {

        return switch(o) {
            case File file -> "Saving a file of size: " + String.format("%,d bytes", file.length());
            case Path path -> "Saving a file of size: " + String.format("%,d bytes", Files.size(path));
            case String str -> "Saving a string of size: " + String.format("%,d bytes", str.length());
            case null -> "Why are you doing this?";
            default -> "I cannot save the given object";
        };                       
    }

    public static void main(String[] args) throws IOException {
        System.out.println(save(Paths.get("pom.xml")));
        System.out.println(save(new File("pom.xml")));
        System.out.println(save("This is a plain string"));
        System.out.println(save(null));
    }
}
