package modern.challenge;

public class Main {

    public static void main(String[] args) {

         // Quick test
        String newline = "\\n".translateEscapes();
        System.out.println(("\n".equals(newline)) ? "yes" : "no");
        System.out.println();

        // An example
        String address = """
                         JASON MILLER (\\"BIGBOY\\")\\n
                         \\tMOUNT INC\\n
                         \\t104 SEAL AVE\\n
                         \\tMIAMI FL 55334 1200\\n
                         \\tUSA
                         """;

        String translatedAddress = address.translateEscapes();
        
        Strings.printAddressOnEnvelope(address);
        Strings.printAddressOnEnvelope(translatedAddress);
    }
}
