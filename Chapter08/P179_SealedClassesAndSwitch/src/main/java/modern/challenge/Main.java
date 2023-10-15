package modern.challenge;

public class Main {
    
    public static String convert(
            TextConverter converter, String text) {       

        return switch (converter) {
            case Utf8 c8 -> "Converting text to UTF-8: " + c8;
            case Utf16be c16 -> "Converting text to UTF-16BE: " + c16; // optional
            case Utf16le c16 -> "Converting text to UTF-16LE: " + c16; // optional
            case Utf16 c16 -> "Converting text to UTF-16: " + c16;            
            case Utf32 c32 -> "Converting text to UTF-32: " + c32;            
            // case TextConverter tc -> "Converting text: " + tc;      // total type pattern
            //default -> "Unrecognized converter type";                // default label                      
        };
    }
    
    public static void main(String[] args) {}
}