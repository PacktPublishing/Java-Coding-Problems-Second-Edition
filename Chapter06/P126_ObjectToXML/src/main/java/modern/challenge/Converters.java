package modern.challenge;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

public final class Converters {

    private Converters() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static String objectToXML(Serializable obj) throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        
        try ( XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(baos))) {
            encoder.writeObject(obj);
        }
        
        baos.close();
        
        return new String(baos.toByteArray());
    }

    public static Object XMLToObject(String xml) throws IOException {

        try ( InputStream is = new ByteArrayInputStream(xml.getBytes());  
                XMLDecoder decoder = new XMLDecoder(is)) {

            return decoder.readObject();
        }
    }
}
