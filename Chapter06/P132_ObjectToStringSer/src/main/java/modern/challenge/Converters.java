package modern.challenge;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;

public final class Converters {

    private Converters() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static String objectToString(Serializable obj) throws IOException {       
        
        try ( ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream ois = new ObjectOutputStream(baos)) {
            ois.writeObject(obj);
            
            return Base64.getEncoder().encodeToString(baos.toByteArray());
        }                
    }

    public static Object stringToObject(String obj) 
            throws IOException, ClassNotFoundException {

        byte[] data = Base64.getDecoder().decode(obj);
        try ( ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            return ois.readObject();
        }
    }
}
