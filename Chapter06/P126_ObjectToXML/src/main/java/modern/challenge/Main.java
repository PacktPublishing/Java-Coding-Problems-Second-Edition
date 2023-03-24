package modern.challenge;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Melon melon = new Melon("Gac", 2500);

        System.out.println();
        // use XMLEncoder/XMLDecoder
        System.out.println();
        
        String melonSerXMLE = Converters.objectToXML(melon);
        System.out.println("Serialization (XMLEncoder): " + melonSerXMLE);
        
        Melon melonDeserXMLD = (Melon) Converters.XMLToObject(melonSerXMLE);
        System.out.println("Deserialization (XMLDecoder): " + melonDeserXMLD);
        
        System.out.println();
        // use Jackson XmlMapper
        System.out.println();
        
        String melonSerXMLM = Converters.objectToXMLJackson(melon);
        System.out.println("Serialization (XmlMapper): " + melonSerXMLM);
        
        System.out.println();
               
        Melon melonDeserXMLM = Converters.XMLToObjectJackson(melonSerXMLM, Melon.class);
        System.out.println("Deserialization (XmlMapper): " + melonDeserXMLM);
    }
}
